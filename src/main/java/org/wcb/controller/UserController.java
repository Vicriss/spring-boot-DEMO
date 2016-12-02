package org.wcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcb.entity.User;
import org.wcb.mapper.UserMapper;

import javax.servlet.http.HttpSession;

/**
 * Created by wybe on 11/29/16.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "your Grace") String name, Model model) {
        model.addAttribute("name", name);
        return "login" ;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, String adminCode, Model model) {
        if (user.getUsername() == null || user.getUsername().equals("") || user.getPassword() == null
                || user.getPassword().equals("")) {
            model.addAttribute("errMsg", "invalid data");
            return "error";
        }
        User findUser = userMapper.findByName(user.getUsername());
        if (findUser != null) {
            model.addAttribute("errMsg", "the user named " + user.getUsername() + " already exists");
            return "error";
        }
        if ("storeAdmin".equals(adminCode))
            user.setIsadmin(1);
        userMapper.insert(user);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userMapper.findByNameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("uid", user.getId());
            session.setAttribute("isAdmin", user.getIsadmin());
            return "redirect:/book/list";
        } else {
            model.addAttribute("errMsg", "login failed, please try again!");
            return "error";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("uid");
        session.removeAttribute("isAdmin");
        return "redirect:/login.html";
    }
}

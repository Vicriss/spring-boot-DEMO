package org.wcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcb.entity.Book;
import org.wcb.mapper.BookMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wybe on 11/29/16.
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @RequestMapping("/list")
    public String bookList(Model model) {
        List<Book> books = bookMapper.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @RequestMapping(value = "/search")
    public String search(String word, int type, Model model) {
        int id = 0;
        String name = "";
        if (type == 0) {
            for (char c : word.toCharArray()) {
                if (!Character.isDigit(c)) {
                    model.addAttribute("errMsg", "invalid data");
                    return "error";
                }
            }
            id = Integer.parseInt(word);
        } else {
            name = word;
        }
        List<Book> result = new ArrayList<>();
        if (id != 0) {
            Book book = bookMapper.findOne(id);
            if (book != null)
                result.add(book);
        } else if (name != null || "".equals(name)) {
            result = bookMapper.findByName(name);
        } else {
            model.addAttribute("errMsg", "invalid data");
            return "error";
        }
        model.addAttribute("books", result);
        return "booklist";
    }

    @RequestMapping("/add")
    public String add(Book book, Model model) {
        if (book.getPrice() < 0 || book.getBalance() <= 0 || book.getSales() < 0) {
            model.addAttribute("errMsg", "can't small than 0");
            return "error";
        }
        bookMapper.insert(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/buy")
    public String sell(int id, int num, Model model) {
        Book book = bookMapper.findOne(id);
        if (num <= 0 || num > book.getBalance()) {
            model.addAttribute("errMsg", "invalid data");
            return "error";
        }
        bookMapper.sellUpdate(id, num);
        double total = num * book.getPrice();
        model.addAttribute("msg", "you need to pay " + total + "$");
        return "redirect:/book/list";
    }

    @RequestMapping("shelve")
    public String shelve(int id, Model model) {
        if (bookMapper.findOne(id) == null) {
            model.addAttribute("errMsg", "invalid data");
            return "error";
        }
        bookMapper.delete(id);
        return "redirect:/book/list";
    }
}

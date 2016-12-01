package org.wcb.mapper;

import org.apache.ibatis.annotations.Param;
import org.wcb.entity.User;

/**
 * Created by wybe on 11/28/16.
 */


public interface UserMapper extends BaseMapper<User> {

    User findByNameAndPassword(@Param("username") String username, @Param("password") String password);

    User findByName(@Param("username")String username);
}

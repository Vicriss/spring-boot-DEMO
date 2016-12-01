package org.wcb.mapper;

import org.apache.ibatis.annotations.Param;
import org.wcb.entity.Book;

import java.util.List;

/**
 * Created by wybe on 11/28/16.
 */


public interface BookMapper extends BaseMapper<Book>{

    List<Book> findByName(@Param("name")String name);

    void sellUpdate(@Param("id") int id, @Param("num") int num);

}

package org.wcb.mapper;

import java.util.List;

/**
 * Created by wybe on 11/29/16.
 */

public interface BaseMapper<T> {
    void insert(T obj);

    T findOne(int id);
    
    List<T> findAll();

    void delete(T obj);

    void delete(int id);

    void update(T obj);
}

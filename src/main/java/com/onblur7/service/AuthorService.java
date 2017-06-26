package com.onblur7.service;


import com.onblur7.entity.Author;

/**
 * Created by ronger on 2017/6/24.
 */
public interface AuthorService {
    /**
     * 添加新用户
     *
     * account 唯一， 默认 USER 权限
     */
    boolean save(Author author);
    /**
     * 查询用户信息
     * @param username 账号
     * @return Author
     */
    Author findByUsername(String username);
}

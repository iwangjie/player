package com.onblur7.repository;


import com.onblur7.entity.Author;

/**
 * Created by ronger on 2017/6/24.
 */
public interface AuthorRepositoryCustom {
    Author findByUsernameWithAuthorities(String username);
}

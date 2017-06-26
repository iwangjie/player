package com.onblur7.service.impl;


import com.onblur7.entity.Author;
import com.onblur7.repository.AuthorRepository;
import com.onblur7.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ronger on 2017/6/24.
 */
@Service
@Transactional
public class BaseAuthorService implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public BaseAuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    /**
     * 添加新用户
     * <p>
     * account 唯一， 默认 USER 权限
     *
     * @param author
     */
    @Override
    public boolean save(Author author) {
        String account = author.getUsername();
        if(exist(account)){
            return false;
        }else{
            Author result = authorRepository.save(author);
            return result != null;
        }
    }

    /**
     * 查询用户信息
     *
     * @param username 账号
     * @return Author
     */
    @Override
    public Author findByUsername(String username) {
        Author author = authorRepository.findByUsername(username);
        return author;
    }

    private boolean exist(String username) {
        Author author = authorRepository.findByUsername(username);
        return (author != null);
    }
}

package com.onblur7.repository;


import com.onblur7.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ronger on 2017/6/24.
 */
public interface AuthorRepository extends JpaRepository<Author,String>,AuthorRepositoryCustom {

    /**
     *
     * */
    void deleteAllInBatch();
    /**
     * 根据用户账号获取用户信息
     * */
    Author findByUsername(String username);
    /**
     *
     * */
    Long countByUsernameAndPassword(String username, String password);
    /**
     * 创建用户
     * */
    Author save(Author author);
}

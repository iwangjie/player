package com.onblur7.repository;


import com.onblur7.entity.Author;
import com.onblur7.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by ronger on 2017/6/24.
 */
@Service
@Transactional
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author findByUsernameWithAuthorities(String username) {
        Author author = authorRepository.findByUsername(username);
        if(author == null){
            return null;
        }
        for (Role role:author.getAuthorities()){
            //触发加载数据,解决懒加载
            role.getAuthority();
        }
        return author;
        //如果调用getSingleResult(),那就要捕捉异常了,因为可能存在找不到用户的情况
       /* List<Author> users=em.createQuery("SELECT e FROM Author e WHERE e.username=?1", Author.class).setParameter(1, username).setMaxResults(1).getResultList();
        if (users.size()>0){
            Author user=users.get(0);
            //从打印的SQL来看,这里使用了inner Join,而不是一个一个去查!
            for (Role role:user.getAuthorities()){
                //触发加载数据,解决懒加载
                role.getAuthority();
            }
            return user;
        }else{
            return null;
        }*/
    }
}

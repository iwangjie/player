package com.onblur7.handler.security;


import com.onblur7.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * Created by ronger on 2017/6/24.
 */
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    public UserDetailsServiceCustom(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authorRepository.findByUsernameWithAuthorities(username);
    }
}

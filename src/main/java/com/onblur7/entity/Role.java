package com.onblur7.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ronger on 2017/6/24.
 */
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    private Set<Author> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getUsers() {
        return users;
    }

    public void setUsers(Set<Author> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Role) {
            return name.equals(((Role) o).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

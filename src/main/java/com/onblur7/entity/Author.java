package com.onblur7.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ronger on 2017/6/14.
 */
@Entity
@Table(name="author")
public class Author implements UserDetails {

    /**
     * 标识
     * */
    @Id
    private String id;
    /**
     * 账号
     * */
    private String username;
    /**
     * 密码
     * */
    private String password;
    /**
     * 昵称
     * */
    private String nick;
    /**
     * 头像
     * */
    private String avatar;
    /**
     * 签名
     * */
    private String sign;
    /**
     * 性别
     * */
    private String gender;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 生日
     * */
    private String birth;
    /**
     * 手机号码
     * */
    private String tel;
    /**
     * 扩展字段
     * */
    private String custom;
    /**
     * 创建时间
     * */
    @Column(name="create_time")
    private Long createTime;
    /**
     * 更新时间
     * */
    @Column(name="update_time")
    private Long updateTime;
    /**
     * 密钥
     * */
    private String token;
    /**
     * 权限
     * */
    private String roles;
    /**
     * 状态
     * */
    private int state;
    /**
     * 状态
     * */
    private boolean accountNonExpired=true;
    /**
     * 状态
     * */
    private boolean accountNonLocked=true;
    /**
     * 状态
     * */
    private boolean credentialsNonExpired=true;
    /**
     * 状态
     * */
    private boolean enabled=true;
    /**
     * 状态
     * */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_user")
    private Set<Role> authorities;

    public Author() {
    }

    public Author(String id, String username, String password, String nick, String avatar, String sign, String gender, String email, String birth, String tel, String custom, Long createTime, Long updateTime, String token, String roles, int state, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, Set<Role> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nick = nick;
        this.avatar = avatar;
        this.sign = sign;
        this.gender = gender;
        this.email = email;
        this.birth = birth;
        this.tel = tel;
        this.custom = custom;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.token = token;
        this.roles = roles;
        this.state = state;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

}

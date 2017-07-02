package com.onblur7.entity;

import javax.persistence.*;

/**
 * Created by ronger on 2017/7/2.
 */
@Entity
@Table(name = "invitation_code")
public class InvitationCode {
    private int id;
    /**
     * 邀请码
     * */
    private String code;
    /**
     * 拥有者
     * */
    private String owner;
    /**
     * 创建时间
     * */
    private String time;
    /**
     * 有效时间
     * */
    private String effectiveTime;
    /**
     * 状态
     * */
    private int state;
    /**
     * 使用人
     * */
    private String useAuthor;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Column(name = "effective_time")
    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUseAuthor() {
        return useAuthor;
    }

    public void setUseAuthor(String useAuthor) {
        this.useAuthor = useAuthor;
    }

    public InvitationCode() {
    }

    public InvitationCode(int id, String code, String owner, String time, String effectiveTime, int state, String useAuthor) {
        this.id = id;
        this.code = code;
        this.owner = owner;
        this.time = time;
        this.effectiveTime = effectiveTime;
        this.state = state;
        this.useAuthor = useAuthor;
    }
}

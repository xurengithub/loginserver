package com.xuren.loginserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuren
 * @since 2023-08-15
 */
@TableName("t_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uid
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * id
     */
    private String openId;

    private String account;

    private String password;

    private LocalDateTime insertDt;

    private LocalDateTime updDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getInsertDt() {
        return insertDt;
    }

    public void setInsertDt(LocalDateTime insertDt) {
        this.insertDt = insertDt;
    }

    public LocalDateTime getUpdDt() {
        return updDt;
    }

    public void setUpdDt(LocalDateTime updDt) {
        this.updDt = updDt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id = " + id +
            ", openId = " + openId +
            ", account = " + account +
            ", password = " + password +
            ", insertDt = " + insertDt +
            ", updDt = " + updDt +
        "}";
    }
}

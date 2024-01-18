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
@TableName("t_role_info")
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * uid
     */
    private Integer uid;

    /**
     * level
     */
    private Integer level;

    /**
     * id
     */
    private String sec;

    private String roleName;

    private LocalDateTime insertDt;

    private LocalDateTime updDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        return "RoleInfo{" +
            "id = " + id +
            ", uid = " + uid +
            ", level = " + level +
            ", sec = " + sec +
            ", roleName = " + roleName +
            ", insertDt = " + insertDt +
            ", updDt = " + updDt +
        "}";
    }
}

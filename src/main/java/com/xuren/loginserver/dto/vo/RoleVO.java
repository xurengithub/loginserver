package com.xuren.loginserver.dto.vo;

/**
 * @author xuren
 */
public class RoleVO {
    private Integer uid;
    private Integer rid;
    private String roleName;
    private int level;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
            "uid='" + uid + '\'' +
            ", rid='" + rid + '\'' +
            ", roleName='" + roleName + '\'' +
            ", level=" + level +
            '}';
    }
}

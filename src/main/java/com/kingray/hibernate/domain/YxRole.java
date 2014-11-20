package com.kingray.hibernate.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
public class YxRole extends BaseDomain {
    private Integer roleId;
    private String roleName;

    @Id
    @GeneratedValue
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxRole yxRole = (YxRole) o;

        if (roleId != null ? !roleId.equals(yxRole.roleId) : yxRole.roleId != null) return false;
        if (roleName != null ? !roleName.equals(yxRole.roleName) : yxRole.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

}

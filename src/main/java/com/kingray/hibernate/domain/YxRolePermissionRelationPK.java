package com.kingray.hibernate.domain;


import javax.persistence.Id;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
public class YxRolePermissionRelationPK extends BaseDomain {
    private YxRole role;
    private YxPermission permission;

    @Id
    public YxPermission getPermission() {
        return permission;
    }

    public void setPermission(YxPermission permission) {
        this.permission = permission;
    }

    @Id
    public YxRole getRole() {

        return role;
    }

    public void setRole(YxRole role) {
        this.role = role;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        YxRolePermissionRelationPK that = (YxRolePermissionRelationPK) o;
//
//        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
//        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = roleId != null ? roleId.hashCode() : 0;
//        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
//        return result;
//    }
}

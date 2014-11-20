package com.kingray.hibernate.domain;


import javax.persistence.Id;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
public class YxUserRoleRelationPK extends BaseDomain {
    private PUser user;
    private YxRole role;

    @Id
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
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
//        YxUserRoleRelationPK that = (YxUserRoleRelationPK) o;
//
//        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
//        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = roleId != null ? roleId.hashCode() : 0;
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
//        return result;
//    }
}

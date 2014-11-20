package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
@IdClass(YxRolePermissionRelationPK.class)
public class YxRolePermissionRelation extends BaseDomain {
    private YxRole role;
    private YxPermission permission;

    @Id
    @ManyToOne
    public YxPermission getPermission() {
        return permission;
    }

    public void setPermission(YxPermission permission) {
        this.permission = permission;
    }

    @Id
    @ManyToOne
    public YxRole getRole() {

        return role;
    }

    public void setRole(YxRole role) {
        this.role = role;
    }
}

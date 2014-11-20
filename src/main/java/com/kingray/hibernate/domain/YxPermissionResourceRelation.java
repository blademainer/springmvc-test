package com.kingray.hibernate.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
@IdClass(YxPermissionResourceRelationPK.class)
public class YxPermissionResourceRelation extends BaseDomain {
    private YxPermission permission;
    private YxResource resource;

    @Id
    @ManyToOne
    public YxPermission getPermission() {
        return permission;
    }

    public void setPermission(YxPermission yxPermissionByPermissionId) {
        this.permission = yxPermissionByPermissionId;
    }

    @Id
    @ManyToOne
    public YxResource getResource() {
        return resource;
    }

    public void setResource(YxResource yxResourceByResourceId) {
        this.resource = yxResourceByResourceId;
    }
}

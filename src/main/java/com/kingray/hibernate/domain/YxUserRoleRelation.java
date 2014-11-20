package com.kingray.hibernate.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
@IdClass(YxUserRoleRelationPK.class)
public class YxUserRoleRelation extends BaseDomain {
    private PUser user;
    private YxRole role;

    @Id
    @ManyToOne
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
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

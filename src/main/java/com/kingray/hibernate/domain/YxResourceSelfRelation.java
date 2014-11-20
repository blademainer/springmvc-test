package com.kingray.hibernate.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
@IdClass(YxResourceSelfRelationPK.class)
public class YxResourceSelfRelation extends BaseDomain {
    @JsonIgnore
    private YxResource yxResourceBySuperiorResourceId;
    private YxResource yxResourceBySublevelResourceId;

    @ManyToOne
    @Id
    public YxResource getYxResourceBySuperiorResourceId() {
        return yxResourceBySuperiorResourceId;
    }

    public void setYxResourceBySuperiorResourceId(YxResource yxResourceBySuperiorResourceId) {
        this.yxResourceBySuperiorResourceId = yxResourceBySuperiorResourceId;
    }

    @ManyToOne
    @Id
    public YxResource getYxResourceBySublevelResourceId() {
        return yxResourceBySublevelResourceId;
    }

    public void setYxResourceBySublevelResourceId(YxResource yxResourceBySublevelResourceId) {
        this.yxResourceBySublevelResourceId = yxResourceBySublevelResourceId;
    }
}

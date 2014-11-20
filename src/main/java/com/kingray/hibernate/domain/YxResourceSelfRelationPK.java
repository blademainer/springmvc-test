package com.kingray.hibernate.domain;


import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
public class YxResourceSelfRelationPK extends BaseDomain implements Serializable {
    private YxResource yxResourceBySuperiorResourceId;
    private YxResource yxResourceBySublevelResourceId;

    @Id
    public YxResource getYxResourceBySuperiorResourceId() {
        return yxResourceBySuperiorResourceId;
    }

    public void setYxResourceBySuperiorResourceId(YxResource yxResourceBySuperiorResourceId) {
        this.yxResourceBySuperiorResourceId = yxResourceBySuperiorResourceId;
    }

    @Id
    public YxResource getYxResourceBySublevelResourceId() {
        return yxResourceBySublevelResourceId;
    }

    public void setYxResourceBySublevelResourceId(YxResource yxResourceBySublevelResourceId) {
        this.yxResourceBySublevelResourceId = yxResourceBySublevelResourceId;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        YxResourceSelfRelationPK that = (YxResourceSelfRelationPK) o;
//
//        if (sublevelResourceId != null ? !sublevelResourceId.equals(that.sublevelResourceId) : that.sublevelResourceId != null)
//            return false;
//        if (superiorResourceId != null ? !superiorResourceId.equals(that.superiorResourceId) : that.superiorResourceId != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = superiorResourceId != null ? superiorResourceId.hashCode() : 0;
//        result = 31 * result + (sublevelResourceId != null ? sublevelResourceId.hashCode() : 0);
//        return result;
//    }
}

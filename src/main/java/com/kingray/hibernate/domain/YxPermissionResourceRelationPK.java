package com.kingray.hibernate.domain;


import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
public class YxPermissionResourceRelationPK extends BaseDomain implements Serializable {
    private YxPermission permission;
    private YxResource resource;

    @Id
    public YxPermission getPermission() {
        return permission;
    }

    public void setPermission(YxPermission yxPermissionByPermissionId) {
        this.permission = yxPermissionByPermissionId;
    }

    @Id
    public YxResource getResource() {
        return resource;
    }

    public void setResource(YxResource yxResourceByResourceId) {
        this.resource = yxResourceByResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxPermissionResourceRelationPK that = (YxPermissionResourceRelationPK) o;
        if (permission != null ? that.permission == null : that.permission != null) {
            return false;
        }
        if (resource != null ? that.resource == null : that.resource != null) {
            return false;
        }

        if (permission.getPermissionId() != null ? !permission.getPermissionId().equals(that.permission.getPermissionId()) : that.permission.getPermissionId() != null)
            return false;
        if (resource.getResourceId() != null ? !resource.getResourceId().equals(that.resource.getResourceId()) : that.resource.getResourceId() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resource.getResourceId() != null ? resource.getResourceId().hashCode() : 0;
        result = 31 * result + (permission.getPermissionId() != null ? permission.getPermissionId().hashCode() : 0);
        return result;
    }
}

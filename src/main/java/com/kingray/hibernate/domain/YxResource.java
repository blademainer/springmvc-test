package com.kingray.hibernate.domain;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/3/24 0024.
 */
@Entity
public class YxResource extends BaseDomain {
    private Integer resourceId;
    private Integer resourceTypeId;
    @NotEmpty(message = "资源名不能为空")
    @Size(min = 3, max = 10, message = "资源名必须在3-10之间")
    private String resourceName;
    private String resourceCode;
    private String resourceDescribe;
    private Byte resourceDisplay;
    private String resourceIcon;
    @NumberFormat
    private Integer resourceSortNumber;

    @Id
    @GeneratedValue
    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceDescribe() {
        return resourceDescribe;
    }

    public void setResourceDescribe(String resourceDescribe) {
        this.resourceDescribe = resourceDescribe;
    }

    public Byte getResourceDisplay() {
        return resourceDisplay;
    }

    public void setResourceDisplay(Byte resourceDisplay) {
        this.resourceDisplay = resourceDisplay;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public Integer getResourceSortNumber() {
        return resourceSortNumber;
    }

    public void setResourceSortNumber(Integer resourceSortNumber) {
        this.resourceSortNumber = resourceSortNumber;
    }

//    /**
//     * 获取父级资源<br>
//     * 识别方法：getYxResourceSelfRelationsByResourceId() -> YxResource.yxResourceBySuperiorResourceId -> 数据库字段：SUPERIOR_RESOURCE_ID<br>
//     * SUPERIOR_RESOURCE_ID表示资源自关联中的父级资源；因此与SUPERIOR_RESOURCE_ID关联的资源是其子资源<br>
//     * YxResource.yxResourceBySuperiorResourceId表示SUPERIOR_RESOURCE_ID的子集资源；<br>
//     * getYxResourceSelfRelationsByResourceId()关联着YxResource.yxResourceBySuperiorResourceId，因此getYxResourceSelfRelationsByResourceId对应为子资源<br>
//     */
//    @OneToMany(mappedBy = "yxResourceBySublevelResourceId")
//    public Collection<YxResourceSelfRelation> getYxResourceSelfRelationsForSublevelResourceId() {
//        return yxResourceSelfRelationsForSublevelResourceId;
//    }
//
//    /**
//     * 获取子级资源<br>
//     * 识别方法：getYxResourceSelfRelationsByResourceId() -> YxResource.yxResourceBySuperiorResourceId -> 数据库字段：SUPERIOR_RESOURCE_ID<br>
//     * SUPERIOR_RESOURCE_ID表示资源自关联中的父级资源；因此与SUPERIOR_RESOURCE_ID关联的资源是其子资源<br>
//     * YxResource.yxResourceBySuperiorResourceId表示SUPERIOR_RESOURCE_ID的子集资源；<br>
//     * getYxResourceSelfRelationsByResourceId()关联着YxResource.yxResourceBySuperiorResourceId，因此getYxResourceSelfRelationsByResourceId对应为子资源<br>
//     */
//    @OneToMany(mappedBy = "yxResourceBySuperiorResourceId")
//    public Collection<YxResourceSelfRelation> getYxResourceSelfRelationsForSuperiorResourceId() {
//        return yxResourceSelfRelationsForSuperiorResourceId;
//    }

}

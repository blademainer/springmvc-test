package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * 项目合同
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/30 0030.
 */
@Entity
public class BizContract extends BaseDomain {
    private Integer contractId;
    /**
     * 合同号
     */
    private String contractNumber;
    /**
     * 上传文件
     */
    private Collection<YxFile> files;

    @Id
    @GeneratedValue
    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @OneToMany
    public Collection<YxFile> getFiles() {
        return files;
    }

    public void setFiles(Collection<YxFile> files) {
        this.files = files;
    }
}

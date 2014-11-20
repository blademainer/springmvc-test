package com.kingray.hibernate.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 订单，用户投资项目后生成对应订单
 * Created by qi on 2014/11/14 0014.
 */
@Entity
public class BizOrder extends BaseDomain {
    private Integer orderId;

    private String orderNumber;

    private Double orderAmount;

    private BizOrderStatus orderStatus;

    @Id
    @GeneratedValue
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @ManyToOne
    public BizOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(BizOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}

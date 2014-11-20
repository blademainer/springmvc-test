package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by hmm on 14-8-13.
 */
@Entity
public class FriendRelation extends BaseDomain {

    private Integer id;
    /**
     *邀请人
     */
    PUser inviter;
    /**
     *被邀请人
     */
    PUser invitee;


    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public PUser getInviter() {
        return inviter;
    }

    public void setInviter(PUser inviter) {
        this.inviter = inviter;
    }

    @ManyToOne
    public PUser getInvitee() {
        return invitee;
    }


    public void setInvitee(PUser invitee) {
        this.invitee = invitee;
    }
}

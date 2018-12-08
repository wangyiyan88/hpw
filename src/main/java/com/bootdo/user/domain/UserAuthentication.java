package com.bootdo.user.domain;

import java.util.Date;

public class UserAuthentication {
    private Integer id;

    private String userid;

    private String idcard;

    private String idpositiveimg;

    private String idsideimg;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getIdpositiveimg() {
        return idpositiveimg;
    }

    public void setIdpositiveimg(String idpositiveimg) {
        this.idpositiveimg = idpositiveimg == null ? null : idpositiveimg.trim();
    }

    public String getIdsideimg() {
        return idsideimg;
    }

    public void setIdsideimg(String idsideimg) {
        this.idsideimg = idsideimg == null ? null : idsideimg.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
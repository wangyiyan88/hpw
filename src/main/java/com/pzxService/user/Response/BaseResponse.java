package com.pzxService.user.Response;



public class BaseResponse {

    private String  Responsestatus ="0001";

    private String  ResponseText="成功";

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResponsestatus() {
        return Responsestatus;
    }

    public void setResponsestatus(String responsestatus) {
        Responsestatus = responsestatus;
    }

    public String getResponseText() {
        return ResponseText;
    }

    public void setResponseText(String responseText) {
        ResponseText = responseText;
    }



}

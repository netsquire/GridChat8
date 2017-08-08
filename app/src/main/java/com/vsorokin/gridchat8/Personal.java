package com.vsorokin.gridchat8;

/**
 * All related to personal and identification
 * <p>
 * Created by vsorokin on 8/7/2017.
 */

class Personal {

    private String id;
    private String ip;

    Personal(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }
}

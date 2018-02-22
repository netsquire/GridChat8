package com.vsorokin.gridchat8.model;

/**
 * All related to personal and identification
 * <p>
 * Created by vsorokin on 8/7/2017.
 */

class Personal {

    private static String id;
    private String ip;

    Personal(String id) {
        Personal.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setId(String id) {
        Personal.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    static String getId() {
        return id;
    }
}

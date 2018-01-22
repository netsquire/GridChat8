package com.vsorokin.gridchat8;

/**
 *
 * Created by netsquire on 12/20/17.
 */

public class GridContext {

    private static String instanceName = "Put your name here";
    private static String peerName;
    private static String ip;

    public static String getInstanceName() {
        return instanceName;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        GridContext.ip = ip;
    }

    static void setInstanceName(String instanceName) {
        GridContext.instanceName = instanceName;
    }

    public static String getPeerName() {return peerName;}

    static void setPeerName(String peerName) { GridContext.peerName = peerName;}

}


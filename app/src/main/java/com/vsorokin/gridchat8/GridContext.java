package com.vsorokin.gridchat8;

import java.util.Map;

public class GridContext {

    private static String instanceName = "your name here";
    private static String peerName;
    private static String ip;
    private static Map<String, String> peerList;

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

    public static void setPeerList(Map<String, String> peerList) {
        GridContext.peerList = peerList;
    }

    public static Map<String, String> getPeerList() {
        return peerList;
    }
}


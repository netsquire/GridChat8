package com.vsorokin.gridchat8.model;

import java.util.List;

public class GridContext {

    private static String instanceName = "Local instance name";
    private static String peerName;
    private static String ip;
    private static List<Contact> peerList;

    private static int position;

    public static String getInstanceName() {
        return instanceName;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        GridContext.ip = ip;
    }

    public static void setInstanceName(String instanceName) {
        GridContext.instanceName = instanceName;
    }

    public static String getPeerName() {return peerName;}

    static void setPeerName(String peerName) { GridContext.peerName = peerName;}

    public static void setPeerList(List<Contact> peerList) {
        GridContext.peerList = peerList;
    }

    public static List<Contact> getPeerList() {
        return peerList;
    }

    public static int getPosition() {
        return position;
    }

    public static void setPosition(int position) {
        GridContext.position = position;
    }
}


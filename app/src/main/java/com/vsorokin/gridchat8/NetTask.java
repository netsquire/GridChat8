package com.vsorokin.gridchat8;

import android.os.AsyncTask;
import android.util.Log;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.Enumeration;

class NetTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... params) {
        return getAllIp(6);
    }

    private String getAllIp(int version) {
        String ipv4 = "?.?.?.?";
        String ipv6 = "?:?:?:?";
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkInterface = en.nextElement();
                Enumeration<InetAddress> addrs = networkInterface.getInetAddresses();
                while (addrs.hasMoreElements()){
                    InetAddress inetAddress = addrs.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        Log.d("IP", "HostAddress IP=" + inetAddress.getHostAddress());
                        if(inetAddress instanceof Inet4Address) {
                            ipv4 = inetAddress.getHostAddress();
                        }
                        if(inetAddress instanceof Inet6Address) {
                            ipv6 = inetAddress.getHostAddress().split("%")[0];
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return version == 4 ? ipv4 : ipv6;
    }
}

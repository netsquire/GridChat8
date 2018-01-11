package com.vsorokin.gridchat8.net;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ObtainOwnIp extends AsyncTask<Void, Void, Void> {

    private static final int IP_VERSION = 6;

    public ObtainOwnIp(TextView selfIp) {
        selfIp.setText(getAllIp());
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    private String getAllIp() {
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
        return IP_VERSION == 4 ? ipv4 : ipv6;
    }
}

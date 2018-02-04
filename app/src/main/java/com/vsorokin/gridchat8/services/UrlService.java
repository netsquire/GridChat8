package com.vsorokin.gridchat8.services;

import static com.vsorokin.gridchat8.Constants.LOCATOR_URL;

public class UrlService {

    /**
     * 	~> @Path("/{id}/ip/{ip}")
     *
     * @param ip
     * @param alias
     * @return
     */
    public static String buildAnnounceUrl(String ip, String alias) {
        return LOCATOR_URL + alias + "/ip/" + ip;
    }

    public static String buildGetIpUrl(String id) {
        return LOCATOR_URL + "ip/" + id;
    }


}

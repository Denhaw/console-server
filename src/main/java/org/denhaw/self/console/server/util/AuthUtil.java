package org.denhaw.self.console.server.util;

import org.denhaw.self.console.server.constant.AuthConstants;

public class AuthUtil {
    public static boolean isAuthUrl(String url){
        if(url==null){
            return false;
        }
        for(String item:AuthConstants.AUTH_URL_ITEM_LIST){
            if(url.contains(item)){
                return true;
            }
        }
        return false;
    }
}

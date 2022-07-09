package org.denhaw.self.console.server.app;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Console implements Serializable {
    private Map<String,App> apps;
    public Console(){
        apps=new LinkedHashMap<>();
    }

    public String getAppName() {
        return "console";
    }

    public String getHelpInf() {
        return null;
    }

    public App.Response invoke(String appName,String operation,Map<String, Object> paramMap) {
        App app=this.apps.get(appName);

        return null;
    }

}

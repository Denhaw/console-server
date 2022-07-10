package org.denhaw.self.console.server.dao;

import org.denhaw.self.console.server.app.App;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RuntimeAppMemory {
    private Map<String,App> appMap;
    private final ReentrantLock appChangeLock;
    public RuntimeAppMemory(){
        this.appChangeLock=new ReentrantLock();
    }
    public void setApps(List<App> apps){
        this.appChangeLock.lock();
        this.appMap=new LinkedHashMap<>();
        apps.forEach(app -> {
            appMap.put(app.getAppName(),app);
        });
        this.appChangeLock.unlock();
    }
    public boolean containsApp(String appName){
        return this.appMap.containsKey(appName);
    }
    public App getApp(String appName){
        return this.appMap.get(appName);
    }
}

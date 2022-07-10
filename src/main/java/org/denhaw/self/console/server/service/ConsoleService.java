package org.denhaw.self.console.server.service;

import org.denhaw.self.console.server.app.App;
import org.denhaw.self.console.server.dao.RuntimeAppMemory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConsoleService implements Serializable {
    @Resource
    private RuntimeAppMemory runtimeAppMemory;

    public String getAppName() {
        return "console";
    }

    public String getHelpInf() {
        return null;
    }

    public App.Response invoke(String appName, String operation, Map<String, Object> paramMap) {

        return null;
    }

}

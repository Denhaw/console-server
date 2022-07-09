package org.denhaw.self.console.server.app;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

public interface App extends Serializable {
    String getAppName();
    String getHelpInf();
    App.Response invoke(String opName,Map<String,Object> paramMap);
    Map<String,App.Operation> getOperations();
    @Data
    @AllArgsConstructor
    class Response implements Serializable{
        private Boolean success;
        private String msg;
        private String result;
        public static App.Response buildSuccessfulResponse(String result){
            return new App.Response(true,"",result);
        }
        public static App.Response buildFailedResponse(String msg){
            return new App.Response(true,msg,"");
        }
    }
    @Data
    @AllArgsConstructor
    class Operation implements Serializable{
        private String opName;
        private Map<String,Class<?>> params;
    }

}

package br.com.srvletapi.classes;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class ParameterHandling {

    public static String getRequiredParameter(HttpServletRequest req, String paramName) throws Exception {
        return Optional.ofNullable(req.getParameter(paramName))
                    .orElseThrow(() -> new Exception("Parâmetro '" + paramName + "' não foi passado!"));
    }

    public static String getRequiredKey(JSONObject body, String keyName) throws Exception {
        return Optional.ofNullable(body.optString(keyName))
                    .orElseThrow(() -> new Exception("Parâmetro '" + keyName + "' não foi passado!"));
    }
    
    
}

package br.com.srvletapi;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class ParameterHandling {

    public static String getRequiredParameter(HttpServletRequest req, String keyName) throws Exception {
        return Optional.ofNullable(req.getParameter(keyName))
                    .orElseThrow(() -> new Exception("Parâmetro '" + keyName + "' não foi passado!"));
    }
    public static String getRequiredKey(JSONObject body, String keyName) throws Exception {
        return Optional.ofNullable(body.optString(keyName))
                    .orElseThrow(() -> new Exception("Parâmetro '" + keyName + "' não foi passado!"));
    }
    public static String getOptionalKey(JSONObject body, String keyName) throws Exception {
        return Optional.ofNullable(body.optString(keyName))
                       .filter(value -> !value.isEmpty())
                       .orElse(null);
    }
    
    
}

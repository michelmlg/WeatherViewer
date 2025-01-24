package br.com.srvletapi.classes;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

public class RequestBodyReader {
    public static JSONObject readRequestBody(BufferedReader reader) throws IOException{
        var body = new StringBuilder();
        var line = "";

        while((line = reader.readLine()) != null){
            body.append(line);
        }

        return new JSONObject(body.toString());
    }
}

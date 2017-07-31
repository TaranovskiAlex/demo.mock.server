package com.example.demo.mock.server.converter.log;

import com.example.demo.mock.server.converter.body.ResponseBodyExtractor;
import com.example.demo.mock.server.domain.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by OTARANOVSKYI on 28.07.2017.
 */
@Component
public class ResponseDataProducer {

    @Autowired
    private ResponseBodyExtractor responseBodyExtractor;
    @Autowired
    private LogExtractor logExtractor;

    public ResponseData createResponse(Map map) {
        String message = getFormattedMessage(map);

        Map<String, Object> response = logExtractor.getResponse(message);

        Map<String, Object> body = responseBodyExtractor.getBody(response);

        ResponseData responseData = new ResponseData();

        responseData.setResponse(response);
        responseData.setBody(body);

        return responseData;
    }

    private String getFormattedMessage(Map map) {
        return (String) map.get("formattedMessage");
    }
}
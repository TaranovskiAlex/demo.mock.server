package com.example.demo.mock.server.converter.log;

import com.example.demo.mock.server.converter.body.RequestBodyExtractor;
import com.example.demo.mock.server.domain.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by OTARANOVSKYI on 28.07.2017.
 */
@Component
public class RequestDataProducer {

    @Autowired
    private RequestBodyExtractor requestBodyExtractor;

    public RequestData createRequestData(Map request) {
        Map<String, Object> body = requestBodyExtractor.getBody(request);

        RequestData requestData = new RequestData();

        requestData.setRequest(request);
        requestData.setBody(body);

        return requestData;
    }

}

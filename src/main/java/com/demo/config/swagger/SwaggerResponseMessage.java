package com.demo.config.swagger;

import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by elena.miovska on 26.12.2016 г..
 */
public class SwaggerResponseMessage {

    public static ResponseMessage buildResponseMessage(int code, String message) {
        return new ResponseMessageBuilder()
                .code(code)
                .message(message)
                .build();
    }

    /**
     * @return A list of all Swagger Response Messages
     */
    public static List<ResponseMessage> buildResponseMessages() {
        return Arrays.asList(
                buildResponseMessage(500, "SCI internal server error"));
    }
}

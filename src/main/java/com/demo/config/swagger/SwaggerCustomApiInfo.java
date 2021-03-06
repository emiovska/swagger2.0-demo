package com.demo.config.swagger;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Created by elena.miovska on 26.12.2016 г..
 */
public class SwaggerCustomApiInfo {

    private static String TITLE = "Swagger demo REST API";
    private static String DESCRIPTION = "Custom description of API";
    private static String API_VERSION = "API Version";
    private static String TERMS_OF_SERVICES_URL = "Terms of services URL";
    private static String CONTACT_NAME = "Elena Miovska";
    private static String CONTACT_URL = "Contact URL";
    private static String CONTACT_EMAIL = "elena.miovska.1@bg.ibm.com";
    private static String LICENSE = "License";
    private static String LICENSE_URL = "License URL";

    private static Contact CONTACT = new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);


    public static ApiInfo apiInfo() {
        return new ApiInfo(TITLE, DESCRIPTION, API_VERSION, TERMS_OF_SERVICES_URL, CONTACT,LICENSE, LICENSE_URL);
    }
}

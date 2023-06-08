package org.example.application.template.controller;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.example.application.template.config.Routes;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
@Log4j
public class ApiControllerService {

    private final Routes routes;

    public ApiControllerService(Routes routes) {
        this.routes = routes;
    }

    public Response getResponseFromActivityURL() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        log.debug("ApiController: GET requested");
        return given().contentType(ContentType.JSON).when().get(routes.getActivityURL());
    }
}
package org.example.application.template.modelStructure;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Log4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class POJOResponse {

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public POJOResponse(Response response) {
        this.activity = response.body().jsonPath().getString("activity");
        this.type = response.body().jsonPath().getString("type");
        this.participants = response.body().jsonPath().getInt("participants");
        this.link = response.body().jsonPath().getString("link");
        this.key = response.body().jsonPath().getString("key");
        this.accessibility = response.body().jsonPath().getDouble("accessibility");
    }

    public void checkResponseChema(Response response) {
        response.then().assertThat()
                .body(JsonSchemaValidator
                              .matchesJsonSchemaInClasspath("schemas/jsonSchema.json"));
    }
}

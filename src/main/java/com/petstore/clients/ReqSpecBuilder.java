package com.petstore.clients;


import com.petstore.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.UUID;

import static io.restassured.http.ContentType.JSON;

public class ReqSpecBuilder {

    public RequestSpecification prepareReq(String domain){
        return new RequestSpecBuilder()
                .setBaseUri(Config.getProperties(domain))
                .setContentType(JSON)
                .addHeader("x-correlationid", UUID.randomUUID().toString())
                .addHeader("x-executor-user","Pet store")
                .addHeader("x-agentname","Pet store")
                .build();
    }
}

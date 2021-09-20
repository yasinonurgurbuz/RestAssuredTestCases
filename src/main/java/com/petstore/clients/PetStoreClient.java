package com.petstore.clients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.petstore.models.petstoreapi.request.UserCreateRequest;
import com.petstore.models.petstoreapi.request.UserUpdateRequest;
import com.petstore.models.petstoreapi.response.UserCreateResponse;
import com.petstore.models.petstoreapi.response.UserUpdatedResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetStoreClient extends ReqSpecBuilder{
    private final RequestSpecification request;

    private Gson gson = new GsonBuilder().serializeNulls().create();

    public PetStoreClient() {
        this.request = prepareReq("PETSTORE_API_URL");
    }

    public UserCreateResponse setUserAccountForPetStore(UserCreateRequest userCreateRequest) {
        return gson.fromJson(
                given()
                        .spec(request)
                        .body(gson.toJson(userCreateRequest))
                        .post("/v2/user")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .response()
                        .getBody()
                        .asString(), UserCreateResponse.class);
    }

    public void setUserInformationUpdateRequest(String username, UserUpdateRequest userUpdateRequest) {
        given()
                .spec(request)
                .body(gson.toJson(userUpdateRequest))
                .when()
                .put("/v2/user/" + username)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public UserUpdatedResponse getUpdatedPetStoreUserInformationWithUserName(String username) {
        return gson.fromJson(
                given()
                        .spec(request)
                        .get("/v2/user/" + username)
                        .then()
                        .assertThat()
                        .extract()
                        .response()
                        .getBody()
                        .asString(), UserUpdatedResponse.class
        );
    }




}

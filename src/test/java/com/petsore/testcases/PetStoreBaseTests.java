package com.petsore.testcases;

import com.petstore.clients.PetStoreClient;
import com.petstore.models.petstoreapi.request.UserCreateRequest;
import com.petstore.models.petstoreapi.request.UserUpdateRequest;
import com.petstore.models.petstoreapi.response.UserUpdatedResponse;

public class PetStoreBaseTests {
    private PetStoreClient petStoreClient = new PetStoreClient();

    public void setUserAccountForPetStore(UserCreateRequest userCreateRequest){
        petStoreClient.setUserAccountForPetStore(userCreateRequest);
    }

    public void setUserInformationUpdateRequest(String username, UserUpdateRequest userUpdateRequest){
        petStoreClient.setUserInformationUpdateRequest(username, userUpdateRequest);
    }

    public UserUpdatedResponse getUpdatedPetStoreUserInformationWithUserName(String username){
        return petStoreClient.getUpdatedPetStoreUserInformationWithUserName(username);
    }



}

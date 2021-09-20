package com.petsore.testcases;

import com.petstore.models.petstoreapi.request.UserCreateRequest;
import com.petstore.models.petstoreapi.request.UserUpdateRequest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTests extends PetStoreBaseTests{
    @Test
    public void it_should_create_user_for_pet_store(){
        //Given : Create an user for PetStore
        var username = "userName";
        var firstName = "User First Name;";
        var userCreateRequest = UserCreateRequest
                .builder()
                .id(111L)
                .username(username)
                .firstName(firstName)
                .lastName("User Last Name")
                .email("useremail@gmail.com")
                .password("1234user")
                .phone("095555555555")
                .userStatus(1L)
                .build();
        setUserAccountForPetStore(userCreateRequest);

        //When : Update the user information on Pet Store
        var updateFirstName = "User Update First Name";
        var userUpdateRequest = UserUpdateRequest
                .builder()
                .id(111L)
                .username(username)
                .firstName(updateFirstName)
                .lastName("User Update Last Name")
                .email("updateduseremail@gmail.com")
                .password("1234updateduser")
                .phone("095555555555")
                .userStatus(1L)
                .build();
        setUserInformationUpdateRequest(username,userUpdateRequest);

        //Then : Check the values for updated user Information
        var petStoreUpdatedUserResponse = getUpdatedPetStoreUserInformationWithUserName(username);
        var updatedFirstName = petStoreUpdatedUserResponse.getFirstName();
        assertThat("Check the updateFirstName is equal to updatedFirstName", updateFirstName, equalTo(updatedFirstName));
    }
}

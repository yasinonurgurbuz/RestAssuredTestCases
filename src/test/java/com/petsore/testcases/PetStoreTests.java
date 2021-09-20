package com.petsore.testcases;

import com.petstore.models.petstoreapi.request.UserCreateRequest;
import com.petstore.models.petstoreapi.request.UserUpdateRequest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTests extends PetStoreBaseTests{
    @Test
    public void it_should_create_user_for_pet_store(){

        //Given : Create a user for PetStore
        var username = "mehmet";
        var firstName = "Mehmet;";
        var userCreateRequest = UserCreateRequest
                .builder()
                .id(111L)
                .username(username)
                .firstName(firstName)
                .lastName("Gürbüz")
                .email("deneme@gmail.com")
                .password("1234asdf")
                .phone("095555555555")
                .userStatus(1L)
                .build();
        setUserAccountForPetStore(userCreateRequest);

        //When : Set package to the archive with migration
        var updateFirstName = "Ahmet";
        var userUpdateRequest = UserUpdateRequest
                .builder()
                .id(111L)
                .username(username)
                .firstName(updateFirstName)
                .lastName("Gürbüz")
                .email("updatedemail@gmail.com")
                .password("updatedPassword")
                .phone("updatedPhoneNumber")
                .userStatus(1L)
                .build();

        setUserInformationUpdateRequest(username,userUpdateRequest);

        //Then : Check the values for updated user Information
        var petStoreUpdatedUserResponse = getUpdatedPetStoreUserInformationWithUserName(username);
        var updatedFirstName = petStoreUpdatedUserResponse.getFirstName();



        assertThat("Check the orderNumber before the migrate", updateFirstName, equalTo(updatedFirstName));
    }
}

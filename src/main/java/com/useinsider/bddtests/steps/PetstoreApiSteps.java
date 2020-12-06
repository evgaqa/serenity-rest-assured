package com.useinsider.bddtests.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Condition;

import static net.serenitybdd.rest.SerenityRest.given;

public class PetstoreApiSteps {

    private static final String PET_STORE_URL = "https://petstore.swagger.io/v2";
    private static final String GET_PET_BY_ID = "/pet/{id}";
    private static final String ADD_PET = "/pet";
    private static final String UPDATE_PET = "/pet";
    private static final String DELETE_PET = "/pet/{petId}";
    private static final String FIND_PETS_BY_STATUS = "/pet/findByStatus";
    private static final String UPDATE_PET_WITH_FORM_DATA = "/pet/{petId}";

    @Step("GET /pet/{petId} Find pet by ID")
    public Response getPetById(long petId) {
        return given()
                .basePath(GET_PET_BY_ID)
                .baseUri(PET_STORE_URL)
                .contentType("application/json")
                .pathParam("id", petId)
                .get()
                .then()
                .extract().response();
    }

    @Step("POST /pet Add a new pet to the store")
    public Response createPet(Pet pet) {
        System.out.println("REQUEST " + pet.toString());
        return given()
                .baseUri(PET_STORE_URL)
                .basePath(ADD_PET)
                .contentType("application/json")
                .body(pet)
                .post()
                .then()
                .extract().response();
    }

    @Step("PUT /pet Update an existing pet")
    public Response updatePet(Pet pet) {
        return given()
                .baseUri(PET_STORE_URL)
                .basePath(UPDATE_PET)
                .contentType("application/json")
                .body(pet)
                .put()
                .then()
                .extract().response();
    }

    @Step("DELETE /pet/{petId} Deletes a pet")
    public Response deletePet(long petId, String API_KEY) {
        return given()
                .baseUri(PET_STORE_URL)
                .basePath(DELETE_PET)
                .contentType("application/json")
                .header("api_key", API_KEY)
                .pathParam("petId", petId)
                .delete()
                .then()
                .extract().response();
    }

    @Step("GET /pet/findByStatus Finds Pets by status")
    public Response getPetsByStatus(String petStatus) {
        return given()
                .baseUri(PET_STORE_URL)
                .basePath(FIND_PETS_BY_STATUS)
                .contentType("application/json")
                .param("status", petStatus)
                .get();
    }

    @Step("POST /pet/{petId} Updates a pet in the store with form data")
    public Response updatePetWithFormData(long petId, String petName, String petStatus) {
        return given()
                .baseUri(PET_STORE_URL)
                .basePath(UPDATE_PET_WITH_FORM_DATA)
                .contentType("application/json")
                .contentType("application/x-www-form-urlencoded")
                .pathParam("petId", petId)
                .param("name", petName)
                .param("status", petStatus)
                .post()
                .then()
                .extract().response();
    }
}

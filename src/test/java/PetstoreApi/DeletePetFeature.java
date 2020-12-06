package PetstoreApi;

import com.useinsider.bddtests.steps.Pet;
import com.useinsider.bddtests.steps.PetstoreApiSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@WithTag("PetstoreAPI")
public class DeletePetFeature {

    private static final String API_KEY = "special-key";

    @Steps
    private PetstoreApiSteps petstoreApiSteps;

    @Test
    public void deletePet() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = "available";
        Pet pet = new Pet(petId, petName, petStatus);

        long newPetId = petstoreApiSteps
                .createPet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("name", is(petName))
                .body("status", is(petStatus))
                .extract().path("id");

        petstoreApiSteps
                .deletePet(newPetId, API_KEY)
                .then()
                .statusCode(200)
                .and()
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(String.valueOf(newPetId)));

        petstoreApiSteps
                .getPetById(newPetId)
                .then()
                .statusCode(404)
                .and()
                .body("code", is(1))
                .body("type", is("error"))
                .body("message", is("Pet not found"));
    }

    @Test
    public void deleteAlreadyDeletedPet() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = "available";
        Pet pet = new Pet(petId, petName, petStatus);

        long newPetId = petstoreApiSteps
                .createPet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("name", is(petName))
                .body("status", is(petStatus))
                .extract().path("id");

        petstoreApiSteps
                .deletePet(newPetId, API_KEY)
                .then()
                .statusCode(200)
                .and()
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(String.valueOf(newPetId)));

        petstoreApiSteps
                .deletePet(newPetId, API_KEY)
                .then()
                .statusCode(404);
    }

    //This test detect a bug, pet could be deleted with any API key
    @Test
    public void deletePetWithWrongApiKey() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = "available";
        Pet pet = new Pet(petId, petName, petStatus);

        long newPetId = petstoreApiSteps
                .createPet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("name", is(petName))
                .body("status", is(petStatus))
                .extract().path("id");

        petstoreApiSteps
                .deletePet(newPetId, "wrong-key")
                .then()
                .statusCode(400);
    }
}

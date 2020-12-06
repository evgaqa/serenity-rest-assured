package PetstoreApi;

import com.useinsider.bddtests.steps.Pet;
import com.useinsider.bddtests.steps.PetstoreApiSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@WithTag("PetstoreAPI")
public class CreatePetFeature {

    @Steps
    private PetstoreApiSteps petstoreApiSteps;

    @Test
    public void createNewPet() {
        int petId = 0;
        String petName = null;
        String petStatus = null;
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
                .getPetById(newPetId)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));
    }

    @Test
    public void createNewPetWithName() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = null;
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
                .getPetById(newPetId)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));
    }

    @Test
    public void createNewPetWithStatus() {
        int petId = 0;
        String petName = null;
        String petStatus = "available" + new Date().getTime();
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
                .getPetById(newPetId)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));
    }

    @Test
    public void createNewPetWithNameAndStatus() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = "notAvailable" + new Date().getTime();
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
                .getPetById(newPetId)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));
    }

    @Test
    public void createNewPetEmptyJSON() {
        String petName = null;
        String petStatus = null;
        Pet pet = new Pet();

        long newPetId = petstoreApiSteps
                .createPet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("name", is(petName))
                .body("status", is(petStatus))
                .extract().path("id");
        petstoreApiSteps
                .getPetById(newPetId)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));
    }
}

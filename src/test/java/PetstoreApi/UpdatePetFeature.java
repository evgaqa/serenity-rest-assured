package PetstoreApi;

import com.useinsider.bddtests.steps.Pet;
import com.useinsider.bddtests.steps.PetstoreApiSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@WithTag("PetstoreAPI")
public class UpdatePetFeature {

    @Steps
    private PetstoreApiSteps petstoreApiSteps;

    @Test
    public void updatePetName() {
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

        petName = "gorilla" + new Date().getTime();
        pet = new Pet(newPetId, petName, petStatus);

        petstoreApiSteps
                .updatePet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));

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
    public void updatePetStatus() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
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

        petStatus = "notAvailable" + new Date().getTime();

        pet = new Pet(newPetId, petName, petStatus);

        petstoreApiSteps
                .updatePet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));

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
    public void updatePetNameAndStatus() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
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

        petName = "gorilla" + new Date().getTime();
        petStatus = "notAvailable" + new Date().getTime();

        pet = new Pet(newPetId, petName, petStatus);

        petstoreApiSteps
                .updatePet(pet)
                .then()
                .statusCode(200)
                .and()
                .body("id", is(newPetId))
                .body("name", is(petName))
                .body("status", is(petStatus));

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
    public void updatePetNameAndStatusWithFormData() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
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

        petName = "gorilla" + new Date().getTime();
        petStatus = "notAvailable" + new Date().getTime();

        petstoreApiSteps
                .updatePetWithFormData(newPetId, petName, petStatus)
                .then()
                .statusCode(200)
                .and()
                .body("message", is(String.valueOf(newPetId)))
                .body("code", is(200))
                .body("type", is("unknown"));

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

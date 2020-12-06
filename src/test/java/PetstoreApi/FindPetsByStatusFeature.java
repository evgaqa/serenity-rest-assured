package PetstoreApi;

import com.useinsider.bddtests.steps.Pet;
import com.useinsider.bddtests.steps.PetstoreApiSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@WithTag("PetstoreAPI")
public class FindPetsByStatusFeature {

    @Steps
    private PetstoreApiSteps petstoreApiSteps;

    @Test
    public void findPetsByStatus() {
        int petId = 0;
        String petName = "monkey" + new Date().getTime();
        String petStatus = "sold";
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
                .getPetsByStatus(petStatus)
                .then()
                .statusCode(200)
                .and()
                .body("name", hasItem(petName))
                .body("status", hasItem(petStatus))
                .body("id", hasItem(newPetId));
    }
}

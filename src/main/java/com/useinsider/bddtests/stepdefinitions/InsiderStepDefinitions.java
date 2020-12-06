package com.useinsider.bddtests.stepdefinitions;

import com.useinsider.bddtests.steps.InsiderSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class InsiderStepDefinitions {

    @Steps
    private InsiderSteps insiderSteps;

    @When("^Open insider page$")
    public void openInsiderPage() {
        insiderSteps.openInsiderPage();
    }

    @When("^Click in header '(.*)' button$")
    public void clickInButton(String button) {
        insiderSteps.clickInButton(button);
    }
}
package com.useinsider.bddtests.steps;

import com.useinsider.bddtests.page.InsiderPage;
import net.thucydides.core.annotations.Step;

public class InsiderSteps {

    private InsiderPage insiderPage;

    @Step
    public void openInsiderPage() {
        insiderPage.open();
        insiderPage.checkThatHomePageOpened();
    }

    @Step
    public void clickInButton(String button) {
        insiderPage.clickInButton(button);
    }
}

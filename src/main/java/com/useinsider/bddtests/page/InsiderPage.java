package com.useinsider.bddtests.page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DefaultUrl("page:home.page")
public class InsiderPage extends PageObject {

    public void checkThatHomePageOpened() {
        assertThat(getDriver().getTitle(), is("The First Integrated Growth Management Platform - Insider"));
    }

    public void clickInButton(String button) {
        getDriver().findElement(By.xpath("//div[@id='header-outer']/descendant::*[text()='" + button + "']")).click();
    }
}

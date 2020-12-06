package com.useinsider.bddtests.page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DefaultUrl("page:home.page")
public class InsiderCareerPage extends PageObject {

    @FindBy(id = "locations")
    private WebElement cultureBlock;
    @FindBy(id = "culture")
    private WebElement locationsBlock;
    @FindBy(id = "teams")
    private WebElement teamsBlock;
    @FindBy(xpath = "//h2[text()='CAREER OPPORTUNITIES']/ancestor::div[@id='jobs']")
    private WebElement jobsBlock;
    @FindBy(id = "life-at-insider")
    private WebElement lifeAtInsiderBlock;
    @FindBy(className = "jobs-locations")
    private WebElement filterByLocation;
    @FindBy(className = "jobs-list")
    private WebElement jobsList;
    @FindBy(xpath = "//div[@class='postings-btn-wrapper']/a[@class='postings-btn template-btn-submit shamrock']")
    private WebElement headlineApplybtn;

    public void insiderCareerCheckMenuHeadContains(List<String> menuTitles) {
        List<String> items = new ArrayList<>();
        for (WebElement webElement : getDriver().findElements(By.xpath("//h4[@class='vc_custom_heading menu-head']/a"))) {
            items.add(webElement.getText());
        }
        assertThat(items, equalTo(menuTitles));
    }

    public void insiderCareerCheckThatCultureBlockIsVisible() {
        waitFor(ExpectedConditions.visibilityOf(cultureBlock));
    }

    public void insiderCareerCheckThatLocationsBlockIsVisible() {
        waitFor(ExpectedConditions.visibilityOf(locationsBlock));
    }

    public void insiderCareerCheckThatTeamsBlockIsVisible() {
        waitFor(ExpectedConditions.visibilityOf(teamsBlock));
    }

    public void insiderCareerCheckThatJobsBlockIsVisible() {
        waitFor(ExpectedConditions.visibilityOf(jobsBlock));
    }

    public void insiderCareerCheckThatLifeAtInsiderBlockIsVisible() {
        waitFor(ExpectedConditions.visibilityOf(lifeAtInsiderBlock));
    }

    public void insiderCareerScrollToTheCareerOpportunitiesBlock() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView()", jobsBlock);
    }

    public void insiderCareerCareerOpportunitiesChooseOfficeFilter(String office) {
        filterByLocation.click();
        getDriver().findElement(By.xpath("//select[@class='jobs-locations']/option[text()='" + office + "']")).click();
    }

    public void insiderCareerCareerOpportunitiesChooseDepartmentFilter(String department) {
        filterByLocation.click();
        getDriver().findElement(By.xpath("//select[@class='jobs-teams']/option[text()='" + department + "']")).click();
    }

    public void insiderCareerCareerOpportunitiesCheckThePresenceOfJobsList() {
        waitFor(ExpectedConditions.visibilityOf(jobsList));
    }

    public void insiderCareerCareerOpportunitiesCheckThatAllJobsDepartmentIs(String department) {
        for (WebElement webElement : getDriver().findElements(By.xpath("//div[@class='jobs-list']/descendant::span[@class='tag'][1]"))) {
            assertThat(webElement.getText(), is(department));
        }
    }

    public void insiderCareerCareerOpportunitiesCheckThatAllJobsLocationIs(String location) {
        for (WebElement webElement : getDriver().findElements(By.xpath("//div[@class='jobs-list']/descendant::span[@class='tag'][2]"))) {
            assertThat(webElement.getText(), is(location));
        }
    }

    public void clickJobTitleQualityAssuranceTeamLead(String job) {
        getDriver().findElement(By.xpath("//span[@class='job-title' and text()='" + job + "']")).click();
    }

    public void insiderCareerCheckJobTitleIsAsd(String jobTitle) {
        assertThat(getDriver().findElement(By.cssSelector("h2")).getText(), is(jobTitle));
    }

    public void insiderCareerCheckJobDescriptionBlockIsPresence() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='section-wrapper page-full-width']")).isDisplayed(), is(true));
    }

    public void insiderCareerCheckThatApplyForThisJobBtnIsShown() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='postings-btn-wrapper']/a[@class='postings-btn template-btn-submit shamrock']")).isDisplayed(), is(true));
        assertThat(getDriver().findElement(By.xpath("//div[@class='section page-centered last-section-apply']/a[@class='postings-btn template-btn-submit shamrock']")).isDisplayed(), is(true));
        assertThat(getDriver().findElements(By.xpath("//a[@class='postings-btn template-btn-submit shamrock']")).size(), is(2));
    }

    public void insiderCareerJobPageClickHeadlineApplyForThisJobBtn() {
        headlineApplybtn.click();
    }

    public void insiderCareerCheckJobPageApplicationFormIsOpened() {
        assertThat(getDriver().findElement(By.cssSelector("h4")).getText(), is("SUBMIT YOUR APPLICATION"));
    }
}

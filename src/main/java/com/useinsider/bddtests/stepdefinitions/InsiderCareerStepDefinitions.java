package com.useinsider.bddtests.stepdefinitions;

import com.useinsider.bddtests.steps.InsiderCareerSteps;
import com.useinsider.bddtests.steps.InsiderSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.util.List;

public class InsiderCareerStepDefinitions {

    @Steps
    private InsiderCareerSteps insiderCareerSteps;

    @When("^Insider career check menu head contains$")
    public void insiderCareerCheckMenuHeadContains(List<String> menuTitles) {
        insiderCareerSteps.insiderCareerCheckMenuHeadContains(menuTitles);
    }

    @When("^Insider career check that culture block is visible$")
    public void insiderCareerCheckThatCultureBlockIsVisible() {
        insiderCareerSteps.insiderCareerCheckThatCultureBlockIsVisible();
    }

    @When("^Insider career check that locations block is visible$")
    public void insiderCareerCheckThatLocationsBlockIsVisible() {
        insiderCareerSteps.insiderCareerCheckThatLocationsBlockIsVisible();
    }

    @When("^Insider career check that teams block is visible$")
    public void insiderCareerCheckThatTeamsBlockIsVisible() {
        insiderCareerSteps.insiderCareerCheckThatTeamsBlockIsVisible();
    }

    @When("^Insider career check that jobs block is visible$")
    public void insiderCareerCheckThatJobsBlockIsVisible() {
        insiderCareerSteps.insiderCareerCheckThatJobsBlockIsVisible();
    }

    @When("^Insider career check that life at insider block is visible$")
    public void insiderCareerCheckThatLifeAtInsiderBlockIsVisible() {
        insiderCareerSteps.insiderCareerCheckThatLifeAtInsiderBlockIsVisible();
    }

    @When("^Insider career scroll to the Career Opportunities block$")
    public void insiderCareerScrollToTheCareerOpportunitiesBlock() {
        insiderCareerSteps.insiderCareerScrollToTheCareerOpportunitiesBlock();
    }

    @When("^Insider career career opportunities choose office filter '(.*)'$")
    public void insiderCareerCareerOpportunitiesChooseOfficeFilter(String office) {
        insiderCareerSteps.insiderCareerCareerOpportunitiesChooseOfficeFilter(office);
    }

    @When("^Insider career career opportunities choose department filter '(.*)'$")
    public void insiderCareerCareerOpportunitiesChooseDepartmentFilter(String department) {
        insiderCareerSteps.insiderCareerCareerOpportunitiesChooseDepartmentFilter(department);
    }

    @Then("^Insider career career opportunities check the presence of jobs list$")
    public void insiderCareerCareerOpportunitiesCheckThePresenceOfJobsList() {
        insiderCareerSteps.insiderCareerCareerOpportunitiesCheckThePresenceOfJobsList();
    }

    @Then("^Insider career career opportunities check that all jobs department is '(.*)'$")
    public void insiderCareerCareerOpportunitiesCheckThatAllJobsDepartmentIs(String department) {
        insiderCareerSteps.insiderCareerCareerOpportunitiesCheckThatAllJobsDepartmentIs(department);

    }

    @Then("^Insider career career opportunities check that all jobs location is '(.*)'$")
    public void insiderCareerCareerOpportunitiesCheckThatAllJobsLocationIs(String location) {
        insiderCareerSteps.insiderCareerCareerOpportunitiesCheckThatAllJobsLocationIs(location);

    }

    @When("^Insider career career opportunities click job title '(.*)'$")
    public void clickJobTitleQualityAssuranceTeamLead(String job) {
        insiderCareerSteps.clickJobTitleQualityAssuranceTeamLead(job);
    }

    @When("^Insider career check job title is '(.*)'$")
    public void insiderCareerCheckJobTitleIsAsd(String jobTitle) {
        insiderCareerSteps.insiderCareerCheckJobTitleIsAsd(jobTitle);
    }

    @When("^Insider career check job description block is presence$")
    public void insiderCareerCheckJobDescriptionBlockIsPresence() {
        insiderCareerSteps.insiderCareerCheckJobDescriptionBlockIsPresence();
    }

    @Then("^Insider career check that apply for this job btn is shown$")
    public void insiderCareerCheckThatApplyForThisJobBtnIsShown() {
        insiderCareerSteps.insiderCareerCheckThatApplyForThisJobBtnIsShown();
    }

    @When("^Insider career job page click headline apply for this job btn$")
    public void insiderCareerJobPageClickHeadlineApplyForThisJobBtn() {
        insiderCareerSteps.insiderCareerJobPageClickHeadlineApplyForThisJobBtn();
    }

    @Then("^Insider career check job page application form is opened$")
    public void insiderCareerCheckJobPageApplicationFormIsOpened() {
        insiderCareerSteps.insiderCareerCheckJobPageApplicationFormIsOpened();
    }
}
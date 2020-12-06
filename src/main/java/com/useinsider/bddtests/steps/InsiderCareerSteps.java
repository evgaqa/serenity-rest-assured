package com.useinsider.bddtests.steps;

import com.useinsider.bddtests.page.InsiderCareerPage;
import com.useinsider.bddtests.page.InsiderPage;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.List;

public class InsiderCareerSteps {

    private InsiderCareerPage insiderCareerPage;

    @Step
    public void insiderCareerCheckMenuHeadContains(List<String> menuTitles) {
        insiderCareerPage.insiderCareerCheckMenuHeadContains(menuTitles);
    }

    @Step
    public void insiderCareerCheckThatCultureBlockIsVisible() {
        insiderCareerPage.insiderCareerCheckThatCultureBlockIsVisible();
    }

    @Step
    public void insiderCareerCheckThatLocationsBlockIsVisible() {
        insiderCareerPage.insiderCareerCheckThatLocationsBlockIsVisible();
    }

    @Step
    public void insiderCareerCheckThatTeamsBlockIsVisible() {
        insiderCareerPage.insiderCareerCheckThatTeamsBlockIsVisible();
    }

    @Step
    public void insiderCareerCheckThatJobsBlockIsVisible() {
        insiderCareerPage.insiderCareerCheckThatJobsBlockIsVisible();
    }

    @Step
    public void insiderCareerCheckThatLifeAtInsiderBlockIsVisible() {
        insiderCareerPage.insiderCareerCheckThatLifeAtInsiderBlockIsVisible();
    }

    @Step
    public void insiderCareerScrollToTheCareerOpportunitiesBlock() {
        insiderCareerPage.insiderCareerScrollToTheCareerOpportunitiesBlock();
    }

    @Step
    public void insiderCareerCareerOpportunitiesChooseOfficeFilter(String office) {
        insiderCareerPage.insiderCareerCareerOpportunitiesChooseOfficeFilter(office);
    }

    @Step
    public void insiderCareerCareerOpportunitiesChooseDepartmentFilter(String department) {
        insiderCareerPage.insiderCareerCareerOpportunitiesChooseDepartmentFilter(department);
    }

    @Step
    public void insiderCareerCareerOpportunitiesCheckThePresenceOfJobsList() {
        insiderCareerPage.insiderCareerCareerOpportunitiesCheckThePresenceOfJobsList();
    }

    @Step
    public void insiderCareerCareerOpportunitiesCheckThatAllJobsDepartmentIs(String department) {
        insiderCareerPage.insiderCareerCareerOpportunitiesCheckThatAllJobsDepartmentIs(department);
    }

    @Step
    public void insiderCareerCareerOpportunitiesCheckThatAllJobsLocationIs(String location) {
        insiderCareerPage.insiderCareerCareerOpportunitiesCheckThatAllJobsLocationIs(location);
    }

    @Step
    public void clickJobTitleQualityAssuranceTeamLead(String job) {
        insiderCareerPage.clickJobTitleQualityAssuranceTeamLead(job);
    }

    @Step
    public void insiderCareerCheckJobTitleIsAsd(String jobTitle) {
        insiderCareerPage.insiderCareerCheckJobTitleIsAsd(jobTitle);
    }

    @Step
    public void insiderCareerCheckJobDescriptionBlockIsPresence() {
        insiderCareerPage.insiderCareerCheckJobDescriptionBlockIsPresence();
    }

    @Step
    public void insiderCareerCheckThatApplyForThisJobBtnIsShown() {
        insiderCareerPage.insiderCareerCheckThatApplyForThisJobBtnIsShown();
    }

    @Step
    public void insiderCareerJobPageClickHeadlineApplyForThisJobBtn() {
        insiderCareerPage.insiderCareerJobPageClickHeadlineApplyForThisJobBtn();
    }

    @Step
    public void insiderCareerCheckJobPageApplicationFormIsOpened() {
        insiderCareerPage.insiderCareerCheckJobPageApplicationFormIsOpened();
    }
}

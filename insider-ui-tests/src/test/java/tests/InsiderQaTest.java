package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class InsiderQaTest extends BaseTest {

    @Test
    public void insiderQaTest() {

        HomePage home = new HomePage(driver);
        home.open();
        assertTrue(home.isHomePageOpened());
        home.acceptCookies();
        home.scrollToBottom();
        assertTrue(home.mainBlocksLoaded());
        home.goToCareers();

        CareersPage careers = new CareersPage(driver);
        careers.clickExploreOpenRoles();
        careers.clickSeeAllTeams();
        careers.openQaPage();

        LeverPage lever = new LeverPage(driver);
        assertTrue(lever.isLeverPage());
        lever.openLocationFilter();
        lever.selectIstanbul();
        lever.isQaFilterSelected();
        lever.isJobListPresent();
        lever.validateJobs();
        lever.clickApplyButton();

        JobPage job = new JobPage(driver);
        job.clickApplyForThisJobButton();
        assertTrue(job.isApplicationFormVisible());
    }
}
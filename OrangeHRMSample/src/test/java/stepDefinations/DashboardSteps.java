package stepDefinations;

import base.Base;
import base.BasePage;
import io.cucumber.java.en.Then;
import pageObejctModel.DashboardPage;

public class DashboardSteps extends Base {

	@Then ("all the button works at the dashboard page")
	public void all_the_button_works_at_the_home_page() {
		CurrentPage.As(DashboardPage.class).checkBasePageElements();
//		DashboardPage dashboardPage=new DashboardPage();
//		dashboardPage.checkBasePageElements();
	}
	
	@Then ("user is logout")
	public void user_is_logout() {
		CurrentPage.As(DashboardPage.class).logout();
//		DashboardPage dashboardPage=new DashboardPage();
//		dashboardPage.logout();
	}
	
}

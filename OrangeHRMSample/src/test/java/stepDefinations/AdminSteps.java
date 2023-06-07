package stepDefinations;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObejctModel.DashboardPage;

public class AdminSteps extends Base{

	@When("User click employee tab")
	public void user_click_employee_tab() {
	   CurrentPage=CurrentPage.As(DashboardPage.class).clickOnAdminTab();
	}

	@Then("User click on add button")
	public void user_click_on_add_button() {
	    
	}

	@And("User enter following details")
	public void user_enter_following_details(io.cucumber.datatable.DataTable dataTable) {
	   
	}

	@And("User click on save button")
	public void user_click_on_save_button() {
	   
	}

}

package com.features.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.CartSteps;
import com.steps.serenity.CustomerCareSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductSteps;
import com.steps.serenity.SaleSteps;

import Helpers.IMAPHelper;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src\\test\\resources\\datafiles\\data.csv")
public class CustomerCareDataDrivenTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	String name, email, subject, message, response;

	@Steps
	public NavigationSteps navigationSteps;

	@Steps
	public ProductSteps productSteps;

	@Steps
	public CartSteps cartSteps;

	@Steps
	public SaleSteps saleSteps;

	@Steps
	public CustomerCareSteps customerCareSteps;
	
	@Steps 
	public IMAPHelper imapHelper;

	@Test
	public void customer_care() throws Exception {

		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.go_to_the_customer_care_page();

		customerCareSteps.fill_in_form(name, email, subject, message);		
		//customerCareSteps.check_response_message_is(response);

		customerCareSteps.waitABit(7000);
		
		//customerCareSteps.check_email_subject_is("New message via your Wix website, from  " + email);
		//customerCareSteps.check_body_content_is(email);
	
		customerCareSteps.verify_no_emails_are_sent_for_invalid_form_completion();
		
		
	}
	
	
	
	
	
	
	
	

}

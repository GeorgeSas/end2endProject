package com.steps.serenity;

import javax.mail.MessagingException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.pages.CustomerCarePage;
import com.pages.FramePage;
import com.pages.HomePage;
import com.pages.ShopPage;

import Helpers.IMAPHelper;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class CustomerCareSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;
	ShopPage shopPage;
	FramePage framePage;
	CustomerCarePage customerCarePage;
	
	int unreadEmails;
	
	@Step
	public void enter_name(String name) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
	    jse.executeScript("window.scrollBy(0,250)", ""); 
		
		customerCarePage.enter_text_in_name_field(name);
		
	}
	@Step
	public void enter_email(String email) {
		customerCarePage.enter_text_in_email_field(email);
		//Assert.assertEquals("Please fill in all required fields", customerCarePage.get_name_response_message());
	}
	@Step
	public void enter_subject(String subject) {
		customerCarePage.enter_text_in_subject_field(subject);
		//Assert.assertEquals("Please provide a valid email", customerCarePage.get_email_response_message());
	}
	@Step
	public void enter_message(String message) {
		customerCarePage.enter_text_in_message_field(message);
		//Assert.assertEquals("Success! Message received.", customerCarePage.get_subject_response_message());
	}

	@Step
	public void click_the_submit_button() {
		customerCarePage.click_on_the_submit_button();
		//Assert.assertEquals("Please provide a valid email", customerCarePage.get_subject_response_message());
	}
	@Step
	public void check_response_message_is(String response) {
		
		Assert.assertTrue(response.contentEquals(customerCarePage.get_name_response_message()));
		
	}
	
	@StepGroup
	public void fill_in_form(String name, String email, String subject, String message){
		enter_name(name);
		enter_email(email);
		enter_subject(subject);
		enter_message(message);
		
		click_the_submit_button();
	}
	
	@Step
	public void check_email_subject_is(String expectedSubject) throws Exception {
		

		iMAPHelper.connectToIMAP("imap.gmail.com", "scoalainformalait@gmail.com", "1nf0rmala");

		int unreadEmails = iMAPHelper.getUnreadEmails();
		
		boolean subjectFlag = false;

		for (int i = 0; i < unreadEmails; i++) {
			String actualSubject = iMAPHelper.getEmailSubject(i);
			
			if (expectedSubject.contentEquals(actualSubject)) {
				subjectFlag = true;
				break;
			}
			//iMAPHelper.getEmailFrom(i);
			//iMAPHelper.getEmailRecipients(i);
			//iMAPHelper.getEmailBody(i);
		}
		
		Assert.assertTrue("Could not find unread mail with expected subject!!", subjectFlag);
	}
	
	IMAPHelper iMAPHelper = new IMAPHelper();
	
	@Step
	public void check_body_content_is(String expectedContent) throws Exception {		

		iMAPHelper.connectToIMAP("imap.gmail.com", "scoalainformalait@gmail.com", "1nf0rmala");
		unreadEmails = iMAPHelper.getUnreadEmails();
		
		boolean bodyFlag = false;

		for (int i = 0; i < unreadEmails; i++) {
			String actualContent = iMAPHelper.getEmailBody(i);
			
			if (actualContent.contains((expectedContent))) {
				bodyFlag = true;
				break;
			}
			//iMAPHelper.getEmailFrom(i);
			//iMAPHelper.getEmailRecipients(i);
			//iMAPHelper.getEmailBody(i);
		}
		
		Assert.assertTrue("Could not find unread mail with expected body content!!", bodyFlag);
	}
	
	public int get_number_of_unread_emails() throws MessagingException {
		iMAPHelper.connectToIMAP("imap.gmail.com", "scoalainformalait@gmail.com", "1nf0rmala");		
		return unreadEmails = iMAPHelper.getUnreadEmails();		
	}
	
	@Step
	public void verify_no_emails_are_sent_for_invalid_form_completion() throws MessagingException {	
		Assert.assertEquals(0, get_number_of_unread_emails());		
	}
	
}

   

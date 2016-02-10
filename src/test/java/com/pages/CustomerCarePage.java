package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CustomerCarePage extends PageObject {
	 @FindBy(css="input.s20_required.s20nameField")
	 private WebElementFacade nameField;
	 
	 @FindBy(css="input.s20_required.s20emailField")
	 private WebElementFacade emailField;
	 
	 @FindBy(css="input.s20subjectField")
	 private WebElementFacade subjectField;
	 
	 @FindBy(css="input.s20subjectField")
	 private WebElementFacade messagetField;
	 
	 @FindBy(css="button#i24bs8nssubmit")
	 private WebElementFacade submitButton;
	 
	 @FindBy(css="div.s20wrapper span")
	 private WebElementFacade nameResponseMessage;
	 
	 @FindBy(css="div.s20wrapper span")
	 private WebElementFacade emailResponseMessage;
	 
	 @FindBy(css="div.s20wrapper span")
	 private WebElementFacade subjectResponseMessage;
	 
	 @FindBy(css="div.s20wrapper span")
	 private WebElementFacade messageResponseMessage;
	 
	 
	 
	 
	 public void enter_text_in_name_field(String name){
		 nameField.sendKeys(name);
	 }
	 
	 public void enter_text_in_email_field(String email){
		 emailField.sendKeys(email);
	 }
	 
	 public void enter_text_in_subject_field(String subject){
		 subjectField.sendKeys(subject);
	 }
	 
	 public void enter_text_in_message_field(String message){
		 messagetField.sendKeys(message);
	 }
	 
	 public void click_on_the_submit_button() {
		 submitButton.click();
	 }
	 
	 
	 public String get_name_response_message() {
		 nameResponseMessage.waitUntilVisible();
		 waitABit(2000);
		 return nameResponseMessage.getText();
	 }
	 
	 public String get_email_response_message() {
		 emailResponseMessage.waitUntilVisible();
		 return emailResponseMessage.getText();
	 }
	 
	 public String get_subject_response_message() {
		 subjectResponseMessage.waitUntilVisible();
		 return subjectResponseMessage.getText();
	 }
	 
	 public String get_message_response_message() {
		 messageResponseMessage.waitUntilVisible();
		 return messageResponseMessage.getText();
	 
	 }
	 
    
}
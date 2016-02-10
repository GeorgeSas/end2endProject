package com.pages;

import Helpers.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl(Constants.BASE_URL)
public class HomePage extends PageObject {

    @FindBy(css="a#i2epz4bn_1link")
    private WebElementFacade shopNowButton;
    
    @FindBy(css="p#i1ltay0q2label")
    private WebElementFacade saleButtonFromMenu;
    
    @FindBy(css="a text.quantity")
    private WebElementFacade cartWidgetButton;
    
    @FindBy(css="button#submit.ladda-button")
    private WebElementFacade subscribeNowButton;
    
    @FindBy(css=".invalid_text:nth-of-type(2)")
    private WebElementFacade errorMessage;
    
    @FindBy(css="#i1ltay0q3label")
    private WebElementFacade customerCareLinkFromMenu;
  
	public void click_shopNow_button() {
		shopNowButton.waitUntilVisible();
		shopNowButton.click();		
	}

	public void click_the_sale_button_from_the_main_menu() {
		saleButtonFromMenu.waitUntilVisible();
		saleButtonFromMenu.click();
	}

	public void click_the_cart_widget() {
		cartWidgetButton.waitUntilVisible();
		cartWidgetButton.click();
		
	}

	public void click_on_subscribe_now() {
		subscribeNowButton.waitUntilVisible();	
		subscribeNowButton.click();
		
	}

	public String return_error_message() {
		return errorMessage.getText();
		
	}

	public void click_on_the_customer_care_link_int_the_main_menu() {
		customerCareLinkFromMenu.waitUntilVisible();
		customerCareLinkFromMenu.click();
		
	}	
}
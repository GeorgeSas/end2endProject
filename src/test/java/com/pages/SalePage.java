package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class SalePage extends PageObject {

	@FindBy(linkText="Best Seller")
	private WebElementFacade bestSellerLink;
	
	public void click_the_best_seller() {
		bestSellerLink.waitUntilVisible();
		bestSellerLink.click();
	}


}
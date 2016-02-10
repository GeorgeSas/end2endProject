package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ShopPage extends PageObject {

    @FindBy(css="a > img.media-item.active")
    private List<WebElement> productImageList;
    
    @FindBy(css="li.product-media-container")
    private List<WebElement> imageToClickList;
    
    @FindBy(css="a.action.quickview")
    private List<WebElementFacade> quickViewList;
    
    @FindBy(css=".curtain")
    private WebElementFacade curtain; 
    
    @FindBy(css="button.button-primary.is-button-wide")
    private WebElementFacade addToCartButton;
    
    @FindBy(css="footer > a.button-primary.is-button-wide")
	private WebElementFacade viewCartButton;
    
    public void move_mouse_over_nth_product_and_click_quickView(int n) {
    	Actions builder = new Actions(getDriver());
    	
    	builder.moveToElement(productImageList.get(n));
    	builder.perform();
    	
    	quickViewList.get(n).click();
    }
    
    public void move_mouse_over_nth_product_and_click_on_it(int n) {
    	Actions builder = new Actions(getDriver());
    	
    	builder.moveToElement(productImageList.get(n));
    	builder.perform();
    	
    	imageToClickList.get(n).click();
    }
    
    public void click_curtain() {
    	curtain.waitUntilVisible();
    	curtain.click();   	
    }

	public void click_on_add_to_cart_button() {
		addToCartButton.waitUntilVisible();
		addToCartButton.click();	
	}

	public void click_on_view_cart() {
		viewCartButton.waitUntilVisible();
		viewCartButton.click();
		
	}
    
}
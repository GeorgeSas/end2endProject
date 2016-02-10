package com.pages;

import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;

public class FramePage extends PageObject {
  
	// shop
	public void switch_to_shop_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("#i418uphziframe")));		
	}	
	
	// default content
	public void switch_to_default_content() {
		getDriver().switchTo().defaultContent();
	}
	
	// product
	public void switch_to_product_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='storefront/product/']")));
	}
	
	// curtain
	public void switch_to_curtain_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='com/storefront/cartwidgetPopup?cacheKiller']")));
	}

	public void switch_to_cart_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='ecom.wix.com/storefront/cart?cacheKiller']")));
		
	}
	
	public void switch_to_payment_popup_page() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='/storefront/messagePopup?cacheKiller']")));
	}
	
	public void switch_to_sale_page_frame(){
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='/storefront/gallery?cacheKiller']")));
	}
	
	public void switch_to_cart_widget_frame() {
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='/storefront/cartwidget?cacheKiller']")));
	}
	
	public void switch_to_the_subscribe_section_on_footer(){
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[src*='//shoutout.apps.wixapps.net/widget-new']")));
	}
}
package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {

	@FindBy(css = "li .product-media-container")
	private List<WebElementFacade> productInCartList;

	@FindBy(css = "header button.checkout-button")
	private WebElement checkOutHeader;

	@FindBy(css = "footer button.checkout-button")
	private WebElement checkoutFooter;

	@FindBy(css = "input.product-quantity-input")
	private List<WebElementFacade> quantity;
	
	@FindBy(css="a.product-remove")
	private List<WebElementFacade> removeItemButtom;
	
	@FindBy(css="div.products-empty.has-hr")
	private WebElementFacade isEmptyMessage;
	
	@FindBy(css="div.summary-subtotal div span:nth-of-type(2)")
	private WebElementFacade cartSubtotal;
	
	@FindBy(css="div.product-total.price.is-price-large")
	private List<WebElementFacade> totalPricePerProduct;
	
	@FindBy(css="p.popup-message")
	private WebElement popupMessage;
	
	@FindBy(css="main button.button-primary")
	private WebElement paymentOkButton;
	
	@FindBy(css="li a.change-quantity-icon.minus-icon")
	private WebElementFacade minusButton;
	
	@FindBy(css="li a.change-quantity-icon.plus-icon")
	private WebElementFacade plusButton;

	public int find_number_of_product_types_in_cart() {
		List<WebElement> numberOfProductTypes = getDriver().findElements(By.cssSelector("img.product-media"));
		return numberOfProductTypes.size();
	}

	public int find_number_of_products_in_cart(int index) {
		WebElementFacade productQuantityElement = quantity.get(index);
		String productQuantityStr = productQuantityElement.getValue();
		int productQuantity = Integer.parseInt(productQuantityStr);
		return productQuantity;
	}

	public void remove_item_from_cart() {
		
	}

	public void click_on_product(int n) {
		productInCartList.get(n).click();
	}

	public void checkout() {
		checkOutHeader.click();
	}
	
	public void remove_nth_button(int n) {
		removeItemButtom.get(n).click();
	}
	
	public boolean is_cart_empty_message() {
		return isEmptyMessage.isVisible();
	}
	
	public String get_subTotal() {
		return cartSubtotal.getText();
	}
	
	public String get_total_per_product(int index){
		return totalPricePerProduct.get(index).getText();
	}
	
	public String get_payment_popup_text(){
		return popupMessage.getText();
	}

	public void click_the_ok_button_on_the_payment_popup() {
		paymentOkButton.click();
		
	}

	public void decrement_item_count() {
		minusButton.waitUntilVisible();
		minusButton.click();
		
	}

	public void increment_item_count() {
		plusButton.waitUntilVisible();
		plusButton.click();
	}

}

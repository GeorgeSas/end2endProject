package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

	@FindBy(css = "a.select2-choice")
	private WebElementFacade quantityButton;

	@FindBy(css = "li[id*='ui-select-choices-row']")
	private List<WebElement> productQuantityList;

	@FindBy(css = "button.button-primary.is-button-wide.button-add-to-cart")
	private WebElementFacade addToCartButton;
	
	@FindBy(css="#i1ltay0q1bg")
	private WebElement shopButtonInMenu;
	
	@FindBy(css="a.remove-item")
	private List<WebElementFacade> removeFromCurtainButtonList;

	public void click_quantityButton(int n) {
		quantityButton.waitUntilPresent();
		quantityButton.click();
	}

	public void select_quantity(int n) {
		for (WebElement option : productQuantityList) {
			if (Integer.parseInt(option.findElement(By.cssSelector("span")).getText()) == n) {
				option.click();
				break;
			}
		}
	}

	public void click_addToCartButton() {
		// addToCartButton.waitUntilVisible();
		addToCartButton.click();
	}
	
	public void click_shop_in_menu() {
		shopButtonInMenu.click();
	}

	public void click_on_x_to_remove_product(int index){		
		Actions action = new Actions(getDriver());
		
		action.moveToElement(removeFromCurtainButtonList.get(index)).build().perform();
		removeFromCurtainButtonList.get(index).click();
	}
}
package com.steps.serenity;

import com.pages.FramePage;
import com.pages.ProductPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
		
	ProductPage productPage;
	FramePage framePage;

    @Step
    public void select_quantity_from_quick_view(int n) {
    	framePage.switch_to_product_frame();
    	productPage.click_quantityButton(n);
    	productPage.select_quantity(n);
    	framePage.switch_to_default_content();
    }
    
    @Step
    public void select_quantity_from_product_page(int n) {
    	framePage.switch_to_product_frame();
    	productPage.click_quantityButton(n);
    	productPage.select_quantity(n);
    	productPage.click_addToCartButton();
    	framePage.switch_to_default_content();
    }
    
    @Step
    public void add_to_cart_from_quick_view() {
    	framePage.switch_to_product_frame();
    	productPage.click_addToCartButton();
    	framePage.switch_to_default_content();
    }
    
    @Step
    public void add_to_cart_from_product_page() {
    	framePage.switch_to_product_frame();
    	productPage.click_addToCartButton();
    	framePage.switch_to_default_content();
    }
    
    @Step
    public void click_on_the_shop_button_from_the_menu() {
    	productPage.click_shop_in_menu();
    }

    @Step
	public void remove_nth_product_from_curtain_view(int productToRemove){
    	framePage.switch_to_curtain_frame();
    	productPage.click_on_x_to_remove_product(productToRemove);
    	framePage.switch_to_default_content();
	}
}
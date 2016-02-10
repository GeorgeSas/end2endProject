package com.steps.serenity;

import org.junit.Assert;

import com.pages.CartPage;
import com.pages.FramePage;

import net.thucydides.core.annotations.Step;

public class CartSteps {
	CartPage cartPage;
	FramePage framePage;

	@Step
	public void assert_number_of_product_types_in_cart(int n) {
		framePage.switch_to_cart_frame();

		int numberOfProductTypes = cartPage.find_number_of_product_types_in_cart();
		if (numberOfProductTypes == n) {
			System.out.println("Number of product types is as expected: " + n);
		} else {
			System.out.println("Fail. You were expecting " + n + " item type(s). Actual number of types is "
					+ numberOfProductTypes);
		}

		framePage.switch_to_default_content();
	}

	@Step
	public void assert_total_number_of_products_in_cart(int totalExpected) {
		framePage.switch_to_cart_frame();

		int sum = 0;
		for (int i = 0; i < cartPage.find_number_of_product_types_in_cart(); i++) {
			sum += cartPage.find_number_of_products_in_cart(i);
		}

		Assert.assertSame(totalExpected, sum);

		framePage.switch_to_default_content();
	}

	@Step
	public void click_on_nth_product_from_within_cart(int nthProduct) {
		framePage.switch_to_cart_frame();
		cartPage.click_on_product(nthProduct-1);
		framePage.switch_to_default_content();
	}

	@Step
	public void click_the_checkout_button() {
		cartPage.checkout();
	}
	
	
	@Step
	public void remove_all_items() throws InterruptedException {
		framePage.switch_to_cart_frame();	
		
		int numberOfProdTypes = cartPage.find_number_of_product_types_in_cart();;
		for (int i=0; i < numberOfProdTypes; i++) {
			cartPage.remove_nth_button(0);
			Thread.sleep(2000);			
		}
		
		framePage.switch_to_default_content();
	}
	
	@Step
	public void remove_all_items(int n) {
		framePage.switch_to_cart_frame();	
		cartPage.remove_nth_button(n);
		framePage.switch_to_default_content();
	}
	
	
	@Step 
	public void assert_whether_cart_is_empty() {
		framePage.switch_to_cart_frame();
		Assert.assertTrue(cartPage.is_cart_empty_message());
		framePage.switch_to_default_content();
	}
	
	@Step 
	public void check_cart_subtotal_is(String subtotal) {
		framePage.switch_to_cart_frame();
		Assert.assertTrue(subtotal.contentEquals(cartPage.get_subTotal()));
		framePage.switch_to_default_content();
	}
	
	@Step 
	public void check_cart_total_per_product_is(String perProdTotal, int nthOfProd) {
		framePage.switch_to_cart_frame();
		Assert.assertEquals(perProdTotal, cartPage.get_total_per_product(nthOfProd-1));
		framePage.switch_to_default_content();
	}
	
	@Step 
	public void click_on_the_checkout_button() {
		framePage.switch_to_cart_frame();
		cartPage.checkout();
		framePage.switch_to_default_content();
	}

	@Step
	public void assert_the_correct_message_is_displayed(String expectedMessage) {
		framePage.switch_to_payment_popup_page();
		
		String popupMessage = cartPage.get_payment_popup_text();
		Assert.assertEquals(expectedMessage, popupMessage);
		
		framePage.switch_to_default_content();
		
	}

	@Step
	public void return_to_cart_from_payment_popup() {
		framePage.switch_to_payment_popup_page();
		cartPage.click_the_ok_button_on_the_payment_popup();
		framePage.switch_to_default_content();
		
	}

	@Step
	public void decrease_number_of_products(int numberOfTimesToDrecrement) {
		framePage.switch_to_cart_frame();
		
		for (int i=0; i < numberOfTimesToDrecrement; i++) {
			cartPage.decrement_item_count();
		}
		
		framePage.switch_to_default_content();
		
	}

	@Step
	public void increase_number_of_products(int numberOfTimesToIncrement) {
		framePage.switch_to_cart_frame();
		
		for (int i=0; i < numberOfTimesToIncrement; i++) {
			cartPage.increment_item_count();
		}
		
		framePage.switch_to_default_content();
	}


}

package com.features.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.CartSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductSteps;
import com.steps.serenity.SaleSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityRunner.class)
@UseTestDataFrom("src\\test\\resources\\datafiles\\data.csv")

public class AddToCartTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public NavigationSteps navigationSteps;

	@Steps
	public ProductSteps productSteps;

	@Steps
	public CartSteps cartSteps;

	@Steps
	public SaleSteps saleSteps;

	//@Test
	public void add_to_cart_using_quick_view_and_product_view() {

		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nth_product(0);
		productSteps.select_quantity_from_quick_view(3);
		productSteps.add_to_cart_from_quick_view();
		navigationSteps.close_curtain_for_nth_product();

		navigationSteps.click_on_nth_product(1);
		productSteps.select_quantity_from_product_page(1);
		productSteps.add_to_cart_from_product_page();

		navigationSteps.view_cart();

		// cartSteps.assert_number_of_product_types_in_cart(1);
		// cartSteps.assert_total_number_of_products_in_cart(6);

		// cartSteps.click_on_product_from_within_cart();
		// cartSteps.click_the_checkout_button();

		navigationSteps.waitABit(2000);

	}

	//@Test
	public void add_and_remove_from_cart_verification() throws InterruptedException {
		
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.click_on_nth_product(1);
		productSteps.select_quantity_from_product_page(3);
		productSteps.add_to_cart_from_product_page();
		navigationSteps.view_cart();

		productSteps.click_on_the_shop_button_from_the_menu();

		navigationSteps.click_on_nth_product(2);
		productSteps.select_quantity_from_product_page(2);
		productSteps.add_to_cart_from_product_page();
		navigationSteps.view_cart();

		productSteps.click_on_the_shop_button_from_the_menu();

		navigationSteps.click_on_nth_product(3);
		productSteps.select_quantity_from_product_page(2);
		productSteps.add_to_cart_from_product_page();
		navigationSteps.view_cart();

		cartSteps.remove_all_items();
		cartSteps.assert_whether_cart_is_empty();
		cartSteps.check_cart_subtotal_is("$0.00");

		navigationSteps.waitABit(3000);

	}

	///////////////////// HOMEWORK STARTS HERE ////////////////////////////
	
	@Test
	public void verify_price_for_nth_product_in_the_cart() {
		
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		//navigationSteps.open_quick_view_for_nth_product(0);
		//productSteps.select_quantity_from_quick_view(3);
		//productSteps.add_to_cart_from_quick_view();
		//navigationSteps.close_curtain_for_nth_product();

		navigationSteps.click_on_nth_product(1);
		productSteps.select_quantity_from_product_page(1);
		productSteps.add_to_cart_from_product_page();

		navigationSteps.view_cart();

		// product count starts at 1
		cartSteps.check_cart_total_per_product_is("$44.97", 1);

		navigationSteps.waitABit(2000);
	}

	//@Test
	public void increase_or_decrease_product_quantity_from_the_cart() {

		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nth_product(0);
		productSteps.select_quantity_from_quick_view(3);
		productSteps.add_to_cart_from_quick_view();

		navigationSteps.view_cart();

		cartSteps.decrease_number_of_products(2);
		cartSteps.increase_number_of_products(3);

		navigationSteps.waitABit(2000);
	}

	//@Test
	public void go_to_nth_product_page_from_within_the_cart() {
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nth_product(0);
		productSteps.select_quantity_from_quick_view(3);
		productSteps.add_to_cart_from_quick_view();

		navigationSteps.close_curtain_for_nth_product();

		navigationSteps.click_on_nth_product(1);
		productSteps.select_quantity_from_product_page(1);
		productSteps.add_to_cart_from_product_page();

		navigationSteps.view_cart();

		// product count starts at 1
		cartSteps.click_on_nth_product_from_within_cart(1);

		navigationSteps.waitABit(2000);
	}

	//@Test
	public void view_cart_from_the_cart_widget() {

		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nth_product(0);
		productSteps.select_quantity_from_quick_view(3);
		productSteps.add_to_cart_from_quick_view();
		navigationSteps.close_curtain_for_nth_product();

		navigationSteps.click_on_cart_widget();

		navigationSteps.view_cart();

		navigationSteps.waitABit(2000);
	}

	//@Test
	public void go_to_checkout_and_verify_message() {
		
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.click_on_nth_product(1);
		productSteps.select_quantity_from_product_page(2);
		productSteps.add_to_cart_from_product_page();

		navigationSteps.view_cart();

		cartSteps.click_on_the_checkout_button();
		cartSteps.assert_the_correct_message_is_displayed(
				"We are unable to accept online payments. Please contact us to complete your purchase");
		cartSteps.return_to_cart_from_payment_popup();

		navigationSteps.waitABit(3000);
	}

	//@Test
	public void add_bestseller_product_from_the_sale_page_to_cart() {
		
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.access_the_sale_page();

		saleSteps.click_on_the_best_seller_product();

		productSteps.select_quantity_from_product_page(2);
		productSteps.add_to_cart_from_product_page();

		navigationSteps.view_cart();

		navigationSteps.waitABit(3000);
	}

	// couldn't make it to work
	// @Test
	public void remove_products_from_the_curtain() {
		
		navigationSteps.open_homepage_and_maximize_window();
		navigationSteps.click_the_shop_button_from_home_page();

		navigationSteps.open_quick_view_for_nth_product(0);
		productSteps.select_quantity_from_quick_view(3);
		productSteps.add_to_cart_from_quick_view();

		productSteps.remove_nth_product_from_curtain_view(1);

		navigationSteps.waitABit(2000);
	}

	// couldn't make it to work
	// @Test
	public void subscribe_with_no_email_adress_entered_from_the_home_page() {
		
		navigationSteps.open_homepage_and_maximize_window();

		navigationSteps.click_on_the_subscribe_button_on_the_home_page();
		navigationSteps.assert_error_message("Please fill in a valid email address");

		navigationSteps.waitABit(2000);
	}

}

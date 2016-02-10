package com.steps.serenity;

import org.junit.Assert;

import com.pages.FramePage;
import com.pages.HomePage;
import com.pages.ShopPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigationSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;
	ShopPage shopPage;
	FramePage framePage;

    @Step
    public void open_homepage_and_maximize_window() {
        homePage.open();
        getDriver().manage().window().maximize();
    }

    @Step
	public void click_the_shop_button_from_home_page() {
		homePage.click_shopNow_button();		
	}
    
    @Step
    public void open_quick_view_for_nth_product(int n) {
    	framePage.switch_to_shop_frame();
    	shopPage.move_mouse_over_nth_product_and_click_quickView(n);
    	framePage.switch_to_default_content();
    }  
    
    @Step
    public void click_on_nth_product(int n) {
    	framePage.switch_to_shop_frame();
    	shopPage.move_mouse_over_nth_product_and_click_on_it(n);
    	framePage.switch_to_default_content();
    }  
    
    @Step
    public void close_curtain_for_nth_product() {
    	framePage.switch_to_curtain_frame();
    	shopPage.click_curtain();
    	framePage.switch_to_default_content();
    }

    @Step
	public void view_cart() {
		framePage.switch_to_curtain_frame();
		shopPage.click_on_view_cart();
		framePage.switch_to_default_content();		
	}  
    
    @Step
    public void click_on_cart_widget() {
    	framePage.switch_to_cart_widget_frame();
    	homePage.click_the_cart_widget();
    	framePage.switch_to_default_content();
    }

    @Step
	public void access_the_sale_page() {
		homePage.click_the_sale_button_from_the_main_menu();
	}

    @Step
	public void click_on_the_subscribe_button_on_the_home_page() {
		framePage.switch_to_the_subscribe_section_on_footer();
		homePage.click_on_subscribe_now();		
		framePage.switch_to_default_content();
	}

    @Step
	public void assert_error_message(String expectedMessage) {
		framePage.switch_to_the_subscribe_section_on_footer();
		
		String errorMessage = homePage.return_error_message();		
		Assert.assertEquals(expectedMessage, errorMessage);		
		
		framePage.switch_to_default_content();
	}

    @Step
	public void go_to_the_customer_care_page() {
		homePage.click_on_the_customer_care_link_int_the_main_menu();
	
	}


   
}
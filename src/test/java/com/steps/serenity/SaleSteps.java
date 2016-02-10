package com.steps.serenity;

import com.pages.FramePage;
import com.pages.SalePage;

import net.thucydides.core.annotations.Step;

public class SaleSteps {
	SalePage salePage;	
	FramePage framePage;
	
	@Step
	public void click_on_the_best_seller_product() {
	framePage.switch_to_sale_page_frame();
	salePage.click_the_best_seller();
	framePage.switch_to_default_content();
		
	}

	
	


}

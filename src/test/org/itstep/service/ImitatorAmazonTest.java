package test.org.itstep.service;


import static org.junit.Assert.assertTrue;

import org.itstep.model.Account;
import org.itstep.service.CreateAccount;
import org.itstep.service.ImitatorAmazon;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ImitatorAmazonTest {
	
	
	@Test
	public void testRegisterAccount() {
		
		Account account = new Account();
		account = CreateAccount.createAccountAmazon();
		
		ImitatorAmazon imitator = new ImitatorAmazon();
		WebDriver driverout = imitator.registerAccount(account);
		assertTrue("Test is failed", driverout.getPageSource().contains("Hello, " + account.getName()));	
			
	}
	
	@Test
	public void testAddToCard() {
		
		String asinItem = "B00797NHFC";
		Account account = new Account();
		account = CreateAccount.createAccountAmazon();
		
		ImitatorAmazon imitator = new ImitatorAmazon();
		WebDriver driver = imitator.registerAccount(account);
		WebDriver driverout = imitator.getAddToCart(driver, asinItem);
		assertTrue("Test is failed", driverout.getPageSource().contains("Added to Cart"));
	}
	
	//@Test
	//public void testAddToWishlist() {
		
	//	String asinItem = "B00797NHFC";
	//	Account account = new Account();
	//	account = CreateAccount.createAccountAmazon();
		
	//	ImitatorAmazon imitator = new ImitatorAmazon();
	//	WebDriver driver = imitator.registerAccount(account);
	//	WebDriver driverout = imitator.getAddToWishList(driver, asinItem);
	//	assertTrue("Test is failed", driverout.getPageSource().contains(account.getName() + "'s List"));
	//}

}

package testeJunit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageClass.SearchPage;
import pageClass.SearchPageAccount;

public class Teste {
	private WebDriver driver;
	private String baseURL;
	SearchPage searchPage;
	SearchPageAccount searchPageAccount;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		searchPage = new SearchPage(driver);
		searchPageAccount = new SearchPageAccount(driver);
		baseURL = "http://automationpractice.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	 	public void Comprar2Itens() throws InterruptedException {
		
		searchPage.SignIn("datumqatest@soprock.com","datum2021");
		searchPage.SearchProduct("Printed Chiffon Dress");
		searchPage.ClickProduct("Printed Chiffon Dress");
		searchPage.AddToCart();
		searchPage.ContinueShopping();
		searchPage.SearchProduct("Blouse");
		searchPage.ClickProduct("Blouse");
		searchPage.AddToCart();
		searchPage.ProceedCheckout();
		searchPage.SummaryProceedCheckout();
		searchPage.AddressProceedCheckout();
		searchPage.CheckTermsOfService();
		searchPage.ShippingProceedCheckout();
		searchPage.payOrder("check");
		searchPage.ConfirmOrderPay();

		Assert.assertEquals("Your order on My Store is complete.", searchPage.StatusOrder());
	}
	
	@Test
	public void ComprarComNovoUsuario() throws InterruptedException {
		
		searchPageAccount.CreateAccount("Renato@teste.com.br");
		searchPageAccount.SelectGender("Mrs");
		searchPageAccount.FillName("Renato", "Martins");
		searchPageAccount.FillPassword("12345");
		searchPageAccount.SelectBithDate("5", "July", "1989");
		searchPageAccount.FillAddress("Rua dos teste, 200", "New York", "New York", "00000", "United States");
		searchPageAccount.FillPhoneMobile("11945405450");
		searchPageAccount.FillAliasAccount("Teste");
		searchPageAccount.RegisterAccount();
		searchPage.SearchProduct("Blouse");
		searchPage.ClickProduct("Blouse");
		searchPage.AddToCart();
		searchPage.ProceedCheckout();
		searchPage.SummaryProceedCheckout();
		searchPage.AddressProceedCheckout();
		searchPage.CheckTermsOfService();
		searchPage.ShippingProceedCheckout();
		searchPage.payOrder("check");
		searchPage.ConfirmOrderPay();
		
		Assert.assertEquals("Your order on My Store is complete.", searchPage.StatusOrder());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

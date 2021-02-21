package pageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	List<WebElement> list;

	//Elements Page
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement mailSignIn;

	@FindBy(id = "passwd")
	WebElement passwordSignIn;

	@FindBy(id = "SubmitLogin")
	WebElement buttonSignIn;

	@FindBy(id = "search_query_top")
	WebElement boxSearch;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement buttonSearch;

	@FindBy(xpath = "//div[@id=\"center_column\"]/ul")
	WebElement listProducts;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement buttonAddCart;

	@FindBy(xpath = "//div[@class=\"button-container\"]/span")
	WebElement buttonContinueShopping;

	@FindBy(xpath = "//div[@class=\"button-container\"]/a/span")
	WebElement buttonProceedChekout;

	@FindBy(xpath = "//div[3]/div[1]/p[2]/a[1]/span[1]")
	WebElement buttonProceedSumamry;

	@FindBy(xpath = "//button[@name=\"processAddress\"]/span")
	WebElement buttonProceedAddress;

	@FindBy(id = "cgv")
	WebElement checkTerm;

	@FindBy(xpath = "//button[@name=\"processCarrier\"]/span")
	WebElement buttonProceedShipping;

	@FindBy(className = "bankwire")
	WebElement payBankWire;

	@FindBy(className = "cheque")
	WebElement payCheck;

	@FindBy(xpath = "//p[@id=\"cart_navigation\"]/button/span")
	WebElement buttonConfirmOrder;

	@FindBy(xpath = "//div[@id=\"center_column\"]/p")
	WebElement alertSuccess;

	//Construct Method
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** return list of products searching
	 * 
	 * @param product
	 * @return
	 */
	private List<WebElement> listSearchProducts(String product) {
		list = listProducts.findElements(By.tagName("li"));		
		return list;
	}

	/** Wait element is visible in page
	 * 
	 * @param elementWait
	 * @param timout
	 */
	private void waitForElement(WebElement elementWait, int timout) {
		WebElement element = null;

		WebDriverWait wait = new  WebDriverWait(driver, timout);
		element = wait.until(ExpectedConditions.visibilityOf(elementWait));
	}

	/** Sing in the Page
	 * 
	 * @param mail
	 * @param password
	 */
	public void SignIn(String mail, String password) {
		signIn.click();
		mailSignIn.sendKeys(mail);
		passwordSignIn.sendKeys(password);
		buttonSignIn.click();
	}

	/** Search the product
	 * 
	 * @param product
	 */
	public void SearchProduct(String product) {
		boxSearch.clear();
		boxSearch.sendKeys(product);
		buttonSearch.click();
	}

	/** click in product 
	 * 
	 * @param product
	 */
	public void ClickProduct(String product) {
		list =  listSearchProducts(product);
		for(WebElement products : list)
		{
			if(products.getText().contains(product)) {
				products.click();
				break;
			}	
		}
	}

	/**Add product in cart
	 * 
	 */
	public void AddToCart() {
		buttonAddCart.click();
	}

	/** Click continue shopping
	 * 
	 */
	public void ContinueShopping() {
		waitForElement(buttonContinueShopping, 5);
		buttonContinueShopping.click();
	}

	/** Click button proceed Chekout
	 * 
	 */
	public void ProceedCheckout() {
		waitForElement(buttonProceedChekout, 5);
		buttonProceedChekout.click();
	}

	/** Click button proceed Chekout Summary
	 * 
	 */
	public void SummaryProceedCheckout() {
		buttonProceedSumamry.click();
	}

	/** Click button proceed Checkout Address
	 * 
	 */
	public void AddressProceedCheckout() {
		buttonProceedAddress.click();
	}

	/** Check the terms of service
	 * 
	 */
	public void CheckTermsOfService() {
		if(!checkTerm.isSelected()) {
			checkTerm.click();
		}
	}

	/** Click button proceed Checkout Shipping
	 * 
	 */
	public void ShippingProceedCheckout() {
		buttonProceedShipping.click();
	}

	/** Choose type of payment
	 * 
	 * @param payment
	 */
	public void payOrder(String payment) {
		switch(payment) {
		case "bankwire":
			payBankWire.click();
			break;
		case "check":
			payCheck.click();
			break;
		}
	}

	/** Confirm Order of payment
	 * 
	 */
	public void ConfirmOrderPay() {
		buttonConfirmOrder.click();
	}

	/** Retorn message success
	 * 
	 * @return
	 */
	public String StatusOrder() {
		return alertSuccess.getText();
	}
}
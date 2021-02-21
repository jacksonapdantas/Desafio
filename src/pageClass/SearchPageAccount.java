package pageClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPageAccount {
	WebDriver driver;
	Select select;
	
	
	//Elements Page
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	@FindBy(id = "email_create")
	WebElement mailAddress;
	
	@FindBy(id = "SubmitCreate")
	WebElement buttonCreate;
	
	@FindBy(id = "id_gender1")
	WebElement genderMr;
	
	@FindBy(id = "id_gender2")
	WebElement genderMrs;
	
	@FindBy(id = "customer_firstname")
	WebElement textBoxFirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement textBoxLastName;
	
	@FindBy(id = "passwd")
	WebElement textBoxPassword;
	
	@FindBy(id = "days")
	WebElement birthDay;
	
	@FindBy(id ="months")
	WebElement birthMonth;
	
	@FindBy(id = "years")
	WebElement birthYear;
	
	@FindBy(id = "address1")
	WebElement textBoxAddress;
	
	@FindBy(id = "city")
	WebElement textBoxCity;
	
	@FindBy(id = "id_state")
	WebElement selectState;
	
	@FindBy(id = "postcode")
	WebElement textBoxPostalCode;
	
	@FindBy(id = "id_country")
	WebElement selectCountry;
	
	@FindBy(id = "phone_mobile")
	WebElement textBoxPhoneMobile;
	
	@FindBy(id = "alias")
	WebElement textBoxAlias;
	
	@FindBy(id = "submitAccount")
	WebElement buttonRegisterAccount;
	
	// Methods
	//Construct Method
	public SearchPageAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/** Access creation new account
	 * 
	 * @param mail
	 */
	public void CreateAccount(String mail) {
		signIn.click();
		mailAddress.sendKeys(mail);
		buttonCreate.click();
	}
	
	/** Seletc the gender - Mr or Mrs
	 * 
	 * @param gender
	 */
	public void SelectGender(String gender) {
		switch(gender) {
		case "Mr":
			genderMr.click();
			break;
		case "Mrs":
			genderMrs.click();
			break;
		}
	}
	
	/**Fill the firts and  last name
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void FillName(String firstName, String lastName) {
		textBoxFirstName.sendKeys(firstName);
		textBoxLastName.sendKeys(lastName);
	}
	
	/** Fill the Password
	 * 
	 * @param pass
	 */
	public void FillPassword(String pass) {
		textBoxPassword.sendKeys(pass);
	}
	
	/** Select the birthDate day(numeral), month(in full), year(numeral)
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public void SelectBithDate(String day, String month, String year) {
		birthDay.sendKeys(day);
		birthMonth.sendKeys(month);
		birthYear.sendKeys(year);
	}
	
	/** Fill the Address
	 * 
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param country
	 */
	public void FillAddress(String address, String city, String state, String zipCode, String country) {
		textBoxAddress.sendKeys(address);
		textBoxCity.sendKeys(city);
		select = new Select(selectState);
		select.selectByVisibleText(state);
		textBoxPostalCode.sendKeys(zipCode);
		select = new Select(selectCountry);
		select.selectByVisibleText(country);
	}
	
	/** Fill the phone mobile
	 * 
	 * @param phoneMobile
	 */
	public void FillPhoneMobile(String phoneMobile) {
		textBoxPhoneMobile.sendKeys(phoneMobile);
	}
	
	/** Fill the alias for account
	 * 
	 * @param alias
	 */
	public void FillAliasAccount(String alias) {
		textBoxAlias.clear();
		textBoxAlias.sendKeys(alias);
	}
	
	/** Click button register the account
	 * 
	 */
	public void RegisterAccount() {
		buttonRegisterAccount.click();
	}
	
	
	
}

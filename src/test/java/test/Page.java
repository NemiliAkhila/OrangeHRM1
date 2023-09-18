package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement Username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement Password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginClick;
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    public WebElement Admin;
    @FindBy(xpath = "//span[contains(text(),'Organization')]")
    public WebElement Organisation;
    @FindBy(xpath = "//a[contains(text(),'General Information')]")
    public WebElement GeneralOrganisation;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")
    public WebElement Edit;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")
    public WebElement OrganisationName;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement Save;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement VerifyBlankSave;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement VerifySave;

    @FindBy(xpath = "//a[contains(text(),'Locations')]")
    public WebElement SelectLocation;
    @FindBy(xpath = "(//div//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement LocationName;
    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[3]")
    public WebElement LocationCity;
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")
    public WebElement LocationCountry;
    @FindBy(xpath = "(//div[contains(@class, 'oxd-select')])[3]")
    public WebElement LocationCountrySelect;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LocationSearch;
    @FindBy(xpath = "//button[contains(@class, 'oxd-button')]")
    public WebElement LocationDataReset;
    @FindBy(xpath = "(//button[contains(@class, 'oxd-button')])[3]")
    public WebElement LocationAdd;
    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
    public WebElement LocationAddName;
    @FindBy(xpath = "(//div[contains(@class,'oxd-select')])[2]")
    public WebElement LocationAddCountryDropdown;
    @FindBy(xpath = "//div[contains(@class,'oxd-select-text-input')]")
    public WebElement LocationAddCountrySelect;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LocationAddSave;
    @FindBy(xpath = "(//span[contains(@class,'oxd-text oxd-text')])[13]")
    public WebElement LocationCountryMiss;
    @FindBy(xpath = "(//i[contains(@class,'oxd-icon')])[30]")
    public WebElement LocationDeleteSelect;
    @FindBy(xpath = "(//button[contains(@class,'oxd-button')])[4]")
    public WebElement LocationDeleteClick;
    @FindBy(xpath = "(//button[contains(@class,'oxd-button oxd-button')])[6]")
    public WebElement LocationDeleteYes;
    @FindBy(xpath = "(//p[contains(@class,'oxd-text')])[4]")
    public WebElement VerifyLocationDeleted;
    @FindBy(xpath = "//a[contains(text(),'Structure')]")
    public WebElement SelectStructure;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")                       //xpath
    public WebElement StructureEditEnable;
    @FindBy(xpath = "//*[@class='oxd-icon bi-chevron-up']")                       //xpath
    public WebElement StructureArrowFunctionality;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary org-structure-add']")                       //xpath
    public WebElement StructureAddFunctionality;
    @FindBy(xpath = "(//input[contains(@class,'oxd-input oxd-input--active')])[3]")
    public WebElement StructureAddName;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement StructureSaveFunctionality;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash-fill'][1]")
    public WebElement StructureDeleteFunctionality;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash-fill'][1]")
    public WebElement StructureSaveVerifyFunctionality;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement StructureSaveButtonFunctionality;
    @FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
    public WebElement EditFunctionalityVerify;
    @FindBy(xpath = "//a[contains(text(),'OrangeHRM, Inc')]")
    public WebElement DefaultEnableWhileEditDisable ;
    @FindBy(xpath = "(//i[contains(@class, 'oxd-icon')])[14]")
    public WebElement LocationSelectAllFunctionality ;
    @FindBy(xpath = "//button[contains(@class, 'danger ')]")
    public WebElement VerifySelectAll ;
    public void Login(String username, String password) {
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginClick.click();

    }
}


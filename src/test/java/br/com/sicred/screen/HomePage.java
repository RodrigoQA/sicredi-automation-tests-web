package br.com.sicred.screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='floatL l5'][contains(.,'Customers')]")
    public WebElement paginaInicial;

    @FindBy(xpath = "//a[contains(.,'Add Customer')]")
    public WebElement btnAddCustomer;

    @FindBy(id = "switch-version-select")
    public WebElement selectVersao;

    @FindBy(xpath = "//*[contains(@class,'lert alert-success')]")
    public WebElement waitAlertSucess;

    @FindBy(xpath = "//td[contains(.,'Teste Sicredi')]")
    public WebElement clienteTesteSicred;

    @FindBy (name = "customerName")
    public WebElement inputName;

    @FindBy (xpath = "(//a[contains(.,'Edit')])[2]")
    public WebElement btnEdit;

    @FindBy (xpath = "//input[@class='select-row']")
    public WebElement checkboxClienteSelecionado;

    @FindBy (xpath = "//*[contains(@class,'delete-selected-button')]")
    public WebElement btnDeleteCadastro;

    @FindBy (xpath = "//*[@class='alert-delete-multiple-one']")
    public WebElement alertDesejaDeletar;

    @FindBy (xpath = "(//button[contains(.,'Delete')])[2]")
    public WebElement btnConfirmarExclusao;

    @FindBy(xpath = "(//*[contains(@class,'lert alert-success')]/span)[3]/p")
    public WebElement msgDeleted;

}

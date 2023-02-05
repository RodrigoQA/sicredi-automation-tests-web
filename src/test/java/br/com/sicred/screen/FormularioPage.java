package br.com.sicred.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioPage {

    public FormularioPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By cadastradoComSucesso = By.id("report-success");

    @FindBy(id = "field-customerName")
    public WebElement fieldNome;

    @FindBy (id = "field-contactLastName")
    public WebElement fieldUltimoNome;

    @FindBy (id = "field-contactFirstName")
    public WebElement fieldContPrimeiroNome;

    @FindBy (id = "field-phone")
    public WebElement fieldTelefone;

    @FindBy (id = "field-addressLine1")
    public WebElement fieldEndereco1;

    @FindBy (id = "field-addressLine2")
    public WebElement fieldEndereco2;

    @FindBy (id = "field-city")
    public WebElement fieldCidade;

    @FindBy (id = "field-state")
    public WebElement fieldEstado;

    @FindBy (id = "field-postalCode")
    public WebElement fieldCep;

    @FindBy (id = "field-country")
    public WebElement fieldPais;

    @FindBy (xpath = "//a[contains(.,'Select from Employeer')]")
    public WebElement comboEmpregadora;

    @FindBy (xpath = "//li[contains(.,'Fixter')]")
    public WebElement fixter;

    @FindBy (id = "field-creditLimit")
    public WebElement filedLimiteCredito;

    @FindBy (id = "form-button-save")
    public WebElement btnSave;

    @FindBy (id = "report-success")
    public WebElement msgSaveComSucesso;

    @FindBy (id = "save-and-go-back-button")
    public WebElement btnBackPage;


}

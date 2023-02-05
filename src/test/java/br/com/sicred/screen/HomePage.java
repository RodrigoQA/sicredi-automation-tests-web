package br.com.sicred.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public By clienteTesteSicred = By.xpath( "//td[contains(.,'Teste Sicredi')]");

    public By waitAlert = By.xpath("//*[contains(@class,'lert alert-success')]");

    public By selectVersao = By.id("switch-version-select");

    public By paginaInicial = By.id("gcrud-search-form");

    @FindBy(xpath = "//a[contains(.,'Add Customer')]")
    public WebElement btnAddCustomer;

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

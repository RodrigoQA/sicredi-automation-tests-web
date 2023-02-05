package br.com.sicred.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.logging.Logger;
import static br.com.sicred.core.DriverFactory.getDriver;

public class BasePage {
    public static Logger log = Logger.getLogger("QALogger");

    public static void esperarElementAparecerTela(By element){

        Wait <WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        log.info("Elemento: "+element+ "escontrado com sucesso");
    }

    public static void escrever(WebElement el, String text){
        el.sendKeys(text);
        log.info("texto: "+text+ " foi preenchido com sucesso!");

    }

    public static void clicar(WebElement el){
        el.click();
        log.info("Elemento: "+el+" clicado com sucesso!");

    }


}

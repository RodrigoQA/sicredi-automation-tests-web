package br.com.sicred.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class DriverFactory {

    private static WebDriver driver;
    private static Enum nomeNavegador;
    public static Logger log = Logger.getLogger("QALogger");


    public static void openBrowser(Enum navegador, String URL) {
        nomeNavegador = navegador;
        getDriver().get(URL);


    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Inicia driver
            createDriver();
        }
        return driver;

    }

    private static void createDriver() {

        switch (setNavegador()) {

            case "GOOGLE_CHROME":
                try {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    log.info("Chrome Driver selecionado");
                } catch (Throwable e) {
                    log.info("ERRO: " + e.getMessage());
                }
                break;
            case "HEADLESS_CHROME":

                try {
                    ChromeOptions chromeOptionsHeadless = new ChromeOptions();
                    chromeOptionsHeadless.addArguments("--headless");
                    chromeOptionsHeadless.addArguments("disable-gpu");
                    chromeOptionsHeadless.addArguments("window-size=1280x1024");
                    driver = new ChromeDriver(chromeOptionsHeadless);
                    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                    log.info("Chrome Headless Driver selecionado");
                } catch (Throwable e) {
                    log.info("ERRO: " + e.getMessage());
                }
                break;
            case "FIREFOX":
                try {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    log.info("Gecko Driver selecionado");
                } catch (Throwable e) {
                    log.info("ERRO: " + e.getMessage());
                }

                break;
            case "INTERNET_EXPLORER":
                try {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    DesiredCapabilities capabilitiesIE = new DesiredCapabilities();
                    capabilitiesIE.setCapability("requireWindowFocus", true);
                    capabilitiesIE.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                    capabilitiesIE.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                    capabilitiesIE.setCapability("ie.ensureCleanSession", true);
                    capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    capabilitiesIE.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                    capabilitiesIE.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                    log.info("Internet Explorer Driver selecionado");

                } catch (Throwable e) {
                    log.info("ERRO: " + e.getMessage());
                }
                ;

            case "DRIVER_PHANTOM":

                try {
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setJavascriptEnabled(true);
                    caps.setCapability("takesScreenshot", true);
                    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                            "./resources/phantomjs.exe");
                    ArrayList<String> phantomJsPlusCapabilities = new ArrayList();
                    phantomJsPlusCapabilities.add("--web-security=false");
                    phantomJsPlusCapabilities.add("--ssl-protocol=any");
                    phantomJsPlusCapabilities.add("--ignore-ssl-errors=true");
                    phantomJsPlusCapabilities.add("--webdriver-loglevel=NONE");
                    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsPlusCapabilities);
                    driver = new PhantomJSDriver(caps);
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    log.info("PhantomJS Driver selecionado");

                } catch (Throwable e) {
                    log.info("ERRO: " + e.getMessage());

                }

            default:
                log.warning(">>>>>>> ATENÇÃO SEU NAVEGADOR NÃO ESTÁ DISPONÍVEL! <<<<<<<<<<");
        }
    }

    /**
     * Definir navegador setup ou Property
     */
    private static String setNavegador() {

        if (System.getProperty("Browser") != null) {
            return System.getProperty("Browser");
        } else {
            return nomeNavegador.name();
        }

    }

    /**
     * Finaliza driver
     */
    public static void killDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }

}
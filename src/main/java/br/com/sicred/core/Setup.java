package br.com.sicred.core;

import br.com.sicred.utils.Enums.Navegadores;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static br.com.sicred.core.DriverFactory.*;

public class Setup {

    @BeforeAll
    public static void inicializarBrowser() {
        openBrowser(Navegadores.GOOGLE_CHROME,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

       //Ex: Run Handless
       // openBrowser(Navegadores.HEADLESS_CHROME,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

    }

    @AfterAll
    public static void fecharBrowser() {
     killDriver();
    }

}

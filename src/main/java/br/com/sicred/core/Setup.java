package br.com.sicred.core;

import br.com.sicred.utils.Enums.Navegadores;
import br.com.sicred.utils.TearDown;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static br.com.sicred.core.DriverFactory.*;
import static br.com.sicred.utils.Relatorio.EvidenceReport.*;



@ExtendWith(TearDown.class)
public class Setup extends TearDown {
    /**
     *  Ex: Run Handless
     openBrowser(Navegadores.HEADLESS,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

     */
    @BeforeAll
    public static void inicializarBrowser() {
        openBrowser(Navegadores.CHROME,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");


    }



    @BeforeEach
    public void setupScenario(TestInfo testInfo) {
        novoCenario = true;
        nomeTest = testInfo.getTestMethod().get().getName();
        nomeCenario = testInfo.getDisplayName();


    }

   @AfterAll
    public static void fecharBrowser() {

     killDriver();

    }

}

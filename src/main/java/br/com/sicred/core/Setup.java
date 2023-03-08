package br.com.sicred.core;

import br.com.qautils.enums.Navegadores;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import static br.com.qa.utils.reports.EvidenceReport.*;
import static br.com.qautils.managedriver.DriverFactory.*;
import static br.com.sicred.utils.Relatorio.AllureEnvironmentWriter.allureEnvironmentWriter;






public class Setup  {
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
        setAllureEnvironment();
        killDriver();

    }

    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", setBrowser())
                        .put("API.Version", "1.0")
                        .put("Ambiente ", "Homologação")
                        .put("Responsavel ", "Equipe de Automação")
                        .build());


    }


}

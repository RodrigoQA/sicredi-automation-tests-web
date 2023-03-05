package br.com.sicred.core;

import br.com.sicred.utils.Enums.Navegadores;
import br.com.sicred.utils.Relatorio.TearDown;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static br.com.sicred.core.DriverFactory.*;
import static br.com.sicred.utils.Relatorio.AllureEnvironmentWriter.allureEnvironmentWriter;
import static br.com.sicred.utils.Relatorio.EvidenceReport.*;



@ExtendWith(TearDown.class)
public class Setup extends TearDown {
    /**
     *  Ex: Run Handless
     openBrowser(Navegadores.HEADLESS,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

     */
    @BeforeAll
    public static void inicializarBrowser() {
        openBrowser(Navegadores.HEADLESS,"https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");


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

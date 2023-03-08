package br.com.sicred.tests;

import br.com.qa.utils.reports.ReportFail;
import br.com.sicred.action.FormularioAction;
import br.com.sicred.action.HomeAction;
import br.com.sicred.core.Setup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static io.qameta.allure.SeverityLevel.*;

@ExtendWith(ReportFail.class)
public class AdicionarNovoClienteTest extends Setup {

    @Test
    @Tags(value = {@Tag("add-cliente"),@Tag("regressivo")})
    @Description("Realizar a inclusão do cliente atraves do preenchimento do formulario")
    @Story("Adicional novo cliente na base")
    @Severity(CRITICAL)
    public void incluirNovoClienteNaBaseDeDados() {
        new HomeAction()
                .selecionarBootstrapV4()
                       .clicaAddCliente();

        new FormularioAction()
                 .preencherInformacoesDoClienteNoFormulario()
                        .validarMensagemDeDadosSalvosComSucesso("Your data has been successfully stored into the database.");


    }

}

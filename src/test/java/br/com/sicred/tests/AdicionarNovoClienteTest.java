package br.com.sicred.tests;


import br.com.sicred.action.FormularioAction;
import br.com.sicred.action.HomeAction;
import br.com.sicred.core.Setup;
import br.com.sicred.utils.Relatorio.ReportFail;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Method;

import static io.qameta.allure.SeverityLevel.*;
import static org.junit.Assert.assertEquals;

@ExtendWith(ReportFail.class)
public class AdicionarNovoClienteTest extends Setup {

    @Test
    @Severity(CRITICAL)
    @Tags(value = {@Tag("add-cliente"),@Tag("regressivo")})
    @Epic("Disponibilizar recursos cadastrar e excluir ")
    @Story("Usuarios Cadastrados")
    @Feature("Inclusao de novos Clientes")
    @Description("Realizar a inclusão do cliente atraves do preenchimento do formulario")
    public void incluirNovoClienteNaBaseDeDados() {

        new HomeAction()
                .selecionarBootstrapV4()
                       .clicaAddCliente();

        new FormularioAction()
                 .preencherInformacoesDoClienteNoFormulario()
                        .validarMensagemDeDadosSalvosComSucesso("Your data has been successfully stored into the database.");


    }

}

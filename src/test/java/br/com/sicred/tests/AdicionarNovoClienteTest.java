package br.com.sicred.tests;

import br.com.sicred.action.FormularioAction;
import br.com.sicred.action.HomeAction;
import br.com.sicred.core.Setup;
import br.com.sicred.utils.TearDown;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TearDown.class)
public class AdicionarNovoClienteTest extends Setup {

    @Test
    @Tags(value = {@Tag("add-cliente"),@Tag("regressivo")})
    @DisplayName("Realizar a inclusão do cliente atraves do preenchimento do formulario")
    public void incluirNovoClienteNaBaseDeDados() {
        new HomeAction()
                .selecionarBootstrapV4()
                       .clicaAddCliente();

        new FormularioAction()
                 .preencherInformacoesDoClienteNoFormulario()
                        .validarMensagemDeDadosSalvosComSucesso("Your data has been successfully stored into the database.");


    }

}

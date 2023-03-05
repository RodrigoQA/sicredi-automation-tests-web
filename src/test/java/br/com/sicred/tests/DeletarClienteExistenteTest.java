package br.com.sicred.tests;


import br.com.sicred.action.FormularioAction;
import br.com.sicred.core.Setup;
import br.com.sicred.utils.Relatorio.TearDown;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TearDown.class)
public class DeletarClienteExistenteTest extends Setup {



    @Test
    @Tags(value = {@Tag("excluir-cliente"),@Tag("regressivo")})
    @Description("Realizar a exclusão de um cliente já Cadastrado na plataforma")
    @Severity(SeverityLevel.CRITICAL)
    public void exclusaoDeClienteNaBaseDeDados(){

        new AdicionarNovoClienteTest()
                .incluirNovoClienteNaBaseDeDados();

        new FormularioAction()
                .voltarPaginaPrincipal()
                        .selecionarClienteParaExcluir("Teste Sicredi")
                                .habilitarCheckBoxDelete()
                                        .deletarCadastroCliente()
                                                .validarAlertaParaConfirmarExclusao("Are you sure that you want to delete this 1 item?")
                                                        .confirmarExclusao()
                                                              .validarMensagemExcluidoComSucesso("Your data has been successfully deleted from the database.");





    }


}

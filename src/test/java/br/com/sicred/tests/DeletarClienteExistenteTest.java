package br.com.sicred.tests;


import br.com.sicred.action.FormularioAction;
import br.com.sicred.core.Setup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DeletarClienteExistenteTest extends Setup {



    @Test
    @Tag("excluir-cliente")
    @DisplayName("Realizar a exclusão de um cliente já Cadastrado na plataforma")
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

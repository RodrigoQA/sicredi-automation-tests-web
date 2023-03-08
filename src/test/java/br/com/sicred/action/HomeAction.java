package br.com.sicred.action;

import br.com.sicred.core.BasePage;
import br.com.sicred.screen.HomePage;
import org.openqa.selenium.support.ui.Select;

import static br.com.qa.utils.reports.EvidenceReport.gerarRelatorio;
import static br.com.qautils.managedriver.DriverFactory.getDriver;
import static br.com.sicred.core.BasePage.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeAction extends HomePage {

    public HomeAction() {
        super(getDriver());
    }

    public void clicaAddCliente() {
            btnAddCustomer.click();
        gerarRelatorio("Add Cliente","Clicar no botão 'Add Customer'");

    }

    public HomeAction selecionarBootstrapV4() {
        Select dropdown = new Select(selectVersao);
        dropdown.selectByVisibleText("Bootstrap V4 Theme");
        gerarRelatorio("Selecionar Menu","Selecionar novo menu bootstrapv4");
        return this;
    }

    public HomeAction selecionarClienteParaExcluir(String cliente) {
       BasePage.esperarElementAparecerTela(paginaInicial,15);
       BasePage.clicar(inputName);
       BasePage.escrever(inputName,cliente);
       BasePage.esperarElementAparecerTela(clienteTesteSicred,15);
       assertThat(clienteTesteSicred.getText(), is(cliente));
        gerarRelatorio("Selecionar Cliente","Selecionar cliente a ser excluido");
        return this;

    }

    public HomeAction habilitarCheckBoxDelete() {
        gerarRelatorio("Habilitar checkbox","Selecionar checkbox do cliente  a ser excluido");
       clicar(checkboxClienteSelecionado);

      return this;

    }

    public HomeAction deletarCadastroCliente() {
        gerarRelatorio("Deletar Cliente","Clicar em deletar cliente");
       clicar(btnDeleteCadastro);

       return this;

    }

    public HomeAction validarAlertaParaConfirmarExclusao(String msg_alerta_esperado) {
        BasePage.esperarElementAparecerTela(alertDesejaDeletar,15);
        validarSeTextoEhExatamenteOMesmo(alertDesejaDeletar, msg_alerta_esperado);
        gerarRelatorio("Alerta Confirmar exclusão","Validar mensagem sobre a confirmação da exclusão");
       return this;

    }

    public HomeAction confirmarExclusao() {
        esperarElementoASerClicado(btnConfirmarExclusao,15);
        clicar(btnConfirmarExclusao);
      return this;

    }

    public void validarMensagemExcluidoComSucesso(String mensagemExcluidoComSucesso) {
        BasePage.esperarElementAparecerTela(msgDeleted,15);
        assertThat(msgDeleted.getText(), is(mensagemExcluidoComSucesso));
        gerarRelatorio("Deletado com sucesso","Validar mensagem deletado com sucesso");
    }
}

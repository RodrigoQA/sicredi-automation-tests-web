package br.com.sicred.action;

import br.com.sicred.core.BasePage;
import br.com.sicred.screen.HomePage;
import org.openqa.selenium.support.ui.Select;
import static br.com.sicred.core.BasePage.clicar;
import static br.com.sicred.core.BasePage.esperarElementAparecerTela;
import static br.com.sicred.core.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeAction extends HomePage {

    public HomeAction() {
        super(getDriver());
    }

    public void clicaAddCliente() {
       btnAddCustomer.click();


    }

    public HomeAction selecionarBootstrapV4() {
        Select dropdown = new Select(getDriver().findElement(selectVersao));
        dropdown.selectByVisibleText("Bootstrap V4 Theme");
        return this;
    }

    public HomeAction selecionarClienteParaExcluir(String cliente) {
       esperarElementAparecerTela(paginaInicial);
       BasePage.clicar(inputName);
       BasePage.escrever(inputName,cliente);
       esperarElementAparecerTela(clienteTesteSicred);
       assertThat(getDriver().findElement(clienteTesteSicred).getText(), is(cliente));
        return this;

    }

    public HomeAction habilitarCheckBoxDelete() {
       clicar(checkboxClienteSelecionado);
      return this;

    }

    public HomeAction deletarCadastroCliente() {
       clicar(btnDeleteCadastro);
       return this;

    }

    public HomeAction validarAlertaParaConfirmarExclusao(String alerta) {
       assertThat(alertDesejaDeletar.getText(), is(alerta));
       return this;

    }

    public HomeAction confirmarExclusao() {
      clicar(btnConfirmarExclusao);
      return this;

    }

    public void validarMensagemExcluidoComSucesso(String mensagemExcluidoComSucesso) {
        esperarElementAparecerTela(waitAlert);
        assertThat(msgDeleted.getText(), is(mensagemExcluidoComSucesso));
    }
}

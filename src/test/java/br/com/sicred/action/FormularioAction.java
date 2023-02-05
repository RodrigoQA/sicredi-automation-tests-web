package br.com.sicred.action;

import br.com.sicred.core.BasePage;
import br.com.sicred.screen.FormularioPage;
import org.junit.Assert;
import static br.com.sicred.core.BasePage.esperarElementAparecerTela;
import static br.com.sicred.core.DriverFactory.getDriver;

public class FormularioAction extends FormularioPage {


    public FormularioAction(){
        super(getDriver());
    }

    public FormularioAction preencherInformacoesDoClienteNoFormulario(){
        BasePage.escrever(fieldNome,"Teste Sicredi");
        BasePage.escrever(fieldUltimoNome,"Teste");
        BasePage.escrever(fieldContPrimeiroNome,"Rodrigo");
        BasePage.escrever(fieldTelefone,"51 9999-9999");
        BasePage.escrever(fieldEndereco1,"Av Assis Brasil, 3970");
        BasePage.escrever(fieldEndereco2," Torre D");
        BasePage.escrever(fieldCidade,"Porto Alegre");
        BasePage.escrever(fieldEstado,"RS");
        BasePage.escrever(fieldCep,"91000-000");
        BasePage.escrever(fieldPais,"Brasil");
        BasePage.clicar(comboEmpregadora);
        BasePage.clicar(fixter);
        BasePage.escrever(filedLimiteCredito,"200");
        BasePage.clicar(btnSave);

        return this;

    }
        public FormularioAction validarMensagemDeDadosSalvosComSucesso(String mensagemEsperada){
        esperarElementAparecerTela(cadastradoComSucesso);
        Assert.assertTrue(msgSaveComSucesso.getText().contains(mensagemEsperada));
        return this;
    }
    public HomeAction voltarPaginaPrincipal(){
         BasePage.clicar(btnBackPage);
         return new HomeAction();
    }
}


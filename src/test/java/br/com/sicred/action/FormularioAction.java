package br.com.sicred.action;

import br.com.sicred.core.BasePage;
import br.com.sicred.screen.FormularioPage;

import static br.com.qa.utils.reports.EvidenceReport.gerarRelatorio;
import static br.com.qautils.managedriver.DriverFactory.getDriver;
import static br.com.sicred.core.BasePage.*;


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
        descerAteElementoNaTela(comboEmpregadora);
        BasePage.clicar(comboEmpregadora);
        esperarElementoASerClicado(fixter,5);
        BasePage.clicar(fixter);
        BasePage.escrever(filedLimiteCredito,"200");
        gerarRelatorio("Preencher Formulário","Preencher formulário com as informações do cliente");
        BasePage.clicar(btnSave);

        return this;

    }
        public void validarMensagemDeDadosSalvosComSucesso(String mensagemEsperada){
        esperarElementAparecerTela(cadastradoComSucesso,15);
            gerarRelatorio("Cliente cadastrado","Validar mensagem cliente cadastrado com sucesso");
            validarSeTextoContainsString(msgSaveComSucesso,mensagemEsperada);
        }
    public HomeAction voltarPaginaPrincipal(){
         BasePage.clicar(btnBackPage);
         return new HomeAction();
    }
}


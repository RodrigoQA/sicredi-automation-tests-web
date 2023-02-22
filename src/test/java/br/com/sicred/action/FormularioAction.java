package br.com.sicred.action;

import br.com.sicred.core.BasePage;
import br.com.sicred.screen.FormularioPage;
import static br.com.sicred.core.BasePage.esperarElementAparecerTela;
import static br.com.sicred.core.BasePage.validarSeTextoContainsString;
import static br.com.sicred.core.DriverFactory.getDriver;
import static br.com.sicred.utils.Relatorio.EvidenceReport.gerarRelatorio;



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
        gerarRelatorio("Preencher Formulário","Preencher formulário com as informações do cliente");
        BasePage.clicar(btnSave);

        return this;

    }
        public void validarMensagemDeDadosSalvosComSucesso(String mensagemEsperada){
        esperarElementAparecerTela(cadastradoComSucesso,10);
            gerarRelatorio("Cliente cadastrado","Validar mensagem cliente cadastrado com sucesso");
            validarSeTextoContainsString(msgSaveComSucesso,mensagemEsperada);
        }
    public HomeAction voltarPaginaPrincipal(){
         BasePage.clicar(btnBackPage);
         return new HomeAction();
    }
}


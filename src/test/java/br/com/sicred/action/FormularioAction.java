package br.com.sicred.action;


import br.com.sicred.screen.FormularioPage;
import static br.com.sicred.core.BasePage.*;
import static br.com.sicred.core.DriverFactory.getDriver;
import static br.com.sicred.utils.Relatorio.EvidenceReport.gerarRelatorio;



public class FormularioAction extends FormularioPage {


    public FormularioAction(){
        super(getDriver());
    }

    public FormularioAction preencherInformacoesDoClienteNoFormulario(){
        escreverTexto(fieldNome,"Teste Sicredi");
        escreverTexto(fieldUltimoNome,"Teste");
        escreverTexto(fieldContPrimeiroNome,"Rodrigo");
        escreverTexto(fieldTelefone,"51 9999-9999");
        escreverTexto(fieldEndereco1,"Av Assis Brasil, 3970");
        escreverTexto(fieldEndereco2," Torre D");
        escreverTexto(fieldCidade,"Porto Alegre");
        escreverTexto(fieldEstado,"RS");
        escreverTexto(fieldCep,"91000-000");
        escreverTexto(fieldPais,"Brasil");
        clicar(comboEmpregadora);
        clicar(fixter);
        escreverTexto(filedLimiteCredito,"200");
        gerarRelatorio("Preencher Formulário","Preencher formulário com as informações do cliente");
        clicar(btnSave);

        return this;

    }
        public void validarMensagemDeDadosSalvosComSucesso(String mensagemEsperada){
        esperarElementAparecerTela(cadastradoComSucesso,10);
            gerarRelatorio("Cliente cadastrado","Validar mensagem cliente cadastrado com sucesso");
            validarSeContemTexto(msgSaveComSucesso,mensagemEsperada);
        }
    public HomeAction voltarPaginaPrincipal(){
         clicar(btnBackPage);
         return new HomeAction();
    }
}


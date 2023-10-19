package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;

   @AfterEach
   public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }

   @Test
   public void deveriaCadastrarNovoLeilao() {
       LoginPage paginaDeLogin = new LoginPage();
       paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
       this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
       CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
       //Cadastrando novo leilao

       String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       String nome = "Leilao do dia " +hoje;
       String valor = "500.00";

       this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);

       Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));

   }
}
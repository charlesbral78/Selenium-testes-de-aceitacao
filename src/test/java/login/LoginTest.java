package login;

import login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;
    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fechar();
    }
    @Test
    public void deveriaEfetuarLoginComDadosValidos() {

        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {

        paginaDeLogin.preencheFormularioDeLogin("invalido", "123123");
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));

    }
}

package br.com.alura.leilao;

import org.apache.tomcat.jni.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "C:/ALURA/2019-selenium-java-projeto_inicial/drivers/chromedriver.exe");

        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }

        this.browser.manage().timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS)
        .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        this.browser.quit();
    }

}

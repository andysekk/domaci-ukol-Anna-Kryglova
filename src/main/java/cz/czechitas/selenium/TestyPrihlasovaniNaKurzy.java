package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyPrihlasovaniNaKurzy<prihlaseniRodice> {
    private static final String URL_APLIKACE = "https://cz-test-jedna.herokuapp.com/";
    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.navigate().to(URL_APLIKACE);
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void prihlaseniRodiceDoSystemu() {
        prihlaseniRodice();
        overeniPrihlaseniRodice();
    }

    @Test
    public void vyberKurzuPotePrihlaseni() {
        vyberKurzuTrimesicniKurzyProgramovaniJavaskript();
        prihlaseniRodiceDoSystemu();
        vyplneniPrihlaskyTrimesicniKurzyProgramovaniJavaskript();
        overeniPrihlaseniZakaDoKurzu();
    }

    @Test
    public void prihlaseniPoteVyberKurzu() {
        prihlaseniRodiceDoSystemu();
        vyberKurzuDATestovaniZakladyAlgoritmizace();
        vyplneniPrihlaskyKurzuDATestovaniZakladyAlgoritmizace();
        overeniPrihlaseniZakaDoKurzu();
    }

    @Test
    public void odhlaseniUcastiZakaZKurzu() {
        prihlaseniRodiceDoSystemu();
        vyberKurzuDATestovaniZakladyAlgoritmizace();
        vyplneniPrihlaskyKurzuDATestovaniZakladyAlgoritmizace();
        odhlaseniUcastiZaka();
        overeniOdhlaseniZaka();
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }


    public void prihlaseniRodice() {
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        tlacitkoPrihlasit.click();
        WebElement prihlaseniEmail = prohlizec.findElement(By.id("email"));
        prihlaseniEmail.sendKeys("andysek.brno@seznam.cz");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("Franta1");
        WebElement tlacitkoPrihlasit2 = prohlizec.findElement(By.xpath("//button[contains(text(),'Přihlásit')]"));
        tlacitkoPrihlasit2.click();
    }

    public void overeniPrihlaseniRodice() {
        WebElement potvrzeniOPrihlaseniRodice = prohlizec.findElement(By.xpath("//nav/div/div[2]/div/a"));
        Assertions.assertEquals("Franta Kocourek", potvrzeniOPrihlaseniRodice.getText());
    }

    public void vyberKurzuTrimesicniKurzyProgramovaniJavaskript() {
        WebElement volbaTrimesicniKurzyProgramovani = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[3]//a[text()='Více informací']"));
        volbaTrimesicniKurzyProgramovani.click();
        WebElement volbaJavaScript = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[2]//a[text()='Vytvořit přihlášku']"));
        volbaJavaScript.click();
    }

    public void vyplneniPrihlaskyTrimesicniKurzyProgramovaniJavaskript() {
        WebElement vyberTerminu = prohlizec.findElement(By.xpath("//*[contains(text(),'Vyberte termín...')]"));
        vyberTerminu.click();
        WebElement vyplneniTerminu = prohlizec.findElement(By.xpath("//*[contains(@class,'bs-searchbox')]//input"));
        vyplneniTerminu.sendKeys("05.07. - 09.07.2021");
        WebElement vyberData = prohlizec.findElement(By.xpath("//*[contains(@class,'text')]"));
        vyberData.click();
        WebElement vyplneniJmenaZaka = prohlizec.findElement(By.id("forename"));
        vyplneniJmenaZaka.sendKeys("Lojza");
        WebElement vyplneniPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        vyplneniPrijmeniZaka.sendKeys("Kocourek");
        WebElement vyplneniDatumuNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        vyplneniDatumuNarozeniZaka.sendKeys("20.08.2008");
        WebElement tlacitkoPlatbaPrevodem = prohlizec.findElement(By.xpath("//*[contains(text(),'Bankovní převod')]"));
        tlacitkoPlatbaPrevodem.click();
        WebElement tlacitkoSouhlasSPodminkami = prohlizec.findElement(By.xpath("//*[contains(text(),'Souhlasím')]"));
        tlacitkoSouhlasSPodminkami.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.xpath("//*[contains(@class,'btn btn-primary mt-3')]"));
        tlacitkoVytvoritPrihlasku.click();
    }

    public void overeniPrihlaseniZakaDoKurzu() {
        WebElement potvrzeniOPrihlaseniZaka = prohlizec.findElement(By.xpath("//*[contains(@class,'mb-1 btn btn-sm btn-success')]"));
        Assertions.assertEquals("Stáhnout potvrzení o přihlášení", potvrzeniOPrihlaseniZaka.getText());
    }

    public void vyberKurzuDATestovaniZakladyAlgoritmizace() {
        WebElement tlacitkoVytvoritNovouPrihlasku = prohlizec.findElement(By.xpath("//*[contains(@class,'btn btn-sm btn-info')]"));
        tlacitkoVytvoritNovouPrihlasku.click();
        WebElement volbaDigitalniAkademieTestovani = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[1]//a[text()='Více informací']"));
        volbaDigitalniAkademieTestovani.click();
        WebElement volbaZakladyAlgoritmizace = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[1]//a[text()='Vytvořit přihlášku']"));
        volbaZakladyAlgoritmizace.click();
    }

    public void vyplneniPrihlaskyKurzuDATestovaniZakladyAlgoritmizace() {
        WebElement vyberTerminu = prohlizec.findElement(By.xpath("//*[contains(text(),'Vyberte termín...')]"));
        vyberTerminu.click();
        WebElement vyplneniTerminu = prohlizec.findElement(By.xpath("//*[contains(@class,'bs-searchbox')]//input"));
        vyplneniTerminu.sendKeys("02.08. - 06.08.2021");
        WebElement vyberData = prohlizec.findElement(By.xpath("//*[contains(@class,'text')]"));
        vyberData.click();
        WebElement vyplneniJmenaZaka = prohlizec.findElement(By.id("forename"));
        vyplneniJmenaZaka.sendKeys("Lojza");
        WebElement vyplneniPrijmeniZaka = prohlizec.findElement(By.id("surname"));
        vyplneniPrijmeniZaka.sendKeys("Kocourek");
        WebElement vyplneniDatumuNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        vyplneniDatumuNarozeniZaka.sendKeys("20.08.2008");
        WebElement tlacitkoPlatbaPrevodem = prohlizec.findElement(By.xpath("//*[contains(text(),'Bankovní převod')]"));
        tlacitkoPlatbaPrevodem.click();
        WebElement tlacitkoSouhlasSPodminkami = prohlizec.findElement(By.xpath("//*[contains(text(),'Souhlasím')]"));
        tlacitkoSouhlasSPodminkami.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.xpath("//*[contains(@class,'btn btn-primary mt-3')]"));
        tlacitkoVytvoritPrihlasku.click();
    }

    public void odhlaseniUcastiZaka() {
        WebElement tlacitkoOdhlaseniUcasti = prohlizec.findElement(By.xpath("(//div[@class='btn-group'])[13]//a[text()='Odhlášení účasti']"));
        tlacitkoOdhlaseniUcasti.click();
        WebElement duvodOdhlaseniNemoc = prohlizec.findElement(By.xpath("//*[text()='Nemoc']"));
        duvodOdhlaseniNemoc.click();
        WebElement tlacitkoOdhlasitZaka = prohlizec.findElement(By.xpath("//*[@class='btn btn-primary']"));
        tlacitkoOdhlasitZaka.click();
        WebElement tlacitkoDetail = prohlizec.findElement(By.xpath("( //div[@class = 'btn-group'] )[13]//a[text()='Detail']"));
        tlacitkoDetail.click();
    }

    public void overeniOdhlaseniZaka() {
        WebElement potvrzeniOOdhlaseni = prohlizec.findElement(By.xpath("//li"));
        Assertions.assertTrue(potvrzeniOOdhlaseni.getText().startsWith("Žák byl odhlášen"));
    }
}

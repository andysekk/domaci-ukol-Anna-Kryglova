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

    WebDriver prohlizec;



    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }



    @Test
    public void vyberKurzuPotePrihlaseni() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement volbaTrimesicniKurzyProgramovani = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[3]//a[text()='Více informací']"));
        volbaTrimesicniKurzyProgramovani.click();
        WebElement volbaJavaScript = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[2]//a[text()='Vytvořit přihlášku']"));
        volbaJavaScript.click();

        WebElement prihlaseniEmail = prohlizec.findElement(By.id("email"));
        prihlaseniEmail.sendKeys("andysek.brno@seznam.cz");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("Franta1");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//button[contains(text(),'Přihlásit')]"));
        tlacitkoPrihlasit.click();

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

        WebElement potvrzeniOPrihlaseni = prohlizec.findElement(By.xpath("//*[contains(text(),'Stáhnout potvrzení o přihlášení')]"));
        Assertions.assertNotNull(potvrzeniOPrihlaseni);
    }

    @Test
    public void prihlaseniPoteVyberKurzu() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        tlacitkoPrihlasit.click();
        WebElement prihlaseniEmail = prohlizec.findElement(By.id("email"));
        prihlaseniEmail.sendKeys("andysek.brno@seznam.cz");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("Franta1");
        WebElement tlacitkoPrihlasit2 = prohlizec.findElement(By.xpath("//button[contains(text(),'Přihlásit')]"));
        tlacitkoPrihlasit2.click();

        WebElement tlacitkoVytvoritNovouPrihlasku = prohlizec.findElement(By.xpath("//*[contains(@class,'btn btn-sm btn-info')]"));
        tlacitkoVytvoritNovouPrihlasku.click();
        WebElement volbaDigitalniAkademieTestovani = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[1]//a[text()='Více informací']"));
        volbaDigitalniAkademieTestovani.click();
        WebElement volbaZakladyAlgoritmizace = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[1]//a[text()='Vytvořit přihlášku']"));
        volbaZakladyAlgoritmizace.click();


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

        WebElement potvrzeniOPrihlaseni = prohlizec.findElement(By.xpath("//*[contains(text(),'Stáhnout potvrzení o přihlášení')]"));
        Assertions.assertNotNull(potvrzeniOPrihlaseni);

    }

    @Test
    public void odhlaseniUcastiZKurzu() {

        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement tlacitkoPrihlasit = prohlizec.findElement(By.xpath("//a[@href='https://cz-test-jedna.herokuapp.com/prihlaseni']"));
        tlacitkoPrihlasit.click();
        WebElement prihlaseniEmail = prohlizec.findElement(By.id("email"));
        prihlaseniEmail.sendKeys("andysek.brno@seznam.cz");
        WebElement polickoHeslo = prohlizec.findElement(By.id("password"));
        polickoHeslo.sendKeys("Franta1");
        WebElement tlacitkoPrihlasit2 = prohlizec.findElement(By.xpath("//button[contains(text(),'Přihlásit')]"));
        tlacitkoPrihlasit2.click();

        WebElement tlacitkoOdhlaseniUcasti = prohlizec.findElement(By.xpath("(//div[@class='btn-group'])[3]//a[text()='Odhlášení účasti']"));
        tlacitkoOdhlaseniUcasti.click();
        WebElement duvodOdhlaseniNemoc = prohlizec.findElement(By.xpath("//*[text()='Nemoc']"));
        duvodOdhlaseniNemoc.click();
        WebElement tlacitkoOdhlasitZaka = prohlizec.findElement(By.xpath("//*[@class='btn btn-primary']"));
        tlacitkoOdhlasitZaka.click();
        WebElement tlacitkoDetail = prohlizec.findElement(By.xpath("( //div[@class = 'btn-group'] )[3]//a[text()='Detail']"));
        tlacitkoDetail.click();

        WebElement potvrzeniOOdhlaseni = prohlizec.findElement(By.xpath("//*[contains(text(),'Žák byl odhlášen')]"));
        Assertions.assertNotNull(potvrzeniOOdhlaseni);
   }



    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }



}

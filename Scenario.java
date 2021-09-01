package Scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario {
  private WebDriver driver;
  private String baseUrl = "E:/Logiciels/chromedriver_win32/chromedriver.exe";
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", baseUrl);
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testLoginValideEtMdpValide() throws Exception {
	  
    driver.get("http://www.google.fr");
    
    WebElement Accepter=driver.findElement(By.xpath("//button[@id=\'L2AGLb\']"));
    
    Accepter.click();
    
    WebElement Recherche=driver.findElement(By.xpath("//input[@title='Rechercher']"));
    WebElement ButtonRechercher=driver.findElement(By.xpath("//input[@name='btnK']"));
    		
    Recherche.sendKeys("site:doyoubuzz.com java");
    
    ButtonRechercher.submit();
    
    
    WebElement elements=driver.findElement(By.id("search"));
    
    List<WebElement> resultats=elements.findElements(By.xpath("//div[@class='yuRUbf']/a"));
    
    int tailleListe = resultats.size();
    List<String> links = new ArrayList<String>();
    
    
    // On boucle tous les href pour les mettres dans links
    for(int i = 0; i < tailleListe; i++) {
    	
    	links.add(resultats.get(i).getAttribute("href"));
    	
    }
    
    

	//Excel initialization
    String fileURL="D:/Documents/AJC Formation/Cours AJC/9. java/ResultsDoYouBuzz.xlsx";
    
    String feuilleName="Feuil1";
    
    ExcelUtils excel = new ExcelUtils();
    
    excel.ouvertureFeuille(fileURL, feuilleName);
    
    
    
    // On boucle tous les links pour choper les infos.
    for(int i=0; i< tailleListe; i++) {
    	
    	driver.get(links.get(i));
    	
    	WebElement elementPrenom=driver.findElement(By.xpath("//span[@itemprop='givenName']"));
        WebElement elementNom=driver.findElement(By.xpath("//span[@itemprop='familyName']"));
        WebElement elementTitre=driver.findElement(By.xpath("//h2[@class='cvTitle']"));
        
        String prenom = elementPrenom.getText();
        String nom = elementNom.getText();
        String cvTitle = elementTitre.getText();
 
        excel.EcrireCell(i, 0, prenom);
        excel.EcrireCell(i, 1, nom);
        excel.EcrireCell(i, 2, cvTitle);
    	
    }
    

    excel.Sauvegarder(fileURL);
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

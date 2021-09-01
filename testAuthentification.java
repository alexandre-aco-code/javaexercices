package Authentification;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testAuthentification {
	  private static WebDriver driver;
	  private static String baseUrl = "E:/Logiciels/chromedriver_win32/chromedriver.exe";
	  
	  
	@BeforeAll
	static void setUpAll() throws Exception {
		System.setProperty("webdriver.chrome.driver", baseUrl);
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	    driver.quit();
	}
	
	@AfterAll
	static void tearDownAll() throws Exception {

	}

	@Test
	void test() throws Exception {
	    driver.get("http://ats.faimerecruiter.com/index.php?m=login");
	    
	    
//	    System.out.print(login.isDisplayed());
//	    System.out.print(password.isDisplayed());
//	    System.out.print(buttonLogin.isDisplayed());
	    
	    //Get Excel Values
	    String fileURL="D:/Documents/AJC Formation/Cours AJC/9. java/InformationsAuth.xlsx";
	    
	    String feuilleName="Feuil1";
	    
	    ExcelUtils excel = new ExcelUtils();
	    
	    excel.ouvertureFeuille(fileURL, feuilleName);
	    
	    
	    
//	    try {
//		    Assert.assertEquals(resultatAttendu, resultatActuel);
//	    	resultatTest = true;
//	    } catch (Exception e){
//	    	resultatTest = false;
//	    }
	    
//	    System.out.println(excel.RecupererLigne());
	    
	    for(int i=1; i<excel.RecupererLigne(); i++) {
	    	
		    WebElement username=driver.findElement(By.id("username"));
		    WebElement password=driver.findElement(By.id("password"));
	    	
	    	String usernameValue = excel.LireCell(i, 0);
		    String passwordValue = excel.LireCell(i, 1);
		    
		    username.sendKeys(usernameValue);
		    password.sendKeys(passwordValue);
		    
		    WebElement buttonLogin=driver.findElement(By.xpath("//input[@value='Login']"));		    
		    buttonLogin.click();

		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    String resultatActuel = driver.getCurrentUrl();
		    
		    String resultatAttendu = excel.LireCell(i, 2);
		    
			String resultatTest;
			
		    if(resultatAttendu == resultatActuel) {
		    	resultatTest = "PASS";
		    } else {
		    	resultatTest = "FAIL";
		    }
		    
		    String anomalie;
		    
		    anomalie="Le résultat attendu est : "+resultatAttendu+" alors que nous avons comme résultat : "+resultatActuel;

		    excel.EcrireCell(i, 3, resultatActuel);
		    excel.EcrireCell(i, 4, resultatTest);
		    excel.EcrireCell(i, 5, anomalie);
		    
		    excel.Sauvegarder(fileURL);
		    

		    //Logout
		    WebElement logout = driver.findElement(By.linkText("Logout"));
		    logout.click();
		    
		    
	    	
	    }
	    
	    
	    
	    
	    
	} 

}

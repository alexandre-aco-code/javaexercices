package Authentification;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

//@Listeners(Automatisation.ListenerTest.class)
public class CreateJobOrder {

	private WebDriver driver;

	String Title;
	String Company;
	String City;
	String State;
	String Recruiter;
	String Owner;
	String Type;
	String Openings;
	String ResultatAttendu;
	// optionnelles
	String Department;
	String Contact;
	String StartDate;
	String Duration;
	String MaximumRate;
	String Salary;
	String CompanyJobID;
	String Hot;
	String Public;
	String Description;
	String InternalNotes;
	String Questionnaire;

	String URLFile = "D:/Documents/AJC Formation/Cours AJC/10. selenium/CreateJobOrder.xlsx";
	String URLFileSave = "D:/Documents/AJC Formation/Cours AJC/10. selenium/CreateJobOrderSave.xlsx";

	@BeforeTest
	public void beforeClass() throws InterruptedException {

		// Instantiation du driver
		System.setProperty("webdriver.chrome.driver", "E:/Logiciels/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Connexion à l'ATS
		driver.get("http://ats.faimerecruiter.com/index.php?m=joborders");

		// Saisie Login mdp et connexion

		WebElement ObjUsername = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement ObjPassword = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement ObjValidation = driver.findElement(By.xpath("//input[@value='Login']"));

		ObjUsername.clear();
		ObjUsername.sendKeys("admin");
		ObjPassword.clear();
		ObjPassword.sendKeys("admin");

		ObjValidation.click();

		// Temporisateur wait attend jusqu'à remplir la condition title
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add Job Order')]")));

	}

	@DataProvider(name = "RegisterData")

	public Object[][] RegisterData() throws Exception {

//		ExcelUtils excelUtils = new ExcelUtils();
//		excelUtils.ouvertureFeuille(URLFile, "Feuil1");

		Excel.ExcelUtils.setExcelFile(URLFile, "Feuil1");

//		FileInputStream inputStream = new FileInputStream(
//				new File("D:/Documents/AJC Formation/Cours AJC/10. selenium/CreateJobOrder.xlsx"));
//		@SuppressWarnings("resource")
//		XSSFWorkbook Workbook = new XSSFWorkbook(inputStream);
//		XSSFSheet sheet = Workbook.getSheetAt(0);
//		int NombreLigne=sheet.getLastRowNum();

//		Thread.sleep(1000);

		int NombreLigne;
		NombreLigne = Excel.ExcelUtils.getRowCount();

		Object[][] Data = new Object[NombreLigne][22];
//		DataFormatter formatter = new DataFormatter();

		Title = "";
		Company = "";
		City = "";
		State = "";
		Recruiter = "";
		Owner = "";
		Type = "";
		Openings = "";
		ResultatAttendu = "";
		// optionnelles
		Department = "";
		Contact = "";
		StartDate = "";
		Duration = "";
		MaximumRate = "";
		Salary = "";
		CompanyJobID = "";
		Hot = "";
		Public = "";
		Description = "";
		InternalNotes = "";
		Questionnaire = "";

		for (int i = 1; i <= NombreLigne; i++) {

//			XSSFCell CellTitle = excelUtils.LireCell(0);
//			Username=CellUsername.getStringCellValue();
//			formatter.formatCellValue(CellTitle);

//			XSSFCell CellCompany = sheet.getRow(i).getCell(1);
//			Company = formatter.formatCellValue(CellCompany);

//			XSSFCell CellCity = sheet.getRow(i).getCell(2);
//			City = formatter.formatCellValue(CellCity);
//
//			XSSFCell CellState = sheet.getRow(i).getCell(3);
//			State = formatter.formatCellValue(CellState);
//
//			XSSFCell CellRecruiter = sheet.getRow(i).getCell(4);
//			Recruiter = formatter.formatCellValue(CellRecruiter);
//
//			XSSFCell CellOwner = sheet.getRow(i).getCell(5);
//			Owner = formatter.formatCellValue(CellOwner);
//
//			XSSFCell CellType = sheet.getRow(i).getCell(6);
//			Type = formatter.formatCellValue(CellType);
//
//			XSSFCell CellOpenings = sheet.getRow(i).getCell(7);
//			Openings = formatter.formatCellValue(CellOpenings);
//
//			XSSFCell CellResultatAttendu = sheet.getRow(i).getCell(8);
//			ResultatAttendu = formatter.formatCellValue(CellResultatAttendu);

			Title = Excel.ExcelUtils.getCellData(i, 0);
			Company = Excel.ExcelUtils.getCellData(i, 1);
			City = Excel.ExcelUtils.getCellData(i, 2);
			State = Excel.ExcelUtils.getCellData(i, 3);
			Recruiter = Excel.ExcelUtils.getCellData(i, 4);
			Owner = Excel.ExcelUtils.getCellData(i, 5);
			Type = Excel.ExcelUtils.getCellData(i, 6);
			Openings = Excel.ExcelUtils.getCellData(i, 7);
			ResultatAttendu = Excel.ExcelUtils.getCellData(i, 8);

			Department = Excel.ExcelUtils.getCellData(i, 13);
			Contact = Excel.ExcelUtils.getCellData(i, 14);
			StartDate = Excel.ExcelUtils.getCellData(i, 15);
			Duration = Excel.ExcelUtils.getCellData(i, 16);
			MaximumRate = Excel.ExcelUtils.getCellData(i, 17);
			Salary = Excel.ExcelUtils.getCellData(i, 18);
			CompanyJobID = Excel.ExcelUtils.getCellData(i, 19);
			Hot = Excel.ExcelUtils.getCellData(i, 20);
			Public = Excel.ExcelUtils.getCellData(i, 21);
			Description = Excel.ExcelUtils.getCellData(i, 22);
			InternalNotes = Excel.ExcelUtils.getCellData(i, 23);
			Questionnaire = Excel.ExcelUtils.getCellData(i, 24);

			if (Recruiter.length() == 0) {
				Recruiter = "(Select a User)";
			}

			if (Owner.length() == 0) {
				Owner = "(Select a User)";
			}

			if (Type.length() == 0) {
				Type = "C (Contract)";
			}

			Data[i - 1][0] = Title;
			Data[i - 1][1] = Company;
			Data[i - 1][2] = City;
			Data[i - 1][3] = State;
			Data[i - 1][4] = Recruiter;
			Data[i - 1][5] = Owner;
			Data[i - 1][6] = Type;
			Data[i - 1][7] = Openings;
			Data[i - 1][8] = ResultatAttendu;
			Data[i - 1][9] = i;

			// optionnelles
			Data[i - 1][10] = Department;
			Data[i - 1][11] = Contact;
			Data[i - 1][12] = StartDate;
			Data[i - 1][13] = Duration;
			Data[i - 1][14] = MaximumRate;
			Data[i - 1][15] = Salary;
			Data[i - 1][16] = CompanyJobID;
			Data[i - 1][17] = Hot;
			Data[i - 1][18] = Public;
			Data[i - 1][19] = Description;
			Data[i - 1][20] = InternalNotes;
			Data[i - 1][21] = Questionnaire;

		}
		return Data;
	}

	@Test(dataProvider = "RegisterData")
	public void TestAddJobOrder(String Title, String Company, String City, String State, String Recruiter, String Owner,
			String Type, String Openings, String ResultatAttendu, int i, String Department, String Contact,
			String StartDate, String Duration, String MaximumRate, String Salary, String CompanyJobID, String Hot,
			String Public, String Description, String InternalNotes, String Questionnaire) throws Exception {

		System.out.println("Cas test N° " + i);
//		System.out.println("Informations : " + Title + " " + Company + " " + City + " " + State + " " + Recruiter + " "
//				+ Owner + " " + Type + " " + Openings + " " + ResultatAttendu);

		Thread.sleep(100);

		WebElement ObjAddJobOrder = driver.findElement(By.xpath("//a[contains(text(),'Add Job Order')]"));

		ObjAddJobOrder.click();
//	Thread.sleep(500);

		driver.switchTo().frame(0);

		// Temporisateur wait attend jusqu'à remplir la condition title
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Create Job Order']")));

		WebElement ObjCreateJobOrder = driver.findElement(By.xpath("//input[@value='Create Job Order']"));

		ObjCreateJobOrder.click();

//	WebElement ObjTitle = driver.findElement(By.xpath("//input[@id='title']"));
//	
//	System.out.println(ObjTitle.getText());

//    driver.get("http://ats.faimerecruiter.com/index.php?m=login");

		driver.findElement(By.xpath("//input[@id='title']")).sendKeys(Title);

//    driver.findElement(By.xpath("//input[@name='typeCompany']")).click();
//    driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys(Company);
//    driver.findElement(By.xpath("//form[@id='addJobOrderForm']/table/tbody/tr[2]/td[2]")).click();
//    

		driver.findElement(By.id("companyName")).click();
		driver.findElement(By.id("companyName")).clear();
		driver.findElement(By.id("companyName")).sendKeys(Company);
		if (Company.length() != 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggest0")));
			driver.findElement(By.id("suggest0")).click();
		}

//		System.out.println("Le recruteur est " + Recruiter);
		driver.findElement(By.id("recruiter")).click();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("recruiter"))).selectByVisibleText(Recruiter);

//		System.out.println("Le Owner est " + Owner);
		driver.findElement(By.id("owner")).click();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("owner"))).selectByVisibleText(Owner);

//		System.out.println("Le Type est " + Type);
		driver.findElement(By.id("type")).click();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("type"))).selectByVisibleText(Type);

		driver.findElement(By.id("openings")).click();
		driver.findElement(By.id("openings")).clear();
		driver.findElement(By.id("openings")).sendKeys(Openings);

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(City);

		driver.findElement(By.id("state")).click();
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys(State);

		Thread.sleep(1000);

		
		
		
		// optionnelles

//		driver.findElement(By.id("departmentSelect")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggest0")));
//		driver.findElement(By.id("suggest0")).click();

		driver.findElement(By.id("departmentSelect")).click();
		Select departmentSelect = new Select(driver.findElement(By.id("departmentSelect")));
		departmentSelect.selectByVisibleText("None");
		

//		Thread.sleep(1000);
		

		driver.findElement(By.id("contactID")).click();
		Select contactID = new Select(driver.findElement(By.id("contactID")));
		contactID.selectByVisibleText(Contact);
		

//		Thread.sleep(1000);
		
//		driver.findElement(By.id("contactID")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggest0")));
//		driver.findElement(By.id("suggest0")).click();
		
		
		driver.findElement(By.id("startDate_Month_ID")).click();
		new Select(driver.findElement(By.id("startDate_Month_ID"))).selectByVisibleText(StartDate);

//		Thread.sleep(1000);
		
		driver.findElement(By.id("startDate_Day_ID")).click();
		new Select(driver.findElement(By.id("startDate_Day_ID"))).selectByVisibleText("6");
		

//		Thread.sleep(1000);
		
		driver.findElement(By.id("startDate_Year_ID")).click();
		driver.findElement(By.id("startDate_Year_ID")).clear();
		driver.findElement(By.id("startDate_Year_ID")).sendKeys("21");	
		

//		Thread.sleep(1000);
		
		driver.findElement(By.id("duration")).click();
		driver.findElement(By.id("duration")).clear();
		driver.findElement(By.id("duration")).sendKeys(Duration);
		
		
		driver.findElement(By.id("maxRate")).click();
		driver.findElement(By.id("maxRate")).clear();
		driver.findElement(By.id("maxRate")).sendKeys(MaximumRate);
		
		driver.findElement(By.id("salary")).click();
		driver.findElement(By.id("salary")).clear();
		driver.findElement(By.id("salary")).sendKeys(Salary);
		
		driver.findElement(By.id("companyJobID")).click();
		driver.findElement(By.id("companyJobID")).clear();
		driver.findElement(By.id("companyJobID")).sendKeys(CompanyJobID);
		
		driver.findElement(By.id("isHot")).click();
		driver.findElement(By.id("public")).click();
		

		Thread.sleep(1000);
		
		
		
//		driver.switchTo().frame( driver.findElement( By.xpath("//iframe[@title='Éditeur de texte enrichi, description']")));
		
//		driver.switchTo().frame(driver.findElements(By.tagName("iframe").get(0));
//		driver.findElement(By.xpath("//body[@contenteditable=true]")).sendKeys(Description);
//
//		
//		 driver.switchTo().defaultContent();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Éditeur de texte enrichi, description']")));
		
//		driver.findElement(By.xpath("//body[@contenteditable=true]")).sendKeys(Description);
		driver.findElement( By.xpath( "//body" ) ).sendKeys(Description);

		
		driver.switchTo().defaultContent();
		
		

		
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 |
		// ]]
		// ERROR: Caught exception [unknown command [editContent]]
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame |
		// relative=parent | ]]//input[@id='title']
		
		
		

		Thread.sleep(1000);
		
		driver.findElement(By.id("notes")).click();
		driver.findElement(By.id("notes")).clear();
		driver.findElement(By.id("notes")).sendKeys(InternalNotes);
		
		driver.findElement(By.id("questionnaire")).click();
		new Select(driver.findElement(By.id("questionnaire"))).selectByVisibleText("Tests Quest");
		
		

		Thread.sleep(1000);
		
		
		
		
		
		

		driver.findElement(By.name("submit")).click();

		String ResultatObtenu;
		boolean TestValid;

		try {
			String AlertMessage = driver.switchTo().alert().getText();
//			System.out.println(AlertMessage);
//			System.out.println("Problème");
			ResultatObtenu = "Message d'erreur";
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
//			System.out.println("OK");
			ResultatObtenu = "Job Order Created";
		}

		try {
			driver.findElement(By.xpath("//div[contains(text(),'Bad Server Information')]"));
			ResultatObtenu = "Message erreur serveur";
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println("ResultatAttendu : " + ResultatAttendu.trim());
		System.out.println("ResultatObtenu : " + ResultatObtenu.trim());

		String anomalie;
		if (ResultatAttendu.trim().equals(ResultatObtenu.trim())) {
			TestValid = true;
			anomalie = "";
		} else {
			System.out.println("écriture de l'anomalie");
			TestValid = false;
			anomalie = "Le résultat attendu est : " + ResultatAttendu.trim() + " alors que nous avons comme résultat : "
					+ ResultatObtenu.trim();

		}

//		System.out.println("on passe le try catch bloquant");

//		Row row = this.feuille.getRow(ligne);
//		if (row == null) {
//			row = this.feuille.createRow(ligne);
//		}
//		
//		Cell cell = row.getCell(colonne);
//		if (cell == null) {
//			cell = row.createCell(colonne);
//		}
//		cell.setCellValue(value);

		String resultTest;

		if (TestValid) {
			resultTest = "PASS";
		} else {
			resultTest = "FAIL";
		}

		System.out.println("Resultat du test : " + resultTest);

		System.out.println("On ecrit dans le Excel");
		Excel.ExcelUtils.setCellData(i, 9, ResultatObtenu);
		Excel.ExcelUtils.setCellData(i, 10, resultTest);
		Excel.ExcelUtils.setCellData(i, 11, anomalie);

		try {
			assertEquals(ResultatAttendu, ResultatObtenu);
		} catch (Exception e) {
			System.out.println(e);
		}

		driver.get("http://ats.faimerecruiter.com/index.php?m=joborders");

//		try {
//			driver.findElement(By.xpath("//h2[contains(text(), 'Job Orders: Job Order Details')]"));
//			ResultatObtenu = "Job Order Created";
//
//		} catch (NoSuchElementException e) {
//			AlertMessage = driver.switchTo().alert().getText();
//			System.out.println(AlertMessage);
//			driver.switchTo().alert().accept();
//			ResultatObtenu = "Message d'erreur";
//		}

//		if (AlertMessage.length() != 0) {
//			// choper details job order plutot 
//			ResultatObtenu = "Job Order Created";
//		} else {
//			ResultatObtenu = "Message d'erreur";
//		};

//		if (ResultatObtenu == ResultatAttendu) {
//			TestValid = true;
//		} else {
//			TestValid = false;
//		}

	}

	@AfterClass
	public void afterClass() throws Exception {

		Excel.ExcelUtils.SaveAs(URLFileSave);

		driver.quit();
	}

}
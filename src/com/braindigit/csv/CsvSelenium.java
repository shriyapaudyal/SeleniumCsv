package com.braindigit.csv;
import Check.ExcelConnect;

//import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class CsvSelenium {

	
		static int count=0;
		public static void main(String[] args) throws Exception {
	
			// TODO Auto-generated method stub
			System.setProperty("webdriver.gecko.driver","E:\\backup\\geckodriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\selenium\\chromedriver.exe");
			WebDriver driver = new FirefoxDriver();
			//WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://lb25.braindigit.com/qa18/");
			Thread.sleep(5000);

			driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
			driver.findElement(By.id("modlgn-username")).clear();
			driver.findElement(By.id("modlgn-username")).sendKeys("lina0");
			driver.findElement(By.id("modlgn-passwd")).clear();
			driver.findElement(By.id("modlgn-passwd")).sendKeys("brain");
			driver.findElement(By.id("modlgn-passwd")).click();
			Thread.sleep(500);
			driver.findElement(By.name("Submit")).click();
			//Thread.sleep(50);
			//ExcelConnect ec= new ExcelConnect();
			String sheet = "property";
			String path = "E:\\shriya\\SeleniumPractice\\DataCenter.xlsx";		
			int rownum= ExcelConnect.getRowCount(path, sheet);
			Thread.sleep(5000);
			driver.findElement(By.xpath("html/body/div[1]/aside/div/section/ul/li[4]/a/span[contains(.,'Properties')]")).click();
			Thread.sleep(5000);
			for(int i=0;i<=rownum;i++)
			{					
				
				
				Thread.sleep(10000);
				
				driver.findElement(By.xpath("html/body/div[1]/div[2]/section[2]/div[1]/div/div/a[contains(.,'New')]")).click() ;
			
				Thread.sleep(8000);
				//title
				String title1=ExcelConnect.getCellValue(path, sheet, i, count++);
				driver.findElement(By.id("title")).sendKeys(title1);
				Thread.sleep(500);
				
				//category
				String category1=ExcelConnect.getCellValue(path, sheet, i, count++);
				Select category = new Select(driver.findElement(By.id("category_id")));
				category.selectByVisibleText(category1);
				Thread.sleep(1500);
				
				//type
				String type1=ExcelConnect.getCellValue(path, sheet, i, count++);
				Select type= new Select(driver.findElement(By.id("type_id")));
				type.selectByVisibleText(type1);
				Thread.sleep(1500);
						
				//area
				//DataFormatter formatter = new DataFormatter(); 
				String area=ExcelConnect.getCellValue(path, sheet, i, count++);
				//int area1= 					
				driver.findElement(By.name("area")).sendKeys(area);
				Thread.sleep(1500);
				
				//purpose
				String purpose1=ExcelConnect.getCellValue(path, sheet, i, count++);			
				Select purpose = new Select(driver.findElement(By.id("purpose_id")));
				purpose.selectByVisibleText(purpose1);
				Thread.sleep(1500);
				
				//bedroom
				String bedroom=ExcelConnect.getCellValue(path, sheet, i, count++);
				driver.findElement(By.name("exf[BEDROOM_NUMBER]")).click();
				driver.findElement(By.name("exf[BEDROOM_NUMBER]")).clear();
				driver.findElement(By.name("exf[BEDROOM_NUMBER]")).sendKeys(bedroom);
				Thread.sleep(1500);
				//bathroom
				String bathroom=ExcelConnect.getCellValue(path, sheet, i, count++);
				driver.findElement(By.xpath(".//*[@id='exfBATHROOM_NUMBER']")).sendKeys(bathroom);
				Thread.sleep(1500);
				
				//garage
				String garage1=ExcelConnect.getCellValue(path, sheet, i, count++);
				Select garage= new Select(driver.findElement(By.id("exfGARAGE")));
				garage.selectByVisibleText(garage1);
				Thread.sleep(1500);
				
				//price
				String price=ExcelConnect.getCellValue(path, sheet, i, count++);
				driver.findElement(By.xpath(".//*[@id='price']")).sendKeys(price);
				Thread.sleep(1500);
				
				//state
				String state1=ExcelConnect.getCellValue(path, sheet, i, count++);
				Select state = new Select(driver.findElement(By.id("property_region")));
				state.selectByVisibleText(state1);
				Thread.sleep(1500);
				
				//region
				String region1=ExcelConnect.getCellValue(path, sheet, i, count++);
				Select region = new Select(driver.findElement(By.id("area_id")));
				region.selectByVisibleText(region1);
				Thread.sleep(1500);
				
				driver.findElement(By.name("saveProperty")).click();
			
			
			Thread.sleep(5000);
			
			count=0;
			
			driver.navigate().refresh();
			}
			driver.quit();
		
	}

}

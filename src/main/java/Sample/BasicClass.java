package Sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicClass {
	
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String browsername) {
		
		switch(browsername) {
		
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "Internet Explorer":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
				System.out.println("INVALID BROWSER");
				break;
		
		}
		return driver;
	
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		
		
		}
	@SuppressWarnings("unused")
	public static void impAndMax(long sec) {
	     driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	     driver.manage().window().maximize();

	}
	
	public static void quit() {
		driver.quit();

	}
	
    public static String title() {
		String title = driver.getTitle();
		return title;

	}
    
    public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
    
    public static void sendKeys(WebElement s,String data) {
		s.sendKeys(data);

	}
    
    
    
    public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		}
    
    public static void dragAndDrop(WebElement from, WebElement to) {
    	Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}
    public static void clickAndHold(WebElement target) {
    	Actions a=new Actions(driver);
    	a.clickAndHold().moveToElement(target).release();

	}
    public static void clicks(WebElement target1, WebElement target2) {
    	Actions a=new Actions(driver);
    	a.contextClick(target1).moveToElement(target2).doubleClick();

	}
    public static void alert(String types) {
		
    	switch(types)
    	{
    	case "simple alert":
    		Alert sa=driver.switchTo().alert();
    		sa.accept();
    		
    	case "confirm alert":
    		Alert ca=driver.switchTo().alert();
    		ca.dismiss();
    	}
    }
    public static void promptalert(String types,String data) {	
    	
    		Alert pa=driver.switchTo().alert();
    		pa.sendKeys(data);
    		pa.accept();
    		
    	}
    		
		
    @SuppressWarnings("unused")
	public static void selectByIndex(WebElement data, int index) {
    	Select sbi=new Select(data);
    	sbi.selectByIndex(index);
    	}
    public static void selectByValue(WebElement data, String value) {
    	Select sbv=new Select(data);
    	sbv.selectByValue(value);
    	}
    public static void selectByText(WebElement data, String text) {
    	Select sbvt=new Select(data);
    	sbvt.selectByVisibleText(text);
    	}
    public static void deselectByIndex(WebElement data, int index) {
    	Select dsbi=new Select(data);
    	dsbi.deselectByIndex(index);

	}
   public static void deselectByValue(WebElement data, String value) {
	   Select dsbv=new Select(data);
       dsbv.deselectByValue(value);
	

}
    public static void deselectByText(WebElement data, String text) {
    	Select dsbt=new Select(data);
    	dsbt.deselectByVisibleText(text);
    	

	}
    public static void getOptions(WebElement data) {
    	Select allopt=new Select(data);
    	List<WebElement> options = allopt.getOptions();
    	System.out.println(options);
    	}
    public static void getParticularOptions(WebElement data, int index) {
    	Select allopt=new Select(data);
    	List<WebElement> options = allopt.getOptions();
    	WebElement text = options.get(index);
    	String txtprint = text.getText();
    	System.out.println(txtprint);
    	
	    }
    public static void getAllSelectedOptions(WebElement data) {
    	Select allselectopt=new Select(data);
    	List<WebElement> allSelectedOptions = allselectopt.getAllSelectedOptions();
    	System.out.println(allSelectedOptions);
    	}
    public static void getFirstSelectedOptions(WebElement data) {
    	Select frstselectedopt=new Select(data);
    	WebElement firstSelectedOption = frstselectedopt.getFirstSelectedOption();
    	System.out.println(firstSelectedOption);
        }
    public static void deSelectAll(WebElement data) {
    	Select deselectall=new Select(data);
    	deselectall.deselectAll();
    	}
    public static void isMultiple(WebElement data) {
    	Select multiple=new Select(data);
    	boolean mult = multiple.isMultiple();
    	System.out.println(mult);
    	}
    
    public static void screenShot(String location) throws IOException {
    	TakesScreenshot tk=(TakesScreenshot)driver;
    	File from = tk.getScreenshotAs(OutputType.FILE);
    	File to = new File(location);
    	FileUtils.copyFile(from, to);
		}
    
    public static void jsExecuteSetAttribute(String data, Object element) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
    	}
    public static Object jsExecuteGetAttribute(WebElement element) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", element);
         return  executeScript;
    	}
    public static void jsExecuteClick(WebElement element) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", element);
	   }
    public static void jsScrollDown(WebElement element) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0],scrollIntoView(true)",element);
    	}
    public static void jsScrollUp(WebElement element) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0],scrollIntoView(false)",element);
    }
    
    public static String stringExcel(String filename,String sheetname,int r,int c) throws Throwable {
    	

		File f=new File(filename);
		
		FileInputStream fis= new FileInputStream(f);
		
		Workbook wr= new XSSFWorkbook(fis);
		
		Sheet sheet = wr.getSheet(sheetname);
		Row row = sheet.getRow(r);
		Cell cell2 = row.getCell(c);
		
		
		
		CellType type = cell2.getCellType();
		int code = type.getCode();
		
		String value=null;
		if(code==1){
			value = cell2.getStringCellValue();
			
		}
		else {
			if(DateUtil.isCellDateFormatted(cell2)) {
		         value = new SimpleDateFormat("dd-mm-yyyy").format(cell2.getDateCellValue());
				
			}else {
				value = String.valueOf((long)cell2.getNumericCellValue());
				
				}
		}
	   return value;
    }

    private void createExcel(String filename,String sheetname,int row,int cell,String givingvalue) throws Throwable {
    	File f=new File(filename);
		Workbook w= new XSSFWorkbook();
		
        Sheet cs = w.createSheet(sheetname);
        
        Row r = cs.createRow(row);
        
        Cell c = r.createCell(cell);
        
        c.setCellValue(givingvalue);
        
        System.out.println(c);
        
        FileOutputStream out= new FileOutputStream(f);
        
        w.write(out);
        

	}





}


			
	
    

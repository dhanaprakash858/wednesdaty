package org.tb1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// 1.
	public static void getDriver() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}

	// 2.
	public static void enterUrl(String url) {
		driver.get(url);
	}

	// 3.
	public static void windowMax() {
		driver.manage().window().maximize();
	}
	
	//3.1
	public static void elementClear(WebElement element) {
		element.clear();
	}

	// 4.
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;

	}

	// 5.
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	// 6.
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}

	// 7.
	public void backword() {
		driver.navigate().back();
	}

	// 8.
	public void forward() {
		driver.navigate().forward();
	}

	// 9.
	public void refresh() {
		driver.navigate().refresh();
	}

	// 10.
	public void closeCurrentWindow() {
		driver.close();
	}

	// 11.
	public static void closeAllWindow() {
		driver.quit();
	}

	// 12.
	public WebElement findById(String attribute) {
		WebElement element = driver.findElement(By.id(attribute));
		return element;

	}

	// 13.
	public WebElement findByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	// 14.
	public WebElement findByClass(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;

	}

	// 15.
	public WebElement findByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 16
	public List<WebElement> findByTagName(String tagName) {
		List<WebElement> element = driver.findElements(By.tagName(tagName));
		return element;
	}

	// 17.
	public void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	

	// 18.
	public void clickElement(WebElement element) {
		element.click();
	}

	// 19.
	public String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;

	}

	// 20.
	public String getAttribute(WebElement element) throws IOException {
		String att = element.getAttribute("value");
		System.out.println(att);
		return att;
	}
	

	// 21.
	public String getAttribute1(WebElement element, String attributeValue) {
		String att = element.getAttribute(attributeValue);
		System.out.println(att);
		return att;

	}

	// 22.
	public void mouseOver(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	// 23.
	public void dragandDrop(WebElement source, WebElement target) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}

	// 24.
	public void rightClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// 25.
	public void doubleClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// //26.
	//
	// public void robotClass() throws AWTException {
	//
	// Robot robot =new Robot();
	// robot.keyPress(KeyEvent.VK_ENTER);
	// robot.keyRelease(KeyEvent.VK_ENTER);
	// }

	// 27.

	public void robotSendKeysEnter(Actions element, String text) {
		element.sendKeys("text", Keys.ENTER);
	}

	// 28.
	public static void alertBoxOk() {

		driver.switchTo().alert().accept();

	}

	// 29.
	public void alertBoxCancel() {

		driver.switchTo().alert().dismiss();

	}

	// 30.

	public void alertBoxSendKeys(String text) {
		driver.switchTo().alert().sendKeys("text");

	}

	// 31.

	public String alertBoxText() {

		String text = driver.switchTo().alert().getText();

		return text;

	}

	// 32.
	public void sendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	// 33.
	public Object getAttributeJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object text = executor.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(text);
		return text;
	}

	// 34.
	public void clickByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	// 35.
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 36.
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 37.
	public Object takeScreenShot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		FileUtils.copyFile(screenshotAs, destFile);

		return destFile;
	}

	// 38.
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 39.
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 40.
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 41.
	public boolean isMutlipleSelect(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

	// 42.
	public String getFirstSelected(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (WebElement x : options) {
			String text = x.getText();
			select.selectByVisibleText(text);
		}
		// Print First Selected value

		WebElement first = select.getFirstSelectedOption();
		String att = first.getAttribute("value");
		System.out.println(att);
		return att;

	}

	// 43.
	public String getAllSelected(WebElement element) {
		Select select = new Select(element);
		List<WebElement> all = select.getAllSelectedOptions();

		for (WebElement y : all) {
			String text = y.getText();
			System.out.println(text);

		}
		return null;

	}

	// 44.
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 45.
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 46.
	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 47.
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 48.
	public int sizeOfFrames(String tagname) {
		List<WebElement> f = driver.findElements(By.tagName(tagname));
		int size = f.size();
		System.out.println(size);
		return size;
	}

	// 49.
	public void switchToFrameId(String Id) {
		driver.switchTo().frame(Id);

	}

	// 50
	public void switchToFrameIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 51.
	public void switchToFrameWebElement(String web) {

		driver.switchTo().frame(web);

	}

	// 52
	public void switchToParentFrame() {

		driver.switchTo().parentFrame();
	}

	// 53
	public void switchToDefaultFrame() {

		driver.switchTo().defaultContent();
	}

	// 54.
	public String getWindowHandle() {
		String parent = driver.getWindowHandle();

		return parent;

	}

	// 55.

	public String getWindowHandles() {

		String parent = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {

			if (!child.equals(parent)) {
				driver.switchTo().window(child);
			}
		}
		return null;

	}

	// 56.

	public void getWindowHandles1(int index) {

		Set<String> all = driver.getWindowHandles();

		List<String> li1 = new ArrayList<String>(all);

		String string = li1.get(index);

		driver.switchTo().window(string);

	}

	// 57.

	public void switchParticularWindowHandles(int index) {

		Set<String> allWindows = driver.getWindowHandles();

		String window = (String) allWindows.toArray()[index];
		driver.switchTo().window(window);
	}

	// 58

	public void sleep(long millis) throws InterruptedException {

		Thread.sleep(millis);
	}

	// 59.
	public static void implicitlyWaits(int value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}

	// 60
	public void implicitlyWaits1(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// 61.
	public void explicitPresenceOfElementLocated(int value, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	}

	// 62.
	public void elementToBeClickable(int value, String id) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));

	}

	// 63.
	public void visibilityOfAllElements(int value, WebElement elements) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	// 64
	public void visibilityOfAllElementsLocatedBy(int value, String id) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));

	}

	// 65
	public void PresenceOfAllElementsLocated(int value, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));

	}

	// 66

	public boolean ElementToBeSelected(int value, String id) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		Boolean until = wait.until(ExpectedConditions.elementToBeSelected(By.id(id)));

		return until;
	}

	// Get the Cell Data-----Read
	// 67
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws IOException {

		String res = null;

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Frames\\Excel\\Datas.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
				res = dateFormat.format(dateCellValue);
			}

			else {

				double numericCellValue = cell.getNumericCellValue();

				long check = Math.round(numericCellValue);

				if (check == numericCellValue) {

					res = String.valueOf(check);
				} else {

					res = String.valueOf(numericCellValue);
				}

				return res;
			}

			break;

		default:
			break;
		}

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);
		return res;

	}

	// Update Data-------Write
	// 68
	public void updateData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Frames\\Excel\\Datas.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {

			cell.setCellValue(newData);
		}

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);

	}

	// 3. Create New Cell--------Write
	// 69
	public void writeCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Frames\\Excel\\Datas.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.createCell(cellNum);

		cell.setCellValue(data);

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);
		
		
		

	}

	// 4.Create new Workbook
	// 70
	public void createWorkBook(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Frames\\Excel\\Datas.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.createSheet(sheetName);

		Row row = sheet.createRow(rowNum);

		Cell cell = row.createCell(cellNum);

		cell.setCellValue(data);

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);

	}

	// Web Table
	// 71
	public void getWebTableDatas(String tagName, String tagName1) {

		List<WebElement> tableRows = driver.findElements(By.tagName(tagName));

		for (WebElement Rows : tableRows) {

			List<WebElement> tDatas = Rows.findElements(By.tagName(tagName1));

			for (WebElement web : tDatas) {
				String text = web.getText();
				System.out.println(text);
			}
		}
	}
}

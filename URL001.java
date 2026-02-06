import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.DriverManager;
import utils.ScreenshotUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class URL{

	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = DriverManager.getDriver("chrome");
		
		
		
		driver.get("https://www.amazon.in/");
		try
		{
		WebElement popup= driver.findElement(By.xpath("//button[contains(text(), 'Continue shopping' )]"));
		popup.click();
		System.out.println("Popup Clicked");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Popup not displayed");
		}
		
		WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
		search.click();
		search.sendKeys("Laptop");
		
		Thread.sleep(2000);
		
		List<WebElement> list= driver.findElements(By.xpath("//div[@id=\"sac-autocomplete-results-container\"]"));
		
		for(WebElement value : list)
		{
			System.out.println(value.getText());
	    }
		
		List<WebElement> valueclick= driver.findElements(By.xpath("//div[@class=\"s-suggestion-container\"]"));
		System.out.println(valueclick.size());
		if(valueclick.size()>=10)
		{
			//System.out.println(list.size());
			valueclick.get(2).click();
		}
		else
		{
			System.out.println("results found!");
		}
		
		Thread.sleep(3000);
			
		/*
		 * List<WebElement> totalproduct=
		 * driver.findElements(By.xpath("//div[@data-component-type='s-search-result']")
		 * );
		 * 
		 * //driver.findElements(By.
		 * xpath("//h2[@class=\"a-size-medium a-spacing-none a-color-base a-text-normal\"]"
		 * ));
		 * 
		 * double maxPrice = 0; WebElement highestProductLink = null;
		 * 
		 * for(WebElement product : totalproduct) {
		 * 
		 * try { // price WebElement priceEl =
		 * product.findElement(By.cssSelector("span.a-price-whole")); String priceStr =
		 * priceEl.getText().replace(",", ""); double price =
		 * Double.parseDouble(priceStr);
		 * 
		 * // title link WebElement titleLink =
		 * product.findElement(By.cssSelector("h2 a"));
		 * 
		 * if (price > maxPrice) { maxPrice = price; highestProductLink = titleLink; }
		 * 
		 * } catch (Exception e) { // Some products have missing price → skip continue;
		 * } }
		 * 
		 * // CLICK the highest priced product if (highestProductLink != null) {
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",
		 * highestProductLink); Thread.sleep(500); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();", highestProductLink); }
		 */
		
		ScreenshotUtils.takeScreenshot(driver, "");
		
		WebElement pro= driver.findElement(By.xpath("(//div[@data-cy=\"title-recipe\"]//span[contains(text(), 'ULTIMUS APEX Laptop Intel Celeron Dual Core 8 GB LPDDR4 512 GB SSD Expandable~1TB 14.1 FHD IPS Laptop Anti-Glare Ultra Thin Bezel 180° Hinge 3.0x3 USB HDMI SD Card Slot Win 11 Home 1.25KG Silver')])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pro);
		Thread.sleep(2000);
		pro.click();
		Thread.sleep(3000);
		
		String parentID = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows) {
		    if (!window.equals(parentID)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		
		WebElement getprice= driver.findElement(By.xpath("//span[@class=\"a-price aok-align-center reinventPricePriceToPayMargin priceToPay\"]//span[@class=\"a-price-whole\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getprice);
		Thread.sleep(2000);
		System.out.println(getprice.getText());
		
<<<<<<< HEAD
		//DriverManager.quitDriver();
		

for{
	i++++
}
=======
		DriverManager.quitDriver();
>>>>>>> main

	}

}

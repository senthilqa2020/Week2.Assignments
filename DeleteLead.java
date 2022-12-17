package Week2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		
		

		ChromeDriver driver = new ChromeDriver();

		// Login into Leaftaps application

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.cssSelector("form li:nth-of-type(2) em span span")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("90");

		driver.findElement(By.cssSelector("form table td:nth-of-type(2) .x-plain-body table button")).click();

		Thread.sleep(3000);

		WebElement leadId = driver
				.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]"));

		String deletedLeadId = leadId.getText();
		
		leadId.click();

		driver.findElement(By.linkText("Delete")).click();

		Thread.sleep(3000);

		driver.findElement(By.linkText("Find Leads")).click();

		Thread.sleep(3000);

		driver.findElement(By.name("id")).sendKeys(deletedLeadId);

		driver.findElement(By.cssSelector(".x-panel-body div:nth-of-type(1) .x-panel-bwrap .x-panel-btns-center button[type='button']")).click();

		Thread.sleep(3000);

		String noRecordsDisplayMessage = driver.findElement(By.cssSelector(".x-small-editor div")).getText();

		if (noRecordsDisplayMessage.equals("No records to display")) {
			System.out.println("No records found for the lead ID: " + deletedLeadId);
		}
		
		driver.quit();

	}



}

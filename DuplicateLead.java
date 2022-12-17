package Week2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		
		*/
		
		
		

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

		driver.findElement(By.cssSelector("form li:nth-of-type(3) em span span")).click();

		driver.findElement(By.name("emailAddress")).sendKeys("an");
		
		driver.findElement(By.cssSelector("form table td:nth-of-type(2) .x-plain-body table button")).click();
		
		Thread.sleep(3000);
		
		String leadName = driver
				.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[3]/div[1]/a[1]"))
				.getText();

		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		
		Thread.sleep(3000);
		

		driver.findElement(By.linkText("Duplicate Lead")).click();

		Thread.sleep(3000);

		String currentTitle = driver.getTitle();

		if (currentTitle.equals("Duplicate Lead | opentaps CRM")) {
			System.out.println("Current title is Duplicate Lead | opentaps CRM");
		}

		driver.findElement(By.className("smallSubmit")).click();

		Thread.sleep(3000);

		String duplicatedFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if (duplicatedFirstName.equals(leadName)) {
			System.out.println(
					"Duplicated lead name is " + duplicatedFirstName + " as same as the captured name " + leadName);

		} else {
			System.out.println(
					"Duplicated lead name is " + duplicatedFirstName + " not same as the captured name " + leadName);

		}

		driver.quit();

	}

		
		

	

}

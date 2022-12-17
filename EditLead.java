package Week2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
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

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Suresh");

		driver.findElement(By.cssSelector("form table td:nth-of-type(2) .x-plain-body table button")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();

		Thread.sleep(3000);

		String editLeadPageTitle = driver.getTitle();

		if (editLeadPageTitle.equals("View Lead | opentaps CRM")) {
			System.out.println("View lead page");
		} else {
			System.out.println("Click on view lead page");
		}

		driver.findElement(By.linkText("Edit")).click();

		String oldCompanyName = driver.findElement(By.name("companyName")).getText();
		Thread.sleep(2000);

		driver.findElement(By.name("companyName")).clear();

		driver.findElement(By.name("companyName")).sendKeys("CIKLUM");

		String newCompanyName = driver.findElement(By.name("companyName")).getText();

		driver.findElement(By.cssSelector(".fieldgroup div:nth-of-type(2) table tr:nth-of-type(12) input")).click();

		Thread.sleep(3000);

		String updatedCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if (updatedCompany.equals("")) {
			System.out.println("Edited Company: " + newCompanyName);
		} else {
			System.out.println("Existing company name: " + oldCompanyName);
		}

		driver.quit();

	}


	

}

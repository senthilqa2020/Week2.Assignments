package Week2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		

	
	//	 * //Pseudo Code
		 
	//	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
	//	 * 2. Enter UserName and Password Using Id Locator
		WebElement element = driver.findElement(By.id("username"));
		//element.sendKeys("Demosalesmanager");
		element.sendKeys("democsr");
		WebElement element1 = driver.findElement(By.id("password"));
		//element1.sendKeys("crmsfa");
		element1.sendKeys("crmsfa");
		
	//	 * 3. Click on Login Button using Class Locator
		WebElement element2 = driver.findElement(By.className("decorativeSubmit"));
		element2.click();
		
		

		
	//	 * 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
	  
	//	 * 5. Click on contacts Button
		// * 6. Click on Create Contact
			
		driver.findElement(By.linkText("Create Contact")).click();
	
	
	//	 * 7. Enter FirstName Field Using id Locator
		  
		  driver.findElement(By.id("firstNameField")).sendKeys("Senthil");

				 
	//	 * 8. Enter LastName Field Using id Locator
		  
			driver.findElement(By.id("lastNameField")).sendKeys("Senthilkumar");
		 
	//	 * 9. Enter FirstName(Local) Field Using id Locator
			driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Computer communications");
	//   * 10. Enter LastName(Local) Field Using id Locator

	//	 * 11. Enter Department Field Using any Locator of Your Choice
		  
		// * 12. Enter Description Field Using any Locator of your choice 
			driver.findElement(By.id("createContactForm_description")).sendKeys("Sample Description");

	//	 * 13. Enter your email in the E-mail address Field using the locator of your choice
			
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("senthilqa2020@gmail.com");

			
	//	 * 14. Select State/Province as NewYork Using Visible Text
			
			Select state = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));

			state.selectByVisibleText("New York");

			driver.findElement(By.name("submitButton")).click();
		 
	//	 * 15. Click on Create Contact
			
	 
	//	 * 16. Click on edit button 
			driver.findElement(By.linkText("Edit")).click();
		 
	//	 * 17. Clear the Description Field using .clear
			
			driver.findElement(By.id("updateContactForm_description")).clear();
		 
	//	 * 18. Fill ImportantNote Field with Any text
			driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("MY first launch program");
		 
	//	 * 19. Click on update button using Xpath locator
			driver.findElement(By.cssSelector(".fieldgroup-body tbody tr:nth-of-type(8) input")).click();
			
			Thread.sleep(2500);
			
			
	//	 * 20. Get the Title of Resulting Page.
			System.out.println(driver.getTitle());
			
       
		
		
		

	}

}

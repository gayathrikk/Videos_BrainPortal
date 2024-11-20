package GTask.myyapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Sanity {
	private RemoteWebDriver driver;

	@BeforeTest

	public void setup() throws MalformedURLException {

		DesiredCapabilities dc = DesiredCapabilities.chrome();

		URL url = new URL("http://172.20.23.92:4444/wd/hub");

		driver = new RemoteWebDriver(url, dc);
	}

	@Test(priority = 1)

	public void testSanity() throws InterruptedException {
		driver.get("https://brainportal.humanbrain.in/");
		driver.manage().window().maximize();
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
	}
	@Test(priority = 2)

	public void homepagecontent() {

		String heading1 = "Sudha Gopalakrishnan Brain Centre";
		WebDriverWait wait = new WebDriverWait(driver, 10);  // Wait for 10 seconds for the element to be visible
		WebElement text1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='main-title']")));
		String Heading1 = text1.getText().trim();  // Trim the text to remove extra spaces or newlines

		System.out.println("Head1: '" + Heading1 + "'");  // Debugging line to print the actual text

		// Assert if the expected heading matches the actual heading
		AssertJUnit.assertEquals("Heading1 is not equal", Heading1, heading1);
		
		String heading2 = "Indian Institute of Technology Madras";
		WebElement text2 = driver.findElement(By.xpath("//p[@class='sub-title']"));
		String Heading2 = text2.getText().trim();  // Trim to remove leading/trailing spaces

		// Log the actual extracted value
		System.out.println("Actual Heading2: '" + Heading2 + "'");

		// Now assert with detailed logging
		AssertJUnit.assertEquals("Heading2 are not equal", Heading2, heading2);  

		// Expected value (without newlines)
		String heading3 = "DHARANI A 3D Developing Human-brain Atlas as a Resource to Advance Neuroscience Internationally Integrated Multimodal Imaging and High-resolution Histology";

		// Find the element and capture the actual text
		WebElement text3 = driver.findElement(By.xpath("//h3[span[contains(text(), 'DHARANI')]]"));
		String Heading3 = text3.getText().trim();

		// Normalize both the expected and actual values by removing newlines and extra spaces
		heading3 = heading3.replace("\n", " ").replaceAll("\\s+", " ").trim();
		Heading3 = Heading3.replace("\n", " ").replaceAll("\\s+", " ").trim();

		// Print both values for debugging
		System.out.println("Expected: '" + heading3 + "'");
		System.out.println("Actual: '" + Heading3 + "'");

		// Assert that the expected and actual values are equal
		AssertJUnit.assertEquals("Heading3 are not equal", heading3, Heading3);




		String expectedParagraph = "Sudha Gopalakrishnan BRAIN Centre\n" +
                "Stilt floor, NAC-1 Building\n" +
                "IIT Madras, Chennai - 600036, India\n" +
                "Email: contact@humanbrainiitm.in\n" +
                "Phone: +91-44-2257-8892\n" +
                "Contact us";

//Find the element and capture the actual text
WebElement text4 = driver.findElement(By.xpath("//div[@class='col-md-4 col-lg-4 footer-mb-5']//h3[contains(text(), 'Address')]/following-sibling::p"));
String actualParagraph = text4.getText().trim();

//Normalize both strings (remove newlines and extra spaces)
expectedParagraph = expectedParagraph.replace("\n", " ").replaceAll("\\s+", " ").trim();
actualParagraph = actualParagraph.replace("\n", " ").replaceAll("\\s+", " ").trim();

//Print both values for debugging
System.out.println("Expected Paragraph: '" + expectedParagraph + "'");
System.out.println("Actual Paragraph: '" + actualParagraph + "'");

//Assert that the expected and actual values are equal
AssertJUnit.assertEquals("Paragraphs are not equal", expectedParagraph, actualParagraph);
		
WebElement tableRow = driver.findElement(By.xpath("//tr[th[text()='Brains'] and th[text()='Gestation week(GW)'] and th[text()='Sectioning Plane'] and th[text()='Available Datasets'] and th[text()='Annotations'] and th[text()='Volumes'] and th[text()='Videos']]"));

		String brains = tableRow.findElement(By.xpath("th[1]")).getText();

		String gestationWeek = tableRow.findElement(By.xpath("th[2]")).getText();

		String sectioningPlane = tableRow.findElement(By.xpath("th[3]")).getText();

		String availableDatasets = tableRow.findElement(By.xpath("th[4]")).getText();

		String annotations = tableRow.findElement(By.xpath("th[5]")).getText();

		String volumes = tableRow.findElement(By.xpath("th[6]")).getText();

		String videos = tableRow.findElement(By.xpath("th[7]")).getText();

		System.out.println("Brains: " + brains);

		System.out.println("Gestation Week (GW): " + gestationWeek);

		System.out.println("Sectioning Plane: " + sectioningPlane);

		System.out.println("Available Datasets: " + availableDatasets);

		System.out.println("Annotations: " + annotations);

		System.out.println("Volumes: " + volumes);

		System.out.println("Videos: " + videos);

		String Ncount = "Nissl (395)";

        WebElement N1 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=NISSL')])[1]"));

        String Ncount1 = N1.getText();

        System.out.println("NisslCount:" + Ncount);

        Assert.assertEquals(Ncount1, Ncount, "Nissl are not equal");



        String Hcount = "Haematoxylin & Eosin (341)";

        WebElement H1 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=HE')])[1]"));

        String Hcount1 = H1.getText();

        System.out.println("HEOSCount:" + Hcount);

        Assert.assertEquals(Hcount1, Hcount, "HEOS are not equal");

        

        String Ncount_1 = "Nissl (536)";

        WebElement N2 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=NISSL')])[2]"));

        String Ncount2 = N2.getText();

        System.out.println("NisslCount:" + Ncount_1);

        Assert.assertEquals(Ncount2, Ncount_1, "Nissl are not equal");

        

        String Hcount_1 = "Haematoxylin & Eosin (485)";

        WebElement H2 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=HE')])[2]"));

        String Hcount2 = H2.getText();

        System.out.println("HEOSCount:" + Hcount_1);

        Assert.assertEquals(Hcount2, Hcount_1, "HEOS are not equal");

        

        String Ncount_2 = "Nissl (540)";

        WebElement N3 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=NISSL')])[3]"));

        String Ncount3 = N3.getText();

        System.out.println("NisslCount:" + Ncount_2);

        Assert.assertEquals(Ncount3, Ncount_2, "Nissl are not equal");

        

        String Hcount_2 = "Haematoxylin & Eosin (467)";

        WebElement H3 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=HE')])[3]"));

        String Hcount3 = H3.getText();

        System.out.println("HEOSCount:" + Hcount_2);

        Assert.assertEquals(Hcount3, Hcount_2, "HEOS are not equal");

        

        String Ncount_3 = "Nissl (689)";

        WebElement N4 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=NISSL')])[4]"));

        String Ncount5 = N4.getText();

        System.out.println("NisslCount:" + Ncount_3);

        Assert.assertEquals(Ncount5, Ncount_3, "Nissl are not equal");

        

        String Hcount_3 = "Haematoxylin & Eosin (687)";

        WebElement H4 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=HE')])[4]"));

        String Hcount4 = H4.getText();

        System.out.println("HEOSCount:" + Hcount_3);

        Assert.assertEquals(Hcount4, Hcount_3, "HEOS are not equal");



        

        String Ncount_4 = "Nissl (657)";

        WebElement N5 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=NISSL')])[5]"));

        String Ncount6 = N5.getText();

        System.out.println("NisslCount:" + Ncount_4);

        Assert.assertEquals(Ncount6, Ncount_4, "Nissl are not equal");

        

        String Hcount_4 = "Haematoxylin & Eosin (335)";

        WebElement H5 = driver.findElement(By.xpath("(//div/a[contains(@href, 'seriesType=HE')])[5]"));

        String Hcount5 = H5.getText();

        System.out.println("HEOSCount:" + Hcount_4);

        Assert.assertEquals(Hcount5, Hcount_4, "HEOS are not equal");

      System.out.println("Home Page Contend Validation Done");  

    }



	public void clickLinkAndHandleTab(String xpath, String identifier) {

		try {

			// Wait for the link to be clickable

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));



			// Click the link

			link.click();

			System.out.println("--------------------------*****************-----------------------");

			System.out.println("The Link for " + identifier + " Clicked Successfully");


			Thread.sleep(3000);


			String parentWindow = driver.getWindowHandle();

			for (String windowHandle : driver.getWindowHandles()) {

				if (!windowHandle.equals(parentWindow)) {

					driver.switchTo().window(windowHandle); // Switch to the new tab

					break;

				}

			}


			driver.close();

			// Switch back to the parent window

			driver.switchTo().window(parentWindow);

		} catch (Exception e) {

			System.out.println("--------------------------*****************-----------------------");

			System.out.println("The Link for " + identifier + " not Clicked");

			e.printStackTrace();

		}

	}

//	@Test(priority = 3)
//
//	public void LinkValidation() {
//
//		// Define your XPath values for multiple links (including the new one you mentioned)
//
//		String[] xpaths = {
//
//				"//a[@href='/code/2dviewer/annotation/public?data=0']",
//
//				"//a[@href='/code/2dviewer/annotation/public?data=1']",
//
//				"//a[@href='/code/2dviewer/annotation/public?data=2']",
//
//				"//a[@href='/code/2dviewer/annotation/public?data=3']",
//
//				"//a[@href='/code/2dviewer/annotation/public?data=4']",
//
//				"//a[@href='/3dviewer/index.html?data=0&view=mri']", // New link added
//
//				"//a[@href='/3dviewer/index.html?data=1&view=mri']", // New link added
//
//				"//a[@href='/3dviewer/index.html?data=2&view=mri']" , // New link added
//
//				"//a[@href='/3dviewer/index.html?data=3&view=mri']",
//
//				"//a[@href='/3dviewer/index.html?data=4&view=mri']",
//
//				"//a[@href='/3dviewer/index.html?data=0&view=nissl']",
//
//				"//a[@href='/3dviewer/index.html?data=1&view=nissl']",
//
//				"//a[@href='/3dviewer/index.html?data=2&view=nissl']",
//
//				"//a[@href='/3dviewer/index.html?data=3&view=nissl']",
//
//				"//a[@href='/3dviewer/index.html?data=4&view=nissl']",
//
//				"//a[@href='/3dviewer/index.html?data=0&view=gray']",
//
//				"//a[@href='/3dviewer/index.html?data=1&view=gray']",
//
//				"//a[@href='/3dviewer/index.html?data=2&view=gray']",
//
//				"//a[@href='/3dviewer/index.html?data=3&view=gray']",
//
//				"//a[@href='/3dviewer/index.html?data=4&view=gray']",
//
//		};
//		String[] identifiers = {
//
//				"Specimen 1 Annotation Link",
//
//				"Specimen 2 Annotation Link",
//
//				"Specimen 3 Annotation Link",
//
//				"Specimen 4 Annotation Link",
//
//				"Specimen 5 Annotation Link",
//
//				"MRI View 1 Link",  // Identifier for new link
//
//				"MRI View 2 Link",  // Identifier for new link
//
//				"MRI View 3 Link" ,
//
//				"MRI View 4 Link",
//
//				"MRI View 5 Link",
//
//				"Nissl View 1 Link",
//
//				"Nissl View 2 Link",
//
//				"Nissl View 3 Link",
//
//				"Nissl View 4 Link",
//
//				"Nissl View 5 Link",
//
//				"Nissl Gray Scale View 1 Link",
//
//				"Nissl Gray Scale View 2 Link",
//
//				"Nissl Gray Scale View 3 Link",
//
//				"Nissl Gray Scale View 4 Link",
//
//				"Nissl Gray Scale View 5 Link", 
//
//		};
//
//		for (int i = 0; i < xpaths.length; i++) {
//
//			clickLinkAndHandleTab(xpaths[i], identifiers[i]);
//
//		}
//
//	}

	@AfterTest

	public void tearDown() {

		if (driver != null) {

			driver.quit();

		}

	}

}


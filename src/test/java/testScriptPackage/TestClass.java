package testScriptPackage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import commonpackage.BaseClass;
import commonpackage.PageObjectClass;



@Listeners(commonpackage.ListenersInterface.class)
public class TestClass extends BaseClass {

			public static WebDriver driver;
			public static PageObjectClass pageObjectClass;
			static SoftAssert assertSoft = new SoftAssert();
			public static Logger log;
						
			@BeforeSuite
			public static Logger logger() {
				log = Logger.getLogger("TicketNew");
				PropertyConfigurator.configure("log4j.properties");
				log.setLevel(Level.DEBUG);
				return log;
				
			}
			
		@Test(priority=1)
		public static void titleMethod() throws IOException {
			driver = launchBrowserMethod(readPropertyFile("Browser"));
			pageObjectClass= new PageObjectClass(driver);
			staticWaitMethod(2000);
			log.info("************ Launch Chrome Browser*********");
			maximizeWindowMethod();
			deleteAllCookiesMethod();
			staticWaitMethod(2000);
			getBrowserMethod(readPropertyFile("URL"));
			staticWaitMethod(2000);
			log.info("************ BookMyShow Application launch*********");
			try {
			sendKeysMethod(pageObjectClass.getPlace(),readPropertyFile("Place"));
			staticWaitMethod(2000);
			sendKeysMethod(pageObjectClass.getPlace(), Keys.ENTER);
			} catch(Exception e) {e.printStackTrace();}
			staticWaitMethod(3000);
			System.out.println(driver.getTitle());
			assertSoft.assertEquals(driver.getTitle(), readPropertyFile("Title"));
			assertSoft.assertTrue(isdisplayedMethod(pageObjectClass.getActualLocation()), "Application not selected the User Location");
			log.info("************ Application Title Verify SuccessFully*********");
		}
		@Test(priority=2)
		public static void chooseMovieMethod() throws IOException {
			staticWaitMethod(2000);
			pageObjectClass.setMovieLink(readPropertyFile("MovieName"));
			clickMethod(pageObjectClass.getMovieLink());
			log.info("************User Movie click successfully*********");
			staticWaitMethod(3000);
			assertSoft.assertEquals(getTextMethod(pageObjectClass.getSelectedMovie()),readPropertyFile("MovieName"), "User Movie is not Clicked");
			log.info("************User Movie verified*********");
		}
		
		@Test(priority=3)
		public static void bookTicketMethod() {
			staticWaitMethod(3000);
			isdisplayedMethod(pageObjectClass.getBookTicketButton());
			staticWaitMethod(2000);
			clickMethod(pageObjectClass.getBookTicketButton());
			log.info("************Book Tickets Button click successfully*********");
			staticWaitMethod(2000);
			assertSoft.assertTrue(containsMethod(getTextMethod(pageObjectClass.getCinemaName()), readPropertyFile("MovieName")), "cinema Name doen't have the User Selected Movie");
			log.info("************Cinema Name verify Successfully*********");
			assertSoft.assertFalse(isdisplayedMethod(pageObjectClass.getPreviousDateSelection()), "user select the previous date");
			log.info("************ disable previous Date selection*********");
			assertSoft.assertAll();
		}

		@AfterSuite
		public static void teardownMethod() {
			browserQuitMethod();
		}

}

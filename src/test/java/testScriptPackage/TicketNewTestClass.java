package testScriptPackage;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonpackage.BaseClass;
import commonpackage.PageTicketNew;


@Listeners(commonpackage.ListenersInterface.class)

public class TicketNewTestClass  extends BaseClass{
	public static WebDriver driver;
	public static PageTicketNew pageObjectClass;
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
	pageObjectClass= new PageTicketNew(driver);
	staticWaitMethod(2000);
	log.info("************ Launch"+readPropertyFile("Browser")+"Browser*********");
	maximizeWindowMethod();
	deleteAllCookiesMethod();
	staticWaitMethod(2000);
	getBrowserMethod(readPropertyFile("URLTicketNew"));
	staticWaitMethod(2000);
	takesScreenShotMethod();
	log.info("************ TicketNew Application launch*********");
	sendKeysMethod(pageObjectClass.getSearchlocation(), readPropertyFile("Place"));
	staticWaitMethod(2000);
	takesScreenShotMethod();
	clickMethod(pageObjectClass.getMovieCitySelector());
	staticWaitMethod(2000);
	assertSoft.assertEquals(driver.getTitle(), readPropertyFile("TitleTicketNew"));
	log.info("************ Application Title Verify SuccessFully*********");
	
}
@Test(priority=2)
public static void chooseMovieMethod() throws IOException {
	staticWaitMethod(2000);
	pageObjectClass.setMovieLanguage(readPropertyFile("MovieLanguage"));
	clickMethod(pageObjectClass.getMovieLanguage());
	takesScreenShotMethod();
	log.info("************User Movie Language Select successfully*********");
	staticWaitMethod(5000);
//	clickMethod(pageObjectClass.getViewAllButton());
	staticWaitMethod(5000);
	pageObjectClass.setUserMovie(readPropertyFile("MovieName"));
	staticWaitMethod(3000);
	clickMethod(pageObjectClass.getUserMovie());
	staticWaitMethod(3000);
	assertSoft.assertEquals(getTextMethod(pageObjectClass.getSelectedMovie()),readPropertyFile("MovieName"), "User Movie is not Clicked");
	log.info("************User Movie verified*********");
	
}

@Test(priority=3)
public static void MovieTheatreAndTimeMethod() throws Exception {
	staticWaitMethod(2000);
	pageObjectClass.setMovieDate(readPropertyFile("MovieDate"));
	clickMethod(pageObjectClass.getMovieDate());
	takesScreenShotMethod();
	staticWaitMethod(2000);
	log.info("************Movie Date Selected Successfully*********");
	pageObjectClass.setMovieTheatreName(readPropertyFile("MovieTheatreName"));
	pageObjectClass.setMovieTime(readPropertyFile("MovieTime"));
	staticWaitMethod(2000);
	clickMethod(pageObjectClass.getUserMovieTime());
	takesScreenShotMethod();
	staticWaitMethod(2000);
	log.info("************User Movie Theatre and timing selected Successfully*********");
}

@Test(priority=4)
public static void SelectSeatMethod() throws Exception {
	staticWaitMethod(2000);
	pageObjectClass.setMovieSeatRow(readPropertyFile("MovieSeatRow"));
	pageObjectClass.setMovieSeatNumber(readPropertyFile("MovieSeatNumber"));
	staticWaitMethod(2000);
	clickMethod(pageObjectClass.getMovieSeat());
	takesScreenShotMethod();
	staticWaitMethod(2000);
	log.info("************User seat selected Successfully*********");
}

@Test(priority=5)
public static void bookTicketConfirmMethod() throws Exception {
	staticWaitMethod(5000);
	assertSoft.assertTrue(isdisplayedMethod(pageObjectClass.getBookTicketButton()), "Book Ticket button not display");
	assertSoft.assertTrue(isEnabledMethod(pageObjectClass.getBookTicketButton()),"Book Ticket button not Enable");
	log.info("************Book Ticket button display*********");
	staticWaitMethod(2000);
	takesScreenShotMethod();
	log.info("************"+getTextMethod(pageObjectClass.getBookTicketPrice())+"*********");
	log.info("************"+getTextMethod(pageObjectClass.getBookTicketCount())+"*********");
	clickMethod(pageObjectClass.getBookTicketButton());
	staticWaitMethod(5000);
	takesScreenShotMethod();
	assertSoft.assertAll();
}


@AfterSuite
public static void teardownMethod() {
	browserQuitMethod();
}

}

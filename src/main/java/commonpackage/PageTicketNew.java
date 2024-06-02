package commonpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTicketNew {
	
	public static WebDriver driver;
	private String movieName;
	private String movieLanguage;
	private String movieDate;
	private String movieTheatreName;
	private String movieTime;
	private String movieSeatRow;
	private String movieSeatNumber;
	
	public PageTicketNew(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}	
	public WebElement getMovieCity() {
		return MovieCity;
	}
	@FindBy(xpath="//div[contains(@class,'cityDropdown')]")
	private WebElement MovieCity;
	
	
	@FindBy(xpath="//input[contains(@class,'AnimatedSearchBar')]")
	private WebElement searchlocation;

	public WebElement getSearchlocation() {
		return searchlocation;
	}
	@FindBy(xpath="//div[text()='Chennai']/../parent::a")
	private WebElement MovieCitySelector;
	
	public WebElement getMovieCitySelector() {
		return MovieCitySelector;
	}
	public void setMovieLanguage(String value) {
        this.movieLanguage = value;
    }
    public WebElement getMovieLanguage() {
        return driver.findElement(By.xpath("//div[text()='Languages']/parent::div/following-sibling::div[contains(@class,'MSo52')]//label[text()='"+movieLanguage+"']/../input"));
    }	
     
    @FindBy(xpath="//div[contains(@class,'ViewMore')]")
    private WebElement viewAllButton;

	public WebElement getViewAllButton() {
		return viewAllButton;
	}
	
	public void setUserMovie(String value) {
		this.movieName=value;
	}
	public WebElement getUserMovie() {
		return driver.findElement(By.xpath("//div[contains(text(),'"+movieName+"')]/../parent::a"));
	}
	
	@FindBy(xpath="//h2[contains(@class,'movieName')]")
    private WebElement selectedMovie;
    
    public WebElement getSelectedMovie() {
    	return selectedMovie;
    }
    
    public void setMovieDate(String value) {
    	this.movieDate= value;
    }
    
    public WebElement getMovieDate() {
    	 return driver.findElement(By.xpath("//div[contains(@class,'datesMonthWrap')]/a[contains(@href,'"+movieDate+"')]"));
    }
    
    public void setMovieTheatreName(String value) {
    	this.movieTheatreName= value;
    }
    public void setMovieTime(String value) {
    	this.movieTime=value;
    }
    public WebElement getUserMovieTime() {
    	return driver.findElement(By.xpath("//a[contains(text(),'"+movieTheatreName+"')]/parent::div/../following-sibling::div/div/div[contains(text(),'"+movieTime+"')]"));
    }
    
    public void setMovieSeatRow(String value) {
    	this.movieSeatRow=value;
    }
    
    public void setMovieSeatNumber(String value) {
    	this.movieSeatNumber=value;
    }
    
    public WebElement getMovieSeat() {
    	return driver.findElement(By.xpath("//div[contains(@class,'rightRow')]/ul/li/div[text()='"+movieSeatRow+"']/following-sibling::div//span[text()='"+movieSeatNumber+"']/parent::div"));
    }
    
    @FindBy(xpath="//button[contains(@class,'bookTicket')]")
    private WebElement bookTicketButton;

	public WebElement getBookTicketButton() {
		return bookTicketButton;
	}
	
	@FindBy(xpath="//div[contains(@class,'ticketPrice')]")
	private WebElement bookTicketPrice;

	public WebElement getBookTicketPrice() {
		return bookTicketPrice;
	}
	
	@FindBy(xpath="//div[contains(@class,'ticketCount')]")
	private WebElement bookTicketCount;

	public WebElement getBookTicketCount() {
		return bookTicketCount;
	}
    
    
}

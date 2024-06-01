package commonpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
	public static WebDriver driver;
	private String movieName;
	
	public PageObjectClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(xpath="//div[text()='Detect my location']")
	private WebElement detectMyLocation;

	public WebElement getDetectMyLocation() {
		return detectMyLocation;
	}
	
	@FindBy(xpath="//input[contains(@placeholder,'city')]")
	private WebElement place;

	public WebElement getPlace() {
		return place;
	}
	
	@FindBy(xpath="//span[contains(@Class,'ellipsis')]")
	private WebElement actualLocation;

	public WebElement getActualLocation() {
		return actualLocation;
	}
	public void setMovieLink(String value) {
        this.movieName = value;
    }
    public WebElement getMovieLink() {
        return driver.findElement(By.xpath("//div[text()='"+movieName+"']"));
    }	
    
    @FindBy(xpath="//h1[contains(@class,'jevoyi')]")
    private WebElement selectedMovie;
    
    public WebElement getSelectedMovie() {
    	return selectedMovie;
    }
    
    @FindBy(xpath="//span[text()='Book tickets']/parent::div/parent::button")
    private WebElement bookTicketButton;

	public WebElement getBookTicketButton() {
		return bookTicketButton;
	}
	
	@FindBy(xpath="//div[contains(@class,'cinema-name')]/a")
	private WebElement cinemaName;

	public WebElement getCinemaName() {
		return cinemaName;
	}
	
	@FindBy(xpath="//button[contains(@class,'prev')]")
	private WebElement previousDateSelection;

	public WebElement getPreviousDateSelection() {
		return previousDateSelection;
	}
	
}

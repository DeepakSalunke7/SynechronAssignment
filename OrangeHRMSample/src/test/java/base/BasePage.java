package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

//	public BasePage() {
//		PageFactory.initElements(DriverContext.Driver, this);
//	}

	 public <TPage extends BasePage> TPage As(Class<TPage> pageInstance)
	    {
	        try
	        {
	            return (TPage)this;
	        }
	        catch (Exception e)
	        {
	            e.getStackTrace();
	        }

	        return null;
	    }
}

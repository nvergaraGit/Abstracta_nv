package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Inicio {

    WebDriver driver;

    public Inicio(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //General

    public WebDriver getDriver() {
        return driver;
    }

    //paso 1

    @FindBy(how = How.XPATH, using = "//input[@class='nav-search-input']")
    private WebElement labeltexto;

    public WebElement getlabeltexto() {
        return labeltexto;
    }


    @FindBy(how = How.XPATH, using = "html/body/header/div/form/button")
    private WebElement botonbuscar;

    public void clickbotonbuscar() {
        botonbuscar.click();
    }

    public void cierre() {
        driver.close();
        driver.quit();
    }
}


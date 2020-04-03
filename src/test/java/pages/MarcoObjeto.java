package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MarcoObjeto {


  public void enmarcarObjeto(WebDriver driver, WebElement element) throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    for (int i = 0; i < 3; i++) {
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
          "border: 4px solid green;");
      Thread.sleep(2500);
    }
  }


  public void desenmarcarObjeto(WebDriver driver, WebElement element) throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    for (int i = 0; i < 3; i++) {
      Thread.sleep(2500);
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

          element, "");
    }
  }
}

package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class WebdriverBase {
    public static WebdriverBase instance;
    private static WebDriver driver;

    private WebdriverBase() {

    }

    public static WebdriverBase getInstance(String browser) {
        if (driver == null) {
            switch (browser) {
                case ("chrome"): {
                    driver = new ChromeDriver();
                    break;
                }
                case ("edge"): {
                    driver = new EdgeDriver();
                    break;
                }
                default:
                    throw new IllegalArgumentException("unsupported browser passed " + browser);
            }
        }
        return instance;
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void quit() {
        if(driver != null){
            driver.quit();
            driver=null;
        }

    }

}
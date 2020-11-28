package userDefinedLibraries;
/**
 * This class is defined in order to setup different Webdrivers.
 * 
 * @author BINARYBEASTS
 * @since 2020/11/27
 * 
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String exePath;
	public static String url = "https://www.urbanladder.com/";
	public static String browsertype;

	public static WebDriver driverInstantiate(String browser) {

		// Declaration and instantiation of objects/variables
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("opera")) {

			
			DesiredCapabilities cap = DesiredCapabilities.operaBlink();
			cap.setBrowserName("operablink");
			cap.setPlatform(Platform.ANY);
			// Here you can use hub address, hub will take the responsibility to
			// execute the test on respective node
		
			// Create driver with hub address and capability
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.100:5555/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browsertype.equalsIgnoreCase("chrome")) {

			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");

			cap.setPlatform(Platform.ANY);
			// Here you can use hub address, hub will take the responsibility to
			// execute the test on respective node
			// Create driver with hub address and capability
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.100:5555/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Launch browsers and direct it to the Base URL
		driver.get(url);
		driver.manage().deleteAllCookies();
		return driver;
	}

	public static void driverClose() {

		DriverSetup.driver.close();

	}
}

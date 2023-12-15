package MobileAutomationBatch.MobileAutomation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class LaunchApplication 
{
	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		File app =new File("C:\\Users\\Sweety Shah\\Downloads","ApiDemo.apk");	
		
		 File js = new File("C:\\Users\\Sweety Shah\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		  AppiumDriverLocalService service =
		  new AppiumServiceBuilder()
		  .withAppiumJS(js)
		  .withIPAddress("0.0.0.0")
		  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		  .usingPort(4723)
		  .build();
		  service.start();

		
		  DesiredCapabilities cap = new DesiredCapabilities();
		 
		  Thread.sleep(2000);
		  cap.setCapability("app", app.getAbsolutePath());
		  cap.setCapability("deviceName", "emulator-5554");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("automationName","UiAutomator2");
		  
		  
		  Thread.sleep(2000);
		  AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		  driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='4. Default values']")).click();
		  
	

	
	}
	
}

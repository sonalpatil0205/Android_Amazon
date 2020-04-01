import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class amazon_TestCases {

	static AndroidDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capability=new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
		  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  capability.setCapability(MobileCapabilityType.DEVICE_NAME, "SGH");
		  capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		  capability.setCapability(MobileCapabilityType.UDID, "f13f15b4");

		  capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.mShop.android.shopping");
		  capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
		 capability.setCapability("adbExecTimeout", 2000000);
		 capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000000);
		 capability.setCapability("showChromedriverLog", true);
		  capability.setCapability("noReset", true);
		 capability.setCapability("unicodekeyboard", true);
		  capability.setCapability("uiautomator2ServerInstallTimeout",2000000);
		  
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capability);
			
			System.out.println("Amazon app launched");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			//TC_01_Login();
			//TC_02_Signout();
			TC_03_CheckItemAdded();
	}
			
			

			public static void TC_01_Login() {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
			MobileElement signin=(MobileElement) driver.findElement(By.id("com.amazon.mShop.android.shopping:id/sign_in_button"));
			signin.click();
			System.out.println("clicked signin");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			MobileElement email = (MobileElement) driver.findElementByXPath("//android.webkit.WebView[@content-desc=\"Amazon Sign-In\"]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");
			email.click();
			email.sendKeys("sonu1002@gmail.com");
			System.out.println("entered email id");
			
			MobileElement contin=(MobileElement) driver.findElementByAccessibilityId("Continue");
			contin.click();
			
			MobileElement password = (MobileElement) driver.findElementByXPath("//android.webkit.WebView[@content-desc=\"Amazon Sign-In\"]/android.view.View/android.view.View[5]/android.view.View[2]/android.widget.EditText");
			password.click();
			password.sendKeys("Maythis@12");
			System.out.println("entered password");
			
			MobileElement signIn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Sign-In\"]");
			signIn.click();
			System.out.println("signin into amazon app");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			}
			
			public static void TC_02_Signout() {
				MobileElement menu=(MobileElement) driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon"));
				menu.click();
				System.out.println("clicked on menu");
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				MobileElement scrollToSetting=(MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.amazon.mShop.android.shopping:id/gno_drawer_list\"))"
						+ ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\").text(\"Settings\"))");
						scrollToSetting.click();
				System.out.println("click on setting");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				MobileElement scrollToSignout=(MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.amazon.mShop.android.shopping:id/gno_second_level_header\"))"
						+ ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\").text(\"Not sonal? Sign out\"))");
						scrollToSignout.click();
				
				System.out.println("clicked on signout");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				MobileElement confirmSignout=(MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/button2\")");
				confirmSignout.click();
				System.out.println("clicked on confirm signout");
				
			}
			
			public static void TC_03_CheckItemAdded() throws InterruptedException { 
				MobileElement searchTxtBox = driver.findElementByAndroidUIAutomator(
						"new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\").className(\"android.widget.EditText\")");
				searchTxtBox.click();
				searchTxtBox.sendKeys("mouse");
				driver.pressKeyCode(AndroidKeyCode.ENTER);
				Thread.sleep(3000);
				// /descendant::android.view.View[7]
				driver.findElementByAndroidUIAutomator(
						"new UiSelector().resourceId(\"search\").className(\"android.view.View\")").click();
				Thread.sleep(3000);
//				 driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()"
//				 + ".className(\"android.view.View\"))"
//				 + ".scrollIntoView(UiSelector().textContains(\"Add to Cart\")").click();;

				
				  TouchAction swipe; swipe = new TouchAction(driver); swipe.press(250,
				  650).waitAction(1000).moveTo(250, 200).release().perform(); swipe = new
				  TouchAction(driver); swipe.press(250, 650).waitAction(800).moveTo(250,
				  200).release().perform(); Thread.sleep(3000); MobileElement addtoCartBtn =
				  driver.findElementByAndroidUIAutomator(
				  "new UiSelector().resourceId(\"add-to-cart-button\").className(\"android.widget.Button\")"
				  ); addtoCartBtn.click();
				 
				Thread.sleep(500);
				addtoCartBtn.click();
				// driver.findElementByXPath("//android.view.View[@resourceId='search']").click();
				Thread.sleep(4000);
				MobileElement searchIcon = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]"));
				// driver.findElementByAndroidUIAutomator(
				// "new
				// UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/action_bar_search_icon\")");

				searchIcon.click();
				MobileElement searchBox = driver.findElementByAndroidUIAutomator(
						"new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\").className(\"android.widget.EditText\")");
				searchBox.clear();
				searchBox.sendKeys("keyboard");
				driver.pressKeyCode(AndroidKeyCode.ENTER);
//				driver.findElementByAndroidUIAutomator(
//						"new UiSelector().resourceId(\"search\").className(\"android.view.View\")").click();
				
				  swipe = new TouchAction(driver); swipe.press(250,
				  650).waitAction(1000).moveTo(250, 200).release().perform(); swipe = new
				  TouchAction(driver); swipe.press(250, 650).waitAction(800).moveTo(250,
				  200).release().perform(); Thread.sleep(3000); MobileElement
				  addtoCartBtnforKeyboard = driver.findElementByAndroidUIAutomator(
				  "new UiSelector().resourceId(\"add-to-cart-button\").className(\"android.widget.Button\")"
				  ); addtoCartBtnforKeyboard.click(); Thread.sleep(500);
				  addtoCartBtnforKeyboard.click();
				 
				Thread.sleep(3000);
				driver.findElementByAndroidUIAutomator("new UiScrollable( UiSelector()"
						 + ".className(\"android.view.View\"))"
						 + ".scrollIntoView( UiSelector().textContains(\"Add to Cart\")").click();;
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Cart\"]")).click();
				Thread.sleep(3000);
				// SCREENSHOT
						// File sourceFile=driver.getScreenshotAs(OutputType.FILE);
						 //FileUtils.copyFile(sourceFile, new
						 //File("/Users/kalpeshpatel/Documents/Assignments/cart.png"));
				//

			}
			

			
			
			}


	



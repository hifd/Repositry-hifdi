package ProBook;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;



public class LoginTest {
	
	  String url = "http://probook.progideo.com";
	  String expectedTitle1 = "Fil d'actualités - ProBook";
      String actualTitle1 = null;
      String actualTitle2 = null;
      String expectedTitle2 = "(6) Fil d'actualités - ProBook";
	  String username = "taoufik.hifdi";
	  String password = "19757575";
	  String spaceName = "formation";
	  WebDriver driver;
	  
	  @Test	  
	  public void f() throws InterruptedException {
		  // On clique sur le lien "Se connecter / s'inscrire".
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("Se connecter / s'inscrire")).click();
	      // On récupère le titre de la page actuelle
	      actualTitle1 = driver.getTitle();
	      // On affiche dans le log un message d'information
	      
	      System.out.println("Login page title : expected value is "+expectedTitle1+" actual value is "+actualTitle1);
	      // Si le test échoue, on affiche un message d'erreur
	      
	      
	      if (!actualTitle1.contentEquals(expectedTitle1)) {
	          System.out.println("Test Failed");
	      }
	      // On saisit le username et le password
	      driver.findElement(By.id("login_username")).sendKeys(username);
	      driver.findElement(By.id("login_password")).sendKeys(password);
	      // On clique sur le bouton "Sign in"
	      driver.findElement(By.id("loginBtn")).click();
	      
	      // On vérifie le titre de la page suite à la tentative de connexion
	      actualTitle2 = driver.getTitle();
	      // On affiche dans le log un message d'information
	      System.out.println("Login result : expected value is "+expectedTitle2+" actual value is "+actualTitle2);
	      // Si le test échoue, on affiche un message d'erreur 
	      if (!actualTitle2.contentEquals(expectedTitle2)) {
	          System.out.println("Test Failed");
	      }

	  }
	  
	  @BeforeMethod
	  public void beforeMethod() { 
			//System.setProperty("webdriver.ie.driver","C:\\Users\\A632353\\eclipse\\IEDriver\\IEDriverServer.exe");
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\A632353\\eclipse\\Driverks\\geckodriver.exe");
			//driver = new InternetExplorerDriver ();
		    driver = new FirefoxDriver ();
			driver.get(url);
	  }


	  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
}

package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Excel;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Wd {
    protected static final String CUR_DIR = System.getProperty("user.dir");
    // protected static final String DIR_DOWNLOAD = System.getProperty("user.home", "C:") +
    // File.separator + "Downloads" + File.separator;
    public final static String BROWSER = System.getProperty("BROWSER", "chrome");
    // public static final String WEB_SERVER =
    // System.getProperty("WEB_SERVER","http://enterprise.demo.orangehrmlive.com/auth/login");
    public static WebDriver driver;
    public static WebDriver driver1;
    // String tempDriver = BROWSER;

    private static long timeout = 60;

    public static WebDriver setupDriver() {

        try {
            if (BROWSER.equals("firefox")) {
                WebDriver driver = null;
                String path1 = CUR_DIR + "\\Drivers\\firefox\\geckodriver.exe";
                System.setProperty("webdriver.firefox.driver", path1);

                ProfilesIni allProfiles = new ProfilesIni();
                FirefoxProfile Profile = allProfiles.getProfile("default");
                Profile.setAcceptUntrustedCertificates(true);
                Profile.setAssumeUntrustedCertificateIssuer(false);
                driver = new FirefoxDriver(Profile);
                return driver;

            } else if (BROWSER.equals("chrome")) {
                WebDriver driver = null;
                String path2 = CUR_DIR + "\\Drivers\\Chrome\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", path2);
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver = new ChromeDriver(cap);
                return driver;
            } else if (BROWSER.equals("internetExplorer")) {
                WebDriver driver = null;
                String path3 = CUR_DIR + "\\Drivers\\IE\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", path3);
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(
                        InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability("requireWindowFocus", true);
                capabilities.setCapability(CapabilityType.ENABLE_PROFILING_CAPABILITY, true);
                capabilities.setCapability("ignoreZoomSetting", true);
                driver = new InternetExplorerDriver(capabilities);
                return driver;
            } else if (BROWSER.equals("mobile")) {
                WebDriver driver = null;
                String path4 = CUR_DIR + "\\Drivers\\Chrome\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", path4);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                Map<String, String> mobileEmulation = new HashMap<String, String>();
                mobileEmulation.put("deviceName", "LG Optimus L70");

                // deviceName = "LG Optimus L70";
                // deviceName = "Google Nexus 5";
                // deviceName = "Samsung Galaxy S4";
                // deviceName = "Samsung Galaxy Note 3";
                // deviceName = "Samsung Galaxy Note II";
                // deviceName = "Apple iPhone 4";
                // deviceName = "Apple iPhone 5";
                // deviceName = "Apple iPhone 6";
                // deviceName = "Apple iPad 3 / 4";

                // deviceName = "Apple iPhone 6 Plus";

                // deviceName = "Samsung Galaxy S4";
                // deviceName = "Samsung Galaxy Note II";
                // deviceName = "Samsung Galaxy Note II";

                // deviceName = "Google Nexus 5";
                // deviceName = "Google Nexus 6";


                Map<String, Object> mobileOptions = new HashMap<String, Object>();
                mobileOptions.put("mobileEmulation", mobileEmulation);

                mobileOptions.put("args", Arrays.asList("disable-extensions", "test-type",
                        "no-default-browser-check", "ignore-certificate-errors"));

                capabilities.setCapability(ChromeOptions.CAPABILITY, mobileOptions);
                driver = new ChromeDriver(capabilities);
                return driver;

            } else if (BROWSER.equals("Edge")) {
                WebDriver driver = null;
                String path5 = CUR_DIR + "\\Drivers\\Edge\\MicrosoftWebDriver.exe";
                System.setProperty("webdriver.edge.driver", path5);
                DesiredCapabilities capability = DesiredCapabilities.edge();
                capability.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                capability.setBrowserName("MicrosoftEdge");
                capability.setPlatform(Platform.WIN10);
                capability.setJavascriptEnabled(false);
                capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

                driver = new EdgeDriver(capability);

                return driver;
            } else {
                System.out.println("Tipo de Browser No Soportado");
            }
        } catch (Exception ex) {
            System.out.println("Error al ejecutar el Driver: " + ex.toString());
        }
        return null;
    }

    public static void takeScreenShotTest(WebDriver driver, String imageName) {
        String curDir = System.getProperty("user.dir");
        File directory = new File(curDir + "/imagenes/" + BROWSER);
        // File directory = new File( curDir +"/imagenes/");
        // File directory = new File("c:\\imagenes\\firefox");
        try {
            if (directory.isDirectory()) {
                // Toma la captura de imagen
                File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                // Mueve el archivo a la carga especificada con el respectivo
                // nombre
                FileUtils.copyFile(imagen,
                        new File(directory.getAbsolutePath() + "\\" + imageName + ".png"));
            } else {
                // Se lanza la excepcion cuando no encuentre el directorio
                throw new IOException("ERROR : La ruta especificada no es un directorio!");
            }
        } catch (IOException e) {
            // Impresion de Excepciones
            e.printStackTrace();
        }
    }

    //
    public static List<List<String>> leerArchivo(String nomArchivo, int hoja) throws IOException {

        List<List<String>> datosExcel = new ArrayList<List<String>>();
        datosExcel = Excel.getDatosHojaExcel(nomArchivo, hoja);

        return datosExcel;

    }

}


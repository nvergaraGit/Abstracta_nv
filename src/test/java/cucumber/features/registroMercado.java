package cucumber.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Inicio;
import pages.Login;
import pages.Wd;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

// import util.DriverNavegador;
// import util.DriverNavegador;
// import pages.HeaderPage;
// import pages.HeaderPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class registroMercado {

    Login loginObject = new Login();

    Inicio inicioPage = new Inicio(driver);

    static WebDriver driver = Wd.setupDriver();
//  WebDriverWait wait = new WebDriverWait(driver, 50);

    static List<List<String>> excelArchivoUser;

    static DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    Date date = new Date();
    String date1 = dateFormat.format(date);

    public registroMercado() throws Throwable {

        if (Wd.BROWSER != "chrome") {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        excelArchivoUser = Wd.leerArchivo("users.xls", 0);
    }

    @Given("^Listar autos y links$")
    public void listar_autos_y_links() {
        driver.get(loginObject.HOME);
        driver.manage().window().maximize();
    }

    @When("^Ingreso a Mercadolibre$")
    public void ingreso_a_Mercadolibre() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(inicioPage.getlabeltexto()));
    }

    @Then("^Home se abre correctamente$")
    public void home_se_abre_correctamente() {
        System.out.println("Ingreso OK");
    }

    @When("^Se ingresa palabra de busqueda$")
    public void se_ingresa_palabra_de_busqueda() {
        inicioPage.getlabeltexto().click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inicioPage.getlabeltexto().sendKeys("autos");
    }

    @Then("^entrega resultado en pantalla y archivo de texto$")
    public void entrega_resultado_en_pantalla_y_archivo_de_texto() {
        inicioPage.clickbotonbuscar();

        try {

            //se abre la conexiòn
            URL url = new URL("https://listado.mercadolibre.cl/autos#D[A:autos]");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            //Lectura
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];
            //Seek
            int leido;
            String texto = "";
            while ((leido = br.read(buffer)) > 0) {
                String datos = new String(buffer, 0, leido);
                texto += datos;
            }
            String[] tr = texto.split("<tr");
            String fila = "";
            for (String linea : tr) {
                if (linea.contains("MCL-")) {
                    fila = linea;
                }
            }
            String[] td = fila.split("<td");
            String columna = "";
            for (String linea : td) {
                if (linea.contains(",00")) {
                    System.out.println("---> " + linea);
                    int pos1 = 0;
                    int pos2 = 0;
                    String cotizacion = "";
                    for (int i = 0; i < linea.length(); i++) {
                        if (linea.substring(i, i + 1).equals(">")) {
                            pos1 = i;
                        } else if (linea.substring(i, i + 1).equals("<")) {
                            pos2 = i;
                            break;
                        }
                    }
                    System.out.println("---> " + linea.substring(pos1 + 1, pos2));
                }
            }
            //FIN DE LA CONDICION

        } catch (MalformedURLException ex) {
            Logger.getLogger(registroMercado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(registroMercado.class.getName()).log(Level.SEVERE, null, ex);
        }


        System.out.println("Fin OK");
        inicioPage.cierre();
    }

}


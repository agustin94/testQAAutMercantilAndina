package seleniumgluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static java.lang.Thread.sleep;


public class Cotizacion extends TestBase {
    public WebElement findElement(By locator){
        return  driver.findElement(locator);
    }

    @Given("^el usuario se encuentra en la página home de Mercantil Andina$")
    public void el_usuario_se_encuentra_en_la_página_home_de_MercantilAndina() throws Throwable {
        Assert.assertEquals(elementsPage.getTitleHomePage(),driver.getTitle());
    }

    @Given("^Se hace click en 'Personas', 'Seguros' y 'Hogar'$")
    public void dirigirse_a_cotizacion_hogar() throws Throwable {
        driver.findElement(elementsPage.getpersonasElement()).click();
        driver.findElement(elementsPage.getsegurosElement()).click();
        driver.findElement(elementsPage.gethogarElement()).click();

    }

    @Given("^Presionamos el boton para ir al formulario de cotizacion$")
    public void presionar_boton_cotizar() throws Throwable {
        driver.findElement(elementsPage.getcotizarElement()).click();
    }

    @And("^Llenamos el formulario$")
    public void llenamos_el_formulario() throws Throwable {


        WebElement inputDeNombre = driver.findElement(elementsPage.getInputname());
        inputDeNombre.clear();
        inputDeNombre.sendKeys(elementsPage.getNameAdress());

        WebElement inputDeTelefono = driver.findElement(elementsPage.getInputTel());
        inputDeTelefono.clear();
        inputDeTelefono.sendKeys(elementsPage.getTelefono());

        WebElement inputDeMail = driver.findElement(elementsPage.getInputEmail());
        inputDeMail.clear();
        inputDeMail.sendKeys(elementsPage.getEmail());

        Select vivienda = new Select(findElement(elementsPage.getselectVivienda()));
        vivienda.selectByValue("casa");

        Select superficie = new Select(findElement(elementsPage.getselectSuperficie()));
        superficie.selectByValue("a");

        Select ubicacion = new Select(findElement(elementsPage.getselectUbicacion()));
        ubicacion.selectByValue("1");

        driver.findElement(elementsPage.getsubmitCotizador()).click();
    }

    @And("^Se debe verificar 'Seguro de hogar - Mercantil andina' en su title$")
    public void se_debe_verificar_title() throws Throwable {
        Boolean flag = true;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(elementsPage.getWaitElement())));
        WebElement tablaCotizacion = driver.findElement(elementsPage.getTablaCotizacion());
        List<WebElement> elementsTitle = tablaCotizacion.findElements(By.tagName(elementsPage.getTitleAndina()));

        for(WebElement i : elementsTitle){
            String articleTitle = i.getText();
                if(!articleTitle.contains("Seguro de hogar - Mercantil andina")){
                    flag = false;
                }
        }
        Assert.assertTrue("No se encuentra 'Seguro de hogar - Mercantil andina' en el titulo de todos los elementos",flag);
    }

   @And("^Validar que el costo mensual sea un valor positivo$")
    public void Validar_costo_mensual_sea_positivo() throws Throwable {
        Boolean numeroNegativo = false;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(elementsPage.getWaitElement())));
       Thread.sleep(5000);
       WebElement costoMensual = driver.findElement(elementsPage.getCostoMensual());
        String getTextCosto = costoMensual.getText();
        String[] costoArray = getTextCosto.split(" ");
        int costo = Integer.parseInt(costoArray[1]);
        if(costo < 0){
               numeroNegativo = true;
        }
        Assert.assertFalse("No hay la misma cantidad de elementos",numeroNegativo);
    }

    @And("^Validar que el costo mensual sea mayor a 0$")
    public void Validar_costo_mensual_sea_mayor_cero() throws Throwable {
        int cero = 0;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(elementsPage.getWaitElement())));
        WebElement costoMensual = driver.findElement(elementsPage.getCostoMensual());
        String getTextCosto = costoMensual.getText();
        String[] costoArray = getTextCosto.split(" ");
        int costo = Integer.parseInt(costoArray[1]);
        Assert.assertNotEquals("El costo no es mayor a 0",costo,cero);
    }

    @And("^Validar que el costo mensual sea un entero$")
    public void Validar_costo_mensual_sea_entero() throws Throwable {
        Boolean numeroEntero = true;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(elementsPage.getWaitElement())));
        WebElement costoMensual = driver.findElement(elementsPage.getCostoMensual());
        String getTextCosto = costoMensual.getText();
        String[] costoArray = getTextCosto.split(" ");
        String costoEntero = costoArray[1];
        int costo = Integer.parseInt(costoArray[1]);
        if (costo == (int)costo)
          {
              numeroEntero = false;
          }
        Assert.assertFalse("No es un numero entero",numeroEntero);
    }


    @And("^Validar que se visualice chat online$")
    public void Validar_visualizacion_chat_online() throws Throwable {
        boolean iconVisible = true;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(elementsPage.getWaitElement())));
        WebElement iconChatOnline = driver.findElement(elementsPage.getIconChatOnline());
        boolean iconEnable = iconChatOnline.isEnabled();
        if (iconEnable){
            iconVisible = false;
        }
        Assert.assertFalse("No se visualiza chat Online",iconVisible);
    }

}

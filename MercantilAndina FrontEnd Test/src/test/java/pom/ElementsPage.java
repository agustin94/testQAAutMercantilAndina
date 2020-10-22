package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ElementsPage {

    private String titleHomePage = "Encontrá tus seguros online - Mercantil andina";
    private By personasElement = By.id("menu-item-19524");
    private By segurosElement = By.cssSelector("#menu-item-19525 > a");
    private By hogarElement = By.cssSelector("#menu-item-21317 > a");
    private By cotizarElement = By.xpath("//main[@id='main']/div/div/div[3]/a");
    private By Inputname = By.id("inputName");
    private By InputTel = By.id("inputTel");
    private By InputEmail = By.id("inputemail");
    private By selectVivienda = By.id("tipovivienda");
    private By selectSuperficie = By.id("superficie");
    private By selectUbicacion = By.id("ubicacion");
    private By submitCotizador = By.id("cotizador-submit");
    private String NameAdress = "Agustin Moreno";
    private String Telefono = "110303456";
    private String email = "agustin.moreno94@gmail.com";
    private By tablaCotizacion = By.cssSelector("#cotizador-result > div");
    private String titleAndina = "td";
    private By CostoMensual = By.id("costo");
    private By iconChatOnline = By.id("iconChat");
    private String waitElement = "#cotizador-result";

    public By getpersonasElement() {
        return personasElement;
    }

    public By getsegurosElement() {
        return segurosElement;
    }

    public By gethogarElement() {
        return hogarElement;
    }

    public By getcotizarElement() {
        return cotizarElement;
    }

    public By getInputname() {
        return Inputname;
    }

    public By getInputTel() {
        return InputTel;
    }

    public By getInputEmail() {
        return InputEmail;
    }

    public By getselectVivienda() {
        return selectVivienda;
    }

    public By getselectSuperficie() {
        return selectSuperficie;
    }

    public By getselectUbicacion() {
        return selectUbicacion;
    }

    public By getsubmitCotizador() {
        return submitCotizador;
    }

    public String getNameAdress () {return NameAdress;}

    public String getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return email;
    }

    public By getTablaCotizacion() { return tablaCotizacion; }

    public String getTitleAndina() { return titleAndina; }


    public String getTitleHomePage() {return titleHomePage; }

    public By getCostoMensual() {return CostoMensual;}

    public By getIconChatOnline() {return iconChatOnline;}

    public String getWaitElement(){return waitElement;}



}

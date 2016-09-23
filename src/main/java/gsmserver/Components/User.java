package gsmserver.Components;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class User {

    private SelenideElement firstName = $("[name*='firstName']");
    private SelenideElement lastName = $("[name*='lastName']");
    private SelenideElement middleName = $("[name*='middleName']");
    private SelenideElement email = $("[name*='email']");
    private SelenideElement customCountry = $("#country_id_chosen");
    private SelenideElement customRegion = $("#state_id_chosen");
    private SelenideElement customCity = $("#city_id_chosen");
    private SelenideElement inputCity = $("#city");
    private SelenideElement address = $("[name*='[address]']"); //because of element have name = "address[address]"
    private SelenideElement phoneCountries = $("a.styled-phone-dropdown-button");
    private SelenideElement phoneNumber = $("div.styled-phone-edit > input");
    private SelenideElement zip = $("[name*='zip'");
    private SelenideElement taxId = $("[name*='taxId']");

    @Step public User fillFirstName(final String value){
        this.firstName.setValue(value);
        return this;
    }

    @Step public User fillLastName(final String value) {
        this.lastName.setValue(value);
        return this;
    }

    @Step public User fillMiddleName(final String value) {
        this.middleName.setValue(value);
        return this;
    }

    @Step public User fillEmail(final String value) {
        this.email.setValue(value);
        return this;
    }

    @Step public User fillAddress(final String value) {
        this.address.setValue(value);
        return this;
    }


    @Step public User fillPhoneByCountry(final String country, final String phone){
        this.phoneCountries.click();
        $(String.format("b[data-hint='%s']", country)).scrollTo().click();
        this.phoneNumber.setValue(phone);
        return this;
    }

    @Step public User chooseCountry(final String value){
        $("h1").scrollTo();
        this.customCountry.click();
        this.selectItem(value);
        return this;
    }

    @Step public User chooseRegion(final String value){
        $("h1").scrollTo();
        this.customRegion.click();
        this.selectItem(value);
        return this;
    }

    @Step public User chooseCity(final String value){
        $("h1").scrollTo();
        this.customCity.click();
        this.selectItem(value);
        return this;
    }

    @Step public User fillCity(final String value){
        this.inputCity.setValue(value);
        return this;
    }

    private void selectItem(String nameOfItem){
        $(byXpath(String.format("//li//span[.='%s']", nameOfItem))).scrollTo().click();
    }

}

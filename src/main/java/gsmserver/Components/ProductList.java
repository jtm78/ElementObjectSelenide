package gsmserver.Components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductList {

    private String searchedPhrase;

    private ProductList(){}

    ProductList(String searchedPhrase){
        this.searchedPhrase = searchedPhrase;
    }

    private final SelenideElement searchTitle = $(".search-title-highlight");

    @Step
    public ProductList openProductListPage(){
        open("/gsm/boxes-and-dongles/");
        return new ProductList();
    }

    /**
     * Search result page should have searched phrase in a title
     */
    @Step
    public ProductList searchResultShouldHasSearchedPhrase(){
        searchTitle.shouldHave(Condition.text(searchedPhrase));
        return this;
    }

    @Step
    public void shouldHaveProduct(int id){
        Product.findProduct(id, "li").shouldBe(Condition.visible);
    }

    @Step
    public void shouldNotHaveProduct(int id){
        Product.findProduct(id, "li").shouldNotBe(Condition.visible);
    }

}

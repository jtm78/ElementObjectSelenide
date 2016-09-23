package gsmserver.Components;

import com.codeborne.selenide.Condition;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.open;

public class Cart {

    private String productArg;

    private Cart(){
    }

    public Cart(String productArg){
        this.productArg = productArg;
    }

    @Step
    public static Cart openCartPage(){
        open("cart/");
        return new Cart();
    }

    /**
     * Find product in table by product id
     * @param id
     * id of product (Example: 856333)
     */
    @Step
    public void cartShouldHaveProduct(Integer id){
        ProductWrapper.findProduct(id, "tr").shouldBe(Condition.visible);
    }

}

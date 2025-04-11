package get_order_list;


import io.qameta.allure.Step;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.instanceOf;


public class GetOrderListTest {

    @Step("Тело ответа возвращается список заказов")
    @Test
    public void answerHaveListOrder() {
        CurlForGetOrderList URL = new CurlForGetOrderList();
        given()
                .contentType("application/json")
                .when()
                .get(URL.getURL())
                .then()
                .body("orders", instanceOf(List.class));
    }
}

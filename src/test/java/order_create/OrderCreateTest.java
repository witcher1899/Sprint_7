package order_create;


import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class OrderCreateTest {

    @Step("Создание заказа с разным набором цветов (включая отсутствие цветов)\n" +
    "Тело ответа содержит track")
    @ParameterizedTest
    @CsvSource (value = {
            "'GREY', 'BLACK'",
            "'GREY', 'null'",
            "'null', 'BLACK'",
            "'null', 'null'"
    },
            nullValues = {"null"})
    public void orderCreateWithColourSet(String firstColour, String secondColour) {
        ArrayList<String> color = new ArrayList<>();
        if (firstColour != null) {
            color.add(firstColour);
        } if (secondColour != null) {
            color.add(secondColour);
        }

        CurlForOrderCreate URL = new CurlForOrderCreate();
        RequestOrderCreate request = new RequestOrderCreate("igor", "ishchenko", "Konoha, 142 apt.",
                "Lubanka", "89995692346", 5, "2020-06-06", "test", color);

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(request)
                .when()
                .post(URL.getEndpoint())
                .then()
                .statusCode(201)
                .body("track", anyOf(instanceOf(Integer.class), instanceOf(Long.class)));
    }
}

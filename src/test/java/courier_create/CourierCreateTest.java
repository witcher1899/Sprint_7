package courier_create;


import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CourierCreateTest {

    @Step("Создание курьера при всех обязательных полях\n" +
            "Проверка, что код ответа возвращает 201")
    @Test
    public void statusCode200ByCreatingCourier() {
        CurlForCourierCreate curlForCourierCreate = new CurlForCourierCreate();
        RequestCourierCreate requestForCourierCreate = new RequestCourierCreate("witcher18991996", "12345", "igor");

        given()
                .baseUri(curlForCourierCreate.getURL())
                .contentType("application/json")
                .body(requestForCourierCreate)
                .when()
                .post(curlForCourierCreate.getEndpoint())
                .then()
                .log().all()
                .statusCode(201);

        given()
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .delete("/api/v1/courier/1996");
    }


    @Step("Успешный запрос возвращает ok: true")
    @Test
    public void validAnswerByCreatingCourier() {
        CurlForCourierCreate URL = new CurlForCourierCreate();
        RequestCourierCreate request = new RequestCourierCreate("witcher1900", "12345", "igor");

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(request)
                .when()
                .post(URL.getEndpoint())
                .then()
                .body("ok", equalTo(true));

        given()
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .delete("/api/v1/courier/1996");
    }


    @Step("Проверка на невозможность создать двух одинаковых курьеров\n"+
    "Проверка ошибки, если попытаться создать пользователя с логином, который уже есть")
    @Test
    public void errorByCreatingSameCouriers() {
        CurlForCourierCreate URL = new CurlForCourierCreate();
        RequestCourierCreate firstCourier = new RequestCourierCreate("witcher", "12345", "igor");

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(firstCourier)
                .post(URL.getEndpoint());

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(firstCourier)
                .when()
                .post(URL.getEndpoint())
                .then()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется"));
    }


    @Step("Если одного из полей нет, запрос возвращает ошибку")
    @ParameterizedTest
    @CsvSource (value = {
        "igor, igor, null",
            "'igor', 'null', 'igor'",
                "'null', 'igor', 'igor'",
    },
            nullValues = {"null"})
    public void errorByCreatingCourierWithoutField(String login, String firstName, String password) {
        CurlForCourierCreate URL = new CurlForCourierCreate();
        RequestCourierCreate courier = new RequestCourierCreate(login, firstName, password);

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(courier)
                .when()
                .post(URL.getEndpoint())
                .then()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}

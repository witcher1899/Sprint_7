package courier_login;


import courier_create.CurlForCourierCreate;
import courier_create.RequestCourierCreate;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.Test;


public class CourierLoginTest {


    @Step("Авторизация курьера при всех обязательных полях")
    @Test
    public void statusCode200ByLogin() {
        CurlForLogin URL = new CurlForLogin();
        RequestLogin request = new RequestLogin("witcher19999999", "password");

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(request)
                .when()
                .post(URL.getEndpoint())
                .then()
                .statusCode(200);
    }


    @Step("Успешный запрос возвращает id")
    @Test
    public void validMessageByLogin() {
        CurlForLogin URL = new CurlForLogin();
        RequestLogin request = new RequestLogin("witcher19999999", "password");

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(request)
                .when()
                .post(URL.getEndpoint())
                .then()
                .body("id", instanceOf(Integer.class));
    }


    @Step("Система вернёт ошибку, если неправильно указать логин или пароль")
    @ParameterizedTest
    @CsvSource (value = {
            "igor, null",
            "'null', 'igor'",
            "'null', 'null'",
    },
            nullValues = {"null", "-"})
    public void errorWhenLoginOrPasswordNotExist(String login, String password) {
        CurlForLogin URL = new CurlForLogin();
        RequestLogin request = new RequestLogin(login, password);

        given()
                .baseUri(URL.getURL())
                .contentType("application/json")
                .body(request)
                .when()
                .post(URL.getEndpoint())
                .then()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }


    @Step("Система вернёт ошибку, если неправильно указать логин или пароль\n" +
    "Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку")
    @ParameterizedTest
    @CsvSource ({
            "witcher19999999, null",
            "'null', 'password'",
            "'null', 'null'",
    })
    public void errorWhenLoginOrPasswordNotValid(String login, String password) {
        CurlForLogin URLForLogin = new CurlForLogin();
        RequestLogin loginMessage = new RequestLogin(login, password);

        CurlForCourierCreate URLForCreating = new CurlForCourierCreate();
        RequestCourierCreate createCourier = new RequestCourierCreate("witcher19999999", "igor", "password");

        given()
                .baseUri(URLForCreating.getURL())
                .contentType("application/json")
                .body(createCourier)
                .post(URLForCreating.getEndpoint());

        given()
                .baseUri(URLForLogin.getURL())
                .contentType("application/json")
                .body(loginMessage)
                .when()
                .post(URLForLogin.getEndpoint())
                .then()
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }
}

package POST;

import POJO.UserRegisterOrLogin;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestSuccessfulLogin {

    @Test
    public void testSuccessfulLogin() {
        PostSpecification.installPostSpecification(PostSpecification.requestSpecification(),
                PostSpecification.responseSpecification(200));

        UserRegisterOrLogin userLogin = new UserRegisterOrLogin("eve.holt@reqres.in", "cityslicka");

        given()
                .when()
                    .body(userLogin)
                    .post("api/login")
                .then()
                    .assertThat().body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
}

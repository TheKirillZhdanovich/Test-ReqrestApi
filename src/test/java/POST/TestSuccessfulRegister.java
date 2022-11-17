package POST;

import POJO.SuccessUserRegister;
import POJO.UserRegisterOrLogin;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestSuccessfulRegister {

    @Test
    public void testSuccessfulRegister() {
        PostSpecification.installPostSpecification(PostSpecification.requestSpecification(),
                PostSpecification.responseSpecification(200));

        UserRegisterOrLogin userRegister = new UserRegisterOrLogin("eve.holt@reqres.in", "pistol");

        SuccessUserRegister successUserRegister = given()
                .when()
                    .body(userRegister)
                    .post("api/register")
                .then()
                    .extract().as(SuccessUserRegister.class);

        assertEquals("4", successUserRegister.getId().toString());
        assertEquals("QpwL5tke4Pnpja7X4", successUserRegister.getToken());
    }
}

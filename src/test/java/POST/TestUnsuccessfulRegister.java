package POST;

import POJO.UserRegisterOrLoginWithoutPassword;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestUnsuccessfulRegister {

    @Test
    public void testUnsuccessfulRegister() {
        PostSpecification.installPostSpecification(PostSpecification.requestSpecification(),
                PostSpecification.responseSpecification(400));

        UserRegisterOrLoginWithoutPassword user = new UserRegisterOrLoginWithoutPassword("sydney@fife");

        given()
                .when()
                    .body(user)
                    .post("api/register")
                .then()
                    .assertThat().body("error", equalTo("Missing password"));
    }
}


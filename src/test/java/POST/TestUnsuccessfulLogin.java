package POST;

import POJO.UserRegisterOrLoginWithoutPassword;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestUnsuccessfulLogin {

    @Test
    public void testUnsuccessfulLogin() {
        PostSpecification.installPostSpecification(PostSpecification.requestSpecification(),
                PostSpecification.responseSpecification(400));

        UserRegisterOrLoginWithoutPassword user = new UserRegisterOrLoginWithoutPassword("peter@klaven");

        given()
                .when()
                    .body(user)
                    .post("api/login")
                .then()
                    .assertThat().body("error", equalTo("Missing password"));
    }

}

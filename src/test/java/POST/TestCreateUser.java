package POST;

import POJO.UserCreateResponse;
import POJO.User;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class TestCreateUser {

    @Test
    public void testCreateUser() {
        PostSpecification.installPostSpecification(PostSpecification.requestSpecification(),
                PostSpecification.responseSpecification(201));

        User user = new User("morpheus", "leader");

        UserCreateResponse userCreateResponse = given()
                .when()
                    .body(user)
                    .post("api/users")
                .then()
                    .extract().as(UserCreateResponse.class);

        assertEquals(user.getName(), userCreateResponse.getName());
        assertEquals(user.getJob(), userCreateResponse.getJob());
    }

}

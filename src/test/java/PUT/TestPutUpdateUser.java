package PUT;

import POJO.User;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPutUpdateUser {

    @Test
    public void testPutUpdateUser() {
        PutSpecification.installPostSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecification(200));
        User user = new User("morpheus", "zion resident");

        given()
                .when()
                    .body(user)
                    .put("api/users/2")
                .then()
                    .assertThat()
                    .body("name", equalTo(user.getName()))
                    .body("job", equalTo(user.getJob()));
    }
}

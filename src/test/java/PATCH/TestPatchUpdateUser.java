package PATCH;

import POJO.User;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatchUpdateUser {

    @Test
    public void testPatchUpdateUser() {
        PatchSpecification.installPostSpecification(PatchSpecification.requestSpecification(),
                PatchSpecification.responseSpecification(200));

        User user = new User("morpheus", "zion resident");

        given()
                .when()
                    .body(user)
                    .patch("api/users/2")
                .then()
                    .assertThat()
                    .body("name", equalTo(user.getName()))
                    .body("job", equalTo(user.getJob()));
    }

}

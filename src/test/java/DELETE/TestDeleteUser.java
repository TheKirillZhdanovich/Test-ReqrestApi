package DELETE;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestDeleteUser {

    @Test
    public void testDeleteUser() {
        DeleteSpecification.installPostSpecification(DeleteSpecification.requestSpecification(),
                DeleteSpecification.responseSpecification(204));

        given()
                .when()
                    .delete("api/users/2")
                .then()
                    .assertThat().body(equalTo(""));
    }

}

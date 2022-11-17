package GET;

import POJO.UserData;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TestGetSingleUser {

    @Test
    public void testUserIsJanetWeaver() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        UserData user = given()
                .when()
                    .get("/api/users/2")
                .then()
                    .extract().body().jsonPath().getObject("data", UserData.class);

        assertEquals("Janet", user.getFirst_name());
        assertEquals("Weaver", user.getLast_name());
    }

    @Test
    public void testUserNotFound() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(404));

                given()
                .when()
                    .get("/api/users/23")
                .then()
                    .assertThat().body(equalTo("{}"));
    }

}

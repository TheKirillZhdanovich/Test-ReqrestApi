package GET;

import POJO.UserData;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class TestGetDelayResponse {

    @Test
    public void testGetDelayResponseHaveTheirIdInAvatar() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        List<UserData> userDataList = given()
                .when()
                .get("/api/users?delay=2")
                .then()
                .extract().body().jsonPath().getList("data", UserData.class);

        assertTrue(userDataList.stream().allMatch(x -> x.getAvatar().contains(x.getId().toString())));
    }

    @Test
    public void testGetDelayResponseEmailsContainsReqresIn() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        List<UserData> userDataList = given()
                .when()
                .get("/api/users?delay=2")
                .then()
                .extract().body().jsonPath().getList("data", UserData.class);

        assertTrue(userDataList.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }
}

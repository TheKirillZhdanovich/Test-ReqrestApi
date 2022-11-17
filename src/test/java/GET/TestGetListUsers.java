package GET;

import POJO.UserData;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class TestGetListUsers {

    @Test
    public void testGetListUsersHaveTheirIdInAvatar() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        List<UserData> userDataList = given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .extract().body().jsonPath().getList("data", UserData.class);

        assertTrue(userDataList.stream().allMatch(x -> x.getAvatar().contains(x.getId().toString())));
    }

    @Test
    public void testGetListUsersEmailsContainsReqresIn() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        List<UserData> userDataList = given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .extract().body().jsonPath().getList("data", UserData.class);

        assertTrue(userDataList.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }

}

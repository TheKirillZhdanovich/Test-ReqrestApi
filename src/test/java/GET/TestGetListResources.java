package GET;

import POJO.ResourceData;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class TestGetListResources {

    @Test
    public void testGetListResourcesThatYearIsSorted() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        List<ResourceData> resourceDataList = given()
                .when()
                    .get("api/unknown")
                .then()
                    .extract().body().jsonPath().getList("data", ResourceData.class);

        List<Integer> years = resourceDataList.stream().map(ResourceData::getYear).toList();
        List<Integer> sortedYears = years.stream().sorted().toList();

        assertEquals(sortedYears, years);
    }

}

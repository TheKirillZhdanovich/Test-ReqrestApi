package GET;

import POJO.ResourceData;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TestGetSingleResource {

    @Test
    public void testGetSingleResourceDataIsRight() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(200));

        ResourceData resourceData = given()
                .when()
                    .get("api/unknown/2")
                .then()
                    .extract().body().jsonPath().getObject("data", ResourceData.class);

        assertEquals("2", resourceData.getId().toString());
        assertEquals("fuchsia rose", resourceData.getName());
        assertEquals("2001", resourceData.getYear().toString());
        assertEquals("#C74375", resourceData.getColor());
        assertEquals("17-2031", resourceData.getPantone_value());
    }

    @Test
    public void testGetSingleResourceNotFound() {
        PutSpecification.installSpecification(PutSpecification.requestSpecification(),
                PutSpecification.responseSpecificationExpectedSetStatusCode(404));

        given()
                .when()
                    .get("api/unknown/23")
                .then()
                .assertThat().body(equalTo("{}"));
    }

}

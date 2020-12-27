package healthcheck;

import common.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static enums.Enums.BASE_URI;
import static enums.Enums.PATH_HEALTHCHECK;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class HelathCheckTest extends BaseTest {

    @Test
    public void healthcheck() {

            given().
               spec(requestSpecification).
            when().
               get(BASE_URI.getUrl()).
            then().
               statusCode(SC_OK).
               body("status", is("UP")).
               contentType(ContentType.HTML);
        }
}

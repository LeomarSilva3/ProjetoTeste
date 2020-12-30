package caller;

import common.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static enums.Enums.*;
import static io.restassured.RestAssured.given;


public class CreateUserService extends BaseTest {

    public ValidatableResponse postUser(String body){
        return
             given().
                  spec(requestSpecification).
                  body(body).
             when().
                  post(CREATE_USER.getUrl()).
             then().
                  statusCode(HttpStatus.SC_CREATED).
                  contentType(ContentType.JSON);
    }
}

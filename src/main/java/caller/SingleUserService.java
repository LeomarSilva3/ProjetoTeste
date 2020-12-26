package caller;

import common.BaseTest;
import dto.SingleUserRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static enums.Enums.*;
import static io.restassured.RestAssured.given;

public class SingleUserService extends BaseTest {

        public ValidatableResponse getUserId(SingleUserRequestDTO request){
            return
                    given().
                            spec(requestSpecification).
                                pathParam("userId",request.getUserId()).
                            when().
                                get(SINGLE_USER.getUrl()).
                            then().
                                statusCode(HttpStatus.SC_OK).
                                contentType(ContentType.JSON);
        }


    public ValidatableResponse getUserIdNotFound(SingleUserRequestDTO request) {
        return
                given().
                        spec(requestSpecification).
                            pathParam("userId", request.getUserId()).
                        when().
                            get(SINGLE_USER.getUrl()).
                        then().
                            statusCode(HttpStatus.SC_NOT_FOUND).
                            contentType(ContentType.JSON) ;
    }

}

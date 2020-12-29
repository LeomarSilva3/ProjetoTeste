package contract;

import common.BaseTest;
import datadriven.SingleUserProvider;
import dto.UserRequestDTO;
import org.testng.annotations.Test;
import java.io.File;

import static enums.Enums.SINGLE_USER;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class SingleUserContractTest extends BaseTest {

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUser")
    public void validarContratoSingleUser(UserRequestDTO request){

        given().
                spec(requestSpecification).
                    pathParam("userId",request.getUserId()).
                when().
                    get(SINGLE_USER.getUrl()).
                then().
                    body(matchesJsonSchema(
                        new File("src/main/resources/json_schema/singleUser_schema.json")));


    }

}

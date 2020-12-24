package requestSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static enums.Enums.*;

public class GetSingleUserRequestSpecification {

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                )
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI.getUrl())
                .setBasePath(BASE_PATH.getUrl())
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }


}

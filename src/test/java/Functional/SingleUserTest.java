package functional;

import caller.SingleUserService;
import common.BaseTest;
import datadriven.SingleUserProvider;
import dto.SingleUserRequestDTO;
import dto.SingleUserResponseDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.*;


public class SingleUserTest extends BaseTest {
    SingleUserService getSingleService;

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUser")
    public void RealizarBuscaUsuario(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        SingleUserResponseDTO response = getSingleService.getUserId(request)
                .extract()
                .jsonPath()
                .getObject("$", SingleUserResponseDTO.class);

        Assert.assertEquals(response.getData().getId(), 2);
        Assert.assertEquals(response.getData().getEmail(), "janet.weaver@reqres.in");
        Assert.assertEquals(response.getData().getFirst_name(), "Janet");
        Assert.assertEquals(response.getData().getLast_name(), "Weaver");
        Assert.assertEquals(response.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
    }


    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "userNotFound")
    public void RealizarBuscaUsuarioNaoEncontrado(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        ValidatableResponse response =  getSingleService.getUserIdNotFound(request);

        response.statusCode(is(404));
    }

}


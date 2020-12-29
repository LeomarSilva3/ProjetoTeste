package Functional;

import caller.SingleUserService;
import common.BaseTest;
import datadriven.SingleUserProvider;
import dto.user.UserRequestDTO;
import dto.user.UserSingleResponseDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserSingleTest  extends BaseTest {
    private SingleUserService getSingleService;

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUser")
    public void RealizarBuscaUsuario(UserRequestDTO request) {
        getSingleService = new SingleUserService();

        UserSingleResponseDTO response = getSingleService.getUserId(request)
                .extract()
                .jsonPath()
                .getObject("$", UserSingleResponseDTO.class);

        Assert.assertEquals(response.getData().getId(),2);
        Assert.assertEquals(response.getData().getEmail(), "janet.weaver@reqres.in");
        Assert.assertEquals(response.getData().getFirst_name(), "Janet");
        Assert.assertEquals(response.getData().getLast_name(), "Weaver");
        Assert.assertEquals(response.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
    }


    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "userNotFound")
    public void RealizarBuscaUsuarioNaoEncontrado(UserRequestDTO request) {
        getSingleService = new SingleUserService();

        ValidatableResponse response =  getSingleService.getUserIdNotFound(request);

        response.statusCode(is(404));
    }


}

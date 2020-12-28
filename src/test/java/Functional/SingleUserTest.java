package Functional;

import caller.SingleUserService;
import common.BaseTest;
import datadriven.SingleUserProvider;
import dto.SingleUserRequestDTO;
import dto.SingleUserResponseDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;


public class SingleUserTest extends BaseTest {
    private SingleUserService getSingleService;

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUser")
    public void RealizarBuscaUsuario(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        SingleUserResponseDTO response = getSingleService.getUserId(request)
                .extract()
                .jsonPath()
                .getObject("$", SingleUserResponseDTO.class);

        Assert.assertEquals(response.getData().get(1).getId(), 2);
        Assert.assertEquals(response.getData().get(1).getEmail(), "janet.weaver@reqres.in");
        Assert.assertEquals(response.getData().get(1).getFirst_name(), "Janet");
        Assert.assertEquals(response.getData().get(1).getLast_name(), "Weaver");
        Assert.assertEquals(response.getData().get(1).getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
    }


    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "userNotFound")
    public void RealizarBuscaUsuarioNaoEncontrado(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        ValidatableResponse response =  getSingleService.getUserIdNotFound(request);

        response.statusCode(is(404));
    }


    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUsersList")
    public void VerificarUsuariosPrimeiraPagina(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        SingleUserResponseDTO response = getSingleService.getUserFirstPage()
                .extract()
                .jsonPath()
                .getObject("$", SingleUserResponseDTO.class);

        Assert.assertEquals(response.getPage(), 1);
        Assert.assertEquals(response.getPer_page(), 6);
        Assert.assertEquals(response.getData().get(0).getFirst_name(),"George" );
        Assert.assertEquals(response.getData().get(1).getFirst_name(),"Janet" );
        Assert.assertEquals(response.getData().get(2).getFirst_name(),"Emma" );
        Assert.assertEquals(response.getData().get(3).getFirst_name(),"Eve" );
        Assert.assertEquals(response.getData().get(4).getFirst_name(),"Charles" );
        Assert.assertEquals(response.getData().get(5).getFirst_name(),"Tracey" );

    }

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "getUsersList")
    public void VerificarUsuariosSegundaPagina(SingleUserRequestDTO request) {
        getSingleService = new SingleUserService();

        SingleUserResponseDTO response = getSingleService.getUserSecondPage()
                .extract()
                .jsonPath()
                .getObject("$", SingleUserResponseDTO.class);

        Assert.assertEquals(response.getPage(), 2);
        Assert.assertEquals(response.getPer_page(), 6);
        Assert.assertEquals(response.getData().get(0).getFirst_name(),"Michael" );
        Assert.assertEquals(response.getData().get(1).getFirst_name(),"Lindsay" );
        Assert.assertEquals(response.getData().get(2).getFirst_name(),"Tobias" );
        Assert.assertEquals(response.getData().get(3).getFirst_name(),"Byron" );
        Assert.assertEquals(response.getData().get(4).getFirst_name(),"George" );
        Assert.assertEquals(response.getData().get(5).getFirst_name(),"Rachel" );

    }

}


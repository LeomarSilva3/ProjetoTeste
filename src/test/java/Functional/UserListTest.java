package Functional;

import caller.SingleUserService;
import common.BaseTest;
import datadriven.SingleUserProvider;
import dto.UserRequestDTO;
import dto.UserListResponseDTO;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserListTest extends BaseTest {
    private SingleUserService getSingleService;


    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "usersFirstPage")
    public void VerificarUsuariosPrimeiraPagina(UserRequestDTO request) {
        getSingleService = new SingleUserService();

        UserListResponseDTO response = getSingleService.getUserPerPage(request)
                .extract()
                .jsonPath()
                .getObject("$", UserListResponseDTO.class);

        Assert.assertEquals(response.getPage(), 1);
        Assert.assertEquals(response.getPer_page(), 6);
        Assert.assertEquals(response.getData().get(0).getFirst_name(),"George" );
        Assert.assertEquals(response.getData().get(1).getFirst_name(),"Janet" );
        Assert.assertEquals(response.getData().get(2).getFirst_name(),"Emma" );
        Assert.assertEquals(response.getData().get(3).getFirst_name(),"Eve" );
        Assert.assertEquals(response.getData().get(4).getFirst_name(),"Charles" );
        Assert.assertEquals(response.getData().get(5).getFirst_name(),"Tracey" );

    }

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "usersSecondPage")
    public void VerificarUsuariosSegundaPagina(UserRequestDTO request) {
        getSingleService = new SingleUserService();

        UserListResponseDTO response = getSingleService.getUserPerPage(request)
                .extract()
                .jsonPath()
                .getObject("$", UserListResponseDTO.class);

        Assert.assertEquals(response.getPage(), 2);
        Assert.assertEquals(response.getPer_page(), 6);
        Assert.assertEquals(response.getData().get(0).getFirst_name(),"Michael" );
        Assert.assertEquals(response.getData().get(1).getFirst_name(),"Lindsay" );
        Assert.assertEquals(response.getData().get(2).getFirst_name(),"Tobias" );
        Assert.assertEquals(response.getData().get(3).getFirst_name(),"Byron" );
        Assert.assertEquals(response.getData().get(4).getFirst_name(),"George" );
        Assert.assertEquals(response.getData().get(5).getFirst_name(),"Rachel" );

    }

    @Test(dataProviderClass = SingleUserProvider.class, dataProvider = "pageNotFound")
    public void PaginaNãoEncontrada(UserRequestDTO request) {
        getSingleService = new SingleUserService();

        UserListResponseDTO response = getSingleService.getUserPerPage(request)
                .extract()
                .jsonPath()
                .getObject("$", UserListResponseDTO.class);

       Assert.assertEquals(response.getPage(), 3);
       if(response.getData() != null) {
           System.out.print("Objeto Data está vazio!!");
       }
       else{
           System.out.print("Objeto Data contém valores!!");
       }
    }

}


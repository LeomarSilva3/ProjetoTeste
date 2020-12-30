package Functional;

import caller.CreateUserService;
import common.BaseTest;
import datadriven.CreateUserProvider;
import datadriven.SingleUserProvider;
import dto.createUser.UserCreateResponseDTO;
import dto.user.UserRequestDTO;
import dto.user.UserSingleResponseDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserCreateTest extends BaseTest{
    private CreateUserService postCreateUserService;

    @Test(dataProviderClass = CreateUserProvider.class, dataProvider = "createUser")
    public void criarUsuarioSucesso(String body, UserCreateResponseDTO userCreate){
        postCreateUserService = new CreateUserService();

        UserCreateResponseDTO response = postCreateUserService.postUser(body)
                .extract()
                .jsonPath()
                .getObject("$",UserCreateResponseDTO.class);

       Assert.assertEquals(response.getName(), userCreate.getName());
       Assert.assertEquals(response.getJob(), userCreate.getJob());

    }
}

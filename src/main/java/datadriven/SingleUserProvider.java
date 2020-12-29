package datadriven;

import dto.user.UserRequestDTO;
import org.testng.annotations.DataProvider;

public class SingleUserProvider {

    @DataProvider(name = "getUser")
    public Object[] getUser(){
        UserRequestDTO user = UserRequestDTO.builder()
                .userId(2)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "userNotFound")
    public Object[] userNotFound(){
        UserRequestDTO user = UserRequestDTO.builder()
                .userId(23)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "usersFirstPage")
    public Object[] usersFirstPage(){
        UserRequestDTO user = UserRequestDTO.builder()
                .pageId(1)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "usersSecondPage")
    public Object[] usersSecondPage(){
        UserRequestDTO user = UserRequestDTO.builder()
                .pageId(2)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "pageNotFound")
    public Object[] pageNotFound(){
        UserRequestDTO user = UserRequestDTO.builder()
                .pageId(3)
                .build();
        return new Object[]{user};

    }

}

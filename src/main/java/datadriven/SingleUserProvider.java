package datadriven;

import dto.SingleUserRequestDTO;
import org.testng.annotations.DataProvider;

public class SingleUserProvider {

    @DataProvider(name = "getUser")
    public Object[] getUser(){
        SingleUserRequestDTO user = SingleUserRequestDTO.builder()
                .userId(2)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "userNotFound")
    public Object[] userNotFound(){
        SingleUserRequestDTO user = SingleUserRequestDTO.builder()
                .userId(23)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "usersFirstPage")
    public Object[] usersFirstPage(){
        SingleUserRequestDTO user = SingleUserRequestDTO.builder()
                .pageId(1)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "usersSecondPage")
    public Object[] usersSecondPage(){
        SingleUserRequestDTO user = SingleUserRequestDTO.builder()
                .pageId(2)
                .build();
        return new Object[]{user};

    }

    @DataProvider(name = "pageNotFound")
    public Object[] pageNotFound(){
        SingleUserRequestDTO user = SingleUserRequestDTO.builder()
                .pageId(3)
                .build();
        return new Object[]{user};

    }

}

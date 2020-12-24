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
}

package datadriven;

import dto.createUser.UserCreateResponseDTO;
import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CreateUserProvider {

    @DataProvider(name = "createUser")
    public Object[][] createUser(){
        String body = "{\"name\": \"morpheus\",\n" +
                      " \"job\": \"leader\"}";

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.ofPattern("YYYY-MM-DDEhh:mm:ss");
        String today = LocalDateTime.now(ZoneId.of("UTC-3"))
                .format(formatter);

        UserCreateResponseDTO userCreate = UserCreateResponseDTO.builder()
                .name("morpheus")
                .job("leader")
                .createdAt(today)
                .build();

        return new Object[][]{
                    {body,userCreate}
                };

    }

}


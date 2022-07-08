package datadriven;

import dto.createUser.UserCreateResponseDTO;
import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CreateUserProvider {

    @DataProvider(name = "createUser")
    public Object[] createUser(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-ddEhh:mm:ss");
        String today = LocalDateTime.now(ZoneId.of("UTC-3"))
                .format(formatter);

        UserCreateResponseDTO userCreate = UserCreateResponseDTO.builder()
                .name("Leomar")
                .job("leader")
                .createdAt(today)
                .build();

        String body = "{\"name\": \""+userCreate.getName()+"\",\n" +
                      " \"job\": \""+userCreate.getJob()+"\"}";


        return new Object[][]{
                    {userCreate}
                };

    }

}


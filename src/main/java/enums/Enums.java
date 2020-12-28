package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Enums {

    SINGLE_USER  ("api/users/{userId}"),
    USER_LIST  ("api/users/"),
    BASE_PATH ("/"),
    BASE_URI ("https://reqres.in"),
    PATH_HEALTHCHECK ("actuator/health");

    private String url;
}


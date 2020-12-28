package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Enums {

    SINGLE_USER  ("api/users/{userId}"),
    FIRST_PAGINATION_USER_LIST  ("api/users?page=1"),
    SECOND_PAGINATION_USER_LIST  ("api/users?page=2"),
    BASE_PATH ("/"),
    BASE_URI ("https://reqres.in"),
    PATH_HEALTHCHECK ("actuator/health");

    private String url;
}


package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Enums {

    SINGLE_USER  ("api/users/{userId}"),
    PAGINATION_USER  ("api/users?page={pageId}"),
    BASE_PATH ("/"),
    BASE_URI ("https://reqres.in"),
    PATH_HEALTHCHECK ("actuator/health"),
    CREATE_USER ("api/users/");

    private String url;
}


package dto.createUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserCreateResponseDTO {

    private String name;
    private String job;
    private String id;
    private String createdAt;

}

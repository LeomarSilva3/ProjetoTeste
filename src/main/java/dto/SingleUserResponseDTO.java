package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class SingleUserResponseDTO {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<DataDTO> data;
    private SupportDTO support;

}

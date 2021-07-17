package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personapi.enums.LanguageLevel;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDTO {

    private Long id;

    @Size(max = 20)
    private String name;

    private LanguageLevel level;

}

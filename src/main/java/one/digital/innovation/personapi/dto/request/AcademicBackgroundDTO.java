package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcademicBackgroundDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 150)
    private String nameInstitution;

    @NotEmpty
    private String startDate;

    @NotEmpty
    private String endDate;

}
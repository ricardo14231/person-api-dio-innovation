package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDTO {

    private Long id;

    @NotEmpty
    @Size(max = 150)
    private String companyName;

    @NotEmpty
    @Size(max = 30)
    private String position;

    @NotNull
    private LocalDate startPeriod;

    @NotEmpty
    private String endPeriod;

    @NotEmpty
    @Size(max = 100)
    private String attributions;

}

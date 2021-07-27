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
public class AcademicBackgroundDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 150)
    private String nameInstitution;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

}

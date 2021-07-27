package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumDTO {

    private Long id;

    @Valid
    @NotNull
    private PersonDTO personalData;

    @NotEmpty
    private String objective;

    @Valid
    @NotNull
    private List<AcademicBackgroundDTO> academicBackground;

    @Valid
    @NotNull
    private List<WorkExperienceDTO> workExperience;

    @Valid
    @NotNull
    private List<LanguageDTO> languages;


    private String computerLevel;

    @Valid
    @NotNull
    private List<CourseDTO> course;
}

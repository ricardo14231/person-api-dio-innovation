package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumDTO {

    private Long id;

    @NotEmpty
    private PersonDTO personalData;

    @NotEmpty
    private String objective;

    @NotEmpty
    private List<AcademicBackgroundDTO> academicBackground;

    private List<WorkExperienceDTO> workExperience;

    private List<LanguageDTO> languages;

    private String computerLevel;

    private List<CourseDTO> course;

}

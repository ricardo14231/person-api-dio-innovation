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
public class CourseDTO {

    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String courseTitle;

    @NotEmpty
    @Size(max = 100)
    private String institutionName;
}

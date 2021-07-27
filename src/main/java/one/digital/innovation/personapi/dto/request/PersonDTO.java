package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 80)
    private String fullName;

    @NotNull
    private LocalDate dateBirth;

    @Size(max = 15)
    private String maritalStatus;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Email(message = "E-mail inválido!")
    @NotEmpty
    private String email;
}

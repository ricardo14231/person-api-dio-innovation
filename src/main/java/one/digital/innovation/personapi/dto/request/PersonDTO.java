package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String fullName;

    @NotEmpty
    private String age;

    @Size(max = 10)
    private String maritalStatus;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @NotEmpty
    @Email
    private String email;
}

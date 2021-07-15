package one.digital.innovation.personapi.mapper;

import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    @Mapping(target = "dateBirth", source = "dateBirth", dateFormat = "dd-MM-yyyy")
    PersonDTO toDTO(Person person);
}

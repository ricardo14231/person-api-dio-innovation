package one.digital.innovation.personapi.mapper;


import one.digital.innovation.personapi.dto.request.WorkExperienceDTO;
import one.digital.innovation.personapi.entity.WorkExperience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkExperienceMapper {

    WorkExperienceMapper INSTANCE = Mappers.getMapper(WorkExperienceMapper.class);

    WorkExperience toModel(WorkExperienceDTO workExperienceDTO);

    WorkExperienceDTO toDTO(WorkExperience workExperience);
}

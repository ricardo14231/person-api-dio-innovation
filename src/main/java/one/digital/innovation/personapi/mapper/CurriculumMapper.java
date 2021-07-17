package one.digital.innovation.personapi.mapper;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.entity.Curriculum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurriculumMapper {

    CurriculumMapper INSTANCE = Mappers.getMapper(CurriculumMapper.class);

    Curriculum toModel(CurriculumDTO curriculumDTO);

    CurriculumDTO toDTO(Curriculum curriculum);
}

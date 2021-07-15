package one.digital.innovation.personapi.mapper;

import one.digital.innovation.personapi.dto.request.AcademicBackgroundDTO;
import one.digital.innovation.personapi.entity.AcademicBackground;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AcademicBackgroundMapper {
    AcademicBackgroundMapper INSTANCE = Mappers.getMapper(AcademicBackgroundMapper.class);

    AcademicBackground toModel(AcademicBackgroundDTO academicBackgroundDTO);

    AcademicBackgroundDTO toDTO(AcademicBackground academicBackground);
}

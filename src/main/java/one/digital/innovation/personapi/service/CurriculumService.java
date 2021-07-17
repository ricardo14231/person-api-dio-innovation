package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Curriculum;
import one.digital.innovation.personapi.mapper.CurriculumMapper;
import one.digital.innovation.personapi.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService {

    private final CurriculumMapper curriculumMapper = CurriculumMapper.INSTANCE;

    @Autowired
    private CurriculumRepository curriculumRepository;

    public MessageResponseDTO createCurriculum(CurriculumDTO curriculumDTO) {
        Curriculum curriculumToSave = curriculumMapper.toModel(curriculumDTO);
        Curriculum curriculumSaved = curriculumRepository.save(curriculumToSave);

        return createMessageDTO(curriculumSaved.getId(), "Curriculum com Id adicionado!");
    }

    private MessageResponseDTO createMessageDTO(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + " " + id)
                .build();
    }

}

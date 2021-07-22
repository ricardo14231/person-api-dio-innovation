package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Curriculum;
import one.digital.innovation.personapi.exception.CurriculumNoSuchElementExpertion;
import one.digital.innovation.personapi.mapper.CurriculumMapper;
import one.digital.innovation.personapi.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurriculumService {

    private final CurriculumMapper curriculumMapper = CurriculumMapper.INSTANCE;

    @Autowired
    private CurriculumRepository curriculumRepository;

    public MessageResponseDTO createCurriculum(CurriculumDTO curriculumDTO) {
        Curriculum curriculumToSave = curriculumMapper.toModel(curriculumDTO);
        Curriculum curriculumSaved = curriculumRepository.save(curriculumToSave);

        return createMessageDTO(curriculumSaved.getId(), "Curriculum adicionado! ID:");
    }

    public List<CurriculumDTO> listaAllCurriculum() {
        List<Curriculum> curriculumList = curriculumRepository.findAll();
        return curriculumList.stream()
                .map(c -> curriculumMapper.toDTO(c))
                .collect(Collectors.toList());
    }

    public CurriculumDTO findByIdCurriculum(Long id) {
        Curriculum curriculum = verifyIfExists(id);

        return curriculumMapper.toDTO(curriculum);
    }

    public MessageResponseDTO updateCurriculum(Long id, CurriculumDTO curriculumDTO) {
        verifyIfExists(id);
        Curriculum curriculumSaved = curriculumMapper.toModel(curriculumDTO);
        curriculumRepository.save(curriculumSaved);

        return createMessageDTO(curriculumSaved.getId(), "Curriculum com Id atualizado!");
    }

    public MessageResponseDTO deleteCurriculum(Long id) {
        verifyIfExists(id);
        curriculumRepository.deleteById(id);
        return createMessageDTO(id, "Curriculum Deletado!");
    }

    private Curriculum verifyIfExists(Long id) {
        Curriculum curriculum = curriculumRepository.findById(id)
                .orElseThrow(() -> new CurriculumNoSuchElementExpertion(id));
        return curriculum;
    }

    private MessageResponseDTO createMessageDTO(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + " " + id)
                .build();
    }

}

package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.WorkExperienceDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.WorkExperience;
import one.digital.innovation.personapi.exception.WorkExperienceNoSuchElementExpertion;
import one.digital.innovation.personapi.mapper.WorkExperienceMapper;
import one.digital.innovation.personapi.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    private final WorkExperienceMapper workExperienceMapper = WorkExperienceMapper.INSTANCE;

    public MessageResponseDTO createWorkExperience(WorkExperienceDTO workExperienceDTO) {

        WorkExperience workExperienceToSave = workExperienceMapper.toModel(workExperienceDTO);
        WorkExperience workExperienceSave = workExperienceRepository.save(workExperienceToSave);

        return  messageResponseDTO(workExperienceSave.getId(), "Experiência criada com Id: ");
    }

    public List<WorkExperienceDTO> listAllWorkExperience() {
        return workExperienceRepository.findAll().stream()
                .map(work -> workExperienceMapper.toDTO(work))
                .collect(Collectors.toList());
    }

    public WorkExperienceDTO findByIdWorkExperience(Long id) {
        WorkExperience workExperience = verifyIfExists(id);

        return workExperienceMapper.toDTO(workExperience);
    }


    private WorkExperience verifyIfExists(Long id) {
        return workExperienceRepository.findById(id)
                .orElseThrow(() -> new WorkExperienceNoSuchElementExpertion(id));
    }

    private MessageResponseDTO messageResponseDTO(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + " " + id)
                .build();
    }

}

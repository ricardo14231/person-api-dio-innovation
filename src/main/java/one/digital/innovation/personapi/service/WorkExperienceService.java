package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.WorkExperienceDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.WorkExperience;
import one.digital.innovation.personapi.mapper.WorkExperienceMapper;
import one.digital.innovation.personapi.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private MessageResponseDTO messageResponseDTO(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + " " + id)
                .build();
    }

}

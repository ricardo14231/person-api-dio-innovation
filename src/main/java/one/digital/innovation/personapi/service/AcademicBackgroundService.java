package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.AcademicBackgroundDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.AcademicBackground;
import one.digital.innovation.personapi.mapper.AcademicBackgroundMapper;
import one.digital.innovation.personapi.repository.AcademicBackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademicBackgroundService {

    @Autowired
    private AcademicBackgroundRepository academicBackgroundRepository;

    private final AcademicBackgroundMapper academicBackgroundMapper = AcademicBackgroundMapper.INSTANCE;

    public MessageResponseDTO createAcademicBackground(AcademicBackgroundDTO academicBackgroundDTO) {
        AcademicBackground academicBackground = academicBackgroundMapper.toModel(academicBackgroundDTO);

        AcademicBackground academicSave = academicBackgroundRepository.save(academicBackground);

        return createMessageResponse(academicSave.getId(), "Formação acadêmica adicionada.");
    }

    public List<AcademicBackgroundDTO> listAllAcademicBackgroud() {
        List<AcademicBackground> academicBackgrounds = academicBackgroundRepository.findAll();

        return academicBackgrounds.stream()
                .map(academic -> academicBackgroundMapper.toDTO(academic))
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + " " + id)
                .build();
    }
}

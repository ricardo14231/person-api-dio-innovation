package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Curriculum;
import one.digital.innovation.personapi.mapper.CurriculumMapper;
import one.digital.innovation.personapi.repository.CurriculumRepository;
import one.digital.innovation.personapi.utils.CurriculumCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CurriculumServiceTest {

    @InjectMocks
    private CurriculumService curriculumService;

    private CurriculumMapper curriculumMapper = CurriculumMapper.INSTANCE;

    @Mock
    private CurriculumRepository curriculumRepository;

    @Test
    void testGivenCurriculumDTOThenReturnSuccessfulMessage() {

        //given
        CurriculumDTO curriculumDTO = CurriculumCreator.createCurriculumDTOBuilder();
        Curriculum expectedSavedCurriculum = CurriculumCreator.createCurriculumBuilder();

        //when
        Mockito.when(curriculumRepository.save(Mockito.any(Curriculum.class))).thenReturn(expectedSavedCurriculum);

        //then
        MessageResponseDTO expectedSuccessfulMessage = createExpectedMessageResponse(expectedSavedCurriculum.getId());
        MessageResponseDTO succesMessage = curriculumService.createCurriculum(curriculumDTO);

        assertEquals(expectedSuccessfulMessage, succesMessage);

    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Curriculum adicionado! ID: " + id)
                .build();
    }
}
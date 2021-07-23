package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Curriculum;
import one.digital.innovation.personapi.mapper.CurriculumMapper;
import one.digital.innovation.personapi.repository.CurriculumRepository;
import one.digital.innovation.personapi.utils.CurriculumCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurriculumServiceTest {

    @InjectMocks
    private CurriculumService curriculumService;

    @Mock
    private CurriculumMapper curriculumMapper;

    @Mock
    private CurriculumRepository curriculumRepository;


    @Test
    @DisplayName("Deve retornar mensagem de sucesso ao criar o curriculum.")
    void testGivenCurriculumDTOThenReturnSuccessfulMessage() {

        CurriculumDTO curriculumDTO = CurriculumCreator.curriculumDTOBuilder();
        Curriculum expectedSavedCurriculum = CurriculumCreator.curriculumBuilder();

        //when
        when(curriculumRepository.save(any(Curriculum.class))).thenReturn(expectedSavedCurriculum);

        //then
        MessageResponseDTO expectedSuccessfulMessage = createExpectedMessageResponse(expectedSavedCurriculum.getId(), "Curriculum adicionado! ID:");
        MessageResponseDTO succesMessage = curriculumService.createCurriculum(curriculumDTO);

        assertEquals(expectedSuccessfulMessage, succesMessage);
    }

    @Test
    @DisplayName("Deve retornar uma lista com todos os curriculum.")
    void testGivenListAllCurriculumDTOThenReturnListOfCurriculum() {
        List<Curriculum> expectedCurriculumList = Collections.singletonList(CurriculumCreator.curriculumBuilder());

        //when
        when(curriculumRepository.findAll()).thenReturn(expectedCurriculumList);

        List<CurriculumDTO> expectedCurriculumDTOList = curriculumService.listaAllCurriculum();

        assertEquals(expectedCurriculumDTOList.get(0).getId(), expectedCurriculumList.get(0).getId());

    }

    @Test
    @DisplayName("Deve retornar uma lista vazia.")
    void testGivenListAllCurriculumDTOThenReturnListEmpty() {
        List<CurriculumDTO> expectedCurriculumDTOList = curriculumService.listaAllCurriculum();
        assertTrue(expectedCurriculumDTOList.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar o curriculumDTO com ID.")
    void testGivenFindCurriculumDTOByIdThenReturnCurriculumDTO(){
        CurriculumDTO expectedCurriculumDTOWithId = CurriculumCreator.curriculumDTOWithIdBuilder();
        Curriculum saveCurriculum = CurriculumCreator.curriculumBuilder();

        //when
        when(curriculumRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(saveCurriculum));

        assertEquals(expectedCurriculumDTOWithId, curriculumService.findByIdCurriculum(saveCurriculum.getId()));
    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando o curriculum é null")
    void testGivenFindByIdCurrriculumDTOThenReturnMessageCirriculumNotFound() {
        assertThrows(NoSuchElementException.class, () -> curriculumService.findByIdCurriculum(1L));
    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando tentar atualizar um curriculum que não existe.")
    void testGivenUpdateCurriculumDTOThenReturnCurriculumNotFound() {
        CurriculumDTO expectedCurriculumDTOWithId = CurriculumCreator.curriculumDTOWithIdBuilder();
        assertThrows(NoSuchElementException.class, () -> curriculumService.updateCurriculum(1L, expectedCurriculumDTOWithId));
    }

    @Test
    @DisplayName("Deve atualizar o curriculum.")
    void testGivenUpdateCurriculumThenReturnMessageDTOSuccessful() {
        CurriculumDTO curriculumDTOUpdate = CurriculumCreator.updateCurriculumDTOWithIdBuilder();
        Curriculum expectedCurriculumUpdate = CurriculumCreator.updateCurriculumBuilder();

        when(curriculumRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedCurriculumUpdate));
        when(curriculumRepository.save(any(Curriculum.class))).thenReturn(expectedCurriculumUpdate);

        assertEquals(createExpectedMessageResponse(expectedCurriculumUpdate.getId(), "Curriculum com Id atualizado!"),
                curriculumService.updateCurriculum(curriculumDTOUpdate.getId(), curriculumDTOUpdate));

    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando tentar deletar um curriculum que não existe.")
    void testGivenDeleteCurriculumNotFouldThenReturnNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> curriculumService.deleteCurriculum(1L));
    }

    @Test
    @DisplayName("Deve retornar Mensagem de sucesso ao deletar um curriculum.")
    void testGivenDeleteCurriculumThenReturnMessageSuccessful() {
        Curriculum curriculum = CurriculumCreator.curriculumBuilder();
        //when
        when(curriculumRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(curriculum));
        //when(curriculumRepository.deleteById(1L)).thenReturn(null);

        assertEquals(createExpectedMessageResponse(1L, "Curriculum Deletado!"),
                curriculumService.deleteCurriculum(1L));
    }


    private MessageResponseDTO createExpectedMessageResponse(Long id, String msg) {
        return MessageResponseDTO.builder()
                .message(msg + " " + id)
                .build();
    }
}
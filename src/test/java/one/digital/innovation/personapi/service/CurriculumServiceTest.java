package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Curriculum;
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
    private CurriculumRepository curriculumRepository;

    @Test
    @DisplayName("Deve retornar mensagem de sucesso ao criar o curriculum.")
    void testGivenCurriculumDTOThenReturnSuccessfulMessage() {

        CurriculumDTO curriculumDTO = CurriculumCreator.curriculumDTOBuilder();
        Curriculum expectedSavedCurriculum = CurriculumCreator.curriculumBuilder();

        when(curriculumRepository.save(any(Curriculum.class))).thenReturn(expectedSavedCurriculum);

        MessageResponseDTO expectedSuccessfulMessage = createExpectedMessageResponse(String.format("Curriculum com ID: %o adicionado!",
                expectedSavedCurriculum.getId()));

        MessageResponseDTO succesMessage = curriculumService.createCurriculum(curriculumDTO);

        assertEquals(expectedSuccessfulMessage, succesMessage);
    }

    @Test
    @DisplayName("Deve retornar uma lista com todos os curriculum.")
    void testGivenListAllCurriculumDTOThenReturnListOfCurriculum() {
        List<Curriculum> expectedCurriculumList = Collections.singletonList(CurriculumCreator.curriculumBuilder());

        when(curriculumRepository.findAll()).thenReturn(expectedCurriculumList);

        List<CurriculumDTO> expectedCurriculumDTOList = curriculumService.listAllCurriculum();

        assertEquals(expectedCurriculumDTOList.get(0).getId(), expectedCurriculumList.get(0).getId());

    }

    @Test
    @DisplayName("Deve retornar uma lista vazia.")
    void testGivenListAllCurriculumDTOThenReturnListEmpty() {
        List<CurriculumDTO> expectedCurriculumDTOList = curriculumService.listAllCurriculum();
        assertTrue(expectedCurriculumDTOList.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar o curriculumDTO com ID.")
    void testGivenFindCurriculumDTOByIdThenReturnCurriculumDTO(){
        CurriculumDTO expectedCurriculumDTOWithId = CurriculumCreator.curriculumDTOWithIdBuilder();
        Curriculum saveCurriculum = CurriculumCreator.curriculumBuilder();

        when(curriculumRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(saveCurriculum));

        assertEquals(expectedCurriculumDTOWithId, curriculumService.findByIdCurriculum(1L));
    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando o curriculum ?? null")
    void testGivenFindByIdCurrriculumDTOThenReturnMessageCirriculumNotFound() {
        assertThrows(NoSuchElementException.class, () -> curriculumService.findByIdCurriculum(1L));
    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando tentar atualizar um curriculum que n??o existe.")
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

        assertEquals(createExpectedMessageResponse(String.format("Curriculum com ID: %o atualizado!", expectedCurriculumUpdate.getId())),
                curriculumService.updateCurriculum(curriculumDTOUpdate.getId(), curriculumDTOUpdate));

    }

    @Test
    @DisplayName("Deve retornar NoSuchElementException quando tentar deletar um curriculum que n??o existe.")
    void testGivenDeleteCurriculumNotFoundThenReturnNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> curriculumService.deleteCurriculum(1L));
    }

    @Test
    @DisplayName("Deve retornar Mensagem de sucesso ao deletar um curriculum.")
    void testGivenDeleteCurriculumThenReturnMessageSuccessful() {
        Curriculum curriculum = CurriculumCreator.curriculumBuilder();

        when(curriculumRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(curriculum));

        assertEquals(createExpectedMessageResponse(String.format("Curriculum com ID: %o deletado!", 1L)),
                curriculumService.deleteCurriculum(1L));
    }

    private MessageResponseDTO createExpectedMessageResponse(String msg) {
        return MessageResponseDTO.builder()
                .message(msg)
                .build();
    }
}
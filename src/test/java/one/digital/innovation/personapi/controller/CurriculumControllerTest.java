package one.digital.innovation.personapi.controller;


import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.exception.CurriculumNoSuchElementExpertion;
import one.digital.innovation.personapi.service.CurriculumService;
import one.digital.innovation.personapi.utils.CurriculumCreator;
import one.digital.innovation.personapi.utils.CurriculumRequestJSON;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CurriculumController.class)
class CurriculumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurriculumService curriculumService;

    @Test
    void testCreateCurriculum() throws Exception {

        String curriculumDTOToSave = CurriculumRequestJSON.stringCurriculumDTOWithIdBuilder();

        when(curriculumService.createCurriculum(any(CurriculumDTO.class)))
                .thenReturn(expectedMessageResponse(String.format("Curriculum com ID: %o adicionado!", 1L)));

        mockMvc.perform(MockMvcRequestBuilders.post("/curriculum/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(curriculumDTOToSave))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("message").value("Curriculum com ID: 1 adicionado!"));
    }

    @Test
    void testNamePersonNotFoundCreateCurriculum() throws Exception {
        String curriculumDTO = CurriculumRequestJSON.stringCurriculumDTONamePersonNotFouldBuilder();

        mockMvc.perform(MockMvcRequestBuilders.post("/curriculum/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(curriculumDTO))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testReturnListCurriculum() throws Exception {
        List<CurriculumDTO> curriculumDTO = Collections.singletonList(CurriculumCreator.curriculumDTOWithIdBuilder());

        when(curriculumService.listAllCurriculum()).thenReturn(curriculumDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/curriculum/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(curriculumDTO.size())));
    }

    @Test
    void testReturnListCurriculumEmpty() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/curriculum/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void testReturnCurriculumFindByIdSuccess() throws Exception {
        CurriculumDTO curriculumDTO = CurriculumCreator.curriculumDTOWithIdBuilder();

        when(curriculumService.findByIdCurriculum(1L)).thenReturn(curriculumDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/curriculum/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testReturnCurriculumFindByIdNotFound() throws Exception {

        when(curriculumService.findByIdCurriculum(1L)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/curriculum/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void testUpdateCurriculumSuccess() throws Exception {
        String curriculumDTOUpdate = CurriculumRequestJSON.stringCurriculumDTOWithIdBuilder();
        CurriculumDTO curriculumDTO = CurriculumCreator.curriculumDTOWithIdBuilder();

        when(curriculumService.updateCurriculum(1L, curriculumDTO))
                .thenReturn(expectedMessageResponse(""));

        mockMvc.perform(MockMvcRequestBuilders.put("/curriculum/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(curriculumDTOUpdate))
                .andExpect(status().isNoContent());
    }

    @Test
    void testUpdateCurriculumUnsuccessfulNoBodyRequest() throws Exception {

        CurriculumDTO curriculumDTO = CurriculumCreator.curriculumDTOWithIdBuilder();

        when(curriculumService.updateCurriculum(1L, curriculumDTO))
                .thenReturn(expectedMessageResponse(""));

        mockMvc.perform(MockMvcRequestBuilders.put("/curriculum/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteCurriculumSuccess() throws Exception {
        when(curriculumService.deleteCurriculum(1L))
                .thenReturn(expectedMessageResponse("Curriculum com ID: 1 deletado!"));

        mockMvc.perform(MockMvcRequestBuilders.delete("/curriculum/delete/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private MessageResponseDTO expectedMessageResponse(String msg) {
        return MessageResponseDTO.builder()
                .message(msg)
                .build();
    }

}
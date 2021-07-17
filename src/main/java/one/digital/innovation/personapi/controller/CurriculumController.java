package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCurriculum(@RequestBody CurriculumDTO curriculumDTO) {
        return curriculumService.createCurriculum(curriculumDTO);
    }
}

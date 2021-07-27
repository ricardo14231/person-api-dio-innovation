package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.CurriculumDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCurriculum(@RequestBody @Valid CurriculumDTO curriculumDTO) {
        return curriculumService.createCurriculum(curriculumDTO);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<CurriculumDTO> listAllCurriculum() {
        return curriculumService.listAllCurriculum();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CurriculumDTO findByIdCurriculum(@PathVariable Long id) {
        return curriculumService.findByIdCurriculum(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageResponseDTO updateCurriculum(@PathVariable Long id, @RequestBody @Valid CurriculumDTO curriculumDTO) {
        return curriculumService.updateCurriculum(id, curriculumDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteCurriculum(@PathVariable Long id) {
        return curriculumService.deleteCurriculum(id);
    }
}

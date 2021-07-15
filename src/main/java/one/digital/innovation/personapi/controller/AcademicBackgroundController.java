package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.AcademicBackgroundDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.service.AcademicBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("academic")
public class AcademicBackgroundController {

    @Autowired
    private AcademicBackgroundService academicBackgroundService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAcademicBackground(@RequestBody AcademicBackgroundDTO academicBackgroundDTO) {
        return academicBackgroundService.createAcademicBackground(academicBackgroundDTO);
    }

    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AcademicBackgroundDTO> listAllAcademicBackgroud() {
        return academicBackgroundService.listAllAcademicBackgroud();
    }
}

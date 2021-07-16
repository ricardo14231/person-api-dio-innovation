package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.WorkExperienceDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workExperience")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO) {
        return workExperienceService.createWorkExperience(workExperienceDTO);
    }

}

package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.WorkExperienceDTO;
import one.digital.innovation.personapi.dto.response.MessageResponseDTO;
import one.digital.innovation.personapi.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<WorkExperienceDTO> listAllWorkExperience() {
        return workExperienceService.listAllWorkExperience();
    }

    @GetMapping("/{id}")
    public WorkExperienceDTO findByIdWorkExperince(@PathVariable Long id) {
        return workExperienceService.findByIdWorkExperience(id);
    }

    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateWorkExperience(@PathVariable Long id, @RequestBody WorkExperienceDTO workExperienceDTO) {
        return workExperienceService.updateWorkExperience(id, workExperienceDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkExperience(@PathVariable Long id) {
        workExperienceService.deleteWorkExperience(id);
    }


}

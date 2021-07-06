package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.dto.response.MessageRespondeDTO;
import one.digital.innovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageRespondeDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> listAllPerson() {
        return personService.listAllPerson();
    }
}

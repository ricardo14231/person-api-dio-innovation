package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.dto.response.MessageRespondeDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.mapper.PersonMapper;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageRespondeDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return MessageRespondeDTO
                .builder()
                .message("Pessoa adicionada com ID: " + savePerson.getId())
                .build();
    }
}

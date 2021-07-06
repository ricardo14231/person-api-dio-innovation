package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.response.MessageRespondeDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageRespondeDTO createPerson(Person person){
        Person savePerson = personRepository.save(person);
        return MessageRespondeDTO
                .builder()
                .message("Pessoa adicionada com ID: " + savePerson.getId())
                .build();
    }
}

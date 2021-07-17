package one.digital.innovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurriculumNoSuchElementExpertion extends NoSuchElementException {

    public CurriculumNoSuchElementExpertion(Long id) {
        super("Currículo não encontrado! Id = " + id);
    }
}

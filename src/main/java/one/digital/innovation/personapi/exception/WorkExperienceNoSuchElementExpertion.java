package one.digital.innovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkExperienceNoSuchElementExpertion extends NoSuchElementException {

    public WorkExperienceNoSuchElementExpertion(Long id) {
        super("Experiência de trabalho não encontrado! Id = " + id);
    }
}

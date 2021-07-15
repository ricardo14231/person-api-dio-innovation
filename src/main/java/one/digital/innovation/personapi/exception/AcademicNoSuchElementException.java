package one.digital.innovation.personapi.exception;

import java.util.NoSuchElementException;

public class AcademicNoSuchElementException extends NoSuchElementException {

    public AcademicNoSuchElementException(Long id) {
        super("Formação Acadêmica não encontrada. Id: " + id);
    }
}

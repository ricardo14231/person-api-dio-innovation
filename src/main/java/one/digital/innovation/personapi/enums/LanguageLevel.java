package one.digital.innovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LanguageLevel {

    BASIC("BASIC"),
    INTERMEDIATE("INTERMEDIATE"),
    ADVANCED("ADVANCED");

    private final String description;
}

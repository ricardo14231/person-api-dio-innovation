package one.digital.innovation.personapi.utils;

import lombok.Builder;
import lombok.Getter;
import one.digital.innovation.personapi.dto.request.*;
import one.digital.innovation.personapi.entity.*;
import one.digital.innovation.personapi.enums.LanguageLevel;
import one.digital.innovation.personapi.enums.PhoneType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@Builder
public class CurriculumCreator {

    private Long id;

    private PersonDTO personalData;

    private String objective;

    private List<AcademicBackgroundDTO> academicBackground;

    private List<WorkExperienceDTO> workExperience;

    private List<LanguageDTO> languages;

    private String computerLevel;

    private List<CourseDTO> course;

    public static CurriculumDTO curriculumDTOWithIdBuilder() {
        return  CurriculumDTO.builder()
                .id(1L)
                    .personalData(
                        PersonDTO.builder()
                            .id(1L)
                            .fullName("Ricardo Farias")
                            .dateBirth(LocalDate.of(1992,01,01))
                            .maritalStatus("Solteiro")
                            .phones(Arrays.asList(
                                PhoneDTO.builder()
                                    .id(1L)
                                    .type(PhoneType.MOBILE)
                                    .number("(00)900000000")
                                .build()))
                            .email("teste@gmail.com")
                            .build())
                    .objective("Meu objetivo.")
                    .academicBackground(Arrays.asList(
                            AcademicBackgroundDTO.builder()
                            .id(1L)
                            .nameInstitution("UESB")
                            .startDate(LocalDate.of(2014,03,05))
                            .endDate(LocalDate.of(2021,06,16))
                            .build()))
                    .workExperience(Arrays.asList(
                            WorkExperienceDTO.builder()
                            .id(1L)
                            .companyName("Empresa 1")
                            .startPeriod(LocalDate.of(2018,06,01))
                            .endPeriod("2021-05-31")
                            .attributions("Suporte a Sistemas")
                            .build()))
                    .languages(Arrays.asList(
                            LanguageDTO.builder()
                            .id(1L)
                            .name("Inglês")
                            .level(LanguageLevel.BASIC)
                            .build()))
                    .computerLevel("ADVANCED")
                    .course(Arrays.asList(
                            CourseDTO.builder()
                            .id(1L)
                            .institutionName("DIO INNOVATION")
                            .courseTitle("JAVA")
                            .build()))
                .build();
    }

    public static Curriculum curriculumBuilder() {
        return  Curriculum.builder()
                    .id(1L)
                    .personalData(
                            Person.builder()
                                    .id(1L)
                                    .fullName("Ricardo Farias")
                                    .dateBirth(LocalDate.of(1992,01,01))
                                    .maritalStatus("Solteiro")
                                    .phones(Arrays.asList(
                                            Phone.builder()
                                                    .id(1L)
                                                    .type(PhoneType.MOBILE)
                                                    .number("(00)900000000")
                                                    .build()))
                                    .email("teste@gmail.com")
                                    .build())
                    .objective("Meu objetivo.")
                    .academicBackground(Arrays.asList(
                            AcademicBackground.builder()
                                    .id(1L)
                                    .nameInstitution("UESB")
                                    .startDate(LocalDate.of(2014,03,05))
                                    .endDate(LocalDate.of(2021,06,16))
                                    .build()))
                    .workExperience(Arrays.asList(
                            WorkExperience.builder()
                                    .id(1L)
                                    .companyName("Empresa 1")
                                    .startPeriod(LocalDate.of(2018,06,01))
                                    .endPeriod("2021-05-31")
                                    .attributions("Suporte a Sistemas")
                                    .build()))
                    .languages(Arrays.asList(
                            Language.builder()
                                    .id(1L)
                                    .name("Inglês")
                                    .level(LanguageLevel.BASIC)
                                    .build()))
                    .computerLevel("ADVANCED")
                    .course(Arrays.asList(
                            Course.builder()
                                    .id(1L)
                                    .institutionName("DIO INNOVATION")
                                    .courseTitle("JAVA")
                                    .build()))
                    .build();
    }

    public static CurriculumDTO curriculumDTOBuilder() {
        return  CurriculumDTO.builder()
                .personalData(
                        PersonDTO.builder()
                                .fullName("Ricardo Farias")
                                .dateBirth(LocalDate.of(1992,01,01))
                                .maritalStatus("Solteiro")
                                .phones(Arrays.asList(
                                        PhoneDTO.builder()
                                                .type(PhoneType.MOBILE)
                                                .number("(00)900000000")
                                                .build()))
                                .email("teste@gmail.com")
                                .build())
                .objective("Meu objetivo.")
                .academicBackground(Arrays.asList(
                        AcademicBackgroundDTO.builder()
                                .nameInstitution("UESB")
                                .startDate(LocalDate.of(2014,03,05))
                                .endDate(LocalDate.of(2021,06,16))
                                .build()))
                .workExperience(Arrays.asList(
                        WorkExperienceDTO.builder()
                                .companyName("Empresa 1")
                                .startPeriod(LocalDate.of(2018,06,01))
                                .endPeriod("2021-05-31")
                                .attributions("Suporte a Sistemas")
                                .build()))
                .languages(Arrays.asList(
                        LanguageDTO.builder()
                                .name("Inglês")
                                .level(LanguageLevel.BASIC)
                                .build()))
                .computerLevel("ADVANCED")
                .course(Arrays.asList(
                        CourseDTO.builder()
                                .institutionName("DIO INNOVATION")
                                .courseTitle("JAVA")
                                .build()))
                .build();
    }

    public static CurriculumDTO updateCurriculumDTOWithIdBuilder() {
        return  CurriculumDTO.builder()
                .id(1L)
                .personalData(
                        PersonDTO.builder()
                                .id(1L)
                                .fullName("José Francisco")
                                .email("updateTeste@gmail.com")
                                .build())
                .workExperience(Arrays.asList(
                        WorkExperienceDTO.builder()
                                .id(1L)
                                .companyName("Empresa update")
                                .build()))
                .build();
    }

    public static Curriculum updateCurriculumBuilder() {
        return  Curriculum.builder()
                .id(1L)
                .personalData(
                        Person.builder()
                                .id(1L)
                                .fullName("José Francisco")
                                .email("updateTeste@gmail.com")
                                .build())
                .workExperience(Arrays.asList(
                        WorkExperience.builder()
                                .id(1L)
                                .companyName("Empresa update")
                                .build()))
                .build();
    }

}

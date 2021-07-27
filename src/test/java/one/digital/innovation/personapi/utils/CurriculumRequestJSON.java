package one.digital.innovation.personapi.utils;

public class CurriculumRequestJSON {

    public static String stringCurriculumDTOWithIdBuilder() {
        return "{\n" +
                "\t\"personalData\" : \n" +
                "\t\t{\n" +
                "\t\t\t\"fullName\": \"Ricardo Farias\",\n" +
                "\t\t\t\"dateBirth\": \"1992-01-01\",\n" +
                "\t\t\t\"maritalStatus\" : \"Solteiro\",\n" +
                "\t\t\t\"phones\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"type\": \"MOBILE\",\n" +
                "\t\t\t\t\t\"number\": \"(73)988670365\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"email\" : \"ris5@gmail.com\"\n" +
                "\t\t},\n" +
                "\t\"objective\" : \"Objetivo...\",\n" +
                "\t\"academicBackground\" :\n" +
                "\t\t[{\n" +
                "\t\t\t\t\"nameInstitution\": \"UESB\",\n" +
                "\t\t\t\t\"startDate\": \"2014-03-05\",\n" +
                "\t\t\t\t\"endDate\": \"2021-06-08\"\n" +
                "\t\t }],\n" +
                "\t\"workExperience\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"companyName\": \"Teste 1\",\n" +
                "\t\t\t\"position\": \"Encarregado\",\n" +
                "\t\t\t\"startPeriod\": \"2019-02-01\",\n" +
                "\t\t\t\"endPeriod\": \"2020-02-01\",\n" +
                "\t\t\t\"attributions\": \"asdadad\"\n" +
                "\t\t}],\n" +
                "\t\"languages\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"name\" : \"inglês\",\n" +
                "\t\t\t\"level\" : \"BASIC\"\n" +
                "\t\t}],\n" +
                "\t\"computerLevel\" : \"Avançado\",\n" +
                "\t\"course\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"courseTitle\" : \"Android\",\n" +
                "\t\t\t\"institutionName\" : \"Udemy\"\n" +
                "\t\t}]\n" +
                "\t\n" +
                "}";

    }

    public static String stringCurriculumDTONamePersonNotFouldBuilder() {
        return "{\n" +
                "\t\"personalData\" : \n" +
                "\t\t{\n" +
                "\t\t\t\"dateBirth\": \"1992-01-01\",\n" +
                "\t\t\t\"maritalStatus\" : \"Solteiro\",\n" +
                "\t\t\t\"phones\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"type\": \"MOBILE\",\n" +
                "\t\t\t\t\t\"number\": \"(73)988670365\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"email\" : \"ris5@gmail.com\"\n" +
                "\t\t},\n" +
                "\t\"objective\" : \"Objetivo...\",\n" +
                "\t\"academicBackground\" :\n" +
                "\t\t[{\n" +
                "\t\t\t\t\"nameInstitution\": \"UESB\",\n" +
                "\t\t\t\t\"startDate\": \"2014-03-05\",\n" +
                "\t\t\t\t\"endDate\": \"2021-06-08\"\n" +
                "\t\t }],\n" +
                "\t\"workExperience\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"companyName\": \"Teste 1\",\n" +
                "\t\t\t\"position\": \"Encarregado\",\n" +
                "\t\t\t\"startPeriod\": \"2019-02-01\",\n" +
                "\t\t\t\"endPeriod\": \"2020-02-01\",\n" +
                "\t\t\t\"attributions\": \"asdadad\"\n" +
                "\t\t}],\n" +
                "\t\"languages\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"name\" : \"inglês\",\n" +
                "\t\t\t\"level\" : \"BASIC\"\n" +
                "\t\t}],\n" +
                "\t\"computerLevel\" : \"Avançado\",\n" +
                "\t\"course\" : \n" +
                "\t\t[{\n" +
                "\t\t\t\"courseTitle\" : \"Android\",\n" +
                "\t\t\t\"institutionName\" : \"Udemy\"\n" +
                "\t\t}]\n" +
                "\t\n" +
                "}";

    }
}

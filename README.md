# Digital Innovation - Desenvolvendo um sistema de gerenciamento de curriculum em API REST com Spring Boot


# Sobre o projeto 

Está API foi proposto a partir do projeto de gerenciamento de pessoas desenvolvido durante a Bootcamp GFT START #2 Java, oferecida pela plataforma Digital Innovation One.

Foram feitas algumas alterações na atividade sugerida, a fim de representar um modelo de dados de um Curriculum Vitae.   

## Pré requisitos para executar o projeto:

Java: 11 ou superior
Maven: 3.8.1
JUnit 5.

## Para executar a aplicação:

No diretório do projeto execute o seguinte comando no terminal:
mvn spring-boot:run 

## Endpoints:

Método | Endpoint
:-----:|:--------:
 GET   | http://localhost:8080/curriculum/list
 POST  | http://localhost:8080/curriculum/create
 GET   | http://localhost:8080/curriculum/{id}
 PUT   | http://localhost:8080/curriculum/update/{id}
 DELETE| http://localhost:8080/curriculum/delete/{id}

## Modelo Json para criar um curriculum:
Para adicionar um curriculum, envie uma requisição com o modelo a seguir para o endpoint http://localhost:8080/curriculum/create
``` JSON
{
	"personalData" : 
		{
			"fullName": "Ricardo Farias",
			"dateBirth": "1992-01-01",
			"maritalStatus" : "Solteiro",
			"phones": [
				{
					"type": "MOBILE",
					"number": "(00)900000000"
				}
			],
			"email" : "teste@gmail.com"
		},
	"objective" : "Objetivo...",
	"academicBackground" :
		[{
				"nameInstitution": "Nome da Instituição...",
				"startDate": "2014-03-05",
				"endDate": "2018-06-01"
		 }],
	"workExperience" : 
		[{
			"companyName": "Teste 1",
			"position": "Encarregado",
			"startPeriod": "2019-02-01",
			"endPeriod": "2020-02-01",
			"attributions": "Suporte a sistemas."
		}],
	"languages" : 
		[{
			"name" : "inglês",
			"level" : "BASIC"
		}],
	"computerLevel" : "Avançado",
	"course" : 
		[{
			"courseTitle" : "Android",
			"institutionName" : "Udemy"
		}]
}
```
## Autor:

Ricardo Farias.

https://www.linkedin.com/in/ricardo-farias-04069359/

## Licença:

[![NPM](http://img.shields.io/npm/l/react)](https://github.com/ricardo14231/person-api-dio-innovation/blob/main/LICENSE)

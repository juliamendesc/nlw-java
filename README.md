# NLW Expert (JAVA)

This project is a simple API to simulate a certification system. It was developed during the NLW Expert event, promoted by [Rocketseat](https://rocketseat.com.br/) and it was great for my first incursion into the world of Java and Spring Boot.

## Requisites

- Docker;
- [Maven](https://maven.apache.org/)
- Java and Spring Boot;

## Setup

- Clone the repository;
- Setup PostgreSQL (`docker compose up -d`);
- Connect to PostgresSQL using your favorite client. Username and password are `admin` and `admin`, respectively. DB name is `pg_nlw`;
- Run application (`./mvn spring-boot:run`);
- Create Seed by running the file (`/src/main/java/tech/juliamendesc/certification_nlw/seed/CreateSeed.java`);
- Try it! (I used [Hoppscotch](https://hoppscotch.io/)).

## HTTP

### POST `/students/verifyIfHasCertification`

Verifies if a student has a certification.

#### Request body

```json
{
	"email": "teste@teste.com",
	"technology": "JAVA"
}
```

#### Response body

```json
Usuário pode fazer a prova
```

or

```json
Usuário já fez a prova
```

### GET `/questions/technology/JAVA`

Return questions and alternatives list.

#### Response body

```json
[
	{
		"id": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
		"technology": "JAVA",
		"description": "Como criar uma classe em Java?",
		"alternatives": [
			{
				"id": "bafdf631-6edf-482a-bda9-7dce1efb1890",
				"description": "Usando a palavra-chave \"class\""
			},
			{
				"id": "98f6891b-5f14-4b8e-bb87-46456a2610d4",
				"description": "Definindo uma interface em Java"
			},
			{
				"id": "993a7d37-62a0-4040-810d-d667e3f7a891",
				"description": "Utilizando métodos estáticos"
			},
			{
				"id": "98bf8d0f-dc1c-4db0-b09c-94246089aa02",
				"description": "Criando um construtor padrão"
			}
		]
	},
	{
		"id": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
		"technology": "JAVA",
		"description": "Explique o conceito de polimorfismo em Java.",
		"alternatives": [
			{
				"id": "1da0f5dd-7a02-4c34-8c60-4648b55141f2",
				"description": "Herança simples"
			},
			{
				"id": "c4fd1c23-8993-4972-92d5-b8364b78d1cf",
				"description": "Encapsulamento em Java"
			},
			{
				"id": "9da03a4e-3c8d-4a32-87e1-9898938435c2",
				"description": "Sobrecarga de métodos"
			},
			{
				"id": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9",
				"description": "Capacidade de um objeto de assumir várias formas"
			}
		]
	},
	{
		"id": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
		"technology": "JAVA",
		"description": "Como lidar com exceções em Java?",
		"alternatives": [
			{
				"id": "3528a132-9c12-4c8a-aa93-9f6e813c43d1",
				"description": "Ignorando a exceção"
			},
			{
				"id": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276",
				"description": "Utilizando blocos try-catch"
			},
			{
				"id": "63c0210c-2a9a-4e93-98ec-8d9f3984e2b0",
				"description": "Declarando uma exceção sem tratamento"
			},
			{
				"id": "e4dbf524-0a54-428a-b57c-853996fc8e19",
				"description": "Usando a palavra-chave \"finally\""
			}
		]
	}
]
```

### POST `/students/certification/answer`

Register the student's answers to certification's questions.

#### Request body

```json
{
	"email": "teste@teste.com",
	"technology": "JAVA",
	"questionsAnswers": [
		{
			"questionID": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
			"alternativeID": "bafdf631-6edf-482a-bda9-7dce1efb1890"
		},
		{
			"questionID": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
			"alternativeID": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"
		},
		{
			"questionID": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
			"alternativeID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"
		}
	]
}
```

#### Response body

```json
{
	"id": "6ae6c215-16e7-4d99-b4ee-249866e5fe1f",
	"technology": "JAVA",
	"grade": 3,
	"studentID": "ce9bd65e-f8f3-45c1-b33b-48b20e3b5057",
	"studentEntity": null,
	"answersCertificationsEntities": [
		{
			"id": "eb7aced5-76ae-45e8-9391-f0d0a1f9b7ec",
			"certificationID": "6ae6c215-16e7-4d99-b4ee-249866e5fe1f",
			"studentID": null,
			"studentEntity": null,
			"questionID": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
			"answerID": "bafdf631-6edf-482a-bda9-7dce1efb1890",
			"createdAt": "2024-02-19T12:18:25.972259",
			"correct": true
		},
		{
			"id": "3e5d77a8-6c05-42e3-aeba-0c66144b7aa8",
			"certificationID": "6ae6c215-16e7-4d99-b4ee-249866e5fe1f",
			"studentID": null,
			"studentEntity": null,
			"questionID": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
			"answerID": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9",
			"createdAt": "2024-02-19T12:18:25.973977",
			"correct": true
		},
		{
			"id": "d661536d-8fe4-467f-932f-177fe04dc336",
			"certificationID": "6ae6c215-16e7-4d99-b4ee-249866e5fe1f",
			"studentID": null,
			"studentEntity": null,
			"questionID": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
			"answerID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276",
			"createdAt": "2024-02-19T12:18:25.976171",
			"correct": true
		}
	],
	"createdAt": "2024-02-19T12:18:25.963581"
}
```

## Ranking

### GET `/ranking/top10`

Return the top 10 students in the ranking.

#### Response body

```json
[
	{
		"id": "6ae6c215-16e7-4d99-b4ee-249866e5fe1f",
		"technology": "JAVA",
		"grade": 3,
		"studentID": "ce9bd65e-f8f3-45c1-b33b-48b20e3b5057",
		"studentEntity": {
			"id": "ce9bd65e-f8f3-45c1-b33b-48b20e3b5057",
			"email": "teste@teste.com",
			"createdAt": "2024-02-19T12:18:25.958195"
		},
		"answersCertificationsEntities": [],
		"createdAt": "2024-02-19T12:18:25.963581"
	},
	{
		"id": "1e658a08-840b-4841-a946-fc0e9f15d33e",
		"technology": "JAVA",
		"grade": 2,
		"studentID": "bea57eaa-d1f0-4c94-9746-eca893a24233",
		"studentEntity": {
			"id": "bea57eaa-d1f0-4c94-9746-eca893a24233",
			"email": "teste2@teste.com",
			"createdAt": "2024-02-19T12:17:40.717119"
		},
		"answersCertificationsEntities": [],
		"createdAt": "2024-02-19T12:17:40.755505"
	}
]
```

<div align="center">

Made with ❤️ by [Julia Mendes](https://juliamendes.tech).

</div>

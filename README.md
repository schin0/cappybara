# 🦫 Cappybara
Bem-vindo ao repositório do **Cappybara**! Este projeto foi desenvolvido com o intuito de facilitar a mobilidade social para jovens em eventos. Com o Cappybara, os usuários podem descobrir eventos próximos e visualizar rotas.
O projeto é dividido em duas partes principais: o backend, implementado em Java com Spring Boot, que contém duas APIs, e o app, que é um projeto Kotlin com Jetpack Compose.

## 📂 Estrutura do Projeto

```
├── backend
│   ├── API Evento
│   └── API Usuario
└── frontend
    └── CappybaraApp
```

### 🛠️Tecnologias Utilizadas
-   **Backend:** Java com Spring Boot
-   **Frontend:** Kotlin com Jetpack Compose
-   **Banco de Dados:** PostgreSQL
-   **Armazenamento de Imagens:** Azure Blob Storage
-   **APIs publicadas:** Aplicativo do Azure Spring

## 🚀 Como Rodar o Projeto

### Backend ⚙️

1. Ambas as APIs já estão publicadas no Azure, portanto, não há necessidade de rodá-las localmente. Acesse-as nos links abaixo:
	- [API Evento](https://cappybara-service-spring-app-cappybara-evento.azuremicroservices.io/evento/)
	- [API Usuario](https://cappybara-service-spring-app-cappybara-usuario.azuremicroservices.io/)

### Frontend 🎨

1. Abra o Android Studio.
2. Navegue até o diretório `cappybara` e abra o projeto.
3. Inicie o projeto no emulador ou em um dispositivo físico através da opção **Run > Run App**.

###  Firebase 🔥
1.  Crie um projeto no [Console do Firebase](https://console.firebase.google.com/).
2.  Acesse a seção **Authentication** e ative a opção de Login com o Google.
3.  Adicione um App (clique no ícone do Android) e siga os passos da documentação.
4.  Baixe o arquivo `google-services.json` e insira-o na pasta `app`.
5.  Copie o campo **Id do Cliente da Web** mostrado na "Configuração do SDK da Web" e cole nos arquivos (**colarTokenAqui**):
    -   `local.defaults.properties`
    -   `secrets.properties`

### Google API 🗺️
-   Crie uma API Key no Console do Google, habilitando os seguintes serviços:
    -   **Geocoding API**: Obtém o nome do endereço a partir da latitude/longitude.
    -   **Directions API**: Obtém a rota de um endereço de origem até um destino, além da distância e do tempo de deslocamento.
    -   **Maps SDK for Android**: Permite incorporar o Google Maps no aplicativo.
-   Substitua a API Key nos arquivos (**colarChaveDaApiAqui**):
    -   `local.defaults.properties`
    -   `secrets.properties`

### Open Weather API ❄️
-   Crie uma API Key no Open Weather, habilitando o seguinte serviço:
    -   **Weather**: Obtém o clima atual e a previsão.
-   Substitua a API Key nos arquivos (WEATHER_MAP_API_KEY=**colarChaveDaApiAqui**):
    -   `local.defaults.properties`
    -   `secrets.properties`


## 🔗 Links importantes

- 🎯[Pitch](https://youtu.be/dfZpLrsLpRw?si=3embRfaTcJTj3Lzt)
- 🎨[Figma](https://www.figma.com/design/B3DTn5RlmunHxD8IKBEHPD/DESIGN-SYSTEM%3A-The-Cappybara-Project%3A-Enterprise-Challenge---ManageEngine?node-id=296-422&t=s6vNofi7TBjlnnIr-0)
- 💻 [Vídeo técnico](https://www.youtube.com/watch?v=kAcxnidVAeE)
- 📅 [Cronograma](https://docs.google.com/spreadsheets/d/1fLMJTAmETbPDATLy6dYs3G-HygjCjWUNQBwMHjY8lXo/edit?usp=sharing)

## 📞 Participantes
- [Alex Coelho de Oliveira](https://www.linkedin.com/in/alex-coelho-de-oliveira/)
- [Gabriel Hernandes Schincariol](https://www.linkedin.com/in/gabrielschincariol/)
- [Guilherme Radan Pereira Santos](https://www.linkedin.com/in/guilherme-radan-pereira-santos-0bb65b194/)
- [Lucas da Silva de Almeida Costa](https://www.linkedin.com/in/lucas-costa-7a3b81201/)

## 🏷️ Tags

-   Java
-   Spring Boot
-   Kotlin
-   Jetpack Compose
-   PostgreSQL
-   Azure
-   Firebase



# 🦫 Cappybara
Bem-vindo ao repositório do Cappybara! Este projeto é dividido em duas partes principais: o backend, implementado em Java com Spring Boot, que contém duas APIs, e o frontend, que é um projeto Kotlin com Jetpack Compose

## 📂 Estrutura do Projeto

```
├── backend
│   ├── api Evento (porta 8080)
│   └── api Usuario (porta 8081)
└── frontend
    └── CappybaraApp
```

### 🛠️ Tecnologias Utilizadas
    - Backend: Java com Spring Boot
    - Frontend: Kotlin com Jetpack Compose
    - Banco de Dados: PostgreSQL
    - Armazenamento de Imagens: Azure Blob Storage

## 🚀 Como Rodar o Projeto

### Backend

1. Clone as APIs usando os links abaixo e abra-as na sua IDE de preferência (recomendamos o uso do IntelliJ IDEA):
    - [API Evento](https://github.com/GuilhermeRadan/cappybara-service-evento)
    - [API Usuario](https://github.com/GuilhermeRadan/cappybara-service-usuario)
2. Cada API possui um arquivo de configuração do Docker, chamado `compose.yaml`. Para iniciá-lo, abra o Docker Desktop e inicie as APIs. O container correspondente também será iniciado automaticamente.
    - API Usuario : Porta 8081
    - API Evento: Porta 8080

### Frontend

1. Abra o Android Studio.
2. Navegue até o diretório `cappybara` e abra o projeto.
3. Inicie o projeto no emulador ou em um dispositivo físico.

### Emulador

#### Emulador do Android Studio

Se for rodar o app no emulador do Android Studio, não é necessária nenhuma alteração nas configurações de rede.

#### Celular Físico

Se for rodar o app em um dispositivo físico, será necessário alterar as rotas configuradas. Siga os passos abaixo:

1. Navegue até o pacote `data > api` dentro do projeto `cappybara`.
2. Abra os seguintes arquivos e substitua `10.0.2.2` pelo IP do seu computador:
    - `EventoRetrofitFactory.kt`
    - `LoginRetrofitFactory.kt`

Exemplo de alteração:

```kotlin
// Antes
private const val BASE_URL = "http://10.0.2.2:8081/"

// Depois
private const val BASE_URL = "http://SEU_IP_AQUI:8081/"
```
### Google API
Utilizamos a Geocoding API do Google para obter o nome do endereço a partir da latitude/longitude. Para isso, você precisa de uma API key do Google com esse serviço habilitado. Ao obter essa chave, substitua a string vazia ("apiKey") no arquivo `GoogleMapsService.kt`.

## 🔗 Links importantes

- 🎨[Figma](https://www.figma.com/design/B3DTn5RlmunHxD8IKBEHPD/DESIGN-SYSTEM%3A-The-Cappybara-Project%3A-Enterprise-Challenge---ManageEngine?node-id=296-422&t=s6vNofi7TBjlnnIr-0)
- 💻 [Vídeo técnico](https://www.youtube.com/watch?v=kAcxnidVAeE)
- 📅 [Cronograma](https://docs.google.com/spreadsheets/d/1fLMJTAmETbPDATLy6dYs3G-HygjCjWUNQBwMHjY8lXo/edit?usp=sharing)

## 📞 Participantes
- [Alex Coelho de Oliveira](https://www.linkedin.com/in/alex-coelho-de-oliveira/)
- [Gabriel Hernandes Schincariol](https://www.linkedin.com/in/gabrielschincariol/)
- [Guilherme Radan Pereira Santos](https://www.linkedin.com/in/guilherme-radan-pereira-santos-0bb65b194/)
- [Lucas da Silva de Almeida Costa](https://www.linkedin.com/in/lucas-costa-7a3b81201/)
---

# CineMania

CineMania é uma aplicação Android para fins de estudos. CineMania se conecta com a api [TMBD](https://www.themoviedb.org/) para acesso ao conteúdo.

## Design

A aplicação possui o design isnpirado no projeto gratúito para Figma [StreamVibe - Figma Design Template for OTT Platform](https://www.figma.com/community/file/1294589591426976269/ott-dark-theme-website-ui-design-template-for-media-streaming-movies-and-tv-free-editable)

## Setup do projeto

### Token da API

Para rodar o projeto será necessário criar uma conta e obter um token de leitura para a [api TMDB](https://developer.themoviedb.org/docs/getting-started).

Após obter seu token deverá registrar a variável `TMDB_API_KEY` no arquivo `local.properties` localizado na raiz do projeto.

```
TMDB_API_KEY=<token>
```
## Características do projeto

- Aplicação 100% em Compose
- Testes de componentes UI isolados
- Arquitetura Clean

### Recursos para o futuro

- Arquitetura MuiltiMódulo
- Novas features para exibição de detalhes do filme
- Testes de navegação

## Agradecimentos

<img src="https://www.themoviedb.org/assets/2/v4/logos/v2/blue_short-8e7b30f73a4020692ccca9c88bafe5dcb6f8a62a4c6bc55cd9ba82bb2cd95f6c.svg" width="200px"/>
[Figma Produci UI](https://www.figma.com/@produce_ui)

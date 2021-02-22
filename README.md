# GithubRepoProject

## Objetivo
Olá bem vindo ao projeto GithubRepoProject.

Este Aplicativo lista os repositórios públicos do Github por tópico, listando 100 ao máximo (primeira versão não tem paginação ainda) e podendo realizar busca por nome.

O limite de Requests está indicado pela documentação por aqui: https://docs.github.com/en/developers/apps/rate-limits-for-github-apps

Nesse aplicativo não há login/autenticação.

## Dependências

Utilizando o buildSrc do Gradle, criei uma classe chamada onde tem todas as dependências utilizadas pelo aplicativo: 

- Material Design
- Kotlin Serialization (JSON Parser)
- Android Jetpack: 
    - LiveData
    - ViewModel
    - SavedStateViewModel
    - ViewModel
    - Navigation Component
    - Plugin SafeArgs (Navigation)
- Coroutines
- Koin (Service Locator para Injeção de Dependências)
- Retrofit2
- Coil (Image Loader)
- MockK
- Junit
- ArchTest (Testes para Componentes do Jetpack)

## Algumas Explicações para as dependências utilizadas

### SavedStateViewModel

Evita realizar novos requests mantendo o estado da tela mesmo após troca de configuração.

### Kotlin Serialization

Nova biblioteca para realizar o parse de JSON para modelos Kotlin, realizando de maneira fácil e performática. Utilizando algumas features do Kotlin como Nullable, Default Parameters, entre outros. 

Para a utilização junto ao Retrofit, tive de utilizar o Adapter criado pelo Jake Wharton. Provavelmente irá ter uma versão oficial o mais breve possível.

### Coroutines

Chamadas assíncronas que simulam chamadas síncronas. Simples de usar e fácil de testar.

### Navigation Component

Traz a facilidade do Single Activity (melhora de performance na troca de telas) e junto ao SafeArgs nos auxilia a verificar erros em compile time.

### Koin

Biblioteca fácil de utilizar para Injeção de Dependências com o intuito de criar objetos de maneira diferentes como Single, Factory, entre outros. Também nos auxilia e muito na criação de testes.

### Coil

Nova biblioteca para o carregamento de imagens realizada em Kotlin. Para ser sincero, escolhi para testar. O que me agradou e muito pela facilidade, porém, preciso realizar testes para saber se é tão performática quanto o Glide/Picasso.

### Mockk

Biblioteca de testes para mockar objetos. Tem integração com coroutines o que facilita e muito os testes. Também consegue realizar mock de métodos estáticos (mesmo não utilizando nesse projeto).


## Arquitetura.

Utilizei MVVM no projeto na tela principal por alguns motivos:

 1. Recomendação de Arquitetura do próprio Google atualmente (biblioteca ViewModel + LiveData)
 2. Fácil de manutenção.
 3. Não gera boilerplate como o MVP (Interfaces).
 4. Testável.

 *Observação: Na tela de Detalhe não utilizei pois não há regra de negócio até o momento da escrita desse documento.*

 Utilizei o padrão Repository para as chamadas de Network, porém tem como finalidade orquestrar como se fosse um Data Source. Realizando chamada de APIs, salvando no Banco de Dados, ou caso a API não funcione haveria uma consulta no BD para ver se há registros.

## Gitflow

Se quiser checar o fluxo do desenvolvimento, utilizei o Gitflow. A partir da criação desse documento a branch **develop** e **main** estão equalizadas. Para ver o grafo, pode executar o comando: *git log --oneline --decorate*.

 ## Instalação

 Somente em modo debug o aplicativo irá ser executado. Não gerei proguard para modo release. Pode instalar via Android Studio ou gerar um APK e instalar no dispositivo.
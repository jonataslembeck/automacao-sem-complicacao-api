#language: pt
Funcionalidade: JsonPlaceHolderMap com Token

  Contexto: 
    Quando for realizado uma requisicao do tipo post do token e o token e armazenado

  @JsonPlaceHolderMap
  Cenario: Valida JsonPlaceHolder Map
    Dado que seja preenchidos os campos do JsonPlaceHolderMap
    Quando forem alterados os campos do JsonPlaceHolderMap
      | nome  | Jonatas |
      | idade |      29 |
    E for realizado uma requisicao do tipo post do JsonPlaceHolderMap
    Entao o sistema devolve o satus 201
    E o sistema devolve o campo "nome" com o valor "Jonatas"
    E o sistema devolve o campo "idade" com o valor "29"
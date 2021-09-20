#language: pt
Funcionalidade: JsonPlaceHolder com Token

  Contexto: 
    Quando for realizado uma requisicao do tipo post do token e o token e armazenado

  @JsonPlaceHolder
  Cenario: Valida JsonPlaceHolder
    Dado que seja preenchidos os campos do JsonPlaceHolder
    Quando forem alterados os campos do JsonPlaceHolder
      | nome  | Jonatas |
      | idade |      29 |
    Quando for realizado uma requisicao do tipo post do JsonPlaceHolder
    Entao o sistema devolve o satus 201
    E o sistema devolve o campo "nome" com o valor "Jonatas"
    E o sistema devolve o campo "idade" com o valor "29"
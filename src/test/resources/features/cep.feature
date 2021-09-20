#language: pt
@GetCep
Funcionalidade: Get CEP

  @ValidaCep
  Cenario: Realiza Consulta Cep
    Dado que seja recebido um cep valido com o valor "04055041"
    Quando seja realizado uma requisicao do tipo get do cep

  Cenario: Valida Logradouro Cep
    Entao o sistema devolve o campo "logradouro" com o valor "Rua Mauro"

  Cenario: Valida Bairro Cep
    Entao o sistema devolve o campo "bairro" com o valor "Saúde"

  Cenario: Valida Status Code Cep
    Entao o sistema devolve o satus 200

  Cenario: Valida Quantidade Caracteres do Cep
    Entao o campo "cep" devera retornar com 9 caracteres

  @ValidaCep
  Esquema do Cenario: Realiza Consulta Cep com Esquema <cenario>
    Dado que seja recebido um cep valido com o valor "<cep>"
    Quando seja realizado uma requisicao do tipo get do cep
    Entao o sistema devolve o campo "logradouro" com o valor "<logradouro>"
    E o sistema devolve o campo "bairro" com o valor "<bairro>"
    E o sistema devolve o satus 200

    Exemplos: 
      | cenario | cep      | logradouro       | bairro        |
      | CEP 1   | 04055041 | Rua Mauro        | Saúde         |
      | CEP 2   | 07270300 | Rua Feira Grande | Jardim Brasil |
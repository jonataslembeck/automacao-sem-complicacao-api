#language: pt

Funcionalidade: Token
	@efetuarLogin
	Cenario: Efetuar Login
		Dado que sejam preenchidos os campos para autenticacao
		Quando for realizado uma requisicao do tipo post do token
		Entao o valor do token e armazenado
		
	@efetuarLoginCompleto
	Cenario: Efetuar Login passo unico
		Quando for realizado uma requisicao do tipo post do token e o token e armazenado
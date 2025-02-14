A API desenvolvida tem como objetivo criar um sistema, no back-end, onde é possível criar/abrir pautas e votar nessas pautas.

Foi utilizado SpringBoot 3.4.2 e Java 22.

EndPoints:

/pautas -> Criação das pautas
 -> POST que recebe como body: titulo e descricao.

 
/sessoes/{pautaId} -> Abertura das pautas para iniciar a votação.
 -> POST que recebe como parametro na URL o ID da pauta a ser tratatada e o tempo de duração dela, caso não seja passado nenhum valor de duração, o tempo default é um minuto.


/validar-cpf/{cpf} -> Valida o CPF.
 -> GET que recebe como parametro na URL o CPF sem pontos, apenas números. Se trata de um fake client onde valida o CPF e gera de forma aleatório se está apto ou não para votar.


/votos -> Registro dos votos
 -> POST que recebe como body: 
      sessaoVotacaoId, 
      associadoId, 
      voto(que é um boolean, sendo true(SIM) e false(NÃO))
  Ex: {
        "sessaoVotacaoId":"2",
        "associadoId":"1",
        "voto": true
      }

      
/votos/{pautaId}/resultado
  -> GET que retorna resultado da votação e recebe como parametro na URL o ID da pauta;

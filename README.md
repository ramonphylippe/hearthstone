# hearthstone

Para executar a aplicação:
- Apenas importar no eclipse ou IDE de preferencia, como projeto spring;
- Verificar aguardar o maven atualizar os repositórios;
- executar como aplicação java ou spring apontando a classe "HearthstoneApplication" como principal;

Utilização: 
- Adicionar consultar todas as cartas -> http://localhost:8080/hearthstone/carta/ "GET"
- Buscar uma carta especifica -> http://localhost:8080/hearthstone/carta/{id} "GET"
- Adicionar uma carta* -> http://localhost:8080/hearthstone/carta/ "POST"
- Excluir uma carta -> http://localhost:8080/hearthstone/carta/{id} "DELETE"

OBS1*: No body da requisição passar um Json no seguinte padrão:
```
{
    "nome": "String",
    "descricao": "String",
    "ataque": int,
    "defesa": int,
    "tipo": "ENUM",
    "classe": "ENUM"
}
```
OBS2*: Os enum aceitos são:
- tipo -> "MAGIA","CRIATURA",null
- classe - "MAGO","PALADINO", "DRUIDA", "QUALQUER",null

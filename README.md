# Enlace
API do projeto Enlace - Organização e Planejamento de Casamentos

## Integrantes
Camila Cunha RM551785

Nina Rebello RM99509

## Tarefas

- [ ] CRUD de Empresas
- [ ] CRUD de Serviços
- [ ] CRUD de Usuários

## Documentação da API

### Endpoints
- [Listar Todas as Empresas](#Listar-todas-as-empresas)
- [Cadastrar Empresa](#Cadastrar-empresa)
- [Detalhes da Empresa](#Detalhes-da-empresa)
- [Remover Empresa](#Remover-empresa)
- [Atualizar Empresa](#Atualizar-empresa)


## Listar Todas as Empresas

`GET` /empresa

Retorna um array com todas as empresas

### Exemplo de Resposta

```js
[
    { 
        "id": 1,
        "nome": "Buffet Afrikan House",
        "imagem": "buffet_afrikan"
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados das empresas foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar

---

### Cadastrar empresa

`POST` /empresa

Criar um novo anúncio com os dados enviados no corpo da requisão.

#### Corpo da requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome da empresa que está anunciando.
|imagem|string|✅|O nome da imagem de acordo com a biblioteca Material Images

```js
{
    "nome": "Buffet Afrikan House",
    "imagem": "buffet_afrikan"
}
```

#### Exemplo de resposta
```js
{   
    "id": 1,
    "nome": "Buffet Afrikan House",
    "imagem": "buffet_afrikan"
}
```

#### Código de Status

|código|descrição|
|------|---------|
|201|Empresa cadastrada com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar

---

## Detalhes da Empresa

`GET` /empresa/`{id}`

Retorna os detalhes da empresa com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /empresa/1

{
    "id": 1,
    "nome": "Buffet Afrikan House",
    "imagem": "buffet_afrikan"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da empresa foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe empresa com o `id` informado

___

### Remover Empresa

`DELETE` /empresa/`{id}`

Apaga a empresa com o `id` especificado no parâmetro path.

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da empresa foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe empresa com o `id` informado

___


### Atualizar Empresa

`PUT` /empresa/`{id}`

Altera os dados da empresa especificada no `id`, ultilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome da empresa que está anunciando.
|imagem|string|✅|O nome da imagem de acordo com a biblioteca Material Images

```js
{
    "id": 1,
    "nome": "Buffet Afrikan House",
    "imagem": "buffet_afrikan"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da empresa foram retornados com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar
|404|Não existe empresa com o `id` informado

___

> ### Épico de Produto

A ideia desse arquivo é trazer uma mini-documentação que ira auxiliar o desenvolvedor durante o desenvolvimento das funciondalides do projeto.

Campos para criação de um produto.
- id
- title(unique)*
- price *
- zipcode*(unique)
- seller*
- thubmail 
- date *

 > #### Requisitos Funcionais
* [ ] O sistema deve ser permitir que o usuário possa cadastrar um produto.
* [ ] O sistema deve listar todos os produtos páginados.

> #### Requisitos não Funcionais
* [ ] O sistema não deve cadastrar um produto com o mesmo titulo.
* [ ] O sistema não deve permitir que o usuário cadastre um produto com titulo vázio.
* [ ] O sistema não deve cadastrar um produto com o preço inválido.
* [ ] O sistema não deve cadastrar um produto com um zipcode duplicado.
* [ ] O sistema não deve cadastrar um produto com um seller vazio ou nulo.
* [ ] O sistema não deve cadastrar um produto com  um data vázio um nula.
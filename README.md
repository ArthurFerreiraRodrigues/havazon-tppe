# TPPE 2024.1 - Havazon

https://github.com/andrelanna/fga0242

Alunos:

200056981 - Arthur Ferreira Rodrigues<br>
190084731 - Augusto Durães Camargo<br>
190084600 - Arthur José Nascimento de Lima<br>
190027355 - Erick Melo Vidal de Oliveira


## Refatoracoes TP1

| Grupo | Operação de Refatoração             | Classe / Método         |
|:-----:|:------------------------------------|:------------------------|
|   8   | Extrair método                      | VendaModel::VendaModel()|
|       | Extrair classe                      | ClienteModel            |
|       | Substituir método por objeto-método | VendaModel::calculaCashback() |

### Extrair método

### Extrair classe 

### Substituir método por objeto-método

Descricao: é uma refatoracao utilizada em situações onde um método se torna muito complexo, grande ou difícil de entender. Em vez de manter toda a lógica dentro de um único método, essa refatoracao sugere a criação de uma nova classe para encapsular o método e seu comportamento associado.

#### Codigo refatorado:

Atraves dos commit abaixo podemos ver o metodo calculaCashback() na classe VendaModel desaparecendo, e surgindo e dando origem a uma classe chamada Cashback que lida com o calculo do cashback, bem como seus respectivos testes sendo atualizados e incrementados.

https://github.com/ArthurFerreiraRodrigues/havazon-tppe/commit/e06f46267d1e3661c8c90de033d07b25ae050145

## TP2 

O tp2 se encontra no root do repositorio pelo nome de Tp2 - Grupo 8.pdf

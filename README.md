# TPPE 2024.1 - Havazon

https://github.com/andrelanna/fga0242

Alunos:

200056981 - Arthur Ferreira Rodrigues<br>
190084731 - Augusto Durães Camargo<br>
190084600 - Arthur José Nascimento de Lima<br>
190027355 - Erick Melo Vidal de Oliveira

# TP2

De acordo com a atividade proposta, seguem abaixo as repostas para cada questão do TP2.

## Questão 1

Com base no enunciado providenciado, abaixo estão descritos os princípios de bom código, bem como sua respectiva definição e relação com os maus-cheiros de código apresentados por Fowler.

### 1. Simplicidade
Definição: Um código simples é direto, sem elementos ou complexidades desnecessárias. A simplicidade facilita a compreensão e manutenção do código, reduzindo a probabilidade de erros.


#### Relação com maus-cheiros de código:

Complexidade Acidental (Complexity): Um código excessivamente complicado, cheio de detalhes desnecessários, torna-se difícil de entender e manter. Refatorações como "Simplify Conditionals" ajudam a reduzir a complexidade, promovendo simplicidade.
Código Repetido (Duplicated Code): A presença de código duplicado é um sinal de que a solução pode ser simplificada. Refatorar o código para eliminar duplicações melhora a simplicidade.

### 2. Elegância

Definição: Um código elegante é aquele que, além de resolver o problema de maneira eficaz, o faz de uma maneira que é esteticamente agradável, clara e eficiente.


#### Relação com maus-cheiros de código:

Código Mal Organizado (Disorganized Code): Código desorganizado ou confuso carece de elegância. Refatorar para melhorar a organização e clareza promove a elegância.
Nomeação Pobre (Poor Naming): Nomes inadequados ou confusos para variáveis, funções ou classes comprometem a elegância do código. Renomear elementos para refletir seu propósito real é uma forma de melhorar a elegância.

### 3. Modularidade

Definição: A modularidade é a divisão do sistema em módulos distintos, cada um com uma responsabilidade específica. Isso facilita a manutenção e permite que diferentes partes do sistema evoluam de forma independente.


#### Relação com maus-cheiros de código:

Classes Muito Grandes (Large Class): Classes que fazem muitas coisas ao mesmo tempo são um sinal de baixa modularidade. Refatorações como "Extract Class" ajudam a dividir essas classes em módulos menores e mais coesos.
Métodos Longos (Long Method): Métodos longos e complexos devem ser divididos em métodos menores e mais modulares, facilitando a compreensão e reutilização do código.

### 4. Boas Interfaces

Definição: Boas interfaces definem contratos claros para a interação entre diferentes partes do sistema, permitindo que módulos e componentes se comuniquem de maneira consistente e previsível.


#### Relação com maus-cheiros de código:

Interface Excessivamente Complexa (Excessive Interface Complexity): Interfaces que são complicadas demais para serem entendidas ou usadas corretamente. Simplificar e esclarecer as interfaces torna o código mais acessível e fácil de manter.
Inconsistência na Interface (Inconsistent Naming/Usage): A falta de consistência em como as interfaces são definidas e usadas pode causar confusão. Refatorar para garantir consistência ajuda a manter interfaces claras e robustas.

### 5. Extensibilidade

Definição: Um código extensível é projetado de forma que novas funcionalidades possam ser adicionadas com o mínimo de impacto nas partes existentes do sistema.


#### Relação com maus-cheiros de código:

Código Rígido (Rigidity): Código que é difícil de modificar ou estender sem causar problemas em outras partes do sistema. Aplicar o princípio "Open/Closed" pode ajudar a promover a extensibilidade.
Dependências Enredadas (Tangled Dependencies): Quando diferentes partes do código são fortemente acopladas, torna-se difícil fazer mudanças ou adições. Refatorar para reduzir o acoplamento e aumentar a coesão promove a extensibilidade.

### 6. Evitar Duplicação
Definição: Duplicação de código é quando trechos de código semelhantes ou idênticos aparecem em vários lugares. Evitar duplicação ajuda a manter o código mais fácil de manter e menos propenso a erros.


#### Relação com maus-cheiros de código:

Código Repetido (Duplicated Code): Quando o mesmo código aparece em múltiplos lugares, torna-se mais difícil de manter e propenso a erros. Refatorações como "Extract Method" ou "Extract Class" são formas de eliminar duplicação.
Viés de Copiar e Colar (Copy-Paste Programming): Reutilizar código por meio de copiar e colar em vez de abstrair a lógica repetida em um único local aumenta a complexidade e o risco de inconsistências. Refatorar para remover essa duplicação melhora a qualidade do código.

### 7. Portabilidade

Definição: Portabilidade refere-se à capacidade do código de ser executado em diferentes ambientes ou plataformas com pouca ou nenhuma modificação.


#### Relação com maus-cheiros de código:

Dependência de Plataforma (Platform Dependency): Código que depende fortemente de características específicas de uma plataforma limita sua portabilidade. Refatorar para abstrair dependências específicas pode aumentar a portabilidade do código.
Configuração de Caminho Absoluto (Hard-Coded Paths): Caminhos ou valores específicos de uma plataforma que estão codificados no sistema comprometem a portabilidade. Refatorar para usar caminhos relativos ou configuráveis melhora a portabilidade.

### 8. Código Idiomático e Bem Documentado

Definição: Código idiomático segue as convenções e melhores práticas da linguagem de programação em uso. Documentação clara e concisa é crucial para garantir que outros desenvolvedores possam entender e manter o código.


#### Relação com maus-cheiros de código:

Código Esotérico (Obscure Code): Código que é difícil de entender devido à sua complexidade ou falta de clareza. Refatorar para seguir práticas idiomáticas e adicionar documentação pode ajudar a tornar o código mais acessível.
Comentário Supérfluo (Redundant Comment): Comentários que explicam o óbvio ou que se tornam obsoletos podem ser um sinal de que o código precisa ser simplificado ou melhor nomeado. Comentários devem ser informativos e necessários, não substituindo a clareza do código em si.

## Questão 2

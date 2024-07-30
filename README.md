<h1 align="center">Registro de Exemplares Avistados</h1>

<p align="center">Este sistema permite o gerenciamento de avistamentos e capturas de exemplares, fornecendo uma estrutura clara para a classificação e registro de informações detalhadas sobre os animais avistados</p>

<h2 align="center">Funcionalidades</h2>

<h3>Principais Funcionalidades</h3>
<ul>
    <li><strong>Registro de Avistamentos:</strong> Registre quando e onde um exemplar foi avistado, juntamente com detalhes como peso e comprimento.</li>
    <li><strong>Gerenciamento de Exemplares:</strong> Mantenha um histórico de todos os avistamentos e medições de cada exemplar.</li>
    <li><strong>Classificação Taxonômica:</strong> Classifique exemplares em Espécies, Gêneros e Famílias para uma melhor organização.</li>
</ul>

<h2 align="center">Estrutura do Sistema</h2>

<h3>Classes Principais</h3>

<h4>Usuario</h4>
<p>Representa um usuário do sistema.</p>

**Métodos:**
- `criaRegistro(dh: Date, e: Exemplar, p: float, c: float, d: String, m: Municipio)`: Cria um registro para um exemplar existente no sistema. Instancia um `Registro` com a data e hora (`dh`), peso (`p` ou 0 se não houver pesagem), comprimento (`c` ou 0 se não houver medição), município (`m`), e descrição (`d`). Associa o `Registro` ao `Exemplar` e ao `Usuario`. Retorna o `Registro` instanciado.
- `listRegistro()`: Retorna uma lista de todos os registros do `Usuario`.

<h4>Registro</h4>
<p>Representa o registro/avistamento efetuado para um exemplar.</p>

**Atributos:**
- Data e hora do registro/avistamento
- Peso ou zero caso não tenha sido realizada a pesagem
- Comprimento ou zero caso não tenha sido realizada a medição
- Município onde foi avistado o exemplar
- Descrição do avistamento/registro (opcional)

**Métodos:**
- `getUsuario()`: Retorna o `Usuario` que efetuou o registro.
- `getExemplar()`: Retorna o `Exemplar` ao qual se refere o registro.
- `getMunicipio()`: Retorna o `Municipio` ao qual se refere o registro.
- `setUsuario(u: Usuario)`: Efetiva a navegabilidade `Registro->Usuario`.
- `setExemplar(e: Exemplar)`: Efetiva a navegabilidade `Registro->Exemplar`.
- `setMunicipio(m: Municipio)`: Efetiva a navegabilidade `Registro->Municipio`.

<h4>Exemplar</h4>
<p>Representa um exemplar avistado.</p>

**Atributos:**
- ID
- Descrição

**Métodos:**
- `getEspecie()`: Retorna a `Especie` do exemplar.
- `listRegistro()`: Retorna uma lista com todos os registros (avistamentos) feitos para o exemplar.
- `listMunicipio()`: Retorna uma lista com todos os municípios que tenham registro para o exemplar.
- `getPesoAtual()`: Retorna o peso atual do exemplar, ou seja, o registro mais atual do peso, que tenha valor maior que zero.
- `getComprimentoAtual()`: Retorna o comprimento atual do exemplar, ou seja, o registro mais atual do comprimento, que tenha valor maior que zero.
- `addRegistro(r: Registro)`: Efetiva a navegabilidade `Exemplar->Registro`.
- `setEspecie(e: Especie)`: Efetiva a navegabilidade `Exemplar->Especie`.

<h4>Municipio</h4>
<p>Representa um município onde os exemplares são avistados. Contém atributos triviais, getters e setters.</p>

<h4>Estado</h4>
<p>Representa um estado. Contém atributos triviais, getters e setters.</p>

<h4>Especie</h4>
<p>Representa uma espécie, que contém vários exemplares.</p>

**Métodos:**
- `listExemplar()`: Retorna uma lista com todos os exemplares associados a esta `Especie`.
- `addExemplar(e: Exemplar)`: Efetiva a navegabilidade `Especie->Exemplar`.

<h4>Genero</h4>
<p>Representa um gênero, que contém várias espécies. Contém atributos triviais, getters e setters.</p>

<h4>Familia</h4>
<p>Representa uma família, que contém vários gêneros. Contém atributos triviais, getters e setters.</p>

<h2 align="center">Diagrama de Classes</h2>

<p align="center">
  <img src="./assets/diagramaClassRegistroAnimais.png" alt="Diagrama de Classes">
</p>

<h2>Como Executar</h2>

<ol>
    <li>Implemente as classes em Java conforme descrito.</li>
    <li>Utilize os métodos fornecidos para criar usuários, registrar avistamentos, e consultar registros e informações de exemplares.</li>
    <li>Garanta que todos os relacionamentos e navegabilidades estejam corretamente implementados conforme o diagrama de classes.</li>
</ol>

<h3> Documento Explicativo da Base de Dados de Registro de Animais </h3>

#### Visão Geral
Esta base de dados é projetada para gerenciar o registro de animais, incluindo informações sobre usuários, estados, municípios, famílias, gêneros, espécies, exemplares e registros de avistamentos.

#### Estrutura da Base de Dados

##### 1. Cadastro de Usuários
Os usuários são responsáveis pelo registro e gestão dos dados no sistema. Abaixo estão os usuários cadastrados:

- **Usuário 1**:
  - Login: banco
  - Senha: 123b
  - Nome: Banco

- **Usuário 2**:
  - Login: admin
  - Senha: 123a
  - Nome: Administrador

##### 2. Cadastro de Estados
Os estados representam as unidades federativas onde os municípios e registros estão localizados. Abaixo estão os estados cadastrados:

- **Estado 1**: Rio Grande do Sul (RS)
- **Estado 2**: Santa Catarina (SC)
- **Estado 3**: Paraná (PR)

##### 3. Cadastro de Municípios
Os municípios são as localidades específicas dentro dos estados onde os registros de animais são feitos. Abaixo estão os municípios cadastrados:

- **Município 1**: Gravataí (RS)
- **Município 2**: Florianópolis (SC)
- **Município 3**: Porto Alegre (RS)
- **Município 4**: Curitiba (PR)

##### 4. Cadastro de Famílias
As famílias representam grupos de gêneros de animais. Abaixo estão as famílias cadastradas:

- **Família 1**: Felidae
  - Descrição: Família de felinos, como leões, tigres e gatos.
  
- **Família 2**: Canidae
  - Descrição: Família de canídeos, como cães, lobos e raposas.

##### 5. Cadastro de Gêneros
Os gêneros representam subgrupos dentro das famílias. Abaixo estão os gêneros cadastrados:

- **Gênero 1**: Panthera
  - Descrição: Gênero que inclui leões, tigres, leopardos e onças.
  - Família: Felidae

- **Gênero 2**: Lynx
  - Descrição: Gênero que inclui linces.
  - Família: Felidae

- **Gênero 3**: Canis
  - Descrição: Gênero que inclui cães e lobos.
  - Família: Canidae

##### 6. Cadastro de Espécies
As espécies são subgrupos dentro dos gêneros. Abaixo estão as espécies cadastradas:

- **Espécie 1**: Panthera leo (Leão)
  - Descrição: Leão.
  - Gênero: Panthera

- **Espécie 2**: Lynx pardinus (Lince-ibérico)
  - Descrição: Lince-ibérico.
  - Gênero: Lynx

- **Espécie 3**: Canis lupus (Lobo)
  - Descrição: Lobo.
  - Gênero: Canis

##### 7. Cadastro de Exemplares
Os exemplares representam animais específicos dentro das espécies. Abaixo estão os exemplares cadastrados:

- **Exemplar 1**: 
  - Identificação: 1
  - Nome: Leo
  - Espécie: Panthera leo (Leão)

- **Exemplar 2**: 
  - Identificação: 2
  - Nome: Lince
  - Espécie: Lynx pardinus (Lince-ibérico)

- **Exemplar 3**: 
  - Identificação: 3
  - Nome: Canis lupus
  - Espécie: Canis lupus (Lobo)

##### 8. Cadastro de Registros
Os registros documentam avistamentos de exemplares em diferentes municípios e são realizados por diferentes usuários. Abaixo estão os registros cadastrados:

- **Registro 1**: 
  - Usuário: Banco
  - Data: [Data do registro]
  - Exemplar: Leo (Leão)
  - Peso: 190.2 kg
  - Altura: 1.70 m
  - Observação: Avistamento inicial de Leo
  - Município: Gravataí (RS)

- **Registro 2**: 
  - Usuário: Banco
  - Data: [Data do registro]
  - Exemplar: Leo (Leão)
  - Peso: 187.5 kg
  - Altura: 1.75 m
  - Observação: Segundo avistamento de Leo
  - Município: Gravataí (RS)

- **Registro 3**: 
  - Usuário: Banco
  - Data: [Data do registro]
  - Exemplar: Lince (Lince-ibérico)
  - Peso: 25.3 kg
  - Altura: 0.97 m
  - Observação: Primeiro avistamento de Lince
  - Município: Florianópolis (SC)

- **Registro 4**: 
  - Usuário: Administrador
  - Data: [Data do registro]
  - Exemplar: Canis lupus (Lobo)
  - Peso: 30.5 kg
  - Altura: 0.80 m
  - Observação: Primeiro avistamento de Canis lupus
  - Município: Curitiba (PR)

#### Conclusão
Este documento descreve a base de dados de registro de animais, incluindo detalhes sobre usuários, estados, municípios, famílias, gêneros, espécies, exemplares e registros de avistamentos. Cada entidade é cuidadosamente registrada para assegurar a correta gestão e acompanhamento dos dados dos animais.
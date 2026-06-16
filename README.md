# 📚 Sistema de Biblioteca — UCB

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

## 📖 Sobre o Projeto

Sistema de gerenciamento de biblioteca desenvolvido como projeto final da disciplina de **Programação Orientada a Objetos** na **Universidade Católica de Brasília (UCB)**.

O sistema permite cadastrar livros e usuários, realizar e controlar empréstimos com persistência de dados em banco SQLite, aplicando na prática os principais padrões e pilares da POO.

---

## ✅ Funcionalidades

- **Cadastro de Livros** — registra título, categoria e disponibilidade no banco de dados
- **Cadastro de Usuários** — suporte a dois perfis: Aluno (limite de 3 livros) e Professor (limite de 5 livros)
- **Empréstimo de Livros** — valida disponibilidade do livro e limite do usuário antes de registrar
- **Devolução de Livros** — restaura a disponibilidade do livro e remove o empréstimo do banco
- **Listagem de Livros** — exibe todo o acervo com status de disponibilidade
- **Listagem de Empréstimos** — exibe todos os empréstimos ativos com livro e usuário vinculados
- **Persistência com SQLite** — todos os dados são salvos no arquivo `biblioteca.db`

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 17+ | Linguagem principal |
| SQLite | Banco de dados local (`biblioteca.db`) |
| JDBC | Conexão Java ↔ SQLite |
| IntelliJ IDEA | IDE de desenvolvimento |
| Git & GitHub | Versionamento |

---

## 🏗️ Arquitetura e Estrutura

O projeto segue uma arquitetura em camadas com separação clara de responsabilidades:

```
src/
├── Main.java                          # Ponto de entrada — menu interativo
│
├── DataBase/
│   └── DataBaseConnection.java        # Singleton — conexão com o banco SQLite
│
├── Model/
│   ├── Estandes.java                  # Classe base (id, categoria, disponibilidade)
│   ├── Livro.java                     # Herda de Estandes; adiciona título
│   ├── Usuario.java                   # Classe abstrata com limite de livros
│   ├── Aluno.java                     # Subclasse — limite: 3 livros
│   ├── Professor.java                 # Subclasse — limite: 5 livros
│   ├── Emprestimo.java                # Relacionamento entre Livro e Usuario
│   └── AcoesMenu.java                 # Lógica de interação com o menu
│
├── Repository/
│   ├── LivroRepository.java           # Interface — contrato de operações de Livro
│   ├── LivroRepositorySQLite.java     # Implementação SQLite de LivroRepository
│   ├── UsuarioRepository.java         # Interface — contrato de operações de Usuario
│   ├── UsuarioRepositorySQLite.java   # Implementação SQLite de UsuarioRepository
│   ├── EmprestimoRepository.java      # Interface — contrato de operações de Emprestimo
│   └── EmprestimoRepositorySQLite.java# Implementação SQLite de EmprestimoRepository
│
├── Factory/
│   └── UsuarioFactory.java            # Factory — cria Aluno ou Professor pelo tipo
│
└── Service/
    └── Biblioteca.java                # Regras de negócio (empréstimo, devolução, validações)
```

---

## 🧩 Padrões de Projeto Aplicados

### 🔒 Singleton — `DataBaseConnection`
Garante que **apenas uma conexão** com o banco SQLite seja criada durante toda a execução. Todos os repositórios compartilham essa mesma instância via `DataBaseConnection.getInstance()`.

### 📋 Interface — `Repository`
Três interfaces (`LivroRepository`, `UsuarioRepository`, `EmprestimoRepository`) definem os **contratos** de persistência. As classes `...SQLite` implementam esses contratos, permitindo trocar o banco de dados futuramente sem alterar o restante do código.

### 🏭 Factory — `UsuarioFactory`
Centraliza a criação de objetos `Usuario`. Com base no campo `tipo` salvo no banco (`"ALUNO"` ou `"PROFESSOR"`), a factory instancia a subclasse correta com o limite de livros correspondente.

---

## 🧱 Pilares da POO

| Pilar | Onde foi aplicado |
|---|---|
| **Encapsulamento** | Atributos privados com getters/setters em todas as classes de modelo |
| **Herança** | `Livro` herda de `Estandes`; `Aluno` e `Professor` herdam de `Usuario` |
| **Polimorfismo** | `UsuarioFactory` retorna `Usuario` e os repositórios tratam objetos pelo tipo da interface |
| **Abstração** | `Usuario` é classe abstrata; `LivroRepository`, `UsuarioRepository` e `EmprestimoRepository` são interfaces |

---

## 🗄️ Banco de Dados

O arquivo `biblioteca.db` (SQLite) contém as seguintes tabelas:

```sql
-- Armazena os livros do acervo
CREATE TABLE livro (
    id        INTEGER PRIMARY KEY,
    categoria TEXT NOT NULL,
    titulo    TEXT NOT NULL,
    disponivel INTEGER NOT NULL
);

-- Armazena os usuários (Aluno ou Professor)
CREATE TABLE usuario (
    id   INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    tipo TEXT NOT NULL  -- 'ALUNO' ou 'PROFESSOR'
);

-- Registra os empréstimos ativos
CREATE TABLE emprestimo (
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    livro_id   INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL
);
```

---

## 🚀 Como Executar

**Pré-requisitos:** JDK 17 ou superior instalado.

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/BibliotecaJV.git
   ```

2. Abra a pasta do projeto no **IntelliJ IDEA**.

3. Verifique em *File → Project Structure* que o JDK está configurado (versão 17+).

4. Execute a classe `Main.java`.

> ⚠️ O arquivo `biblioteca.db` deve estar na **raiz do projeto** (mesmo nível que `src/`). Ele é criado automaticamente pelo SQLite se não existir.

---

## 📋 Menu do Sistema

```
1 - Cadastrar Livro
2 - Cadastrar Usuário
3 - Emprestar Livro
4 - Devolver Livro
5 - Listar todos os Livros
6 - Listar Empréstimos
0 - Sair
```

---

Desenvolvido por **Jackson Junio Xavier Franco** 🎓  
Estudante de Análise e Desenvolvimento de Software — Universidade Católica de Brasília  
Status: **Concluído ✅**

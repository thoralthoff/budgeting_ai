# 💶​ Budgeting AI

<br>
Uma Aplicação de gerenciamento financeiro com integração de Inteligência Artificial, desenvolvida com Java e Spring Boot.<br><br>

O **Budgeting AI** utiliza inteligência artificial para tornar o registro e a consulta de informações financeiras mais naturais, permitindo que a pessoa usuária interaja com o sistema por meio de comandos de voz.<br><br>


## 🔄 Fluxo principal da aplicação
<br>
O funcionamento da aplicação é baseado na interação por áudio, utilizando inteligência artificial para interpretar comandos e executar operações financeiras, ocorrendo da seguinte forma:<br><br>

1. **Recebimento do áudio:** a aplicação recebe um arquivo de áudio enviado pela pessoa usuária.<br><br>
2. **Transcrição:** o áudio é convertido em texto utilizando o modelo Whisper da OpenAI.<br><br>
3. **Interpretação com IA:** o texto é analisado pelo GPT-4o-mini para identificar a intenção do comando.<br><br>
4. **Execução da função:** com base na intenção identificada, a aplicação executa uma função correspondente.<br><br>
5. **Operações financeiras:** são realizadas ações como criar ou consultar transações financeiras.<br><br>
6. **Resposta ao usuário:** a aplicação gera uma resposta final, que pode ser convertida em áudio para informar o resultado da operação.<br><br>

Esse fluxo permite que a pessoa usuária registre e consulte informações financeiras de maneira simples e intuitiva, utilizando a própria voz.<br><br>

## 🚀 Tecnologias utilizadas
<br>São:<br><br>
- **Java 25:** linguagem principal do projeto.<br><br>
- **Spring Boot 4.1.2:** framework para desenvolvimento do backend.<br><br>
- **Spring AI 2.0.0-M4:** integração com modelos de inteligência artificial.<br><br>
- **OpenAI GPT-4o-mini:** interpretação de comandos e processamento de linguagem natural.<br><br>
- **OpenAI Whisper:** transcrição de áudio em texto.<br><br>
- **OpenAI GPT-4o-mini-TTS:** geração de respostas em áudio.<br><br>
- **Spring Data JPA:** persistência e acesso aos dados.<br><br>
- **Hibernate:** mapeamento objeto-relacional (ORM).<br><br>
- **MySQL:** banco de dados relacional.<br><br>
- **Docker:** execução e gerenciamento do ambiente do banco de dados.<br><br>
- **Gradle:** gerenciamento de dependências e build.<br><br>
- **SpringDoc OpenAPI:** documentação dos endpoints da API.<br><br><br>

## 🤖 Integração com Inteligência Artificial

<br>A aplicação utiliza o Spring AI para integrar os serviços da OpenAI.<br><br>

### Processamento de texto

- Integração com GPT-4o-mini para processamento de linguagem natural.<br><br>
- Interpretação da intenção dos comandos enviados pela pessoa usuária.<br><br>
- Configuração de respostas em formato textual.<br><br><br>

### Transcrição de áudio

- Integração com Whisper (`whisper-1`).<br><br>
- Reconhecimento de áudio em português.<br><br>
- Configuração orientada a descrições de despesas financeiras.<br><br><br>

### Geração de áudio

- Integração com GPT-4o-mini-TTS.<br><br>
- Voz configurada como `nova`.<br><br>
- Saída de áudio no formato MP3.<br><br><br>

## ⚙️ Configuração e execução

### Pré-requisitos

- Java 25 ou superior.<br><br>
- Docker e Docker Compose.<br><br>
- Chave de API da OpenAI.<br><br>
- Git.<br><br><br>

### 1. Clone o repositório

```bash
git clone https://github.com/thoralthoff/budgeting_ai.git

cd budgeting_ai
```

### 2. Configure a variável de ambiente

Configure sua chave da OpenAI:

```bash
export OPENAI_API_KEY="sua-chave-api"
```

### 3. Execute a aplicação

Com o banco de dados MySQL em execução no Docker e as configurações de conexão definidas no `application.properties`, execute:

```bash
./gradlew bootRun
```

No Windows, utilize:

```bash
gradlew.bat bootRun
```
<br>

## 📚 Documentação da API

<br>O projeto utiliza SpringDoc OpenAPI para documentar os endpoints. A documentação interativa permite visualizar as operações disponíveis, consultar os formatos de requisição e testar os endpoints diretamente pelo navegador.<br><br>

Com a aplicação em execução, acesse:
<br>
```text
http://localhost:8080/swagger-ui/index.html
```
<br><br>
### Endpoints disponíveis

<br>Os endpoints estão organizados no `transaction-controller` e permitem criar, consultar e registrar transações utilizando inteligência artificial.<br>

### 1. Criar uma transação

**POST** `/transactions`

Permite cadastrar uma nova transação financeira enviando os dados em formato JSON.

Exemplo de requisição:

```json
{
  "description": "Compra no supermercado",
  "category": "GROCERIES",
  "amount": 150.50
}
```

A aplicação retorna os dados da transação criada, incluindo seu identificador, com o status HTTP `201 Created`.

O parâmetro `category` deve receber um dos seguintes valores:

- `GROCERIES` – despesas com mercado e alimentação.
- `PHARMA` – despesas com farmácia.
- `AUTO` – despesas relacionadas a automóveis.<br><br>

### 2. Criar uma transação utilizando IA

**POST** `/transactions/ai`

Permite enviar um arquivo de áudio para que a aplicação interprete a solicitação utilizando inteligência artificial.

- **Content-Type:** `multipart/form-data`
- **Parâmetro:** `file` – arquivo de áudio enviado pelo usuário.
- **Resposta:** áudio no formato MP3 (`audio/mp3`).

A aplicação transcreve o áudio com Whisper, utiliza o GPT-4o-mini para interpretar a solicitação e executar a operação correspondente. O resultado é retornado em áudio.<br><br>

### 3. Consultar transações por categoria

**GET** `/transactions/{category}`

Permite consultar as transações cadastradas de acordo com uma categoria específica.

O parâmetro `category` deve receber um dos seguintes valores:

- `GROCERIES` – despesas com mercado e alimentação.
- `PHARMA` – despesas com farmácia.
- `AUTO` – despesas relacionadas a automóveis.

Exemplo de requisição:

```http
GET /transactions/GROCERIES
```

A aplicação retorna uma lista de transações pertencentes à categoria informada, incluindo identificador, categoria, descrição e valor.

---

Desenvolvido com Java, Spring Boot e Inteligência Artificial.

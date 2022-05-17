# Boas vindas ao repositório do desafio PureJS da Aceleração Java!

Este desafio foi proposto visando a utilização de JAVA puro.

---

## Recomendações para iniciar localmente

1. Clone o repositório
  * Entre no diretório do repositório que você acabou de clonar:

2. Instale as dependências:
    * `mvn install`
    
3. Inicie um banco de dados MongoDB:
    * Para utilização da api é necessário iniciar um serviço do MongoDB (sugiro usar Docker para facilitar)

4. Configuração da api:
    * Edite o arquivo DAO (src/main/java/com/aleilton/DesafioPureJS/model/DAO.java) e altere a variável URI para o caminho do DB (Ex.: "mongodb://user:password:192.168.1.76:27017")

5. Inicie o servidor:
    * `mvn exec:java`
    
6. Inicie os testes:
    * Os testes podem ser realizados utilizando o Postman ou qualquer outro programa de sua preferência, basta utilizar o endereço do servidor e o caminho /api
      * GET  /api
      * POST /api
      * DELETE /api/<id>
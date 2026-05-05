# Gear API

## Descrição

Gear API é uma solução backend focada exclusivamente em segurança, autenticação e controle de acesso.  
A aplicação foi projetada para fornecer uma base robusta para sistemas distribuídos, APIs REST, aplicações web, dispositivos IoT e integrações em rede local ou remota.

A arquitetura prioriza:

- Segurança de autenticação
- Controle granular de permissões
- Escalabilidade
- Integridade de sessões
- Comunicação protegida
- Estrutura modular
- Baixo acoplamento
- Facilidade de expansão

---

# Objetivos da API

A Gear API foi desenvolvida com o propósito de centralizar:

- Autenticação de usuários
- Autorização baseada em papéis (RBAC)
- Gerenciamento de sessões
- Proteção de rotas
- Validação de tokens
- Controle de acesso administrativo
- Integração segura com aplicações externas
- Comunicação segura entre dispositivos e serviços

---

# Principais Recursos

## Segurança

- Autenticação JWT
- Refresh Token
- Controle de expiração de sessão
- Criptografia de senhas
- Proteção de endpoints privados
- Filtros de autenticação customizados
- Spring Security
- Validação robusta de requisições
- Controle de acesso por roles e permissões
- Estrutura preparada para auditoria

---

## Controle de Acesso

- RBAC (Role Based Access Control)
- Perfis administrativos
- Perfis privados
- Perfis públicos
- Separação lógica de rotas
- Endpoints protegidos por autenticação
- Restrição de acesso por rede/IP
- Estrutura preparada para múltiplos níveis de privilégio

---

## Arquitetura

- Java
- Spring Boot
- Spring Security
- JWT
- JPA / Hibernate
- JDBC
- PostgreSQL / MySQL / SQL Server
- WebSocket
- MQTT (estrutura preparada)
- REST API
- Arquitetura modular
- DTO Pattern
- Camada Service
- Repository Pattern
- UUID como identificador principal
- Auditoria de entidades

---

# Estrutura Base do Projeto

```bash
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 ├── config/
 ├── security/
 ├── websocket/
 ├── mqtt/
 ├── exception/
 ├── validation/
 └── util/

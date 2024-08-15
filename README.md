# Aplicação de Lista de Contatos

## Descrição

Esta aplicação de lista de contatos permite ao usuário gerenciar uma lista de contatos. O usuário pode adicionar, visualizar, editar e excluir contatos, além de realizar buscas por nome, número ou email. A aplicação também suporta a adição opcional de fotos pré selecionadas aos contatos.

## Funcionalidades

- **Gerenciamento de Contatos**: Adicione, visualize, edite e exclua contatos.
- **Busca**: Pesquise contatos por nome, número ou email.
- **Fotos** (Opcional): Adicione uma foto ao contato.

## Estrutura dos Contatos

Cada contato possui os seguintes atributos:
- `id`: Identificador único do contato (não visível na interface do usuário).
- `nome`: Nome do contato.
- `número`: Número de telefone do contato.
- `email`: Endereço de email do contato.
- `foto`: Foto do contato (opcional).

## Tecnologias Utilizadas

- **Kotlin**: Linguagem de programação para o desenvolvimento Android.
- **Android Studio**: IDE para desenvolvimento Android.

## Instalação e Execução

1. Clone o repositório:
    ```sh
    git clone https://github.com/viniciuscosta12/ListaTelefonica.git
    ```

2. Abra o projeto no Android Studio.

3. Construa e execute a aplicação no emulador ou dispositivo Android.

## Uso

1. **Adicionar Contato**: Navegue para a tela de adicionar contato e preencha os campos obrigatórios. (Opcionalmente, adicione uma foto ao contato.)
2. **Visualizar Contatos**: Navegue para a tela de contatos para ver a lista de contatos salvos.
3. **Editar Contato**: Selecione um contato da lista e edite suas informações.
4. **Excluir Contato**: Selecione um contato da lista e confirme a exclusão.
5. **Buscar Contato**: Utilize a barra de busca para procurar contatos por nome, número ou email.
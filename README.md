# Projeto Podcast App

## Grupo de Alunos
- Henrique Paulo Bonfim

## Visão Geral do Software
Este aplicativo de podcast foi desenvolvido em Java usando o Android Studio. Ele permite que os usuários logados ouçam podcasts de um servidor públicp. O aplicativo apresenta uma interface de usuário simples com botões de reprodução e pausa, e uma lista de podcasts disponíveis.

## Papéis e Permissões dos Usuários
O aplicativo é destinado a usuários finais que desejam ouvir podcasts. Os usuários podem:

- Visualizar a lista de podcasts disponíveis
- Reproduzir um podcast
- Pausar um podcast

## Requisitos Funcionais

### Usuários
O aplicativo permite a qualquer usuário acessar e ouvir os podcasts disponíveis, desde que logado no aplicativo.

### Entradas Necessárias
O usuário precisa selecionar um podcast da lista para reproduzi-lo.

### Processamento
O aplicativo busca dados de podcast de um servidor usando uma API REST e analisa a resposta JSON. Ele usa a classe `MediaPlayer` do Android para transmitir o podcast selecionado.

### Relatórios e Saídas
O aplicativo não gera relatórios. A saída principal é a reprodução do áudio do podcast que está sendo recebido via HTTP. Além disso, a interface do usuário exibe a lista de podcasts disponíveis e o status atual (reproduzindo/pausado) do podcast selecionado.

## Considerações Finais
Este é um projeto simples e não inclui o tratamento de casos de borda, como a falta de conexão com a internet ou a interrupção da reprodução devido a uma chamada recebida. Esses recursos podem ser adicionados em versões futuras do aplicativo.

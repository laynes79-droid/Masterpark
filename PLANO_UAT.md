# Plano de Teste de Aceitação do Usuário (UAT) - Fase 1

Olá! Como seu **Especialista em Documentação e UX**, preparei este guia para que você possa realizar o Teste de Aceitação do Usuário (UAT) na primeira versão funcional do nosso aplicativo **Gestão de Estacionamento**.

## Objetivo
O objetivo deste UAT é validar se a funcionalidade principal de visualização e adição de veículos está funcionando conforme o esperado, de uma perspectiva do usuário final.

## Pré-requisitos
1.  O projeto foi importado com sucesso no Android Studio.
2.  O aplicativo foi compilado (`build`) e instalado em um emulador ou dispositivo físico Android.

---

## Casos de Teste

Por favor, execute os seguintes cenários de teste e preencha a coluna "Resultado".

### Caso de Teste 1: Visualização da Lista Inicial de Veículos

*   **Objetivo:** Verificar se a tela principal exibe corretamente a lista inicial de veículos.

| Passo a Passo                                            | Resultado Esperado                                                                                             | Resultado (Passou/Falhou) | Comentários |
| -------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------- | ----------- |
| 1. Abra o aplicativo "Gestão de Estacionamento".         | A tela principal é aberta, exibindo o título "Gestão de Estacionamento" e uma lista de veículos.                 |                           |             |
| 2. Verifique os itens na lista.                          | A lista deve conter 3 veículos com placas e modelos diferentes (ex: "BRA2E19", "ABC-1234", etc.), conforme os dados de exemplo. |                           |             |
| 3. Observe o botão de adição.                            | Um botão de `+` (Floating Action Button) deve estar visível no canto inferior direito da tela.                 |                           |             |

### Caso de Teste 2: Adicionar um Novo Veículo com Sucesso

*   **Objetivo:** Verificar se o fluxo de adicionar um novo veículo está funcionando corretamente.

| Passo a Passo                                                              | Resultado Esperado                                                                                                                               | Resultado (Passou/Falhou) | Comentários |
| -------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------- | ----------- |
| 1. Na tela principal, clique no botão `+`.                                 | A tela "Adicionar Veículo" é aberta, com campos para "Placa" e "Modelo", e um botão "Salvar Entrada".                                              |                           |             |
| 2. No campo "Placa", digite `TEST-001`.                                    | O texto `TEST-001` é inserido no campo.                                                                                                          |                           |             |
| 3. No campo "Modelo do Veículo", digite `Carro de Teste`.                  | O texto `Carro de Teste` é inserido no campo.                                                                                                    |                           |             |
| 4. Clique no botão "Salvar Entrada".                                       | A tela "Adicionar Veículo" é fechada e você retorna para a tela principal.                                                                       |                           |             |
| 5. Verifique o topo da lista na tela principal.                            | O novo veículo (`TEST-001`, `Carro de Teste`) deve ser o primeiro item da lista. A hora de entrada deve refletir o momento atual.                 |                           |             |

### Caso de Teste 3: Tentativa de Adicionar Veículo com Campos Vazios

*   **Objetivo:** Verificar se o sistema trata corretamente a tentativa de salvar um novo veículo sem preencher os dados obrigatórios.

| Passo a Passo                                                              | Resultado Esperado                                                                                                                               | Resultado (Passou/Falhou) | Comentários |
| -------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------- | ----------- |
| 1. Na tela principal, clique no botão `+`.                                 | A tela "Adicionar Veículo" é aberta.                                                                                                             |                           |             |
| 2. Deixe os campos "Placa" e "Modelo" vazios.                               | -                                                                                                                                                |                           |             |
| 3. Clique no botão "Salvar Entrada".                                       | Uma mensagem de aviso (Toast) aparece na parte inferior da tela com o texto "Placa e modelo são obrigatórios". Você permanece na tela de adição. |                           |             |

---

Agradecemos a sua colaboração nesta importante fase de validação! Seu feedback é crucial para o sucesso do projeto.

**- Esquadrão JULES**

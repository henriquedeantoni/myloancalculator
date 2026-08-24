# MyLoanCalculator App

MyLoanCalculatorApp é um Aplicativo Android desenvolvido para estimar valor de parcelas de financiamento, investimento e retorno com base nos valores de entrada de taxa de juros, valor de entrada e prazo.

Este repositório faz parte do projeto da disciplina Desenvolvimento de Aplicativos COM-437PT-AVBR1 da Universidade Saint Leo  

## Sobre o Projeto

Aplicativo Android para simulação e cálculo de financiamentos, permitindo estimar o valor das parcelas a partir do montante financiado, entrada, taxa de juros e quantidade de parcelas.
A aplicação consegue estimar e calcular financiamentos e também armazenar no celular estes relatórios. A busca e cálculo é feita de modo simples, intuitivo e organizado.

## Funcionalidades
O objetivo principal do aplicativo é o calculo e simulação de financiamento, com base na informação do montante, entrada, taxa, juros, quantidade de parcelas.
Também será possivel salvar simulações conforme alguns critérios, como nome da simulação, data, montante, data da inclusão e período.

### Visualização das parcelas

Após o cálculo é possível resgatar a simulação e verificar todos os dados do financiamento.

### Salvamento das simulações

Todos os cálculos são possíveis listar na tela de resgate, o salvamento ocorre com a confirmação de um Dialog e sua escolha pelo usuário.

## Telas
A aplicação é composta de 3 telas:

 - principal Home
 - simulação de financiamento
 - resgate de cálculos
   
Exemplo da tela de simulação com os temas padrão e Dark.

<img width="576" height="573" alt="image" src="https://github.com/user-attachments/assets/b2834bf7-795f-4f3a-aff3-18b68e6017fe" />

## Tecnologias Usadas

 - Android Studio
 - Kotlin (regras de negócio e persistência)
 - Java (entidades)
 - Gradle (build e configuração)
 - SQLite (Banco interno e local)

## Compilando o Projeto

Usamos submódulos do Git, portanto, ao fazer o checkout do projeto, você precisará garantir que os submódulos sejam inicializados corretamente. Para isso, você pode usar a opção --recursive ao clonar o projeto.

      git clone --recursive https://github.com/henriquedeantoni/myloancalculator.git

Alternativamente, se ja tiver o projeto em checked out, você pode inicializar manualmente.

    git submodule update --init
    
## License
MyLoanCalculator android é distribuido sobre Apache 2.0 [license](LICENSE).

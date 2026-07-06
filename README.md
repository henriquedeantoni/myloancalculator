# MyLoanCalculator App

MyLoanCalculatorApp é um aplicativo desenvolvido para rodar no Android , este repositório faz parte do projeto da disciplina Desenvolvimento de Aplicativos COM-437PT-AVBR1 da Universidade Saint Leo  
O aplicativo foi desenvolvido para calcular financiamento de valores conforme taxas de financiamento, juros e quantidade de parcelas.

## Funcionalidades
O objetivo principal do aplicativo é o calculo e simulação de financiamento, com base na informação do montante, entrada, taxa, juros, quantidade de parcelas.
Tambem será possivel salvar simulações conforme alguns critérios, como nome da simulação, data.
Tambem está previsto salvamento e exportação da tabela em arquivo .csv.

## Telas
A aplicação é bem simples, composta de 3 telas, a principal Home, e duas outras telas, a de simualção e outra de resgate.
Exemplo da tela de simulação com os temas padrão e Dark.

<img width="576" height="573" alt="image" src="https://github.com/user-attachments/assets/b2834bf7-795f-4f3a-aff3-18b68e6017fe" />


## Compilando o Projeto

Usamos submódulos do Git, portanto, ao fazer o checkout do projeto, você precisará garantir que os submódulos sejam inicializados corretamente. Para isso, você pode usar a opção --recursive ao clonar o projeto.

      git clone --recursive https://github.com/henriquedeantoni/myloancalculator.git

Alternativamente, se ja tiver o projeto em checked out, você pode inicializar manualmente.

    git submodule update --init
    
## License
MyLoanCalculator android é distribuido sobre Apache 2.0 [license](LICENSE).

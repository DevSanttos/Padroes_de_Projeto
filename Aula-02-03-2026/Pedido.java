public class Pedido {

    private double valorBase;
    private String tipoCliente; // "PF" ou "PJ"
    private String formaPagamento; // "avista" ou "parcelado"

    public double calcularValorFinal() {
        double valor = valorBase;

        if (tipoCliente.equals("PF")) {
            if (formaPagamento.equals("avista")) {
                valor -= valor * 0.05;
            }
            valor += valor * 0.08;
        } else if (tipoCliente.equals("PJ")) {
            valor -= valor * 0.10;
            valor += valor * 0.12;
        }

        return valor;
    }
}

/*
Primeira 1:
- Validar o tipo de pessoa
- Validar o tipo de pagamento
- Calcular os descontos e juros
- Calcular o valor final do pedido
- retornar o valor final do pedido
*/

/*
Pergunta 2: 
Basicamente o corpo do código inteiro que envolvem o cálculo ou atribuição de valor a variável 'valor'. Caso estivesse modular, o processo seria mais simples e universal.
*/

/*
Pergunta 3: 
Não, uma vez que temos muitas responsabilidades envolvidas. Ou seja, teríamos que ter vários casos de teste para a mesma classe. O que facilitaria os testes seria a separação das responsabilidades existentes dentro dessa classe.
*/

/*
Pergunta 4: 
Não estão declaradas. São sujestivas e subjetivas. Estão escondidas.
*/

/*
Pergunta 5: 
Se for adicionado um novo cliente se a refatoração do método 'calcularValorFinal', poderíamos ter somente o retorno do valor. Ou seja, ele não cairia nos if's e só teria o valor retornado. Logo, não teria descontos associados.
*/


/*
Pergunta 5: 
Script procedural.
*/
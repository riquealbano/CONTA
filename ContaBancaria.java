public public class ContaBancaria {

    // Atributos privados
    private double saldo;
    private int contadorConsultas;

    // Construtor para inicializar a conta com saldo inicial
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.contadorConsultas = 0;
    }

    // Método para adicionar dinheiro na conta com cobrança de 1% de taxa
    public void realizarDeposito(double valorDeposito) {
        if (valorDeposito > 0) {
            double taxaDeposito = valorDeposito * 0.01; // Aqui aplico a taxa de 1%
            saldo += valorDeposito - taxaDeposito;
            System.out.printf("Depósito de R$%.2f realizado. Taxa cobrada: R$%.2f%n", valorDeposito, taxaDeposito);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para sacar dinheiro da conta com cobrança de 0,5% de taxa
    public void realizarSaque(double valorSaque) {
        if (valorSaque > 0) {
            double taxaSaque = valorSaque * 0.005; // Aqui aplico a taxa de 0,5%
            if (valorSaque + taxaSaque <= saldo) {
                saldo -= valorSaque + taxaSaque; // Se o saldo for maior que o valor sacado + da taxa, diminui do saldo 
                System.out.printf("Saque de R$%.2f realizado. Taxa cobrada: R$%.2f%n", valorSaque, taxaSaque);
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    // Método para consultar o saldo com cobrança de R$0,10 a cada 5 consultas
    public void consultarSaldo() {
        contadorConsultas++;
        if (contadorConsultas % 5 == 0) { //apenas quando contadorConsultas for igual a multiplos de 5 que acionará a condição
            saldo -= 0.10; 
        }
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
    }

    // Método toString para exibir o saldo atual
    public String toString() {
        return String.format("Saldo: R$%.2f", saldo);
    }

    // Método principal para demonstrar o funcionamento da classe
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria(1000.00);

        minhaConta.realizarDeposito(300.00);
        minhaConta.realizarSaque(50.00);
        minhaConta.consultarSaldo();
        minhaConta.consultarSaldo();
        minhaConta.consultarSaldo();
        minhaConta.consultarSaldo(); // Neste ainda não foi aplicada a taxa
        minhaConta.consultarSaldo(); // Na quinta consulta, uma taxa de R$0,10 será aplicada
        minhaConta.consultarSaldo();
    }
}

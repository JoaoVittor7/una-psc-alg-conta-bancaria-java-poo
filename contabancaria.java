import java.util.Scanner;

class ContaBancaria {
    private String nomePessoa;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String nomePessoa, String numeroConta, double saldoInicial) {
        this.nomePessoa = nomePessoa;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        }
    }

    public double obterSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner computador = new Scanner(System.in);

        System.out.print("Informe o nome da pessoa: ");
        String nome = computador.next();

        System.out.print("Informe o número da conta: ");
        String numeroConta = computador.next();

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = computador.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        String opcao;
        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("[1] - Depositar");
            System.out.println("[2] - Sacar");
            System.out.println("[3] - Obter saldo");
            System.out.println("[Q] - Sair");
            System.out.print("Opção: ");
            opcao = computador.next();

            switch (opcao.toUpperCase()) {
                case "1":
                    System.out.print("Informe o valor para depósito: ");
                    double valorDep = computador.nextDouble();
                    conta.depositar(valorDep);
                    break;

                case "2":
                    System.out.print("Informe o valor para saque: ");
                    double valorSaq = computador.nextDouble();
                    conta.sacar(valorSaq);
                    break;

                case "3":
                    System.out.printf("Saldo disponível: R$ %.2f%n", conta.obterSaldo());
                    break;

                case "Q":
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (!opcao.equalsIgnoreCase("Q"));

        computador.close();
    }
}
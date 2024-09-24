import java.util.Scanner;


public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        Conta conta;

        if (tipoConta == 1) {
            conta = new ContaCorrente(nomeTitular);
        } else {
            conta = new ContaPoupanca(nomeTitular);
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            if (tipoConta == 1) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Usar cheque especial");
                System.out.println("4. Exibir dados da conta");
            } else {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular rendimento");
                System.out.println("4. Exibir dados da conta");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    if (tipoConta == 1) {
                        System.out.print("Digite o valor a ser retirado com cheque especial: ");
                        double valorChequeEspecial = scanner.nextDouble();
                        ((ContaCorrente) conta).usarChequeEspecial(valorChequeEspecial);
                    } else {
                        System.out.print("Digite a taxa Selic atual: ");
                        double taxaSelic = scanner.nextDouble();
                        double rendimento = ((ContaPoupanca) conta).calcularRendimento(taxaSelic);
                        System.out.printf("Rendimento calculado: R$ %.2f%n", rendimento);
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

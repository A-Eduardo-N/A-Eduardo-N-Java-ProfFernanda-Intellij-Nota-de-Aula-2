import java.util.Scanner;

abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}

class ContaCorrente extends Conta {
    private final double CHEQUE_ESPECIAL = 1000.0;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= saldo + CHEQUE_ESPECIAL) {
            saldo -= valor;
            System.out.println("Uso de cheque especial realizado com sucesso!");
        } else {
            System.out.println("Limite do cheque especial excedido!");
        }
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public double calcularRendimento(double taxaSelic) {
        double rendimento;
        if (taxaSelic > 8.5) {
            rendimento = 0.005 * saldo;
        } else {
            rendimento = 0.007 * taxaSelic * saldo / 100;
        }
        saldo += rendimento;
        return rendimento;
    }
}


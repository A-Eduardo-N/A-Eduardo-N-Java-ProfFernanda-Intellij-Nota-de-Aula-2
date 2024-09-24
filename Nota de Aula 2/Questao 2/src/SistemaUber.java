import java.util.Scanner;

public class SistemaUber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a distância percorrida (em km): ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (em minutos): ");
        int tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base do serviço: R$ ");
        double tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda (ex: 1.2 para aumento de 20%%): ");
        double fatorDemanda = scanner.nextDouble();

        CorridaUber corrida = new CorridaUber(distancia, tempoEspera, tarifaBase, fatorDemanda);
        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}

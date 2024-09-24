import java.util.Scanner;

class CorridaUber {
    private double distancia;      // em quilômetros
    private int tempoEspera;      // em minutos
    private double tarifaBase;     // valor da corrida
    private double fatorDemanda;   // fator de aumento de preço

    public CorridaUber(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }

    public double calcularValorCorrida() {
        return (distancia * 2) + (tempoEspera * 0.5) + (tarifaBase * fatorDemanda);
    }

    public void exibirDetalhesCorrida() {
        double valorFinal = calcularValorCorrida();
        System.out.printf("Detalhes da Corrida:%n");
        System.out.printf("Distância: %.2f km%n", distancia);
        System.out.printf("Tempo de Espera: %d minutos%n", tempoEspera);
        System.out.printf("Tarifa Base: R$ %.2f%n", tarifaBase);
        System.out.printf("Fator de Demanda: %.2f%n", fatorDemanda);
        System.out.printf("Valor Final da Corrida: R$ %.2f%n", valorFinal);
    }
}




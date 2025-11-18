package quest03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Subject Concreto: O Sensor que coleta e publica os dados.
 */
class SensorAmbiente {
    private List<ModuloObservador> observadores = new ArrayList<>();

    private String tipoLeitura;
    private double valorLeitura;
    private LocalDateTime momentoLeitura;

    // Métodos para gerenciar a lista de observadores (Assinatura)

    public void inscrever(ModuloObservador observador) {
        observadores.add(observador);
        System.out.println("LOG: " + observador.getClass().getSimpleName() + " inscrito no sensor.");
    }

    public void desinscrever(ModuloObservador observador) {
        observadores.remove(observador);
        System.out.println("LOG: " + observador.getClass().getSimpleName() + " desinscrito do sensor.");
    }

    // Método que notifica todos os observadores
    private void notificarObservadores() {
        System.out.println("\n--- NOTIFICANDO MÓDULOS ---");
        for (ModuloObservador observador : observadores) {
            observador.atualizar(this.tipoLeitura, this.valorLeitura, this.momentoLeitura);
        }
        System.out.println("---------------------------\n");
    }

    // Simula uma nova leitura do sensor (mudança de estado)
    public void novaLeitura(String tipo, double valor) {
        this.tipoLeitura = tipo;
        this.valorLeitura = valor;
        this.momentoLeitura = LocalDateTime.now();

        System.out.printf("SENSOR: Nova leitura de %s detectada: %.2f\n", tipo, valor);

        // A mudança de estado dispara a notificação
        notificarObservadores();
    }
}
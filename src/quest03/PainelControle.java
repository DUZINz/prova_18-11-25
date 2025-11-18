package quest03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Observer Concreto 1: Atualiza a interface do usuário.
 */
class PainelControle implements ModuloObservador {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void atualizar(String tipoSensor, double valor, LocalDateTime momento) {
        String horaFormatada = momento.format(FORMATTER);
        System.out.printf("  [Painel]: Atualizando UI. %s: %.2f (Recebido às %s)\n",
                tipoSensor, valor, horaFormatada);
    }
}
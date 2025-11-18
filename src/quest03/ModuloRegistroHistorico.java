package quest03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Observer Concreto 3: Registra o histórico em um banco de dados ou arquivo.
 */
class ModuloRegistroHistorico implements ModuloObservador {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void atualizar(String tipoSensor, double valor, LocalDateTime momento) {
        String timestamp = momento.format(FORMATTER);
        // Simula o salvamento de dados
        System.out.printf("  [Registro]: Salvando no DB: | Data/Hora: %s | Tipo: %s | Valor: %.2f |\n",
                timestamp, tipoSensor, valor);
    }
}
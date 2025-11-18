package quest03;

import java.time.LocalDateTime;

/**
 * Interface Observer: Define o contrato para todos os módulos que desejam receber atualizações.
 */
interface ModuloObservador {
    void atualizar(String tipoSensor, double valor, LocalDateTime momento);
}
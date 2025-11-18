package quest03;

import java.time.LocalDateTime;

/**
 * Observer Concreto 2: Verifica condições de alerta.
 */
class ModuloAlertas implements ModuloObservador {
    private static final double LIMITE_POLUICAO = 80.0;

    @Override
    public void atualizar(String tipoSensor, double valor, LocalDateTime momento) {
        if (tipoSensor.equalsIgnoreCase("Poluicao") && valor > LIMITE_POLUICAO) {
            System.err.printf("  [ALERTA]: RISCO! Nível de Poluição (%.2f) excedeu o limite (%.0f)!\n",
                    valor, LIMITE_POLUICAO);
        } else {
            System.out.println("  [Alertas]: Leitura dentro do normal para " + tipoSensor + ".");
        }
    }
}
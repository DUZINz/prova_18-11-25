package quest02;

/**
 * Interface Strategy: Define o contrato para todos os algoritmos de cálculo de risco.
 */
interface ModeloRisco {
    String calcularRisco(double patrimonio, int idade);
}
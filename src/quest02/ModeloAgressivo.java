package quest02;

/**
 * Estratégia Concreta 1: Cálculo Agressivo.
 * Prioriza maior retorno e aceita maior volatilidade.
 */
class ModeloAgressivo implements ModeloRisco {
    @Override
    public String calcularRisco(double patrimonio, int idade) {
        // Fórmula Exemplo: Foco em idade (mais tempo para recuperar perdas)
        if (idade < 40 && patrimonio > 50000) {
            return "Perfil Agressivo Alto";
        }
        return "Perfil Agressivo Padrão";
    }
}
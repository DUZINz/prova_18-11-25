package quest02;

/**
 * Estratégia Concreta 2: Cálculo Moderado.
 * Busca equilíbrio entre segurança e crescimento.
 */
class ModeloModerado implements ModeloRisco {
    @Override
    public String calcularRisco(double patrimonio, int idade) {
        // Fórmula Exemplo: Foco em patrimônio (segurança com crescimento)
        if (patrimonio > 100000 && idade < 55) {
            return "Perfil Moderado Plus";
        }
        return "Perfil Moderado Balanceado";
    }
}
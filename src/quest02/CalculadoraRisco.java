package quest02;

/**
 * Contexto: Mantém uma referência à estratégia e permite que ela seja alterada.
 * Esta é a classe principal que o cliente usará.
 */
class CalculadoraRisco {
    private ModeloRisco modeloRisco;

    // O Setter permite alternar o modelo de cálculo em tempo de execução
    public void setModeloRisco(ModeloRisco modeloRisco) {
        this.modeloRisco = modeloRisco;
        System.out.println("-> Modelo de Risco alterado para: " + modeloRisco.getClass().getSimpleName());
    }

    // O método principal que delega o trabalho à estratégia atual
    public String analisarCliente(double patrimonio, int idade) {
        if (modeloRisco == null) {
            return "ERRO: Nenhum modelo de risco configurado.";
        }
        return this.modeloRisco.calcularRisco(patrimonio, idade);
    }
}
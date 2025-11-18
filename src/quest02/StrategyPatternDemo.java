package quest02;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        // 1. Cria o Contexto (Calculadora)
        CalculadoraRisco calculadora = new CalculadoraRisco();

        System.out.println("--- Análise do Cliente João (Idade: 35, Patrimônio: 60.000) ---");

        // 2. Cliente A: Aplicando Modelo Agressivo
        ModeloRisco modeloAgressivo = new ModeloAgressivo();
        calculadora.setModeloRisco(modeloAgressivo);

        String riscoA = calculadora.analisarCliente(60000, 35);
        System.out.println("Resultado do Risco (Agressivo): " + riscoA + "\n");

        // --- Flexibilidade em Tempo de Execução ---

        System.out.println("--- Análise do Cliente Maria (Idade: 50, Patrimônio: 120.000) ---");

        // 3. Cliente B: Alternando para Modelo Moderado
        ModeloRisco modeloModerado = new ModeloModerado();
        calculadora.setModeloRisco(modeloModerado);

        String riscoB = calculadora.analisarCliente(120000, 50);
        System.out.println("Resultado do Risco (Moderado): " + riscoB + "\n");

        // 4. Demonstração de Extensibilidade
        // Se um novo ModeloConservador for adicionado, basta criar
        // a classe e passá-la para o setter, sem mudar o fluxo da Calculadora.
        System.out.println("O fluxo principal da 'CalculadoraRisco' não precisa ser alterado para novos modelos.");
    }
}
package quest01; // Adicionar o nome da pasta como pacote

// III. Criador Abstrato
abstract class GeradorRelatorio {

    // O Factory Method
    protected abstract Relatorio criarRelatorio();

    // Método principal que utiliza o Factory Method
    public void gerarRelatorio() {
        Relatorio relatorio = criarRelatorio(); // Delega a criação
        System.out.println("--- Iniciando Geração ---");
        relatorio.preparar();
        relatorio.exibirConteudo();
        System.out.println("--- Geração Concluída ---\n");
    }
}
package quest01; // Adicionar o nome da pasta como pacote

// IV. Criador Concreto 2
class GeradorRelatorioEmergencial extends GeradorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        // A lógica de criação específica
        return new RelatorioEmergencial();
    }
}
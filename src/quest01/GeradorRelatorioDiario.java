package quest01; // Adicionar o nome da pasta como pacote

// IV. Criador Concreto 1
class GeradorRelatorioDiario extends GeradorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        // A lógica de criação específica
        return new RelatorioDiario();
    }
}
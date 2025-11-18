package quest01; // Adicionar o nome da pasta como pacote

// II. Produto Concreto 1
class RelatorioDiario implements Relatorio {
    @Override
    public void preparar() {
        System.out.println("Preparando Relatório Diário...");
        System.out.println("> Fonte de Dados: Logs do Sistema e Status de Viagens de 24h.");
        System.out.println("> Priorização: Taxa de Sucesso de Entregas e Veículos Ativos.");
    }

    @Override
    public void exibirConteudo() {
        System.out.println("Formato: Tabela Resumida de Ocorrências Diárias.");
        System.out.println("[Conteúdo do Relatório Diário]");
    }
}
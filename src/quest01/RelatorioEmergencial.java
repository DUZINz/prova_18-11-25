package quest01; // Adicionar o nome da pasta como pacote

// II. Produto Concreto 2
class RelatorioEmergencial implements Relatorio {
    @Override
    public void preparar() {
        System.out.println("Preparando Relatório Emergencial...");
        System.out.println("> Fonte de Dados: Dados de GPS em Tempo Real e Alertas de Sensor.");
        System.out.println("> Priorização: Localização da Incidência e Tempo de Resposta Necessário.");
    }

    @Override
    public void exibirConteudo() {
        System.out.println("Formato: Alerta Detalhado com Mapa e Lista de Ações Recomendadas.");
        System.out.println("[Conteúdo do Relatório Emergencial]");
    }
}
package quest04;

/**
 * Manipulador Abstrato: Define a interface para processar a transação
 * e armazena a referência para o próximo elemento na cadeia.
 */
abstract class Verificacao {
    protected Verificacao proximaVerificacao;

    /**
     * Define o próximo manipulador na cadeia.
     * @param proxima A próxima verificação a ser executada.
     * @return Retorna a próxima verificação, permitindo o encadeamento fluente (Fluent Interface).
     */
    public Verificacao setProxima(Verificacao proxima) {
        this.proximaVerificacao = proxima;
        return proxima;
    }

    /**
     * Método principal de manipulação.
     * Retorna true se a transação for aprovada para esta e todas as próximas etapas.
     * Retorna false e para imediatamente se falhar.
     */
    public abstract boolean verificar(Transacao transacao);

    /**
     * Helper Method: Executa a próxima verificação, se houver.
     */
    protected boolean verificarProximo(Transacao transacao) {
        if (proximaVerificacao != null) {
            return proximaVerificacao.verificar(transacao);
        }
        // Se for o último na cadeia e não falhou, aprova a transação.
        return true;
    }
}
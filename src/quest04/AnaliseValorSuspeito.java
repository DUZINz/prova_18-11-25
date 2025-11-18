package quest04;

/**
 * Manipulador Concreto 1
 */
class AnaliseValorSuspeito extends Verificacao {
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("-> Executando Análise de Valor Suspeito...");

        // Regra: Transações acima de 5000.00 são consideradas suspeitas.
        if (transacao.getValor() > 5000.00) {
            System.out.println("   [BLOQUEIO] Falha: Transação de alto valor detectada.");
            return false; // Falha na verificação, interrompe a cadeia
        }

        System.out.println("   [OK] Valor dentro do limite aceitável.");
        // Passa para a próxima verificação, se houver
        return verificarProximo(transacao);
    }
}
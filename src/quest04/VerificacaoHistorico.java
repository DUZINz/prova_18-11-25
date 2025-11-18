package quest04;

/**
 * Manipulador Concreto 3
 */
class VerificacaoHistorico extends Verificacao {
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("-> Executando Verificação de Histórico do Usuário...");

        // Regra: Usuário 'novo_risco' falha sempre (simulação de histórico negativo).
        if (transacao.getUsuario().equals("novo_risco")) {
            System.out.println("   [BLOQUEIO] Falha: Histórico do usuário indica alto risco.");
            return false; // Falha, interrompe a cadeia
        }

        System.out.println("   [OK] Histórico do usuário aprovado.");
        // Passa para a próxima verificação
        return verificarProximo(transacao);
    }
}
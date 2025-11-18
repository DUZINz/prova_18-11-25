package quest04;

/**
 * Manipulador Concreto 2
 */
class VerificacaoGeolocalizacao extends Verificacao {
    @Override
    public boolean verificar(Transacao transacao) {
        System.out.println("-> Executando Verificação de Geolocalização...");

        // Regra: Se a localização da transação não for 'SP' ou 'RJ' (simulação de localização segura)
        if (!transacao.getLocalizacao().equals("SP") && !transacao.getLocalizacao().equals("RJ")) {
            System.out.println("   [BLOQUEIO] Falha: Localização incomum detectada: " + transacao.getLocalizacao());
            return false; // Falha, interrompe a cadeia
        }

        System.out.println("   [OK] Geolocalização aprovada.");
        // Passa para a próxima verificação
        return verificarProximo(transacao);
    }
}
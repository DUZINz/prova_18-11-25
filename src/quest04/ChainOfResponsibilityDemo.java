package quest04;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        // 1. Instanciar todas as verificações (Manipuladores Concretos)
        Verificacao analiseValor = new AnaliseValorSuspeito();
        Verificacao geo = new VerificacaoGeolocalizacao();
        Verificacao historico = new VerificacaoHistorico();
        // (A verificação de dispositivo incomum pode ser o próximo, mas será omitida para demonstrar o fim da cadeia)

        // 2. Montar a cadeia de responsabilidade (A -> B -> C)
        // A ordem pode ser alterada aqui, sem mudar o código das verificações.
        analiseValor.setProxima(geo).setProxima(historico);

        System.out.println("--- INÍCIO DA CADEIA DE VERIFICAÇÕES ---");

        // --- CENÁRIO 1: TRANSAÇÃO APROVADA (Passa por toda a cadeia) ---
        Transacao t1 = new Transacao("cliente_vip", 1500.00, "SP", "PC");
        System.out.println("\n[Transação 1] Processando: Cliente VIP, Valor 1500, Local SP...");

        boolean resultado1 = analiseValor.verificar(t1);
        System.out.println("\n-> RESULTADO FINAL T1: " + (resultado1 ? "APROVADA" : "BLOQUEADA"));


        // --- CENÁRIO 2: TRANSAÇÃO BLOQUEADA NA PRIMEIRA ETAPA (Alto Valor) ---
        Transacao t2 = new Transacao("cliente_comum", 6000.00, "RJ", "Mobile");
        System.out.println("\n[Transação 2] Processando: Valor 6000 (suspeito), Local RJ...");

        boolean resultado2 = analiseValor.verificar(t2);
        System.out.println("\n-> RESULTADO FINAL T2: " + (resultado2 ? "APROVADA" : "BLOQUEADA"));


        // --- CENÁRIO 3: TRANSAÇÃO BLOQUEADA NA SEGUNDA ETAPA (Geolocalização) ---
        Transacao t3 = new Transacao("cliente_vip", 400.00, "Miami", "PC");
        System.out.println("\n[Transação 3] Processando: Valor baixo, Local Miami (Incomum)...");

        boolean resultado3 = analiseValor.verificar(t3);
        System.out.println("\n-> RESULTADO FINAL T3: " + (resultado3 ? "APROVADA" : "BLOQUEADA"));

        // FLEXIBILIDADE: Se uma nova verificação for adicionada, basta criar a classe
        // e inseri-la em qualquer ponto da cadeia (ex: setProxima(novaVerificacao)).
    }
}
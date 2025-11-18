package quest03;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        // 1. Cria o Subject (O Sensor)
        SensorAmbiente sensorPoluicao = new SensorAmbiente();

        // 2. Cria os Observadores (Os Módulos)
        ModuloObservador painel = new PainelControle();
        ModuloObservador alertas = new ModuloAlertas();
        ModuloObservador registro = new ModuloRegistroHistorico();

        System.out.println("--- Inicializando o Sistema de Monitoramento ---");

        // 3. Os módulos se inscrevem (attach) no sensor
        sensorPoluicao.inscrever(painel);
        sensorPoluicao.inscrever(alertas);
        sensorPoluicao.inscrever(registro);

        System.out.println("\n*** SIMULAÇÃO 1: Leitura Normal de Temperatura ***");
        // O sensor detecta uma nova leitura. Todos os módulos são notificados.
        sensorPoluicao.novaLeitura("Temperatura", 25.5);

        System.out.println("\n*** SIMULAÇÃO 2: Leitura de Poluição Acima do Limite ***");
        // Uma nova leitura de poluição é detectada. O MóduloAlertas reage de forma específica.
        sensorPoluicao.novaLeitura("Poluicao", 85.3);

        System.out.println("\n--- DEMONSTRAÇÃO DE BAIXO ACOPLAMENTO ---");
        // Se adicionarmos um novo módulo (ex: ModuloRelatorio), não precisamos
        // mudar nada no código do 'SensorAmbiente'. Apenas criamos o novo módulo
        // e o inscrevemos, garantindo o baixo acoplamento.
    }
}
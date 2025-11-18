package quest05;

public class SingletonDemo {

    public static void main(String[] args) {

        System.out.println("--- Sistema de Logging - Padrão Singleton ---");

        // 1. Thread 1 solicita a instância do logger
        ModuloLogger logger1 = ModuloLogger.getInstance();
        logger1.registrar("EVENTO", "Transação 123 iniciada.");

        // 2. Thread 2 solicita a instância do logger (será a mesma)
        ModuloLogger logger2 = ModuloLogger.getInstance();
        logger2.registrar("AUDITORIA", "Usuário 'admin' acessou o painel.");

        // 3. Thread 3 usa a instância para registrar um erro
        new Thread(() -> {
            ModuloLogger logger3 = ModuloLogger.getInstance();
            logger3.registrar("ERRO", "Falha de conexão com o DB na thread paralela.");

            // Verifica que a instância é a mesma
            System.out.println("Logger 3 Hash: " + logger3.hashCode());
        }).start();

        // Espera um pouco para a thread terminar e garantir a ordem de saída
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- Verificação da Instância ---");
        logger1.logStatus();
        logger2.logStatus(); // Usa a mesma instância!

        // Compara os códigos hash para provar que são o mesmo objeto
        System.out.println("Logger 1 Hash: " + logger1.hashCode());
        System.out.println("Logger 2 Hash: " + logger2.hashCode());
        System.out.println("Ambos os hash codes são idênticos, confirmando Singleton.");

        // Boa prática: fechar o recurso após o uso
        logger1.fechar();
    }
}
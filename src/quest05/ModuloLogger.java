package quest05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton: Garante que haja apenas uma instância do módulo de logging,
 * com acesso seguro para ambientes multi-thread.
 */
public class ModuloLogger {

    // 1. Instância Volatile Estática:
    // O uso de 'volatile' garante que a leitura e escrita do objeto 'instancia'
    // seja atômica entre diferentes threads.
    private static volatile ModuloLogger instancia;

    private final String ARQUIVO_LOG = "aplicacao.log";
    private final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Recurso para escrita: usa um PrintWriter para simplificar a escrita em arquivo
    private PrintWriter logFileWriter;

    // 2. Construtor Privado: Impede a criação de instâncias fora da própria classe.
    private ModuloLogger() {
        try {
            // Inicializa o recurso (simulando a conexão com servidor externo ou abertura de arquivo)
            logFileWriter = new PrintWriter(new FileWriter(ARQUIVO_LOG, true), true); // 'true' para append e auto-flush
            logFileWriter.println("==================================================");
            logFileWriter.println("LOGGING INICIALIZADO EM: " + LocalDateTime.now().format(FORMATADOR));
            logFileWriter.println("==================================================");
        } catch (IOException e) {
            System.err.println("Erro ao inicializar o logger: " + e.getMessage());
        }
    }

    // 3. Método de Acesso Global Estático (Implementação Thread-Safe)
    public static ModuloLogger getInstance() {
        // Primeira checagem (evita sincronização desnecessária)
        if (instancia == null) {
            // Bloco sincronizado para a segunda checagem
            synchronized (ModuloLogger.class) {
                // Segunda checagem (garante que apenas uma thread crie a instância)
                if (instancia == null) {
                    instancia = new ModuloLogger();
                }
            }
        }
        return instancia;
    }

    // 4. Métodos de Ação (A funcionalidade do logger)
    public void registrar(String nivel, String mensagem) {
        String timestamp = LocalDateTime.now().format(FORMATADOR);
        String logEntry = String.format("[%s] [%s] %s", timestamp, nivel.toUpperCase(), mensagem);

        System.out.println(logEntry); // Imprime no console (saída em tempo real)

        if (logFileWriter != null) {
            logFileWriter.println(logEntry); // Registra no arquivo e/ou envia ao servidor
        }
    }

    // Método para fechar recursos (boa prática)
    public void fechar() {
        if (logFileWriter != null) {
            logFileWriter.close();
        }
    }

    // Método de demonstração para garantir que a instância é única
    public void logStatus() {
        registrar("INFO", "Instância do Logger: " + this.hashCode() + " em uso.");
    }
}
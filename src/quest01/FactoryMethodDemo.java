package quest01; // Adicionar o nome da pasta como pacote

// V. Cliente (Classe Principal)
public class FactoryMethodDemo {

    public static void main(String[] args) {
        System.out.println("Sistema de Geração de Relatórios Operacionais\n");

        // O cliente trabalha apenas com a interface GeradorRelatorio
        GeradorRelatorio geradorDiario = new GeradorRelatorioDiario();
        geradorDiario.gerarRelatorio();

        GeradorRelatorio geradorEmergencial = new GeradorRelatorioEmergencial();
        geradorEmergencial.gerarRelatorio();
    }
}
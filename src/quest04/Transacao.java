package quest04;

class Transacao {
    private final String usuario;
    private final double valor;
    private final String localizacao;
    private final String dispositivo;

    public Transacao(String usuario, double valor, String localizacao, String dispositivo) {
        this.usuario = usuario;
        this.valor = valor;
        this.localizacao = localizacao;
        this.dispositivo = dispositivo;
    }

    public String getUsuario() { return usuario; }
    public double getValor() { return valor; }
    public String getLocalizacao() { return localizacao; }
    public String getDispositivo() { return dispositivo; }
}
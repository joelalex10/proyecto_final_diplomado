package models;

public class Lectura {
    private String TlxCli;
    private String NuevaLectura;

    public Lectura(String tlxCli, String nuevaLectura) {
        TlxCli = tlxCli;
        NuevaLectura = nuevaLectura;
    }

    public String getTlxCli() {
        return TlxCli;
    }

    public void setTlxCli(String tlxCli) {
        TlxCli = tlxCli;
    }

    public String getNuevaLectura() {
        return NuevaLectura;
    }

    public void setNuevaLectura(String nuevaLectura) {
        NuevaLectura = nuevaLectura;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "TlxCli='" + TlxCli + '\'' +
                ", NuevaLectura='" + NuevaLectura + '\'' +
                '}';
    }
}

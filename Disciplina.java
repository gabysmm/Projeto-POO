public class Disciplina {
    private String nome_d;
    private String codigo;

    public Disciplina(String nome_d, String codigo) {
        this.nome_d = nome_d;
        this.codigo = codigo;
    }

    public String getNome_d() {
        return nome_d;
    }
    public void setNome_d(String nome_d) {
        this.nome_d = nome_d;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
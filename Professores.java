public class Professores {
    private String nome;
    private String identificacao;

    public Professor(String nome, String identificacao) {
        this.nome = nome;
        this.identificacao = identificacao;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String identificacao(){
        return this.identificacao;
    }
    public void identificacao(String identificacao){
        this.identificacao = identificacao;
    }
}
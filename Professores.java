public class Professores {
    private String nome;
    private String identificacao;

<<<<<<< HEAD
    public Professor(String nome, String identificacao) {
        this.nome = nome;
=======
    public professores(String nome_p, String identificacao) throws DadosInvalidosException {
        if (nome_p == null || nome_p.isEmpty()) {
            throw new DadosInvalidosException("O nome do professor é um campo obrigatório.");
        }
        this.nome_p = nome_p;
>>>>>>> ed764b0e8488c045bdfcf1be6aed4d867ce377f4
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
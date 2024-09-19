public class Aluno {
    private String nome;
    private String matricula;
    private Avaliacao avaliacao;

    public Aluno(String nome, String matricula) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty()) {
            throw new DadosInvalidosException("o nome do aluno é um campo obrigatório");
        }
        this.nome = nome;
        this.matricula = matricula;
<<<<<<< HEAD
        this.avaliacao = null;
=======
        
    }
>>>>>>> ed764b0e8488c045bdfcf1be6aed4d867ce377f4
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

}
public class Alunos {
    private String nome;
    private String matricula;
    private Avaliacao avaliacao;

    public Aluno(String nome, String matricula) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty()) {
            throw new DadosInvalidosException("o nome do aluno é um campo obrigatório");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.avaliacao = null;
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
    
    @Override
    public String toString() {
        return nome + " (" + matricula + ") - " + periodo;
    }
}
public class Aluno {
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty()) {
            throw new DadosInvalidosException("o nome do aluno é um campo obrigatório");
        }
        this.nome = nome;
        this.matricula = matricula;
        
    }
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

}
import java.util.*; 

public class Alunos {
    private String nome;
    private String matricula;
    private String periodo;
    private Avaliacao avaliacao;

    public Alunos(String nome, String matricula, String periodo) throws Excessoes.DadosInvalidosException {
        if (nome == null || nome.isEmpty()) {
            throw new Excessoes.DadosInvalidosException("o nome do aluno é um campo obrigatório");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.periodo = periodo;
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
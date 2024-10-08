import java.util.*;
import java.util.ArrayList; 

public class Professor {
    private String nome;
    private String identificacao;
    private List <Turmas> turmas;

    public Professor(String nome, String identificacao) throws Excessoes.DadosInvalidosException {
        if (nome == null || nome.isEmpty()) {
            throw new Excessoes.DadosInvalidosException("O nome do professor é um campo obrigatório.");
        }
        this.nome = nome;
        this.identificacao = identificacao;
        this.turmas = new ArrayList<>();
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIdentificacao(){
        return this.identificacao;
    }
    public void setIdentificacao(String identificacao){
        this.identificacao = identificacao;
    }

    public void atribuirTurma(Turmas turma) {
        if (turma != null && !this.turmas.contains(turma)) {
            this.turmas.add(turma); 
            turma.setProfessor(this);
        }
    }

    public void removerTurma(Turmas turma) {
        this.turmas.remove(turma);
    }

    public List<Turmas> getTurmas() {
        return this.turmas;
    }

    @Override
    public String toString() {
        return ("professor" + nome + "identificação" + identificacao);
    }
}
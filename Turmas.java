import java.util.*;

public class Turmas {
    private Disciplina disciplina;
    private Professores professores;
    private List<Alunos> alunos;

    public Turmas(Disciplina disciplina, Professores professores) throws DadosInvalidosException{
        if (nome == null || nome.isEmpty() || disciplina == null) {
            throw new DadosInvalidosException("o nome da disciplina é obrigatório");
        }
        this.professores = professores;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
}
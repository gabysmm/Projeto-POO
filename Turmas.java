import java.util.*;

public class Turmas {
    private Disciplina disciplina;
    private Professores professores;
    private List<Alunos> alunos;

    public Turmas(String nome, Disciplina disciplina, Professor professor) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty() || disciplina == null || professor == null) {
            throw new DadosInvalidosException("todos os campos devem ser preenchidos");
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
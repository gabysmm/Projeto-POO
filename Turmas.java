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
        if (aluno == null) {
            throw new TaInvalidoException("o aluno não pode ser nulo");
        }
        if (alunos.contains(aluno)) {
            throw new TaInvalidoException("o aluno já está matriculado nesta turma");
        }
        alunos.add(aluno);
        
    }

    public void removerAluno(Aluno aluno) throws TaInvalidoException {
        if (aluno == null) {
            throw new TaInvalidoException("O aluno não pode ser nulo.");
        }
        if (!alunos.contains(aluno)) {
            throw new TaInvalidoException("O aluno não está matriculado nesta turma.");
        }
        alunos.remove(aluno);
        alunos.remove(aluno);
    }
}
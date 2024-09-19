import java.util.ArrayList;
import java.util.List;

public class Turmas {
    private Disciplina disciplina;
    private Professor professor;
    private List<Alunos> alunos;
    private String periodo; 

    public Turmas(Disciplina disciplina, Professor professor, List<Alunos> alunos, String periodo) throws Excessoes.DadosInvalidosException {
        if (disciplina == null || professor == null) {
            throw new Excessoes.DadosInvalidosException("Todos os campos devem ser preenchidos. Verifique se não falta nenhum dado.");
        }
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>(alunos);
        this.periodo = periodo;
    }

    public static Turmas atribuirTurma(Disciplina disciplina, Professor professor, List<Alunos> alunos, String periodo) throws Excessoes.DadosInvalidosException {
        return new Turmas(disciplina, professor, alunos, periodo);
    }

    public void addAluno(Alunos aluno) throws Excessoes.TaInvalidoException {
        if (aluno == null) {
            throw new Excessoes.TaInvalidoException("o aluno não pode ser nulo");
        }
        if (alunos.contains(aluno)) {
            throw new Excessoes.TaInvalidoException("o aluno já está matriculado nesta turma");
        }
        alunos.add(aluno);
        
    }

    public void removerAluno(Alunos aluno) throws Excessoes.TaInvalidoException {
        if (aluno == null) {
            throw new Excessoes.TaInvalidoException("O aluno não pode ser nulo.");
        }
        if (!alunos.contains(aluno)) {
            throw new Excessoes.TaInvalidoException("O aluno não está matriculado nesta turma.");
        }
        alunos.remove(aluno);
    }

    public List<Alunos> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public void setAlunos(List<Alunos> alunos) {
        this.alunos = alunos;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void addAvaliacao(Alunos aluno, double nota1bim, double nota2bim, double provafinal) {
        aluno.setAvaliacao(new Avaliacao(nota1bim, nota2bim, provafinal));
    }

    public void alterarAvaliacao(Alunos aluno, double nota1bim, double nota2bim, double provafinal) {
        Avaliacao avaliacao = aluno.getAvaliacao();
        if (avaliacao != null) {
            avaliacao.setNota1bim(nota1bim);
            avaliacao.setNota2bim(nota2bim);
            avaliacao.setProvafinal(provafinal);
        } else {
            System.out.println("Avaliação não encontrada para o aluno.");
        }
    }
}
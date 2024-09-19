import java.util.*;

public class Turmas extends Professor{
    private Disciplina disciplina;
    private Professor professor;
    private List<Alunos> aluno;
    private String periodo; 

    public Turmas(Disciplina disciplina, Professor professor, List<Alunos> aluno, String periodo) throws DadosInvalidosException {
        if (disciplina == null || professor == null || aluno == null || aluno.isEmpty()) {
            throw new DadosInvalidosException("Todos os campos devem ser preenchidos. Verifique se não falta nenhum dado.");
        }
        this.professor = professor;
        this.disciplina = disciplina;
        this.aluno = new ArrayList<>();
        this.periodo = periodo;
    }

    public static Turmas atribuirTurma(Disciplina disciplina, Professores professor, List<Alunos> aluno, String periodo) throws DadosInvalidosException {
        return new Turmas(disciplina, professor, aluno, periodo);
    }

    public List<Alunos> getAlunos() {
        return aluno;
    }

    public void setAlunos(List<Alunos> aluno) {
        this.aluno = aluno;
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

    public void setProfessor (Professor professor) {
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
        Avaliacao avaliacao = getAvaliacao();
        if (this.nota1bim != null) {
            avaliacao.setNota1bim(nota1bim);
        } 
        if (this.nota2bim != null) {
            avaliacao.setNota2bim(nota2bim);
        } 
        if (this.provafinal != null) {
            avaliacao.setProvafinal(provafinal);
        }
    }

    public void addAluno(Alunos aluno) throws TaInvalidoException {
        if (aluno == null) {
            throw new TaInvalidoException("o aluno não pode ser nulo");
        }
        if (aluno.contains(aluno)) {
            throw new TaInvalidoException("o aluno já está matriculado nesta turma");
        }
        aluno.add(aluno);
        
    }

    public void removerAluno(Aluno aluno) throws TaInvalidoException {
        if (aluno == null) {
            throw new TaInvalidoException("O aluno não pode ser nulo.");
        }
        if (!aluno.contains(aluno)) {
            throw new TaInvalidoException("O aluno não está matriculado nesta turma.");
        }
        aluno.remove(aluno);
    }
}

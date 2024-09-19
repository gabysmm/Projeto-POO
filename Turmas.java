import java.util.*;

public class Turmas {
    private Disciplina disciplina;
    private Professores professores;
    private List<Alunos> alunos;
    private String periodo; 

    public Turmas(Disciplina disciplina, Professores professores, List<Alunos> alunos, String periodo) throws DadosInvalidosException {
        if (disciplina == null || professores == null || alunos == null || alunos.isEmpty()) {
            throw new DadosInvalidosException("Disciplina, professor e ao menos um aluno são obrigatórios. Verifique se não falta adicionar nenhum dado.");
        }
        this.professores = professores;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.periodo = periodo;
    }

    public static Turmas atribuirTurma(Disciplina disciplina, Professores professor, List<Alunos> alunos, String periodo) throws DadosInvalidosException {
        return new Turmas(disciplina, professor, alunos, periodo);
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public List<Alunos> getAlunos() {
        return alunos;
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

    public Professores getProfessores() {
        return professores;
    }

    public void setProfessores(Professores professores) {
        this.professores = professores;
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
}
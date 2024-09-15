public class Main {
    public static void main(String[] args) {
        Alunos aluno01 = new Aluno ("Gabrielly");
        Alunos aluno02 = new Aluno ("Luna");
        Alunos aluno03 = new Aluno ("Renan");

        Professores professorL = new professor ("Lucena");
        Professores professorJ = new professor ("Jorgiano");
        Professores professorC = new professor ("coleguinha")

        Disciplina poo = new Disciplina ("programação orientada a objetos");
        Disciplina algoritmos = new Disciplina ("algoritmos");
        Disciplina edl = new Disciplina ("estrutura de dados lineares");

        Turmas turma2 = new turma ("2 periodo");
        Turmas turma4 = new turma ("4 periodo");

        turma2.adcionarAluno(aluno01);
        turma4.adcionarAluno(aluno03);

        professorL.atribuirTurma(turma2);
        professorC.atribuirTurma(turma4);

        turma2.removerAluno(aluno01);
        professorL.removerTurma(turma2);

        System.out.println("Turma: " + turma2.getNome());
        System.out.println("Turma: " + turma4.getNome());
        System.out.println("Disciplina: " + turma2.getDisciplina());
        System.out.println("Professor: " + turma4.getProfessor());
        System.out.println("Alunos: " + turma2.getAlunos());
        System.out.println("Alunos: " + turma4.getAlunos());

    }
}
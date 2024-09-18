public class Main {
    public static void main(String[] args) {
        Alunos aluno01 = new Aluno ("Gabrielly");
        Alunos aluno02 = new Aluno ("Luna");
        Alunos aluno03 = new Aluno ("Renan");

        Professores professorL = new Professor ("Lucena");
        Professores professorJ = new Professor ("Jorgiano");
        Professores professorC = new Professor ("coleguinha")

        Disciplina poo = new Disciplina ("programação orientada a objetos");
        Disciplina algoritmos = new Disciplina ("algoritmos");
        Disciplina edl = new Disciplina ("estrutura de dados lineares");

        Turmas turma2 = new turma ("2 periodo", poo, professorL);
        Turmas turma4 = new turma ("4 periodo", edl, professorC);

        turma2.addAluno(aluno01);
        turma4.addAluno(aluno03);

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
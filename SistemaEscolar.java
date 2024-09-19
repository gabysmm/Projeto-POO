public class Main {
    public static void main(String[] args) {
        try{
            Alunos aluno01 = new Aluno ("Gabrielly", "20232014040000", "2 periodo");
            Alunos aluno02 = new Aluno ("Luna", "20232014040018", "2 periodo");
            Alunos aluno03 = new Aluno ("Renan", "20222014040000", "4 periodo");

            Professor professorL = new Professor ("Lucena", "1111");
            Professor professorJ = new Professor ("Jorgiano", "2222");
            Professor professoraS = new Professor ("Silvia", "3333");

            Disciplina poo = new Disciplina ("programação orientada a objetos");
            Disciplina algoritmos = new Disciplina ("algoritmos");
            Disciplina ihc = new Disciplina ("interface humano computador");

            Turmas turma2 = new turma ("2 periodo", poo, professorL);
            Turmas turma4 = new turma ("4 periodo", ihc, professoraS);

            turma2.addAluno(aluno01);
            turma2.addAluno(aluno02);
            turma4.addAluno(aluno03);

            turma2.removerAluno(aluno02);
            professorL.removerTurma(turma2);

        }
        catch (TaInvalidoException e) {
            System.out.println("atenção, deu erro na:" + e.getMessage());
        }
        catch (DadosInvalidosException e) {
            System.out.println("opa, seus dados estão inválidos" + e.getMessage()); 

        }

        System.out.println("Turma: " + turma2.getNome());
        System.out.println("Turma: " + turma4.getNome());
        System.out.println("Disciplina: " + turma2.getDisciplina());
        System.out.println("Professor: " + turma4.getProfessor());
        System.out.println("Alunos: " + turma2.getAlunos());
        System.out.println("Alunos: " + turma4.getAlunos());

    }
}
import java.util.*;

public class SistemaEscolar {
    private static List<Alunos> alunos = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Turmas> turmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarDisciplina();
                    break;
                case 3:
                    cadastrarProfessor();
                    break;
                case 4:
                    cadastrarTurma();
                    break;
                case 5:
                    listarAlunos();
                    break;
                case 6:
                    listarDisciplinas();
                    break;
                case 7:
                    listarProfessores();
                    break;
                case 8:
                    listarTurmas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema Escolar ===");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Disciplina");
        System.out.println("3. Cadastrar Professor");
        System.out.println("4. Cadastrar Turma");
        System.out.println("5. Listar Alunos");
        System.out.println("6. Listar Disciplinas");
        System.out.println("7. Listar Professores");
        System.out.println("8. Listar Turmas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAluno() {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Período: ");
        String periodo = scanner.nextLine();

        try {
            Aluno aluno = new Aluno(nome, matricula, periodo);
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (DadosInvalidosException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    private static void cadastrarDisciplina() {
        System.out.print("Nome da Disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        Disciplina disciplina = new Disciplina(nome, codigo);
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Identificação: ");
        String identificacao = scanner.nextLine();

        try {
            Professor professor = new Professor(nome, identificacao);
            professores.add(professor);
            System.out.println("Professor cadastrado com sucesso!");
        } catch (DadosInvalidosException e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }

    private static void cadastrarTurma() {
        System.out.print("Nome da Turma: ");
        String nome = scanner.nextLine();
        System.out.print("Código da Disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        System.out.print("Identificação do Professor: ");
        String identificacaoProfessor = scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
            .filter(d -> d.getCodigo().equals(codigoDisciplina))
            .findFirst().orElse(null);

        Professor professor = professores.stream()
            .filter(p -> p.getIdentificacao().equals(identificacaoProfessor))
            .findFirst().orElse(null);

        if (disciplina == null || professor == null) {
            System.out.println("Disciplina ou Professor não encontrados.");
            return;
        }

        Turmas turma = new Turmas(disciplina, professor, new ArrayList<>(), nome);
        turmas.add(turma);
        professor.atribuirTurma(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    private static void listarAlunos() {
        System.out.println("\n=== Lista de Alunos ===");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private static void listarDisciplinas() {
        System.out.println("\n=== Lista de Disciplinas ===");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
        }
    }

    private static void listarProfessores() {
        System.out.println("\n=== Lista de Professores ===");
        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }

    private static void listarTurmas() {
        System.out.println("\n=== Lista de Turmas ===");
        for (Turmas turma : turmas) {
            System.out.println("Turma: " + turma.getPeriodo());
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Professor: " + turma.getProfessor().getNome());
            System.out.println("Alunos: " + turma.getAlunos().size());
        }
    }
}

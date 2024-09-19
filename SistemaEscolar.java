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
                    atribuirNotas();
                    break;
                case 6:
                    emitirBoletim();
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
        System.out.println("5. Atribuir notas ao Aluno");
        System.out.println("6. Emitir Boletim");
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
            Alunos aluno = new Alunos(nome, matricula, periodo);
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Excessoes.DadosInvalidosException e) {
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
        } catch (Excessoes.DadosInvalidosException e) {
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

        try {
            Turmas turma = new Turmas(disciplina, professor, new ArrayList<>(), nome);
            turmas.add(turma);
            professor.atribuirTurma(turma);
            System.out.println("Turma cadastrada com sucesso!");
        } catch (Excessoes.DadosInvalidosException e) {
            System.out.println("Erro ao cadastrar turma: " + e.getMessage());
        }
    }

    // Nova função para atribuir notas
    private static void atribuirNotas() {
        System.out.println("\n=== Atribuir Notas ===");
        System.out.print("Matrícula do aluno: ");
        String matricula = scanner.nextLine();

        Alunos aluno = alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Nota 1º Bimestre: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Nota 2º Bimestre: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Nota da Prova Final (se aplicável, caso contrário insira 0): ");
        double provafinal = scanner.nextDouble();


        Avaliacao avaliacao = new Avaliacao(nota1, nota2, provafinal);
        aluno.setAvaliacao(avaliacao);

        System.out.println("Notas atribuídas com sucesso ao aluno " + aluno.getNome());
    }

    private static void emitirBoletim() {
        System.out.println("\n=== Escolha a Turma para Emitir o Boletim ===");
        for (int i = 0; i < turmas.size(); i++) {
            Turmas turma = turmas.get(i);
            System.out.println((i + 1) + ". Turma: " + turma.getPeriodo() + ", Disciplina: "
                    + turma.getDisciplina().getNome() + " (" + turma.getDisciplina().getCodigo() + ")");
        }
        System.out.print("Escolha uma turma pelo número: ");
        int opcao = scanner.nextInt() - 1;
        if (opcao >= 0 && opcao < turmas.size()) {
            Turmas turmaSelecionada = turmas.get(opcao);

            System.out.println("\n=== Boletim: " + turmaSelecionada.getPeriodo() + " ===");
            System.out.println("Disciplina: " + turmaSelecionada.getDisciplina().getNome()
                    + " (" + turmaSelecionada.getDisciplina().getCodigo() + ")");
            System.out.println("Professor: " + turmaSelecionada.getProfessor().getNome()
                    + " (" + turmaSelecionada.getProfessor().getIdentificacao() + ")");
            System.out.println("Alunos na turma: " + turmaSelecionada.getAlunos().size() + "\n");

            turmaSelecionada.emitirBoletim();
        } else {
            System.out.println("Opção inválida.");
        }
    }
}

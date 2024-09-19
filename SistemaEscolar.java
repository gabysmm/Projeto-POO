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
                    adicionarAlunoNaTurma();
                    break;
                case 6:
                    atribuirAvaliacao();
                    break;
                case 7:
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
        System.out.println("5. Atribuir Aluno a Turma");
        System.out.println("6. Atribuir Notas ao Aluno");
        System.out.println("7. Emitir Boletim por Nome do Aluno");
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
        System.out.print("Código da Disciplina: ");
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
        System.out.print("Período da Turma: ");
        String periodo = scanner.nextLine();
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
            Turmas turma = new Turmas(disciplina, professor, new ArrayList<>(), periodo);
            turmas.add(turma);
            professor.atribuirTurma(turma);
            System.out.println("Turma cadastrada com sucesso!");
        } catch (Excessoes.DadosInvalidosException e) {
            System.out.println("Erro ao cadastrar turma: " + e.getMessage());
        }
    }

    private static void adicionarAlunoNaTurma() {
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        Alunos aluno = alunos.stream()
            .filter(a -> a.getMatricula().equals(matricula))
            .findFirst()
            .orElse(null);
    
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
    
        System.out.print("Código da Disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        Turmas turma = turmas.stream()
            .filter(t -> t.getDisciplina().getCodigo().equals(codigoDisciplina))
            .findFirst()
            .orElse(null);
    
        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }
    
        try {
            turma.addAluno(aluno);
            System.out.println("Aluno adicionado à turma com sucesso!");
        } catch (Excessoes.TaInvalidoException e) {
            System.out.println("Erro ao adicionar aluno à turma: " + e.getMessage());
        }
    }

    private static void atribuirAvaliacao() {
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
        scanner.nextLine(); 

        Avaliacao avaliacao = new Avaliacao(nota1, nota2, provafinal);
        aluno.setAvaliacao(avaliacao);

        System.out.println("Notas atribuídas com sucesso ao aluno " + aluno.getNome());
    }

    private static void emitirBoletim() {
        System.out.print("Digite o nome do aluno para emitir o boletim: ");
        String nomeAluno = scanner.nextLine();

        boolean encontrouAluno = false;

        for (Turmas turma : turmas) {
            for (Alunos alunoTurma : turma.getAlunos()) {
                if (alunoTurma.getNome().equalsIgnoreCase(nomeAluno)) {
                    System.out.println("\n=== Boletim do Aluno: " + alunoTurma.getNome() + " ===");
                    System.out.println("Matrícula: " + alunoTurma.getMatricula());
                    System.out.println("Período: " + turma.getPeriodo());
                    System.out.println("Disciplina: " + turma.getDisciplina().getNome());
                    System.out.println("Professor: " + turma.getProfessor().getNome());
                    System.out.println("=== Notas das Avaliações ===");

                    Avaliacao avaliacao = alunoTurma.getAvaliacao();
                    if (avaliacao != null) {
                        System.out.println("Nota 1º Bimestre: " + avaliacao.getNota1bim());
                        System.out.println("Nota 2º Bimestre: " + avaliacao.getNota2bim());
                        System.out.println("Nota Prova Final: " + avaliacao.getProvafinal());
                        System.out.println("Média Final: " + avaliacao.media());
                        System.out.println("Status: " + avaliacao.statusAluno());
                    } else {
                        System.out.println("Nenhuma avaliação encontrada.");
                    }
                    encontrouAluno = true;
                    break;
                }
            }
            if (encontrouAluno) {
                break;
            }
        }
        if (!encontrouAluno) {
            System.out.println("Aluno não encontrado ou não está matriculado em nenhuma turma.");
        }
    }
}




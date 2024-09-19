public class Professor {
    private String nome_p;
    private String identificacao;
    private List <Turmas> turmas;

    public Professor(String nome_p, String identificacao) throws DadosInvalidosException {
        if (nome_p == null || nome_p.isEmpty()) {
            throw new DadosInvalidosException("O nome do professor é um campo obrigatório.");
        }
        this.nome_p = nome_p;
        this.identificacao = identificacao;
        this.turmas = new ArrayList<>();
    }

    public String getNome_p(){
        return this.nome_p;
    }
    public void setNome_p(String nome_p){
        this.nome_p = nome_p;
    }

    public String getIdentificacao(){
        return this.identificacao;
    }
    public void setIdentificacao(String identificacao){
        this.identificacao = identificacao;
    }

    public void atribuirTurma(Turmas turma) {
        if (turma != null) {
            this.turmas.add(turma); 
        }
    }

    public void removerTurma(Turmas turma) {
        this.turmas.remove(turma);
    }

    public List<Turmas> getTurmas() {
        return this.turmas;
    }
}
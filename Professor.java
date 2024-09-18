public class Professor {
    private String nome_p;
    private String identificacao;

    public Professor(String nome_p, String identificacao) throws DadosInvalidosException {
        if (nome_p == null || nome_p.isEmpty()) {
            throw new DadosInvalidosException("O nome do professor é um campo obrigatório.");
        }
        this.nome_p = nome_p;
        this.identificacao = identificacao;
    }

    public String getNome_p(){
        return this.nome_p;
    }
    public void nome_p(String nome_p){
        this.nome_p = nome_p;
    }

    public String identificacao(){
        return this.identificacao;
    }
    public void identificacao(String identificacao){
        this.identificacao = identificacao;
    }
}
public class Avaliacao{
    private double nota1bim;
    private double nota2bim;
    private double provafinal;

    public Avaliacao(double nota1bim, double nota2bim, double provafinal) {
        this.nota1bim = nota1bim;
        this.nota2bim = nota2bim;
        this.provafinal = provafinal;
    }

    public double media() {
        double media = (nota1bim  *2 + nota2bim * 3) / 5;
        if (media >= 60) {
            return media;
        }
        else() {
            double media_final = (media + provafinal) / 2;
            return media_final;
        }
    }

    public String statusAluno() {
        double media = media();
        if(media >= 60) {
            return("parabéns, você foi aprovado com a média: " + media;)
        }
        else(media < 60) {
            return("infelizmente você foi reprovado :( sua média foi:" + media);
        }
    } 
}
public class Avaliacao{
    private double nota1bim;
    private double nota2bim;
    private double provafinal;

    public Avaliacao(double nota1bim, double nota2bim, double provafinal) {
        this.nota1bim = nota1bim;
        this.nota2bim = nota2bim;
        this.provafinal = provafinal;
    }

    public Media() {
        double media = (nota1bim + nota2bim) / 2;
        if (media >= 60) {
            return media;
        }
        else() {

        }
    }
}
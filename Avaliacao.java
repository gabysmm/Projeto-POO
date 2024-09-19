public class Avaliacao{
    private double nota1bim;
    private double nota2bim;
    private double provafinal;

    public Avaliacao(double nota1bim, double nota2bim, double provafinal) {
        this.nota1bim = nota1bim;
        this.nota2bim = nota2bim;
        this.provafinal = null;
    }

    public double getNota1bim() {
        return nota1bim;
    }
    public void setNota1bim(double nota1bim) {
        this.nota1bim = nota1bim;
    }

    public double getNota2bim() {
        return nota2bim;
    }
    public void setNota2bim(double nota2bim) {
        this.nota2bim = nota2bim;
    }

    public double getProvafinal() {
        return provafinal;
    }
    public void setProvafinal(double provafinal) {
        this.provafinal = provafinal;
    }

    public Media() {
        double media = (nota1bim + nota2bim) / 2;
        if (media >= 60) {
            return media;
        }
        else {

        }
    }
}
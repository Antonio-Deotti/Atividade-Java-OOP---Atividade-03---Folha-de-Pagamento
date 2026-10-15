public class Assalariado extends Funcionario {

    private double salarioSemanal;

    public Assalariado(String nome, String cpf, double salarioSemanal) {
        super(nome, cpf);
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public double calcularSalario() {
        return salarioSemanal;
    }

}

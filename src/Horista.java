public class Horista extends Funcionario{

    private double valorHora;
    private double[] horasPorDia;

    public Horista(String nome, String cpf, double valorHora, double[] horasPorDia) {
        super(nome, cpf);

        if (horasPorDia.length != 7) {
            throw new IllegalArgumentException("Informe a quantidade de horas dos 07 dias da semana.");
        }

        this.valorHora = valorHora;
        this.horasPorDia = horasPorDia;
    }

    public double getTotalHoras(){
        double total = 0;
        for(double horas : horasPorDia){
            total += horas;
        }
        return total;
    }

    @Override
    public double calcularSalario() {
        double totalHoras = getTotalHoras();
        double salario = 0;

        if (totalHoras <= 40) {
            salario = totalHoras * valorHora;
        } else {
            salario = (40 * valorHora) + ((totalHoras - 40) * valorHora * 1.5);
        }

        return salario;


    }


}

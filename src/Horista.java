public class Horista extends Funcionario{

    private double valorHora;
    private double[] horasPorDia;

    public Horista(String nome, String cpf, double valorHora, double[] horasPorDia) {
        super(nome, cpf);
        /*
        if (horasPorDia.length != 7) {
            throw new IllegalArgumentException("Informe a quantidade de horas dos 07 dias da semana.");
        }
         */

        if (valorHora < 0) {
            throw new DadosInvalidosException("O valor da hora não pode ser negativo.");
        }
        if (horasPorDia == null || horasPorDia.length != 7) {
            throw new DadosInvalidosException("Informe a quantidade de horas dos 07 dias da semana.");
        }
        for (double h : horasPorDia) {
            if (h < 0) {
                throw new DadosInvalidosException("As horas trabalhadas não podem ser negativas.");
            }
        }

        this.valorHora = valorHora;
        this.horasPorDia = horasPorDia;
    }

    public void validarHoraJornada() throws ExcessoJornadaException{
        String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};

        for(int i = 0; i < horasPorDia.length; i++){
            if(horasPorDia[i] > 10.0){
                throw new ExcessoJornadaException(getNome(), dias[i], horasPorDia[i], 10.0);
            }
        }

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

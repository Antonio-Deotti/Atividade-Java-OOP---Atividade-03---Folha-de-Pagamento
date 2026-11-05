public class ExcessoJornadaException extends Exception {

    private String nomeFuncionario;
    private String dia;
    private double horasTrabalhadas;
    private double limite;

    public ExcessoJornadaException(String nomeFuncionario, String dia, double horasTrabalhadas, double limite) {
        super(String.format("Excesso de jornada para o funcionário %s no dia %s: %.2f horas trabalhadas (limite: %.2f horas)", nomeFuncionario, dia, horasTrabalhadas, limite));
        this.nomeFuncionario = nomeFuncionario;
        this.dia = dia;
        this.horasTrabalhadas = horasTrabalhadas;
        this.limite = limite;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getDia() {
        return dia;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getLimite() {
        return limite;
    }
}

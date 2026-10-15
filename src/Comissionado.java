public class Comissionado extends Funcionario {

    private double vendas;
    private double taxaComissao;

    public Comissionado(String nome, String cpf, double vendas, double taxaComissao) {
        super(nome, cpf);
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularSalario() {
        return vendas * taxaComissao;
    }

}

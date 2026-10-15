public class AssalariadoComissionado extends Funcionario {

    private double salarioSemanal;
    private double vendas;
    private double taxaComissao;

    public AssalariadoComissionado(String nome, String cpf, double salarioSemanal, double vendas, double taxaComissao){
        super(nome, cpf);
        this.salarioSemanal = salarioSemanal;
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularSalario() {
        return (salarioSemanal * 1.10) + (vendas * taxaComissao);
    }
}

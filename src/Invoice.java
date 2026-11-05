public class Invoice implements Pagavel {

    private String numeroFatura;
    private String descricao;
    private int quantidade;
    private double precoItem;

    public Invoice(String numeroFatura, String descricao, int quantidade, double precoItem) {
        if (quantidade <= 0 || precoItem <= 0) {
            throw new DadosInvalidosException("Quantidade e preço por item na fatura devem ser maiores que zero.");
        }

        this.numeroFatura = numeroFatura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoItem = precoItem;

    }

    @Override
    public double calcularSalario() {
        return quantidade * precoItem;
    }

    @Override
    public String toString() {
        return String.format("Fatura: %s, Descrição: %s, Total: R$ %.2f", numeroFatura, descricao, calcularSalario());
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoTransacoes {
    private Deque<Pagavel> pilhaTransacoes = new ArrayDeque<>();

    public void empilharTransacao(Pagavel pagavel) {
        pilhaTransacoes.push(pagavel);
    }

    public void executarRollback() {
        System.out.println("\n--- Executando Rollback ---");
        int i = 0;
        while (!pilhaTransacoes.isEmpty()) {
            Pagavel pagavel = pilhaTransacoes.pop();
            i++;
            System.out.println(String.format("[%d] Estornando pagamento para: %s (Valor: R$ %.2f)", i, pagavel.getClass().getSimpleName(), pagavel.calcularSalario()));
        }
        System.out.println("Finalizado...");
    }

    public int getTamanhoPilha() {
        return pilhaTransacoes.size();
    }

}
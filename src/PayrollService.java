public class PayrollService {

    public void processarPagamentos(Pagavel[] pagaveis, HistoricoTransacoes historico)
            throws FalhaProcessamentoFolhaException {

        for (int i = 0; i < pagaveis.length; i++) {

            Pagavel funcionario = pagaveis[i];

            try {

                if (funcionario instanceof Horista) {
                    ((Horista) funcionario).validarHoraJornada();
                }

                double valor = funcionario.calcularSalario();

                System.out.println("Processando pagamento de: " + funcionario.getClass().getSimpleName() + " | Valor: R$ " + valor);

                historico.empilharTransacao(funcionario);

            } catch (ExcessoJornadaException e) {

                System.out.println("Erro: Jornada de trabalho excedida!");

                throw new FalhaProcessamentoFolhaException("Falha ao processar folha devido a infração trabalhista.", e);

            } catch (Exception e) {

                System.out.println("Erro ao processar pagamento: " + e.getMessage());

                throw new FalhaProcessamentoFolhaException("Falha no processamento do item " + (i + 1) + ": " + e.getMessage(), e);

            }
        }
    }
}

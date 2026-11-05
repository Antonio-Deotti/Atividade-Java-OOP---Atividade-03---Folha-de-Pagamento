public class Main {

    public static void main(String[] args) {

        /*
        Funcionario assalariado = new Assalariado("João", "123.456.789-00", 1000.0);
        Funcionario comissionado = new Comissionado("Maria", "987.654.321-00", 5000.0, 0.10);
        Funcionario assalariadoComissionado = new AssalariadoComissionado("Carlos", "111.222.333-44", 800.0, 3000.0, 0.05);
        Funcionario horista = new Horista("Ana", "555.666.777-88", 20.0, new double[]{8, 8, 8, 8, 8, 5, 0});

        System.out.println(assalariado.getNome() + " - Salário: R$" + assalariado.calcularSalario());
        System.out.println(comissionado.getNome() + " - Salário: R$" + comissionado.calcularSalario());
        System.out.println(assalariadoComissionado.getNome() + " - Salário: R$" + assalariadoComissionado.calcularSalario());
        System.out.println(horista.getNome() + " - Salário: R$" + horista.calcularSalario());

         */


        PayrollService servico = new PayrollService();

        // 1.Caminho Feliz

        System.out.println("\nIniciando cenario 1: Caminho Feliz");

        HistoricoTransacoes historico1 = new HistoricoTransacoes();

        Pagavel[] pagamento1 = {

                new Invoice("001", "Material de escritorio", 2, 100.0),
                new Assalariado("Joao", "111.111.111-11", 1500.0),
                new Horista("Maria", "222.222.222-22", 20.0, new double[]{8, 8, 8, 8, 8, 0, 0})
        };

        try {

            servico.processarPagamentos(pagamento1, historico1);

            System.out.println("Pagamentos realizados!");

        } catch (FalhaProcessamentoFolhaException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        }


        // 2. Cenário de Violação Trabalhista (Checked):

        System.out.println("\nIniciando cenario 2: Violacao Trabalhista (Checked)");

        HistoricoTransacoes historico2 = new HistoricoTransacoes();

        Pagavel[] pagamento2 = {new Horista("Carlos", "333.333.333-33", 25.0, new double[]{8, 12, 8, 8, 8, 0, 0})};

        try {

            servico.processarPagamentos(pagamento2, historico2);

        } catch (FalhaProcessamentoFolhaException e) {

            System.out.println("Falha no processamento da folha!");

            System.out.println("\n");

            System.out.println("Pendencia registrada: Excesso de jornada.");

            if (e.getCause() instanceof ExcessoJornadaException) {

                ExcessoJornadaException erro = (ExcessoJornadaException) e.getCause();

                System.out.println("Funcionario: " + erro.getNomeFuncionario());
                System.out.println("Dia: " + erro.getDia());
                System.out.println("Horas trabalhadas: " + erro.getHorasTrabalhadas());
                System.out.println("Limite permitido: " + erro.getLimite());
            }

            System.out.println("\n");

            e.printStackTrace();

        }


        // 3. Cenário de Falha com Rollback (Pilha):

        System.out.println("\nIniciando cenario 3: Falha com Rollback (Pilha):");

        HistoricoTransacoes historico3 = new HistoricoTransacoes();

        Pagavel[] pagamento3 = {
                new Invoice("002", "Computador", 1, 3000.0),
                new Assalariado("Pedro", "444.444.444-44", 2000.0),
                new Horista("Ana", "555.555.555-55", 20.0, new double[]{8, 8, 8, 8, 8, 0, 0}),
                new Horista("Paulo", "666.666.666-66", 30.0, new double[]{8, 12, 8, 8, 8, 0, 0}),
                new Invoice("003", "Impressora", 1, 800.0)
        };

        try {

            servico.processarPagamentos(pagamento3, historico3);

        } catch (FalhaProcessamentoFolhaException e) {

            System.out.println("\nErro encontrado: " + e.getMessage());

            System.out.println("\nQuantidade de pagamentos registrados: "+ historico3.getTamanhoPilha());

            System.out.println("Iniciando estorno dos pagamentos...");

            historico3.executarRollback();

        } finally {

            System.out.println("\n");
            System.out.println("Finalizando teste de rollback.");

        }

    }
}
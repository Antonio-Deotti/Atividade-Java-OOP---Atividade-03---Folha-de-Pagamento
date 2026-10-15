public class Main {

    public static void main(String[] args) {

        Funcionario assalariado = new Assalariado("João", "123.456.789-00", 1000.0);
        Funcionario comissionado = new Comissionado("Maria", "987.654.321-00", 5000.0, 0.10);
        Funcionario assalariadoComissionado = new AssalariadoComissionado("Carlos", "111.222.333-44", 800.0, 3000.0, 0.05);
        Funcionario horista = new Horista("Ana", "555.666.777-88", 20.0, new double[]{8, 8, 8, 8, 8, 5, 0});

        System.out.println(assalariado.getNome() + " - Salário: R$" + assalariado.calcularSalario());
        System.out.println(comissionado.getNome() + " - Salário: R$" + comissionado.calcularSalario());
        System.out.println(assalariadoComissionado.getNome() + " - Salário: R$" + assalariadoComissionado.calcularSalario());
        System.out.println(horista.getNome() + " - Salário: R$" + horista.calcularSalario());

    }
}
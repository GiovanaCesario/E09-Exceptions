import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                new Date(), "111.111.111-11", 36, 'm');

        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                new Date(), "000.00000.0000/0001", 25, "Comércio");

        Conta conta1 = new ContaCorrente(1234, joao, 0, 1500);
        Conta conta2 = new ContaPoupanca(12121, lojinha, 10000, 100);
        Conta conta3 = new ContaUniversitaria(23234, lojinha, 345, 100);

        try {
            conta2.depositar(-300);
            conta1.sacar(11500);

        } catch (ValorNegativoException e) {
            System.out.println("ERRO: " + e.getMessage());

        } catch (SemLimiteException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            conta3.setLimite(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

    }
}
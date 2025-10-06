import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Input: ");
            String name = input.nextLine();

            Lexico lexico = new Lexico(name);

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);

            input.close();
        } catch (Exception ex) {
            System.out.println("Comando inválido! + " + ex);
        }
    }
}

import java.util.Scanner;

public class CaixaEletronico {
    
    private static double saldo = 1020;

    public static void main(String[] args) {
        caixaEletronico();
    }

    public static void caixaEletronico() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("=============================================");
            System.out.println("Saldo: R$ " + saldo);
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sair");
            System.out.println("=============================================");
            System.out.print("Escolha um número, por favor! ");
            String resposta = scanner.nextLine();

            if (resposta.equals("1") || resposta.equalsIgnoreCase("sacar")) {
                System.out.print("Quanto deseja sacar? R$ ");
                double sacar = scanner.nextDouble();
                scanner.nextLine();

                while (true) {
                    if (sacar <= saldo) {
                        saldo -= sacar;
                        System.out.println("Seu novo saldo é: R$ " + saldo);
                        break;
                    } else {
                        System.out.println("Seu saldo é insuficiente.");
                        System.out.print("Digite um valor suficiente: R$ ");
                        sacar = scanner.nextDouble();
                        scanner.nextLine();
                    }
                }
            } 
            else if (resposta.equals("2") || resposta.equalsIgnoreCase("depositar")) {
                System.out.print("Quanto você deseja depositar? R$ ");
                double deposito = scanner.nextDouble();
                scanner.nextLine();
                saldo += deposito;
                System.out.println("Seu novo saldo é: R$ " + saldo);
            } 
            else if (resposta.equals("3") || resposta.equalsIgnoreCase("sair")) {
                System.out.println("Obrigado, até mais");
                break;
            }
            else {
                System.out.println("Por favor, digite um número ou opção válida.");
            }


            System.out.print("Deseja voltar ao menu principal? (Sim/Não): ");
            String voltarMenu = scanner.nextLine();
            if (!voltarMenu.equalsIgnoreCase("sim")) {
                System.out.println("Obrigado, até mais!");
                break;
            }
        }
    }
}

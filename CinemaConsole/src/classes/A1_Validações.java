/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Gustavo Gabriel
 */
public class A1_Validações {

    public static Scanner input = new Scanner(System.in);
    public static int poltrona, fileiraint = 0;
    public static String fileira = null;
    public static String filme1 = "MALEVOLA", filme2 = "BRASILEIRAS", filme3 = "ESQUADRÃO SUI", filme4 = "CORINGA";
    public static int FimCompra;
    public static double quantMeia = 0;
    public static double quantInteira = 0;
    public static double Inteira = 25.0;
    public static double Meia = 12.50;
    public static double pagamento = 0;

    public static void main(String[] args) {

    }
    
    public static String[][] preencheMatriz(String[][] matriz) {
        
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 0 ; j < 10 ; j++){
                matriz[i][j]="-_-";
            }
        }
    
        return matriz;
    }
   
    public static String[][] preenche20Matriz(String[][] matriz) { //FALTA CONSERTAR PREENCHIMETO DA 20 POSIÇOES !!!!!!!!!!
        Random aleatorio = new Random ();
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 0 ; j < 2 ; j++){
                matriz[aleatorio.nextInt(10)][aleatorio.nextInt(10)]="\\o/";
            }
        }
    
        return matriz;
    }

    public static int ValidaFilme() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x != 1 && x != 2 && x != 3) {
                    System.out.println("Escolha inválida!\nEscolha um dos títulos de acordo com seu número:");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Escolha inválida!\nEscolha um dos títulos de acordo com seu número:");
            }
        } while (erro);

        return x;
    }

    public static int ValidaSessao() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x != 1 && x != 2 && x != 3) {
                    System.out.println("Escolha inválida!\nEscolha um das sessões de acordo com seu número:");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Escolha inválida!\nEscolha um das sessões de acordo com seu número:");
            }
        } while (erro);

        return x;
    }

    public static int ValidaIngresso() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x < 0) {
                    System.out.println("Quantidade inválida! Informe uma quantodade de meia ou inteira válida");

                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Quantidade inválida! Informe uma quantodade de meia ou inteira válida");
            }
        } while (erro);

        return x;
    }

    public static int ValidaQuantidade() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x == 0) {
                    System.out.println("Valor inválido!\nDigite uma quantidade válida:");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Valor inválido!\nDigite uma quantidade válida:");
            }
        } while (erro);

        return x;
    }

    public static int ValidaFim() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x != 1 && x != 2) {
                    System.out.println("Valor inválido!\nDigite um número correspondente a uma opção");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Valor inválido!\nDigite um número correspondente a uma opção");
            }
        } while (erro);

        return x;
    }

    public static String ValidaFileira() {
        Scanner entrada = new Scanner(System.in);
        String x = null;
        boolean erro = true;
        do {
            try {
                x = entrada.next();
                while (!"a".equals(x) && !"A".equals(x) && !"B".equals(x) && !"b".equals(x) && !"C".equals(x) && !"c".equals(x) && !"D".equals(x) && !"d".equals(x) && !"E".equals(x) && !"F".equals(x) && !"G".equals(x) && !"g".equals(x) && !"H".equals(x) && !"h".equals(x) && !"I".equals(x) && !"i".equals(x) && !"J".equals(x) && !"j".equals(x)) {
                    System.out.println("Fileira Inválida!\nDigite uma letra correspondente a uma fileira");
                    x = entrada.next();
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Fileira Inválida!\nDigite uma letra correspondente a uma fileira");
            }
        } while (erro);

        return x;
    }

    public static int ValidaPoltrona() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x != 1 && x != 2 && x != 3 && x != 4 && x != 5 && x != 6 && x != 7 && x != 8 && x != 9 && x != 10) {
                    System.out.println("Poltrona inválida!\nDigite um número correspondente a uma das poltronas");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Poltrona inválida!\nDigite um número correspondente a uma das poltronas");
            }
        } while (erro);

        return x;
    }
    
    public static int ValidaPagamento() {
        Scanner entrada = new Scanner(System.in);
        int x = 0;
        boolean erro = true;
        do {
            try {
                x = Integer.parseInt(entrada.next());
                while (x != 1 && x != 2 ) {
                    System.out.println("Escolha inválida!\nEscolha um das opções Sim(1) ou NÃO(2)");
                    x = Integer.parseInt(entrada.next());
                }
                erro = false;
            } catch (Exception e) {
                System.out.println("Escolha inválida!\nEscolha um das opções Sim(1) ou NÃO(2)");
            }
        } while (erro);

        return x;
    }

    public static String[][] SelecionaPoltrona(String[][] matriz) {
        
        
        

        System.out.println("Inteira = (" + Inteira + " R$)  Meia = (" + Meia+" R$)");
        int quantidade = 0;
        System.out.println("Quantidade de ingressos que deseja comprar?");
        quantidade = ValidaQuantidade();

        System.out.println("Quantas meias?");
        quantMeia = ValidaIngresso();
        System.out.println("Quantas inteiras?");
        quantInteira = ValidaIngresso();
        while (quantInteira + quantMeia != quantidade) {  // VERIFICA SE A QUANTIDADE DE MEIAS E INTEIRAS BATEM COM A QUANTIDADE DE INGRESSOS TOTAL!
            System.out.println("Quantidade de Meias e Inteiras não conferem com a Quantidade Total! Digite-as novamente");
            System.out.println("Quantas meias?");
            quantMeia = ValidaIngresso();
            System.out.println("Quantas inteiras?");
            quantInteira = ValidaIngresso();
        }
        System.out.println("Poltronas Dísponiveis : (-_-)DÍSPONIVEL (\\o/)OCUPADA \n");
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.print("A ");
            }
            if (i == 1) {
                System.out.print("B ");
            }
            if (i == 2) {
                System.out.print("C ");
            }
            if (i == 3) {
                System.out.print("D ");
            }
            if (i == 4) {
                System.out.print("E ");
            }
            if (i == 5) {
                System.out.print("F ");
            }
            if (i == 6) {
                System.out.print("G ");
            }
            if (i == 7) {
                System.out.print("H ");
            }
            if (i == 8) {
                System.out.print("I ");
            }
            if (i == 9) {
                System.out.print("J ");
            }

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("1");
                }
                if (j == 1) {
                    System.out.print("2");
                }
                if (j == 2) {
                    System.out.print("3");
                }
                if (j == 3) {
                    System.out.print("4");
                }
                if (j == 4) {
                    System.out.print("5");
                }
                if (j == 5) {
                    System.out.print("6");
                }
                if (j == 6) {
                    System.out.print("7");
                }
                if (j == 7) {
                    System.out.print("8");
                }
                if (j == 8) {
                    System.out.print("9");
                }
                if (j == 9) {
                    System.out.print("10");
                }
                System.out.print("(" + matriz[i][j] + ")   ");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n|_____________________________________T E L A _____________________________________|\n\n");

        int cont = 0;
        do {
            System.out.println("Qual fileira deseja?");
            fileira = ValidaFileira();
            if (fileira.equals("A") || fileira.equals("a")) {
                fileiraint = 0;
            }
            if (fileira.equals("B") || fileira.equals("b")) {
                fileiraint = 1;
            }
           if (fileira.equals("C") || fileira.equals("c")) {
                fileiraint = 2;
            }
           if (fileira.equals("D") || fileira.equals("d")) {
                fileiraint = 3;
            }
          if (fileira.equals("E") || fileira.equals("e")) {
                fileiraint = 4;
            }
           if (fileira.equals("F") || fileira.equals("f")) {
                fileiraint = 5;
            }
           if (fileira.equals("G") || fileira.equals("g")) {
                fileiraint = 6;
            }
           if (fileira.equals("H") || fileira.equals("h")) {
                fileiraint = 7;
            }
           if (fileira.equals("I") || fileira.equals("i")) {
                fileiraint = 8;
            }
            if (fileira.equals("J") || fileira.equals("j")) {
                fileiraint = 9;
            }
            System.out.println("Qual número da poltrona:");
            poltrona = ValidaPoltrona();
            if (matriz[fileiraint][poltrona - 1].equals("\\o/")) {
                while (matriz[fileiraint][poltrona - 1].equals("\\o/")) {
                    System.out.println("Poltrona "+fileira+poltrona+" já esta ocupada, porfavor escolha outra! ");
                    System.out.println("Qual fileira deseja?");
                    fileira = input.next();
                    System.out.println("Qual número da poltrona:");
                    poltrona = input.nextInt();
                }
            }
            
            System.out.println("Deseja confirmar a compra deste ingresso? (1)\nCancelar a compra ?(2)");
            FimCompra = ValidaFim();

            if (FimCompra == 1) {
                System.out.println("--------------------");
                    System.out.println("Ingresso\nFilme:   " + Cine_ABC.FILME + "\nSala:    " + Cine_ABC.sala + "\nSessão: " + Cine_ABC.sess + "\nAssento: " + A1_Validações.fileira + " " + A1_Validações.poltrona);
                    System.out.println("--------------------");
              

                        matriz[fileiraint][poltrona - 1] = "\\o/";

                   
                  double valorfinal = (quantInteira * Inteira) + (quantMeia * Meia);
        do{System.out.println("Valor total a pagar : "+valorfinal+"\nPagamento efetuado? SIM(1) ou NÃO(2)");
        pagamento=ValidaPagamento();
        }while(pagamento==2);

                cont++;
             }
        } while (cont < quantidade && FimCompra != 2);
        

      
        

       

        return matriz;
    }

    public static void funcaoA1(){
        int esteFilme = Cine_ABC.filme;
    }
    
}

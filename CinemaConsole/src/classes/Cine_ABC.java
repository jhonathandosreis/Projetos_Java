package classes;

import static classes.A1_Validações.*;

import java.util.Scanner;

/**
 *
 * @author Gustavo Gabriel
 */
public class Cine_ABC {

    public static Scanner input = new Scanner(System.in);

    public static String[][] salaAM = new String[10][10];
    public static String[][] salaAT = new String[10][10];
    public static String[][] salaAN = new String[10][10];
    public static String[][] salaBM = new String[10][10];
    public static String[][] salaBT = new String[10][10];
    public static String[][] salaBN = new String[10][10];
    public static String[][] salaCM = new String[10][10];
    public static String[][] salaCT = new String[10][10];
    public static String[][] salaCN = new String[10][10];

    public static int filme, sessao, tipo = 0, quantidade, FimCompra = 0;
    public static double Inteira = 25.0, Meia = 12.50, valorfinal = 0, quantInteira = 0, quantMeia = 0;

    public static String sess, sala, FILME, filme1 = "MALEVOLA", filme2 = "OS PARÇAS", filme3 = "CORINGA"; //mude o nome do filme aqui@@

    /* A empresa Cine ABC deseja automatizar sua bilheteria, para isso, está contratando sua empresa de
     desenvolvimento de software para a construção desse sistema.*/
    public static void main(String[] args) {

        salaAM = preencheMatriz(salaAM);
        salaAT = preencheMatriz(salaAT);
        salaAN = preencheMatriz(salaAN);
        salaBM = preencheMatriz(salaBM);
        salaBT = preencheMatriz(salaBT);
        salaBN = preencheMatriz(salaBN);
        salaCM = preencheMatriz(salaCM);
        salaCT = preencheMatriz(salaCT);
        salaCN = preencheMatriz(salaCN);

        salaAM = preenche20Matriz(salaAM);
        salaAT = preenche20Matriz(salaAT);
        salaAN = preenche20Matriz(salaAN);
        salaBM = preenche20Matriz(salaBM);
        salaBT = preenche20Matriz(salaBT);  //FALTA CONSERTAR PREENCHIMETO DA 20 Compras iniciais !!!!!!!!!!
        salaBN = preenche20Matriz(salaBN);
        salaCM = preenche20Matriz(salaCM);
        salaCT = preenche20Matriz(salaCT);
        salaCN = preenche20Matriz(salaCN);

        do {
            System.out.println("----------------------------------------------");
            System.out.println("CINE - ABC ");
            System.out.println("Sessões Dísponiveis:\nManhã: " + filme1 + ", " + filme2 + ", " + filme3 + "\nTarde: " + filme1 + ", " + filme2 + ", " + filme3 + "\nNoite: " + filme1 + ", " + filme2 + ", " + filme3 + "\n");
            System.out.println(filme1 + "  (1)\n" + filme2 + " (2)\n" + filme3 + "   (3)\n");
            System.out.println("----------------------------------------------");
            System.out.println("Escolha um dos títulos de acordo com seu número:");
            filme = ValidaFilme();

            switch (filme) {
                case 1:
                    FILME = "MALEVOLA";
                    sala = "A";
                    System.out.println("--------------------  " + filme1 + "  -------------------");
                    System.out.println("Qual sessão deseja ?  Manhã (1) Tarde (2) Noite (3)  ");
                    sessao = ValidaSessao();
                    if (sessao == 1) {   // DIRECIONA PRA SALA DE ACORDO COM A SESSÃO !!!
                        sess = " Manhã";
                        salaAM = SelecionaPoltrona(salaAM);

                    } else if (sessao == 2) {
                        sess = " Tarde";
                        salaAT = SelecionaPoltrona(salaAT);

                    } else if (sessao == 3) {
                        sess = " Noite";
                        salaAN = SelecionaPoltrona(salaAN);

                    }

                    break;
                case 2:
                    FILME = "OS PARÇAS";
                    sala = "B";
                    System.out.println("--------------------  " + filme2 + "  -------------------");
                    System.out.println("Qual sessão deseja ?  Manhã (1) Tarde (2) Noite (3)  ");
                    sessao = ValidaSessao();
                    if (sessao == 1) {   // DIRECIONA PRA SALA DE ACORDO COM A SESSÃO !!!
                        sess = " Manhã";
                        salaBM = SelecionaPoltrona(salaBM);

                    } else if (sessao == 2) {
                        sess = " Tarde";
                        salaBT = SelecionaPoltrona(salaBT);

                    } else if (sessao == 3) {
                        sess = " Noite";
                        salaBN = SelecionaPoltrona(salaBN);

                    }

                    break;
                case 3:
                    FILME = "CORINGA";
                    sala = "C";
                    System.out.println("--------------------  " + filme3 + "  -------------------");
                    System.out.println("Qual sessão deseja ?  Manhã (1) Tarde (2) Noite (3)  ");
                    sessao = ValidaSessao();
                    if (sessao == 1) {   // DIRECIONA PRA SALA DE ACORDO COM A SESSÃO !!!
                        sess = " Manhã";
                        salaCM = SelecionaPoltrona(salaCM);

                    } else if (sessao == 2) {
                        sess = " Tarde";
                        salaCT = SelecionaPoltrona(salaCT);

                    } else if (sessao == 3) {
                        sess = " Noite";
                        salaCN = SelecionaPoltrona(salaCN);

                    }

                    break;

            }
            FimCompra = 2;
        } while (FimCompra == 2);

        //Laço de repetição do código 
    }

    public static void funcaoCine() {
        String estaFileira = A1_Validações.fileira;
    }
}

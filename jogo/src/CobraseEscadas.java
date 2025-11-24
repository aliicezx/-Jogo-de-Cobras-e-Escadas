import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CobraseEscadas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random aleatorio = new Random();

        //inicio do tabuleiro
        int[][] tabuleiro = new int[10][5];
        int numero = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = numero++;
            }
        }

        //posicao das cobras e escadas
        int[] efeitos = new int[51];
        //cobra
        efeitos[20] = 3;
        efeitos[47] = 33;
        efeitos[11] = 7;
        efeitos[27] = 5;
        efeitos[19] = 2;
        efeitos[49] = 43;
        efeitos[45] = 25;
        efeitos[39] = 18;
        efeitos[30] = 12;
        //escada
        efeitos[4] = 16;
        efeitos[10] = 28;
        efeitos[22] = 38;
        efeitos[14] = 36;
        efeitos[9] = 23;
        efeitos[26] = 48;
        efeitos[34] = 46;
        efeitos[8] = 19;
        efeitos[2] = 6;

        // posicao inicial do jogador
        int posicao = 1;
        boolean venceu = false;

        // inicio de texto e depois laco de repeticao
        System.out.println("\uD83D\uDD79\uFE0FJOGO: \uD83D\uDC0DCOBRAS E ESCADAS\uD83E\uDE9C ");
        System.out.println("Objetivo: chegar até a posição final sem ser pego pela\uD83D\uDC0D");
        System.out.println("Use o dado \uD83C\uDFB2  para avançar pelo tabuleiro.\n");

        while (!venceu) {
            exibirTabuleiro(tabuleiro, posicao);

            System.out.print("\nDigite ENTER para rolar o dado\uD83C\uDFB2 ...");
            input.nextLine();

            //executando o dado
            int dado = aleatorio.nextInt(6) + 1;
            System.out.println("Você tirou: " + dado);

            if (posicao + dado <= 50) {
                posicao += dado;
            }

            //posicao das escadas e cobras
            if (efeitos[posicao] != 0) {
                int direcao = efeitos[posicao];
                if (direcao > posicao) {
                    System.out.println("\uD83C\uDF89 Parabén você encontrou uma escada\uD83E\uDE9C para avançar!! Avançando para o " + direcao);
                } else {
                    System.out.println(" Infelizmente você encontrou uma cobra \uD83D\uDC0D e terá que voltar!! Voltando para o " + direcao);
                }
                posicao = direcao;
            }
            System.out.println("\uD83D\uDCCD posicao atual:" + posicao);
            // Condição de vitória
            if (posicao == 50) {
                venceu = true;
            }
        }

        System.out.println("\n\uD83C\uDF89 PARABÉNS! VOCÊ CHEGOU AO FINAL DO TABULEIRO! ");
    }

    // Exibe o tabuleiro
    private static void exibirTabuleiro(int[][] tab, int posicao) {
        System.out.println("\n==== TABULEIRO ====");
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == posicao) {
                    System.out.print("\uD83D\uDCCD"); // 📍 = jogador
                } else {
                    System.out.printf("%2d ", tab[i][j]);
                }
            }
            System.out.println();
        }
    }

}
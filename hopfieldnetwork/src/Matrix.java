import java.util.ArrayList;

/**
 * Created by Анастасия on 22.10.2016.
 */
public class Matrix {
    //преобразование в матрицу
    public static int [][] toMatrix(ArrayList<Character> image, int neuron_count, int kol){

        int[][] matr = new int[neuron_count * neuron_count][kol];
        int k=0;
        for (int col = 0; col < kol; col++) {
            for (int raw = 0; raw < neuron_count * neuron_count; raw++) {
                k = col * (neuron_count*neuron_count) + raw;
                if (Character.toString(image.get(k)).equals("#"))
                    matr[raw][col] = 1;
                if (Character.toString(image.get(k)).equals("-"))
                    matr[raw][col] = -1;
            }
        }

        for (int raw = 0; raw < neuron_count * neuron_count; raw++) {
            for (int col = 0; col < kol; col++) {

                System.out.print(matr[raw][col] + " ");
            }
            System.out.println();
        }

        return matr;
    }
}

import java.util.ArrayList;

/**
 * Created by Анастасия on 22.10.2016.
 */
public class Hopfield {
    public static int[][] learning(int[][] matr, int neuron_count, int kol) {
        //умножение вектор строки на вектор столбец
        int[][] matr_vesov = new int[neuron_count * neuron_count][neuron_count * neuron_count];
        //транспонирование матрицы
        int[][] matr_transp = new int[kol][neuron_count * neuron_count];
        for (int raw = 0; raw < kol; raw++) {
            for (int col = 0; col < neuron_count * neuron_count; col++) {
                matr_transp[raw][col] = matr[col][raw];
            }
        }
        //получение матрицы весов

            for (int raw = 0; raw < neuron_count * neuron_count; raw++) {
                for (int col = 0; col < neuron_count * neuron_count; col++) {
                    for (int l = 0; l < kol; l++) {
                    matr_vesov[raw][col] = matr_vesov[raw][col] + matr[raw][l] * matr_transp[l][col];

                }
            }
        }
        //ставим на главную диагональ 0
        for (int raw = 0; raw < neuron_count * neuron_count; raw++) {
            for (int col = 0; col < neuron_count * neuron_count; col++) {
                if (raw == col)
                    matr_vesov[raw][col] = 0;
                System.out.print(matr_vesov[raw][col] + "   ");
            }
            System.out.println();
        }

        return matr_vesov;
    }

    public static String usage(int[][] matr_input, int[][] matr_vesov, int[][] matr, int neuron_count, int kol) {
        int iter = 0;
        boolean f = false;
        String resultat = "";
        while (!f) {
            iter = iter + 1;
            int[][] result = new int[neuron_count * neuron_count][1];
            for (int row = 0; row < neuron_count * neuron_count; row++) {
                for (int col = 0; col < neuron_count * neuron_count; col++) {
                    result[row][0] = result[row][0] + matr_vesov[row][col] * matr_input[col][0];
                }
                System.out.println();
            }

            for (int j = 0; j < neuron_count * neuron_count; j++) {
                if (result[j][0] >= 0)
                    result[j][0] = 1;
                else
                    result[j][0] = -1;

                if (result[j][0]==1) System.out.print("#" + " ");
                else
                    System.out.print("-" + " ");
                if (j%8==7) System.out.println();
            }
            System.out.println();

            for (int j = 0; j < neuron_count * neuron_count; j++) {
                if (result[j][0] == matr_input[j][0]) {
                    f = true;
                    resultat = "Образец не найден";
                }
                else matr_input[j][0] = result[j][0];
            }
            //сравнение с образцами
            int max=0;
            for (int j = 0; j < kol; j++) {
                int counter = 0;
                for (int i = 0; i < neuron_count * neuron_count; i++) {
                    if (matr_input[i][0] == matr[i][j])
                        counter++;
                }
                /*if (max<counter) {
                    max=counter;
                    resultat = "совпадение с образцом № " +(j+1);
                }*/
                if (counter == neuron_count * neuron_count) {
                    f = true;
                    resultat = "совпадение с образцом №" + (j + 1);
                }
            }

            if (iter >= 200) {
                f = true;
                resultat = "образец не найден, превышено число итераций";
            }

        }
        return resultat;
    }

}

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        int kol = 4;
        int neuron_count = 8;
        int k=1;
        ArrayList<Character> image = new ArrayList<>();
        String path = "C://Users/Анастасия/hopfieldnetwork/input/";
        String input = "C://Users/Анастасия/hopfieldnetwork/input.txt";
        String output = "C://Users/Анастасия/hopfieldnetwork/output.txt";
        image = Parser.parser(path);
        int [][] matr = Matrix.toMatrix(image, neuron_count,kol);
        int [][] matr_vesov = Hopfield.learning(matr, neuron_count,kol);

        String s = Hopfield.usage(Matrix.toMatrix(Parser.parser(input),neuron_count, k), matr_vesov, matr, neuron_count,kol);
        System.out.println(s);
        Parser.saveResultToFile(s, matr_vesov, output, neuron_count*neuron_count, neuron_count*neuron_count);
        //Parser.saveResultToFile(s, matr, matr_vesov, output, neuron_count*neuron_count, neuron_count*neuron_count, neuron_count);
        /*for (int raw = 0; raw < neuron_count * neuron_count; raw++) {
            for (int col = 0; col < 1; col++) {

                System.out.print(matr_input[raw][col] + " ");
            }
            System.out.println();
        }*/
    }
}

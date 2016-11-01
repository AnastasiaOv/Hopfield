import java.io.*;
import java.util.ArrayList;


public class Parser {
    //String path = "C://Users/Анастасия/hopfieldnetwork/input/";

    public static ArrayList<Character> parser(String path) throws IOException {
        ArrayList<Character> image;
        image = new ArrayList<>();
        if (path.indexOf(".txt") > 0) {
            FileInputStream br = new FileInputStream(path);
            String strLine;
            int data = br.read();
            System.out.println();
            while (data != -1) {
                if (Character.toString((char) data).equals("#") || Character.toString((char) data).equals("-"))
                    image.add((char) data);
                System.out.print((char) data);
                data = br.read();
            }
        } else {
            File d = new File(path);
            String[] s = d.list();

            for (String value : s) {
                String stream = path + value;
                FileInputStream br = new FileInputStream(stream);
                String strLine;
                int data = br.read();
                System.out.println();
                while (data != -1) {
                    if (Character.toString((char) data).equals("#") || Character.toString((char) data).equals("-"))
                        image.add((char) data);
                    System.out.print((char) data);
                    data = br.read();
                }
                //System.out.println();
            }

        }
        return image;
    }
    public static void saveResultToFile(String str,int[][] arr, String path, int raw, int col) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(str+"\n");
            for (int i = 0; i < raw; i++) {
                for (int j = 0; j < col; j++) {
                    bw.write(String.valueOf(arr[i][j])+"\t"+"\t");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void saveResultToFile(String str, int [][] template, int[][] arr, String path, int raw, int col, int neuron_count) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(str + "\n");
            if (!str.equals("Образец не найден")) {
                int n = Integer.parseInt(str.substring(str.length()-1));
            for (int i = 0; i < neuron_count * neuron_count; i++) {
                if (String.valueOf(template[i][n - 1]).equals("1"))
                    bw.write("#");
                else
                    bw.write("-");
                if (i % 8 == 7)
                    bw.newLine();
            }
        }
            for (int i = 0; i < raw; i++) {
                for (int j = 0; j < col; j++) {
                    bw.write(String.valueOf(arr[i][j])+"\t"+"\t");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}




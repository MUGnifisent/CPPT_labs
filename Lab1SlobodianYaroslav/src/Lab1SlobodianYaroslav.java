import java.io.*;
import java.util.*;

/**
 * Клас Lab1 реалізує виконання 19 варіанту лабораторної роботи №1
 */
public class Lab1SlobodianYaroslav {
    /**
     * Статичний метод main є точкою входу в програму
     * 
     * @param args масив, який зберігає значення типу <b>String</b>, тобто рядки
     *             (<i>які передаються під час запуску програми з командного
     *             рядка.</i>)
     * @throws FileNotFoundException
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        int size;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("arr.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Enter the size of the square matrix: ");
        size = in.nextInt();
        in.nextLine();
        System.out.print("\nEnter the filler symbol: ");
        filler = in.nextLine();
        in.close();

        arr = new char[size][];

        if (filler.length() == 0) {
            System.out.print("\nNo filler detected");
        } else if (filler.length() == 1) {
            if(size % 2 == 0){
                int temp = 2;
                for (int i = 0; i < size / 2; i++) {
                    if(temp < size){
                        arr[i] = new char[temp];
                        arr[size - i - 1] = new char[temp];
                        temp += 2;
                    }else if(temp == size){
                        arr[i] = new char[temp];
                        arr[i+1] = new char[temp];
                    }
                }
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = (char) filler.codePointAt(0);
                    }
                }
            }
            else{
                int temp = 1;
                for (int i = 0; i < (size - 1)/ 2; i++) {
                        arr[i] = new char[temp];
                        arr[size - i - 1] = new char[temp];
                        temp += 2;
                }
                arr[(size - 1)/ 2] = new char[size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = (char) filler.codePointAt(0);
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                int sub_len = arr[i].length;
                for (int j = 0; j <  size - sub_len; j++){
                    System.out.print(" ");
                    fout.print(" ");
                }
                for (int j = 0; j <sub_len; j++){
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
                System.out.print("\n");
                fout.print("\n");
            }
        } else {
            System.out.print("\nToo many fillers detected");
        }

        fout.flush();
        fout.close();
    }
}

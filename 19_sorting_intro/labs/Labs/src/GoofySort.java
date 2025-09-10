import java.util.Scanner;

public class GoofySort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0 ; i < 3; i++) {
            System.out.print("Enter a sentence :: ");
            String[] sentence = in.nextLine().split(" ");
            int max = sentence[0].length();
            for (String s : sentence){
                max = Math.max(max, s.length());
            }
            char[][] matrix = new char[max][sentence.length];
            for (int j = 0; j < matrix.length; j++){
                for (int k = 0; k < matrix[0].length; k++){
                    if (sentence[sentence.length-1-k].length()-1-j < 0){
                        matrix[j][k] = ' ';
                        continue;
                    }
                    matrix[j][k] = sentence[sentence.length-1-k].charAt(sentence[sentence.length-1-k].length()-1-j);
                }
            }
            for (char[] ary : matrix){
                for (char c : ary){
                    System.out.print(""+c);
                }
                System.out.println();
            }
        }
    }
}

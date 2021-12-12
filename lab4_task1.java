import java.util.InputMismatchException;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        int N = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите количество элементов в массиве");
            N = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Количество элементов массива может быть задано только целым числом");
            System.exit(1);
        }
        float[] A = new float[N];
        if (N >= 2) {
            try {
                System.out.println("Введите элементы массива");
                for (int i = 0; i < N; i++) {
                    A[i] = in.nextFloat();
                }
            } catch (InputMismatchException e) {
                System.out.println("Элементами массива в данной программе могут быть только целые числа или десятичные числа,");
                System.out.println("дробная часть которых записана после запятой");
                System.exit(1);
            }
            int K = 0;
            try {
                System.out.println("Введите индекс элемента -K- (нумерация элементов начинается с нулевого индекса),");
                System.out.println("который Вы хотитете заменить на среднее арифметическое первых K исходных элементов массива,");
                System.out.println("то есть среднее арифметическое будет считаться от нулевого индекса(включая) до K-ого(не включая).");
                System.out.println("Данная операция называется -сглаживание-");
                K = in.nextInt();
                in.close();
            } catch (InputMismatchException e) {
                System.out.println("Индекс элемента массива может быть только целым числом");
                System.exit(1);
            }
            if ((K >= 1) & (K <= N - 1)) {
                float sum = 0;
                float ArithmeticMean = 0;
                for (int i = 0; i < K; i++) {
                    sum = sum + A[i];
                }
                ArithmeticMean = sum / K;
                float[] Anew = new float[N];
                for (int i = 0; i < N; i++) {
                    Anew[i] = A[i];
                }
                Anew[K] = ArithmeticMean;
                System.out.println("Заданный Вами массив:");
                for (float elem : A) {
                    System.out.print(elem + " ");
                }
                System.out.println("\nЗаданный Вами массив после совершения операции -сглаживание-:");
                for (float elem : Anew) {
                    System.out.print(elem + " ");
                }
            } else {
                System.out.println("Для совершения операции -сглаживание- индекс -K- должен находиться в диапазоне");
                System.out.println("от первого элемента массива(включая) (элементы в массиве начинаются с нулевого) до последнего(включая),");
                System.out.println("то есть последний элемент в массиве имеет индекс, равный числу, которое на один меньше, чем число элементов в массиве");
            }
        } else {
            System.out.println("Для работы данной программы Вы должны задать массив, содержащий два элемента или болле");
        }
    }
}
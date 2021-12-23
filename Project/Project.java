/*
* @main
* @Girilen matrix'i istenen yonde ve sayida dondurme
* @21/12/2021
* @Ahmed Muaz Atik - ahmedmuaz.atik@stu.fsm.edu.tr
 */
package project;

import java.util.Scanner;

public class Test {

    public static void stepNumber(int arr[]) {
        int step;
        Scanner scan = new Scanner(System.in);
        System.out.print("Adim sayisi: ");
        step = scan.nextInt();
        arr[4] = step;
        System.out.println("----------------------------------");
        System.out.println("Matrix belirlenen yonde " + step + " kadar donduruluyor..");
        System.out.println("----------------------------------");
    }

    public static void createMatrix(int arr[]) {
        int satir;
        int sutun;
        int random;
        Scanner scan = new Scanner(System.in);
        System.out.print("olusturulacak matrisin satir boyutu: ");
        satir = scan.nextInt();
        System.out.print("olusturulacak matrisin sutun boyutu: ");
        sutun = scan.nextInt();
        System.out.print("0 ile hangi deger arasindaki sayilardan olusacagi: ");
        random = scan.nextInt();
        System.out.println("----------------------------------");
        arr[0] = satir;
        arr[1] = sutun;
        arr[3] = random;
        System.out.println("0 ile " + random + " arasindaki degerlerden bir matrix olusturuluyor..");
        System.out.println("----------------------------------");
    }

    public static void matrixDirection(int arr[]) {
        System.out.print("Direction: ");
        Scanner scan = new Scanner(System.in);
        int direction = scan.nextInt();
        if (direction == 1) {
            System.out.println("----------------------------------");
            System.out.println("Matrix saat yonunun tersine donecektir.");
            System.out.println("----------------------------------");
            arr[2] = direction;
        } else if (direction == -1) {
            System.out.println("----------------------------------");
            System.out.println("Matrix saat yonune donecektir.");
            System.out.println("----------------------------------");
            arr[2] = direction;
        } else {
            System.out.println("----------------------------------");
            System.out.println("Hatali yon girdiniz.");
            System.out.println("----------------------------------");
        }
    }

    public static void rotateMatrix(int arr[]) {
        int satir = arr[0];
        int sutun = arr[1];
        int direction = arr[2];
        int input = arr[3];
        int step = arr[4];
        int matrix[][] = new int[satir][sutun];
        int rotatedMatrix[][] = new int[satir][sutun];

        System.out.println("----------------------------------");
        System.out.println("Dondurulmeden once: ");
        for (int i = 0; i < arr[0]; i++) {
            for (int j = 0; j < arr[1]; j++) {
                matrix[i][j] = (int) (Math.random() * (input - 1)) + 1; //Matrix'e 0 ile kullanicidan alinan input arasindaki random sayilar assign ediliyor.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        System.out.println(step + " Kez donduruldukten sonra: ");
        if (direction == 1) {

            for (int i = 1; i < rotatedMatrix.length - 1; i++) { //Matrix'in ortasinda kalan rotate etmeyecek sayilar rotatedMatrix'e assign ediliyor.
                for (int j = 1; j < rotatedMatrix[i].length - 1; j++) {
                    rotatedMatrix[i][j] = matrix[i][j];
                }
            }

            while (step > 0) { //Step 0 oluncaya kadar matrix 1'er kez saga kayiyor.
                for (int j = 0; j < matrix[0].length - 1; j++) { //Matrix'in ust kismi saga kaydiriliyor.
                    rotatedMatrix[0][j + 1] = matrix[0][j];
                }

                for (int i = 0; i < matrix.length - 1; i++) { //Matrix'in sag kismi asagi kaydiriliyor.
                    rotatedMatrix[i + 1][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
                }

                for (int j = matrix[0].length - 1; j > 0; j--) { //Matrix'in alt kismi sola kaydiriliyor.
                    rotatedMatrix[matrix.length - 1][j - 1] = matrix[matrix.length - 1][j];
                }

                for (int i = matrix.length - 1; i > 0; i--) { //Matrix'in sol kismi yukari kaydiriliyor.
                    rotatedMatrix[i - 1][0] = matrix[i][0];
                }

                for (int i = 0; i < rotatedMatrix.length; i++) { //Step sayisi 1'den farkli olabileceginden her defasinda esitliyoruz.
                    for (int j = 0; j < rotatedMatrix[i].length; j++) {
                        matrix[i][j] = rotatedMatrix[i][j];
                    }
                }
                step--;
            }
            for (int i = 0; i < rotatedMatrix[0].length; i++) {
                System.out.print("←  ");
            }
            System.out.println();
            for (int i = 0; i < rotatedMatrix.length; i++) {
                System.out.print("↓" + " ");
                for (int j = 0; j < rotatedMatrix[i].length; j++) {
                    System.out.print(rotatedMatrix[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < rotatedMatrix[0].length; i++) {
                System.out.print("→  ");
            }
            System.out.println();
            System.out.println("----------------------------------");

        } else if (direction == -1) {

            for (int i = 1; i < rotatedMatrix.length - 1; i++) { //Matrix'in ortasinda kalan rotate etmeyecek sayilar rotatedMatrix'e assign ediliyor.
                for (int j = 1; j < rotatedMatrix[i].length - 1; j++) {
                    rotatedMatrix[i][j] = matrix[i][j];
                }
            }

            while (step > 0) { //Step 0 oluncaya kadar matrix 1'er kez sola kayiyor.
                for (int i = matrix[0].length - 1; i > 0; i--) { //Matrix'in ust kismi sola kaydiriliyor.
                    rotatedMatrix[0][i - 1] = matrix[0][i];
                }

                for (int i = 0; i < rotatedMatrix.length - 1; i++) { //Matrix'in sol kismi asagi kaydiriliyor.
                    rotatedMatrix[i + 1][0] = matrix[i][0];
                }

                for (int i = 0; i < matrix[0].length - 1; i++) { //Matrix'in alt kismi saga kaydiriliyor.
                    rotatedMatrix[matrix.length - 1][i + 1] = matrix[matrix.length - 1][i];
                }

                for (int i = matrix.length - 1; i > 0; i--) { //Matrix'in sag kismi yukari kaydiriliyor.
                    rotatedMatrix[i - 1][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
                }

                for (int i = 0; i < rotatedMatrix.length; i++) { //Matrix'in ortasinda kalan rotate etmeyecek sayilar rotatedMatrix'e assign ediliyor.
                    for (int j = 0; j < rotatedMatrix[i].length; j++) {
                        matrix[i][j] = rotatedMatrix[i][j];
                    }
                }
                step--;
            }
            for (int i = 0; i < rotatedMatrix[0].length; i++) {
                System.out.print("→  ");
            }
            System.out.println();
            for (int i = 0; i < rotatedMatrix.length; i++) {
                System.out.print("↑" + " ");
                for (int j = 0; j < rotatedMatrix[i].length; j++) {
                    System.out.print(rotatedMatrix[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < rotatedMatrix[0].length; i++) {
                System.out.print("←  ");
            }
            System.out.println();
            System.out.println("----------------------------------");
        }

    }

    public static void main(String[] args) {
        int array[] = {5, 5, -1, 100, 2};
        String text = "1. Uygulamayi Calistir \n2. Matris olustur \n3. Direction \n4. Step number \n5. Exit";
        int input;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("{ ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("}");
            System.out.println();
            System.out.println(text);
            System.out.println("----------------------------------");
            System.out.print("-> ");
            input = scan.nextInt();
            if (input == 1) { //Eger kullanici 1 girerse uygulama calisir.
                rotateMatrix(array);

            } else if (input == 2) { //Eger kullanici 2 girerse olsturulacak matrix'in ozelliklerini girer.
                createMatrix(array);

            } else if (input == 3) { //Eger kullanici 3 girerse matrix'in hangi yone donecegini secer.
                matrixDirection(array);

            } else if (input == 4) { //Eger kullanici 4 girerse matrix'in kac kez donecegini secer.
                stepNumber(array);

            } else if (input == 5) { //Eger kullanici 5 girerse uygulamadan cikilir.
                System.out.println("----------------------------------");
                System.out.println("Cikiliyor...");
                System.out.println("----------------------------------");
                break;
            }
        }
    }
}

package Shapenko.Practice5;

public class Practice1 {
    public static void main(String[] args) {
        System.out.println("Чернявський Ілля");
        System.out.println();
      byte[][] matrix=new byte[6][6];
      fillMatrix(matrix);
      printMatrix(matrix);
        System.out.println();
        System.out.println("Result");
        zeroElementsToBegin(matrix);

        printMatrix(matrix);

    }
    // Цей метод виводить матрицю
    private static void printMatrix(byte[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // Цей метод заповнюэ матрицю за допомогою Math.random()
    private static void fillMatrix(byte[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(byte)(Math.random()*10);
            }
        }
    }
/*
    Лоіка методу проста: знаходжу перший нуль, міняю місцем перше число і нуль; знаходжу другий нуль, міняю місцем
    друге число і нуль і так далі.... Для кожного рядку*/
    private static void zeroElementsToBegin(byte[][] matrix){
        for(int i=0;i<matrix.length;i++){
            int place=0;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    byte a=matrix[i][place];
                    matrix[i][place]=0;
                    matrix[i][j]=a;

                }
            }
        }
    }
}

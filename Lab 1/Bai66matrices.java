import java.util.Scanner;
public class Bai66matrices 
{
        public static void main(String[] args) 
    {
        Scanner so= new Scanner(System.in);
        System.out.println("Nhap so hang cua 2 ma tran: ");
        int hang=so.nextInt();
        System.out.println("Nhap so cot cua 2 ma tran: ");
        int cot=so.nextInt();
        int a[][]=new int[hang][cot];
        int b[][]=new int[hang][cot];
        int tong[][]=new int[hang][cot];
        System.out.println("Nhap cac phan tu ma tran thu nhat: ");        
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
            a[i][j]=so.nextInt();
            }
        }
        System.out.println("Nhap cac phan tu ma tran thu hai: ");
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
            b[i][j]=so.nextInt();
            }
        }
        for(int i=0;i<hang;i++)
        {
            for(int j=0;j<cot;j++)
            {
            tong[i][j]=a[i][j]+b[i][j];
            }
        }
        System.out.println("Ma tran la tong cua 2 ma tran tren la: ");
        for (int i=0;i<hang;i++) {
            for (int j=0;j<cot;j++) 
            {
                System.out.print(tong[i][j] + " ");
            }
            System.out.println("\n");
        }
        so.close();
    }
}

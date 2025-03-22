import java.util.Scanner;
public class Bai63starstriangle
{
    public static void main(String[] args) 
    {
        Scanner so= new Scanner(System.in);
        System.out.print("Hay nhap chieu cao tam giac sao: ");
        int n=so.nextInt();
        for (int i=1;i<=n;i++) 
        {
            for (int j=1;j<=n-i;j++) 
            {
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++) 
            {
                System.out.print("*");
            }
            System.out.print("\n");            
        }
        so.close();
    }
}


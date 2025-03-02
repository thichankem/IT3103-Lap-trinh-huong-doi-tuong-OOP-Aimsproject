import java.util.Scanner;
public class Bai64daysofmonth 
{
    public static void main(String[] args) 
    {
        Scanner so= new Scanner(System.in);
        int thang, nam;
        System.out.print("Nhap thang: ");
        thang =so.nextInt();
        while(thang<1||thang>12) {
            System.out.print("Vui long nhap lai dung so thang: ");
            thang = so.nextInt();
        }
        System.out.print("Nhap nam: ");
        nam =so.nextInt();
        while(nam<0) {
            System.out.print("Vui long nhap lai dung so nam: ");
            nam =so.nextInt();
        }
        int ngay;
        if(thang==2) 
        {
            if((nam%4)==0 && (nam%100)!= 0||(nam% 400)==0) 
            {
                ngay=29;
            } 
            else 
            {
                ngay=28;
            }
        } 
        else if(thang==4||thang==6||thang==9||thang==11) 
        {
            ngay= 30;
        } 
        else 
        {
            ngay= 31;
        }
        System.out.println("Thang "+thang+" nam "+nam+" co tat ca "+ngay +" ngay");
        so.close();
    }
}

import javax.swing.JOptionPane;
public class Bai225calculatorulator
 {
    public static void main(String[] args) {
        String sothunhat=JOptionPane.showInputDialog(null,"nhap so thu nhat:","nhap",JOptionPane.INFORMATION_MESSAGE);
        String sothuhai=JOptionPane.showInputDialog(null,"nhap so thu hai:","nhap",JOptionPane.INFORMATION_MESSAGE);
        double so1=Double.parseDouble(sothunhat);
        double so2=Double.parseDouble(sothuhai);
        double tong=so1+so2;
        double hieu=so1-so2;
        double tich=so1*so2;
        String thongbao;
        if(so2==0)
        {
        thongbao = "Tong: "+tong+"\n"
                + "Hieu: "+hieu+"\n"
                + "Tich: "+tich+"\n"
                + "Khong ton tai thuong";
        }
        else
        {
        double thuong=so1/so2;
        thongbao = "Tong: "+tong+"\n"
                + "Hieu: "+hieu+"\n"
                + "Tich: "+tich+"\n"
                + "Thuong: "+thuong;
        }
        JOptionPane.showMessageDialog(null, thongbao, "Ket qua tinh toan", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

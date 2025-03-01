import javax.swing.JOptionPane;
public class Bai226equationsolver {
    public static void main(String[] args) {
            String luachon = JOptionPane.showInputDialog(null,
                "Cong cu\n" +
                "1 Phuong tring bac 1\n" +
                "2 He phuong trinh 2 an\n" +
                "3 Phuong trinh bac 2\n" +
                "4 Thoat", "nhap", JOptionPane.QUESTION_MESSAGE);
            switch(luachon) {
                case "1":
                double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap a:", "Nhap", JOptionPane.QUESTION_MESSAGE));
                double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap b:", "Nhap", JOptionPane.QUESTION_MESSAGE));
                if (a==0) {
                    if(b==0)
                    JOptionPane.showMessageDialog(null,"Co vo so nghiem", "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                    else
                    JOptionPane.showMessageDialog(null,"Vo nghiem", "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    double x =-b /a;
                    JOptionPane.showMessageDialog(null, "x= " + x, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
                case "2":
                    double a11=Double.parseDouble(JOptionPane.showInputDialog(null, "a11: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double a12=Double.parseDouble(JOptionPane.showInputDialog(null, "a12: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double b1=Double.parseDouble(JOptionPane.showInputDialog(null, "b1: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double a21=Double.parseDouble(JOptionPane.showInputDialog(null, "a21: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double a22=Double.parseDouble(JOptionPane.showInputDialog(null, "a22: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double b2=Double.parseDouble(JOptionPane.showInputDialog(null, "b2: ", "Nhap", JOptionPane.QUESTION_MESSAGE));
                    double D = a11 * a22 - a12 * a21;
                    double Dx = b1 * a22 - b2 * a12;
                    double Dy = a11 * b2 - a21 * b1;
                    String message;
                    if (D==0){
                    message = (Dx==0&&Dy== 0) ? "Co vo so nghiem" : "Vo nghiem";
                    } else {
                        double x1 = Dx / D;
                        double x2 = Dy / D;
                        message = "x1= " + x1 + "\n x2= " + x2;
                    }
                    JOptionPane.showMessageDialog(null, message, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3":
                double aa = Double.parseDouble(JOptionPane.showInputDialog(null, "a:", "Nhap", JOptionPane.QUESTION_MESSAGE));
                double bb = Double.parseDouble(JOptionPane.showInputDialog(null, "b:", "Nhap", JOptionPane.QUESTION_MESSAGE));
                double cc = Double.parseDouble(JOptionPane.showInputDialog(null, "c:", "Nhap", JOptionPane.QUESTION_MESSAGE));

        if (aa == 0) {
            JOptionPane.showMessageDialog(null, "He so a phai khac 0", "Loi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double delta=bb*bb-4*aa*cc;
        String message2;
        if (delta > 0) {
            double x1=(-bb+Math.sqrt(delta))/(2* aa);
            double x2 = (-bb-Math.sqrt(delta))/(2 * aa);
            message2 = "x1 = " + x1 + "\n x2 = " + x2;
        } else if (delta == 0) {
            double x = -bb / (2 * aa);
            message2 = "Phuong trinh co nghiem kep\n x0 = " + x;
        } else {
            message2 = "Phuong trinh vo nghiem";
        }
        JOptionPane.showMessageDialog(null, message2, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
        break;
        default:
            JOptionPane.showMessageDialog(null, "Cam on da dung cong cu", "Thoat", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

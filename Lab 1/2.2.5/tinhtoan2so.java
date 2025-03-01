import javax.swing.JOptionPane;
public class tinhtoan2so
 {
    public static void main(String[] args) {
        String soThuNhat = JOptionPane.showInputDialog(null, "Nhap so thu nhat:", "Nhap", JOptionPane.INFORMATION_MESSAGE);
        String soThuHai = JOptionPane.showInputDialog(null, "Nhap so thu hai:", "Nhap", JOptionPane.INFORMATION_MESSAGE);

        try {
            double so1 = Double.parseDouble(soThuNhat);
            double so2 = Double.parseDouble(soThuHai);

            double tong = so1 + so2;
            double hieu = so1 - so2;
            double tich = so1 * so2;
            String thuong = (so2 != 0) ? String.valueOf(so1 / so2) : "Khong the chia cho 0";
            String thongBao = "Tong: " + tong + "\n"
                            + "Hieu: " + hieu + "\n"
                            + "Tich: " + tich + "\n"
                            + "Thuong: " + thuong;
            JOptionPane.showMessageDialog(null, thongBao, "Ket qua tinh toan", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Du lieu khong hop le! Vui long nhap so.", "Loi", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}

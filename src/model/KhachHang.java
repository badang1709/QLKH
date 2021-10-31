package model;
import java.io.Serializable;
import test.TestKhachHang;
public class KhachHang implements Serializable,Comparable<KhachHang>
{   private int ma;
    private  String ten;
    private  String phone;

    public int getMa() {
        return ma;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public KhachHang()
    {

    }

    public KhachHang(int ma, String ten, String phone)
    {
        this.ma = ma;
        this.ten = ten;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "KhachHang{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public int compareTo(KhachHang o) {
        return this.phone.compareToIgnoreCase(o.phone);
    }



}

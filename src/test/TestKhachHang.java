package test;
import io.SerializeFileFactory;
import model.KhachHang;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestKhachHang {static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
    public static void menu() {
        try {
            System.out.println("1. Nhập khách hàng");
            System.out.println("2. In danh sách khách hàng");
            System.out.println("3. Tìm kiếm khách hàng theo đầu số");
            System.out.println("4. Sắp xếp ds khách hàng theo sđt");
            System.out.println("5. Lưu danh sách khách hàng");
            System.out.println("6. Đọc danh sách khách hàng");
            System.out.println("7. Thống kê theo đầu số");//có bao nhiêu khách hàng viettel,vina,mobi...
            System.out.println("8. Thoát");
            int chon = 0;
            System.out.println("Mời bạn chọn chức năng [1->8]");
            chon = new Scanner(System.in).nextInt();
            switch (chon) {
                case 1:
                    xuLyNhap();
                    break;
                case 2:
                    xuLyXuat();
                    break;
                case 3:
                    xuLyTim();
                    break;
                case 4:
                    xuLySapXep();
                    break;
                case 5:
                    xuLyLuu();
                    break;
                case 6:
                    xuLyDoc();
                    break;
                case 7:
                    xuLyThongKe();
                    break;
                case 8:
                    xuLyThoat();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Bạn nhập sai, mời chọn lại");
        }
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        while (true) {
            menu();
        }
    }

    private static void xuLyThoat() {
        System.out.println("Cám ơn bạn đã dùng phần mềm. Bye Bye.");
        System.exit(0);
    }

    private static void xuLyNhap() {
        try {
            KhachHang kh = new KhachHang();
            System.out.println("Mời bạn nhập mã");
            int ma = new Scanner(System.in).nextInt();
            System.out.println("Mời bạn nhập tên");
            String ten = new Scanner(System.in).nextLine();
            System.out.println("Mời bạn nhập số phone:");
            String phone = new Scanner(System.in).nextLine();
            kh.setMa(ma);
            kh.setTen(ten);
            kh.setPhone(phone);

            dsKH.add(kh);
        } catch (Exception ex) {
// TODO: handle exception
            ex.printStackTrace();
        }
    }
    private static void xuLyXuat() {
        System.out.println("=============================");
        System.out.println("Mã\tTên\t Phone");
        for(KhachHang kh:dsKH)
        {
            System.out.println(kh);
        }
        System.out.println("=============================");
    }
    private static void xuLyLuu() {
        boolean kt = SerializeFileFactory.luuFile(dsKH, "d:\\dulieukhachhang.db");
        if(kt==true)
        {
            System.out.println("Đã lưu file thành công");
        }
        else
        {
            System.out.println("Lưu file thất bại");
        }
    }

    private static void xuLyDoc() {
        dsKH = SerializeFileFactory.docFile("d:\\dulieukhachhang.db");
        System.out.println("Đã đọc file thành công");
    }
    private static void xuLyTim() {
        System.out.println("=============================");
        System.out.println("Bạn muốn tìm đầu số nào");
        String phone = new Scanner(System.in).next();
        System.out.println("Khách hàng có đầu số "+phone+" là:");
        System.out.println("Mã\tTên\t Phone");
        for(KhachHang kh: dsKH)
        {
            if(kh.getPhone().startsWith(phone))//kiểm tra những ký tự đầu
            {
                System.out.println(kh);
            }
            System.out.println("=============================");
        }
    }
    private static void xuLySapXep() {
        Collections.sort(dsKH);
        System.out.println("Đã sắp xếp số điện thoại xong rồi");
    }
    private static void xuLyThongKe() {
        int n = 0;
        System.out.println("Mời bạn nhập đầu số cần thống kê:");
        String phone = new Scanner(System.in).next();
        for(KhachHang kh: dsKH)
        {
            if(kh.getPhone().startsWith(phone))
            {
                n++;
            }
        }
        System.out.println("Có "+n+" khách hàng "+phone);
    }



}

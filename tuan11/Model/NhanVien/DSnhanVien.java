    package NhanVien;

    import static java.nio.file.Files.readAllLines;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.nio.file.Files;
    import java.nio.file.Paths;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    
    import javax.swing.JOptionPane;

    public class DSnhanVien {
        protected ArrayList<nhanVien> NHANVIEN ;
        protected int demtime=0;
        protected int seconds =0;
        public int s =-1;
        protected Scanner sc;

        public DSnhanVien() {
            NHANVIEN = new ArrayList<>();
            try {
                FileReader fr = new FileReader("nhanvien.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while (true) { 
                    line = br.readLine();
                    if(line == null)
                        break;
                    String txt[] = line.split(";");
                    String stk = txt[0];
                    String name = txt[1];
                    String mk = txt[2];
                    String date = txt[3];
                    String sdt = txt[4];
                    double luong =Double.parseDouble(txt[5]);
                    double phucap = Double.parseDouble(txt[6]);
                    int cong = Integer.parseInt(txt[7]);
                    int gio = Integer.parseInt(txt[8]);
                    LocalDate ngaybd;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    ngaybd = LocalDate.parse(date,formatter);
                    if(!txt[6].equals("0"))
                    {
                        nhanVienFullTime nvft = new nhanVienFullTime(phucap, ngaybd, sdt, luong,stk, mk, name,cong);
                        NHANVIEN.add(nvft);
                    }
                    else{
                        nhanVienPartTime nvpt = new nhanVienPartTime(gio,ngaybd,sdt,luong,stk,mk,name);
                        NHANVIEN.add(nvpt);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        public void themNV(nhanVien n1)
        {
            NHANVIEN.add(n1);
            ghilai();
            System.out.println("Them thanh cong");
        }
        public ArrayList<nhanVien> getNHANVIEN() {
            return NHANVIEN;
        }

        public void setNHANVIEN(ArrayList<nhanVien> nHANVIEN) {
            NHANVIEN = nHANVIEN;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public Scanner getSc() {
            return sc;
        }

        public void setSc(Scanner sc) {
            this.sc = sc;
        }

        public void themNhanVienFT(){
            nhanVienFullTime NVFT = new nhanVienFullTime();
            NVFT.nhapFT();
            int dem =0;
            for (nhanVien nv : NHANVIEN) {
                if(NVFT.getSTK().equals(nv.getSTK()))
                    dem++;
            }
            if(dem==0)
            {
                NHANVIEN.add(NVFT);
                try {
                    FileWriter fw = new FileWriter("nhanvien.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(NVFT.toString());
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                }
                System.out.println("Them thanh cong !");
            }
            else
                System.out.println("So tai khoan da ton tai !");
        }
        public void themNhanVienPT()
        {
            nhanVienPartTime NVPT = new nhanVienPartTime();
            NVPT.nhap();
            int dem =0;
            for (nhanVien nv2 : NHANVIEN) {
                if(NVPT.getSTK().equals(nv2.getSTK()))
                    dem++;
            }
            if(dem==0)
            {
                NHANVIEN.add(NVPT);
                try {
                    FileWriter fw = new FileWriter("nhanvien.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(NVPT.toString());
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                }
                System.out.println("Them thanh cong !");
            }
            else
                System.out.println("so tai khoan da ton tai !");
        }

        
        public void themNhanVienFullT(String stk, String ten, String sdt,String mk, Double luongCB, LocalDate ngayBD) {
            nhanVienFullTime NVFT= new nhanVienFullTime();
            NVFT.setSTK(stk);
            NVFT.setTenNV(ten);
            NVFT.setSDT(sdt);
            NVFT.setpassWord(mk);
            NVFT.setLuongCB(luongCB);
            NVFT.setNgayBD(ngayBD);
            NVFT.setPhuCap();
            int dem = 0;
        
            for (nhanVien nv : NHANVIEN) {
                if (NVFT.getSTK().equals(nv.getSTK()))
                    dem++;
            }
            if (dem == 0) {
                NHANVIEN.add(NVFT);
                try {
                    FileWriter fw = new FileWriter("nhanvien.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(NVFT.toString());
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace(); // In ra lỗi nếu có
                }
                System.out.println("Them cach cong !");
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!"); // Thêm nhân viên part-time
            } else {
                System.out.println("Số tài khoản đã tồn tại !");
                JOptionPane.showMessageDialog(null, "Them khong thanh cong!");
            }
        }
        
        public void themNhanVienPartT(String stk, String ten, String sdt,String mk, Double luongCB, LocalDate ngayBD) {
            nhanVienPartTime NVPT = new nhanVienPartTime();
            NVPT.setSTK(stk);
            NVPT.setTenNV(ten);
            NVPT.setSDT(sdt);
            NVPT.setpassWord(mk);
            NVPT.setLuongCB(luongCB);
            NVPT.setNgayBD(ngayBD);
            int dem = 0;
        
            for (nhanVien nv2 : NHANVIEN) {
                if (NVPT.getSTK().equals(nv2.getSTK()))
                    dem++;
            }
            if (dem == 0) {
                NHANVIEN.add(NVPT);
                try {
                    FileWriter fw = new FileWriter("nhanvien.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(NVPT.toString());
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace(); // In ra lỗi nếu có
                }
                System.out.println("Them thanh cong !");
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!"); // Thêm nhân viên part-time
            } else {
                System.out.println("Số tài khoản đã tồn tại !");
            }
        }
        public void xoaNV(String STK)
        {
            NHANVIEN.removeIf(nhanVien -> STK.equals(nhanVien.STK));
            System.out.println("Cap nhat thanh cong !");
            ghilai();
        }
        public void DangNhap(String STK, String password)
        {
            for (int i = 0; i < NHANVIEN.size(); i++) {
                if(STK.equals(NHANVIEN.get(i).STK)&&password.equals(NHANVIEN.get(i).getPassword()))
                {
                    s=i;
                    System.out.println("Dang nhap thanh cong !");
                    break;
                }   
            }

        }
        public void thongTinChiTiet()
        {
            System.out.println("STK: "+NHANVIEN.get(s).STK);
            System.out.println("Tên nhân viên: "+NHANVIEN.get(s).tenNV);
            System.out.println("Ngay bat dau lam viec: "+NHANVIEN.get(s).NgayBD);
            System.out.println("So dien thoai: "+NHANVIEN.get(s).SDT);
            System.out.println("Luong co ban: "+NHANVIEN.get(s).luongCB);
            System.out.println("Luong: "+NHANVIEN.get(s).tinhLuong());
            if(NHANVIEN.get(s) instanceof nhanVienFullTime)
            {
                System.out.println("So cong tich luy: "+((nhanVienFullTime) NHANVIEN.get(s)).cong);
                System.out.println("Phu cap: "+((nhanVienFullTime) NHANVIEN.get(s)).phuCap);
            }
            
            else
                System.out.println("So gio lam: "+((nhanVienPartTime) NHANVIEN.get(s)).gio);
        }
        public void doiMK()
        {
            sc = new Scanner(System.in);
            int dem =0;
            String passcu, passmoi;
            do { 
                if(dem<3)
                    dem++;
                else
                    throw new IllegalArgumentException("thao tac sai qua so lan cho phep !");
                System.out.print("Nhap vao mat khau: ");
                passcu= sc.nextLine();
                System.out.print("nhap vao mat khau moi: ");
                passmoi=sc.nextLine();
                if(passcu.equals(NHANVIEN.get(s).getPassword()))
                {
                    NHANVIEN.get(s).setpassWord(passmoi);
                    System.out.println("Doi mat khau thanh cong !");
                    break;
                }
            } while (true);
            
        }
        public void thongtinNV()
        {
            for (nhanVien nv : NHANVIEN) {
                System.out.println("STK: "+nv.STK);
                System.out.println("Tên nhân viên: "+nv.tenNV);
                System.out.println("Ngay bat dau lam viec: "+nv.NgayBD);
                System.out.println("So dien thoai: "+nv.SDT);
                System.out.println("Luong co ban: "+nv.luongCB);
                System.out.println("Luong: "+nv.tinhLuong());
                if(nv instanceof nhanVienFullTime)
                {
                    System.out.println("So cong tich luy: "+((nhanVienFullTime) nv).cong);
                    System.out.println("Phu cap: "+((nhanVienFullTime) nv).phuCap);
                }
                    
                else
                    System.out.println("So gio lam: "+((nhanVienPartTime) nv).gio);
            }
        }

        public nhanVien timNhanVien (String maNhanVien)
        {
            for(nhanVien nv: NHANVIEN)
                if(nv.getSTK().equals(maNhanVien))
                    return nv;
            return null;
        }
        
        // public void quenpass()
        // {
        //     NHANVIEN.get(s).quenpass();
        // }
        public void quenpass()
    {
        sc = new Scanner(System.in);
        String stk;
        int a=-1;
        System.out.print("Nhap vao so tai khoan: ");
        stk = sc.nextLine();
        for (int i = 0; i < NHANVIEN.size(); i++) {
            if(NHANVIEN.get(i).STK.equals(stk))
            {
                a=i;
                break;
            }  
        }
        if(a!=-1)
        {
            String passWord;
            String sdt;
            int dem=0,dem1=0;
            int otp;
            System.out.print("thiet lap mat khau moi :");
            passWord = sc.nextLine();
            System.out.print("Nhap vao so dien thoai: ");
            sdt=sc.nextLine();
            while(!sdt.equals(NHANVIEN.get(a).SDT))
            {
                dem++;
                System.out.print("Nhap vao so dien thoai: ");
                sdt=sc.nextLine();
                if(dem ==3)
                    break;
            }
            if(dem>=3)
            {
                demtime++;
                if(demtime == 3)
                    throw new IllegalArgumentException("thao tac sai qua nhieu lan !");
                 seconds = seconds+5; // Số giây bạn muốn đếm
                for (int i = seconds; i >= 0; i--) {
                    System.out.println("Thoi gian con lai: " + i + " giây");
                    try {
                        Thread.sleep(1000); // Tạm dừng 1000ms (1 giây)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                quenpass();
            }
            System.out.println(NHANVIEN.get(a).getOTP());
            System.out.print("nhap vao OTP: ");
            otp=sc.nextInt();
            sc.nextLine();
            while(otp!=NHANVIEN.get(a).OTP)
            {
                dem1++;
                System.out.print("nhap vao OTP: ");
                otp=sc.nextInt();
                sc.nextLine();
                if(dem1==3)
                    break;
            }
            if(dem1>=3)
                throw new IllegalArgumentException("thao tac sai qua so lan cho phep !");
                NHANVIEN.get(a).setpassWord(passWord);
            System.out.println("Doi mat khau thanh cong !");
            try {
                List<String> lines = readAllLines(Paths.get("nhanvien.txt"));
                String line=null;
                for(int i =0;i<lines.size();i++)
                {
                    if(lines.get(i).startsWith(NHANVIEN.get(a).STK))
                        if(NHANVIEN.get(i) instanceof nhanVienFullTime)
                            line = NHANVIEN.get(a).STK+";"+NHANVIEN.get(a).tenNV+";"+NHANVIEN.get(a).getPassword()+";"+NHANVIEN.get(a).NgayBD+";"+NHANVIEN.get(a).SDT+";"+NHANVIEN.get(a).luongCB+";"+((nhanVienFullTime)NHANVIEN.get(a)).phuCap+";"+((nhanVienFullTime)NHANVIEN.get(a)).cong+";"+"0";
                        else
                            line = NHANVIEN.get(a).STK+";"+NHANVIEN.get(a).tenNV+";"+NHANVIEN.get(a).getPassword()+";"+NHANVIEN.get(a).NgayBD+";"+NHANVIEN.get(a).SDT+";"+NHANVIEN.get(a).luongCB+";"+"0"+";"+"0"+";"+((nhanVienPartTime)NHANVIEN.get(a)).gio;
                        lines.set(i, line);
                        break;
                    }
                    Files.write(Paths.get("nhanvien.txt"),lines);
                    
                } catch (Exception e) {
                    System.err.println("Lỗi khi xử lý file: " + e.getMessage());
                }
            }
            else
            System.out.println("Tai khoan khong ton tai !");
        }

        public void chamconglam()
        {
            NHANVIEN.get(s).chamCong();
        }
        public void ghilai()
        {
            try {
                List<String> lines = readAllLines(Paths.get("D:\\OOP\\nhanvien.txt"));
                String line=null;
                for(int i =0;i<lines.size();i++)
                {
                    if(lines.get(i).startsWith(NHANVIEN.get(s).STK))
                        if(NHANVIEN.get(i) instanceof nhanVienFullTime)
                            line = NHANVIEN.get(s).STK+";"+NHANVIEN.get(s).tenNV+";"+NHANVIEN.get(s).getPassword()+";"+NHANVIEN.get(s).NgayBD+";"+NHANVIEN.get(s).SDT+";"+NHANVIEN.get(s).luongCB+";"+((nhanVienFullTime)NHANVIEN.get(s)).phuCap+";"+((nhanVienFullTime)NHANVIEN.get(s)).cong+";"+"0";
                        else
                            line = NHANVIEN.get(s).STK+";"+NHANVIEN.get(s).tenNV+";"+NHANVIEN.get(s).getPassword()+";"+NHANVIEN.get(s).NgayBD+";"+NHANVIEN.get(s).SDT+";"+NHANVIEN.get(s).luongCB+";"+"0"+";"+"0"+";"+((nhanVienPartTime)NHANVIEN.get(s)).gio;
                    lines.set(i, line);
                    break;
                }
                Files.write(Paths.get("D:\\OOP\\nhanvien.txt"),lines);
                
            } catch (Exception e) {
                System.err.println("Loi khi xu ly file: " + e.getMessage());
            }
        }
        public void ghilai2(String manv)
        {
            try {
                List<String> lines = readAllLines(Paths.get("D:\\OOP\\nhanvien.txt"));
                for(int i =0;i<lines.size();i++)
                {
                    if(lines.get(i).startsWith(manv)){
                            lines.remove(i);
                            break;
                    }
                }
                Files.write(Paths.get("D:\\OOP\\nhanvien.txt"),lines);
                
            } catch (Exception e) {
                // System.err.println("Loi khi xu ly file: " + e.getMessage());
            }
        }
        public void capNhatfile()
        {
            try {
                FileWriter fw= new FileWriter("nhanvien.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (nhanVien nhanVien2 : NHANVIEN) {
                    bw.write(nhanVien2.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println("Loi khi xu cap nhat file");
            }
        }

    }

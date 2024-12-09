package KhachHang;

import Admin.MayTinh;
import Admin.Phong;
import Game.game;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DSKhachHang {
    private ArrayList <KhachHang> dsKhachHang;
    protected ArrayList<game> GAME;
    private ArrayList<Phong> DSPhong;
    private Scanner sc = new Scanner(System.in);
    public int b=-1;
    protected int thoigiandn;
    public double tongtien;
    public DSKhachHang(ArrayList<KhachHang> dsKhachHang, Scanner sc) {
        this.dsKhachHang = dsKhachHang;
        this.sc = sc;
    }

    public DSKhachHang()
    {
        dsKhachHang= new ArrayList<>();
        GAME = new ArrayList<>();
        DSPhong = new ArrayList<>();
        docFile();
        docfile1();
        DSgame();
        docfileMayTinh();
    }

    public void themKhach()
    {
        try {
            KhachHang kh= new KhachHang();
            kh.Nhap();
            kh.setLoaiKhachHang("Khach hang binh thuong");
            int dem=0;
            for(KhachHang k: dsKhachHang)
                if(k.getMaKH().equals(kh.getMaKH()))
                    dem++;
            if(dem==0)
            {
                dsKhachHang.add(kh);
                ghiDSKH(kh);

            }
            else 
                System.out.println("Da co ma khach hang nay");
        } catch (Exception e) {
            System.out.println("Loi khi them  khach hang"+e.getMessage());
        }
    }

    // public KhachHang dangNhap()
    // {
    //     System.out.println("Nhap ma cua khach hang: ");
    //     String maKH= sc.nextLine();
    //     KhachHang kh= timKhachHang(maKH);
    //     if(kh==null)
    //     {
    //         System.out.println("May la ai?");
    //         return null;
    //     }
    //     int thu=0;
    //     while (thu<3) {
    //         System.out.println("Nhap vao mat khau: ");
    //         String mk= sc.nextLine();
    //         if(kh.kiemTraMK(mk))
    //             return kh;
    //         else 
    //         {
    //             thu++;
    //             System.out.println("Mat khau sai. Ban con "+(3-thu)+" lan thu");
    //         }
    //     }

    //     System.out.println("Ban nhap sai qua 3 lan. Ban quen mat khau, co muon khoi phuc (Y|N)");
    //     String luaChon=sc.nextLine();
    //     if(luaChon.equalsIgnoreCase("Y"))
    //         quenMatKhau(kh);
    //     return null;
    // }

    public void quenMatKhau(KhachHang kh)
    {
        System.out.println("Xac thuc so dien thoai");
        String sdt=sc.nextLine();
        System.out.println("Ten cua khach hang");
        String hoTen=sc.nextLine();
        if(sdt.equals(kh.getSdt()) && hoTen.equals(kh.getTenKH()))
        {
            System.out.println("Xac thuc thanh cong! Vui long nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            while (!kh.kiemTraDoManhMatKhau(matKhauMoi) || matKhauMoi.equals(kh.getMatKhau()) ) {
                System.out.println("Mat khau khong du manh va khong duoc giong mat khau gan nhat. Vui long nhap lai: ");
                matKhauMoi = sc.nextLine();
            }
            kh.setMatKhau(matKhauMoi);
            capNhatThongTinKhachHang(kh);
            System.out.println("Dat lai mat khau thanh cong!");
        }
        else
            System.out.println("Thong tin xac thuc khong chinh xac");
    }
    public void capNhatThongTinKhachHang(KhachHang kh)
    {
        try {
            BufferedReader br= new BufferedReader(new FileReader("dsKhachHang.txt"));
            List<String> dsKhach= new ArrayList<>();
            String line;
            while((line=br.readLine())!=null)
                dsKhach.add(line);
            br.close();

            for (int i = 0; i < dsKhach.size(); i++) {
                String [] phan=dsKhach.get(i).split(",");
                if(phan[1].equals(kh.getMaKH()))
                {
                    phan[2]= kh.getMatKhau();
                    dsKhach.set(i,String.join(",",phan));
                    break;
                }
            }
            BufferedWriter bw= new BufferedWriter(new FileWriter("dsKhachHang.txt"));
            for (String khach : dsKhach) {
                bw.write(khach);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Loi khi cap nhat: " + e.getMessage());
        }
    }
    public void docFile()
    {
        try {
            FileReader fr= new FileReader("dsKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null) 
            {
                String [] txt =line.split(",");
                
                    String tenKH=txt[0];
                    String maKH=txt[1];
                    String mk=txt[2];
                    String sdt=txt[3];
                    String soTie=txt[4];
                    double soTien=Double.parseDouble(soTie);
                    String soGioCho=txt[5];
                    int soGioChoi=Integer.parseInt(soGioCho);
                    String diem=txt[7];
                    int soDiem=Integer.parseInt(diem);
                    String loaiKhach=txt[6];
                    if(loaiKhach.equals("Khach hang binh thuong"))
                    {
                        KhachHang kh= new KhachHang(tenKH, maKH, mk ,sdt, soTien, soGioChoi,loaiKhach);
                    // Đây là nơi bạn cần thêm vào danh sách khách hàng
                    dsKhachHang.add(kh);
                    }
                    else
                    {
                        KhachHangVIP KHV = new KhachHangVIP(soDiem, tenKH, maKH, mk, sdt, soTien, soGioChoi, loaiKhach);
                    dsKhachHang.add(KHV);
                    }
                    
                    
                
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so: " + e.getMessage());
        }
    }
    
    public void ghiDSKH(KhachHang kh)
    {
        try {
            FileWriter fw= new FileWriter("dsKhachHang.txt",true);
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write(kh.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: "+e.getMessage());
        }
    }

    public void capNhatFileKh()
    {
        try {
            FileWriter fw= new FileWriter("dsKhachHang.txt",false);
            BufferedWriter bw= new BufferedWriter(fw);
            for (KhachHang khachHang : dsKhachHang) {
                bw.write(khachHang.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: "+e.getMessage());
        }
    }

    public void xoaKhachHang(String maKH)
    {
        dsKhachHang.removeIf(khachHang -> maKH.equals(khachHang.getMaKH()));
        capNhatFileKh();
    }

    public KhachHang timKhachHang(String maKH)
    {
        for (KhachHang khachHang : dsKhachHang) {
            if(khachHang.getMaKH().equals(maKH))
                return khachHang;
        }
        return null;
    }
    public void hienThiDSKH()
    {
        System.out.println("Danh sach khach hang");
        for (KhachHang khachHang : dsKhachHang) {
            System.out.println("Ma khach hang: "+khachHang.getMaKH());
            System.out.println("Ten khach hang: "+khachHang.getTenKH());
            System.out.println("Loai khach hang: "+khachHang.getLoaiKhachHang());
            System.out.println("Ma khach hang: "+khachHang.getSdt());
        }
    }
    public void dn(String STK, String MK)
    {
        
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if(STK.equals(dsKhachHang.get(i).maKH)&&MK.equals(dsKhachHang.get(i).getMatKhau()))
            {
                b=i;
                System.out.println("Dang nhap thanh cong !");
                LocalDateTime time = LocalDateTime.now();
                thoigiandn = time.getHour();
                
                break;
               
            }

        }
     
    }
    public void DKVIP()
    {
        if(dsKhachHang.get(b).soTien >=200000)
        {
            dsKhachHang.get(b).loaiKhachHang="Khach Hang Vip";
            dsKhachHang.get(b).soTien-=200000;
            try {
                List<String> lines = readAllLines(Paths.get("dsKhachHang.txt"));
                String line = "";
                for (int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).startsWith(dsKhachHang.get(b).maKH))
                    {
                        line = dsKhachHang.get(b).tenKH + "," +  dsKhachHang.get(b).maKH + "," +dsKhachHang.get(b).getMatKhau() + "," + dsKhachHang.get(b).sdt + ","
                        + dsKhachHang.get(b).soTien + "," + dsKhachHang.get(b).soGioChoi + ","  + dsKhachHang.get(b).loaiKhachHang+","+"0";
                        lines.set(i, line);
                        break;
                    }
                        
                }
                Files.write(Paths.get("dsKhachHang.txt"),lines);
            } catch (Exception e) {
            }
        }
        else
            System.out.println("So du cua ban khong du !");
        

    }
    public void ghilai()
    {
        try {
            List<String> lines = readAllLines(Paths.get("dsKhachHang.txt"));
            String line = "";
            for (int i = 0; i < lines.size(); i++) {
                if(lines.get(i).startsWith(dsKhachHang.get(b).maKH))
                {
                    if(dsKhachHang.get(b) instanceof KhachHangVIP)
                        line = dsKhachHang.get(b).tenKH + "," +  dsKhachHang.get(b).maKH + "," +dsKhachHang.get(b).getMatKhau() + "," + dsKhachHang.get(b).sdt + ","
                        + dsKhachHang.get(b).soTien + "," + dsKhachHang.get(b).soGioChoi + ","  + dsKhachHang.get(b).loaiKhachHang+","+ ((KhachHangVIP)dsKhachHang.get(b)).diemThuong;
                    else
                        line = dsKhachHang.get(b).tenKH + "," +  dsKhachHang.get(b).maKH + "," +dsKhachHang.get(b).getMatKhau() + "," + dsKhachHang.get(b).sdt + ","
                        + dsKhachHang.get(b).soTien + "," + dsKhachHang.get(b).soGioChoi + ","  + dsKhachHang.get(b).loaiKhachHang+"0";
                    lines.set(i, line);
                    break;
                }
                    
            }
            Files.write(Paths.get("dsKhachHang.txt"),lines);
        } catch (Exception e) {
        }
    }
    public int ktra(String STK)
    {
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if(STK.equals(dsKhachHang.get(i).maKH))
                return i;
        }
        return -1;
    }
    public void xemThongTin()
    {
        LocalDateTime thoigianht = LocalDateTime.now();
        int gioht = thoigianht.getHour();
        int sogiodachoi;
        sogiodachoi = gioht - thoigiandn;
        System.out.println("So tai khoan: "+dsKhachHang.get(b).maKH);
        System.out.println("Ten tai khoan: "+dsKhachHang.get(b).tenKH);
        System.out.println("Loai khach hang: "+dsKhachHang.get(b).loaiKhachHang);
        System.out.println("Thoi gian da dang ky: "+dsKhachHang.get(b).soGioChoi);
        System.out.println("Thoi gian con lai: "+(dsKhachHang.get(b).soGioChoi-sogiodachoi));
        System.out.println("So du: "+dsKhachHang.get(b).getSoTien());
        
    }
    public void doimk()
    {
        String mkcu, mkmoi;
        String sdt;
        System.out.print("Nhap vao mat khau cu: ");
        mkcu = sc.nextLine();
        while (!mkcu.equals(dsKhachHang.get(b).getMatKhau())) { 
            System.out.println("Mat khau cu khong dung");
            System.out.print("Nhap vao mat khau cu: ");
            mkcu = sc.nextLine();
        }
        System.out.print("nhap vao mat khau moi: ");
        mkmoi = sc.nextLine();
        while (!dsKhachHang.get(b).kiemTraDoManhMatKhau(mkmoi)) { 
            System.out.println("Mat khau moi khong du manh !");
            System.out.print("nhap vao mat khau moi: ");
            mkmoi = sc.nextLine();
        }
        System.out.print("Nhap vao so dien thoai: ");
        sdt = sc.nextLine();
        while(!sdt.equals(dsKhachHang.get(b).sdt))
        {
            System.out.println("So dien thoai khong trung khop !");
            System.out.print("Nhap vao so dien thoai: ");
            sdt = sc.nextLine();
        }
        dsKhachHang.get(b).setMatKhau(mkmoi);
        System.out.println("Cap nhat thanh cong !");
    }
    public void napTien()
    {
        double x ;
        System.out.print("Nhap vao so tien muon chuyen: ");
        x=sc.nextDouble();
        dsKhachHang.get(b).napTien(x);
        System.out.println("Nap tien thanh cong !");
        capNhatFileKh();
    }
    public void DSgame(){
        try {
            FileReader fr = new FileReader("game.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
             while (true) { 
                line = br.readLine();
                if(line == null)
                    break;
                String txt[] = line.split(";");
                String maGame = txt[0];
                String tenGame = txt[1];
                double gia = Double.parseDouble(txt[2]);
                int so =Integer.parseInt(txt[3]);
                game game = new game(maGame, tenGame, gia, so);
                GAME.add(game);
             }
        } catch (Exception e) {
        }
    }
    public void themGame(){
        game g = new game();
        g.nhap();
        GAME.add(g);
        try {
            FileWriter fw = new FileWriter("game.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(g.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void dsgame()
    {   
        System.out.println("Danh sach game: ");
        for (game g : GAME) {
            System.out.println("+maGame: "+g.getMaGame()+"    +tenGame: "+g.getTenGame()+"    +gia: "+g.getGia());
            System.out.println("--------------------------------------------------------");  
        }
    }
    public int timkiem(String maGame)
    {
        for (int i = 0; i <GAME.size(); i++) {
            if(maGame.equals(GAME.get(i).getMaGame()))
                return i;
        }
        return -1;
    }
    public void dsGameDaThue(){
        try {
            FileReader fr = new FileReader("dkgame.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) { 
                line = br.readLine();
                if(line==null)
                    break;
                String docgame [] = line.split(";");
                String makh = docgame[0];
                String magame = docgame[1];
                if(makh.equals(dsKhachHang.get(b).maKH))
                {
                    for (int i = 0; i < GAME.size(); i++) {
                        if(magame.equals(GAME.get(i).getMaGame()))
                        System.out.println("Ten game: "+GAME.get(i).getMaGame()+" | Gia: "+GAME.get(i).getGia());
                    }
                    
                }
            }
        } catch (Exception e) {
        }
    }
    public void chonGame(String maGame)
    {
        int s;
        s=timkiem(maGame);

    }
    public void dkgame(String mag)
    {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String thoigian = time.format(formatter);
        for (int i = 0; i < GAME.size(); i++) {
            if(mag.equals(GAME.get(i).getMaGame()))
            {
                try {
                    FileWriter fw = new FileWriter("dkgame.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(dsKhachHang.get(b).maKH+";"+GAME.get(i).getMaGame()+";"+thoigian);
                    bw.newLine();
                    bw.close();
                    fw.close(); 
                } catch (Exception e) {
                }
            }
        }
    }
    public void xoaGame(String maGame)
    {
        int demg=0;
        for (int i = 0; i < GAME.size(); i++) {
            if(maGame.equals(GAME.get(i).getMaGame()))
            {
                 demg++;
                 break;
            }
               
        }
        if(demg==0)
        {
            System.out.println("ma game khong ton tai, xoa that bai !");
        }
        else{
            GAME.removeIf(game -> game.getMaGame().equals(maGame));
            try {
                List<String> lines = readAllLines(Paths.get("game.txt"));
                for (int i=0;i<lines.size();i++) {
                    if(lines.get(i).startsWith(maGame))
                    {
                        lines.remove(i);
                        break;
                    }
                       
                }
                Files.write(Paths.get("game.txt"),lines);
            } catch (Exception e) {
            }
            System.out.println("Cap nhat thanh cong !");
        }
       
    }
    public void docfile1() {
        try {
            FileReader fr = new FileReader("dsphong.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals("Danh sach may tinh") && 
                    !line.equals("-------------------------------")) {
                    String[] txt = line.split(",");
                    if (txt.length == 3) {
                        String maph = txt[0];
                        String loaiph = txt[1];
                        String phiph = txt[2];
                        double phiphong = Double.parseDouble(phiph.trim());
                        Phong ph = new Phong(maph, loaiph, phiphong);
                        DSPhong.add(ph);
                    }
                } else if (line.equals("Danh sach may tinh")) {
                    break;
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so: " + e.getMessage());
        }
    }
    

    public void docfileMayTinh() {
        try {
            FileReader fr = new FileReader("dsMayTinh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 8) { // Đảm bảo có đủ 8 phần tử (mã phòng + 7 thuộc tính máy tính)
                    String maPhong = txt[0]; // Mã phòng
                    String maMay = txt[1]; // Mã máy
                    String cpu = txt[2];
                    String ram = txt[3];
                    String gpu = txt[4];
                    String loaiMay = txt[5];
                    String trangThai = txt[6];
                    double giaGio = Double.parseDouble(txt[7].trim());
    
                    MayTinh mt = new MayTinh(maMay, cpu, ram, gpu, loaiMay, trangThai, giaGio);
    
                    Phong phong = timPhong(maPhong);
                    if (phong != null) {
                        phong.getDSMAYTINH().add(mt);
                    } else {
                        System.out.println("Không tìm thấy phòng với mã: " + maPhong);
                    }
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file máy tính: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số: " + e.getMessage());
        }
    }
    public void themPhong() {
        try {
            Phong pm = new Phong();
            pm.Nhap();
            int ddem =0;
            for (Phong phong : DSPhong) {
                if(pm.getMaPhong().equals(phong.getMaPhong())){
                    ddem++;
                }
            }
            if(ddem==0)
            {
                DSPhong.add(pm);
                ghiFilePhong(pm);
                System.out.println("Them thanh cong");
            }
            else 
                System.out.println("Da co ma phong");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm phòng: " + e.getMessage());
        }
    }


    public void ghiFilePhong(Phong pm) {
        try {
            FileWriter fw = new FileWriter("dsphong.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pm.toString());
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void capNhatfile() {
        try {
            FileWriter fw = new FileWriter("dsphong.txt"); 
            BufferedWriter bw = new BufferedWriter(fw);
            for (Phong pm : DSPhong) {
                if (pm != null) {
                    bw.write(pm.toString());
                    bw.newLine();
                    if (pm.getDSMAYTINH() == null) {
                        bw.write("Khong co may tinh nao trong phong");
                    } else if (pm.getDSMAYTINH().isEmpty()) {
                        bw.write("Khong co may tinh nao trong phong");
                    } else {
                        bw.write("Danh sach may tinh:");
                        bw.newLine();
                        for (MayTinh mt : pm.getDSMAYTINH()) {
                            if (mt != null) {
                                bw.write("\t" + mt.toString());
                                bw.newLine();
                            } else {
                                System.out.println("Null MayTinh detected in phong: " + pm.getMaPhong());
                            }
                        }
                    }
                    bw.write("-------------------------------");
                    bw.newLine();
                } else {
                    System.out.println("Null Phong detected in DSPhong.");
                }
            }
            bw.close();
            fw.close();
            System.out.println("Cap nhat file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi cap nhat file: " + e.getMessage());
        }
    }
    

    public void xoaPhong(String maPhong) {
        DSPhong.removeIf(pm -> maPhong.equals(pm.getMaPhong()));
    }

    public Phong timPhong(String maPhong) {
        for (Phong p : DSPhong)
            if (p.getMaPhong().equals(maPhong))
                return p;
        return null;
    }

    public void hienThiDSPhong() {
        System.out.println("DANH SACH PHONG DON");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Don")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG DOI");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Doi")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG VIP");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("phong Vip")) {
                hienThiThongTinPhong(p);
            }
        }

        System.out.println("DANH SACH PHONG THI DAU");
        for (Phong p : DSPhong) {
            if (p.getLoaiPhong().equals("Phong thi Dau")) {
                hienThiThongTinPhong(p);
            }
        }
    }

    public void hienThiDSPhong(String loaiPhong)
    {
        if(loaiPhong.equals("phong Don")){
            System.out.println("DANH SACH PHONG DON");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Don")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
    
        if(loaiPhong.equals("phong Doi")){
            System.out.println("DANH SACH PHONG DOI");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Doi")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
        
        if(loaiPhong.equals("phong Vip")){
            System.out.println("DANH SACH PHONG VIP");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("phong Vip")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
       
        if(loaiPhong.equals("phong Thi Dau")){
            System.out.println("DANH SACH PHONG THI DAU");
            for (Phong p : DSPhong) {
                if (p.getLoaiPhong().equals("Phong thi Dau")) {
                    hienThiThongTinPhong(p);
                }
            }
        }
    }
    
    private void hienThiThongTinPhong(Phong p) {
        System.out.println(p.getMaPhong()+" ,Phi phong: " + p.getPhiPhong());
    }

    public ArrayList<Phong> getDSPhong() {
        return DSPhong;
    }

    public void setDSPhong(ArrayList<Phong> dSPhong) {
        DSPhong = dSPhong;
    }
    public void chonph()
    {
        System.out.println("Ban muon cho loai phong nao");
        System.out.println("phong Don || phong Doi || phong Vip || phong Thi Dau");
        System.out.println("Loai phong ban muon choi: ");
        String loaiPhong= sc.nextLine();
        switch (loaiPhong) {
            case "phong Don":
                hienThiDSPhong(loaiPhong);
                System.out.println("Chon phong: ");
                String mp2= sc.nextLine();
                Phong p1=timPhong(mp2);
                if(p1!=null)
                {
                    p1.hienThiDanhSachMayTinh();
                    System.out.println("Chon may ban muon choi: ");
                    String maMay=sc.nextLine();
                    MayTinh m1=p1.timMayTinh(maMay);
                    if(m1!=null)
                    {
                        m1.setTrangThai("Da dat");
                        p1.capNhatTrangThaiMay(m1);
                        capNhatfile();
                        ghilaiph(mp2, maMay);
                    }

                    else 
                        System.out.println("May da duoc dat || bao tri");
                }
                break;
            case "phong Doi":
                hienThiDSPhong(loaiPhong);
                System.out.println("Chon phong: ");
                String mp3= sc.nextLine();
                Phong p2=timPhong(mp3);
                if(p2!=null)
                {
                    p2.hienThiDanhSachMayTinh();
                    System.out.println("Chon may ban muon choi: ");
                    String maMay=sc.nextLine();
                    Admin.MayTinh m1=p2.timMayTinh(maMay);
                    if(m1!=null)
                    {
                        m1.setTrangThai("Da dat");
                        p2.capNhatFileMayTinh();
                        capNhatfile();
                        ghilaiph(mp3, maMay);
                    }
                    else 
                        System.out.println("May da duoc dat || bao tri");
                }
                break;
            case "phong Vip":
                hienThiDSPhong(loaiPhong);
                System.out.println("Chon phong: ");
                String mp4= sc.nextLine();
                Phong p3=timPhong(mp4);
                if(p3!=null)
                {
                    p3.hienThiDanhSachMayTinh();
                    System.out.println("Chon may ban muon choi: ");
                    String maMay=sc.nextLine();
                    Admin.MayTinh m1=p3.timMayTinh(maMay);
                    if(m1!=null)
                    {
                        m1.setTrangThai("Da dat");
                        p3.capNhatFileMayTinh();
                        capNhatfile();
                        ghilaiph(mp4, maMay);
                    }
                    else 
                        System.out.println("May da duoc dat || bao tri");
                }
                break;
            case "phong Thi Dau":
                hienThiDSPhong(loaiPhong);
                System.out.println("Chon phong: ");
                String mp5= sc.nextLine();
                Phong p4=timPhong(mp5);
                if(p4!=null)
                {
                    p4.hienThiDanhSachMayTinh();
                    for(Admin.MayTinh mt: p4.getDSMAYTINH())
                    {
                        mt.setTrangThai("Da dat");
                        p4.capNhatFileMayTinh();
                        capNhatfile();
                        ghilaiph(mp5, "null");
                    }
                }
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }
    public void ghilaiph(String maph, String mamay)
    {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String thoigian = time.format(formatter);
        try {
            FileWriter fw = new FileWriter("datphong.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dsKhachHang.get(b).maKH+";"+maph+";"+mamay+";"+thoigian);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void dkGioChoi(int gio)
    {
        dsKhachHang.get(b).setSoGioChoi(gio);
        System.out.println("Dang ky thanh cong !");
    }
    public void xembl(){
        double giaph=0,giamay=0;
        double giagame=0;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String thoigian = time.format(formatter);
        try {
            FileReader fr = new FileReader("datphong.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) { 
                line = br.readLine();
                if(line == null)
                    break;
                String txt[] = line.split(";");
                String stk = txt[0];
                String maph = txt[1];
                String mamay = txt[2];
                String ngay=txt[3];
                if(stk.equals(dsKhachHang.get(b).maKH))
                {
                    for (int i = 0; i < DSPhong.size(); i++) {
                        if(maph.equals(DSPhong.get(i).getMaPhong())&&ngay.equals(thoigian))
                        {
                            giaph = giaph+DSPhong.get(i).getPhiPhong();
                            break;
                        }
                        
                    }
                    for(int i=0;i<DSPhong.size();i++)
                    {
                        for(int j =0;j<DSPhong.get(i).getDSMAYTINH().size();j++)
                        {
                            if(DSPhong.get(i).getMaPhong().equals(maph)&&DSPhong.get(i).getDSMAYTINH().get(j).getMaMay().equals(mamay)&&ngay.equals(thoigian))
                            {
                                giamay = giamay+DSPhong.get(i).getDSMAYTINH().get(j).getGiaGio();
                                break;
                            }
                        }
                    }
                }
               
            }
            FileReader fr1 = new FileReader("dkgame.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            String line1 = "";
            while (true) { 
                line1 = br1.readLine();
                if(line1==null)
                    break;
                String dsgame[] = line1.split(";");
                String manv1 = dsgame[0];
                String magame = dsgame[1];
                String ngay1 = dsgame[2];
                if(manv1.equals(dsKhachHang.get(b).maKH))
                {
                    for (int i = 0; i < GAME.size(); i++) {
                        if(magame.equals(GAME.get(i).getMaGame())&&ngay1.equals(thoigian))
                        {
                            giagame = giagame+ GAME.get(i).getGia();
                        }
                    }
                }
            }

        } catch (Exception e) {
        }
        tongtien=giagame+(giamay*dsKhachHang.get(b).getSoGioChoi())+giaph;
        System.out.println("Thoi gian: "+thoigian);
        System.out.println("Phi phong: "+giaph);
        System.out.println("Gia may: "+giamay);
        System.out.println("So gio da dang ky: "+dsKhachHang.get(b).getSoGioChoi());
        System.out.println("Gia game: "+giagame);
        System.out.println("Tong tien: "+tongtien);
        
    }
    public void dangxuat()
    {
        tinhtien();
        dsKhachHang.get(b).setSoTien(dsKhachHang.get(b).getSoTien()-tongtien);
        dsKhachHang.get(b).setSoGioChoi(0);
        capNhatFileKh();
        capNhatTrangThaiMayT();
       
         b=-1;
        System.out.println("Dang Xuat !");
    }
    public boolean ktraTK(String STK)
    {
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if(STK.equals(dsKhachHang.get(i).maKH)&&dsKhachHang.get(i).loaiKhachHang.equals("Khach hang binh thuong"))
            {
                return true;
            }
        }
        return false;
    }
    public void tinhtien(){
        double giaph=0,giamay=0;
        double giagame=0;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String thoigian = time.format(formatter);
        try {
            FileReader fr = new FileReader("datphong.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) { 
                line = br.readLine();
                if(line == null)
                    break;
                String txt[] = line.split(";");
                String stk = txt[0];
                String maph = txt[1];
                String mamay = txt[2];
                String ngay=txt[3];
                if(stk.equals(dsKhachHang.get(b).maKH))
                {
                    for (int i = 0; i < DSPhong.size(); i++) {
                        if(maph.equals(DSPhong.get(i).getMaPhong())&&ngay.equals(thoigian))
                        {
                            giaph = giaph+DSPhong.get(i).getPhiPhong();
                            break;
                        }
                        
                    }
                    for(int i=0;i<DSPhong.size();i++)
                    {
                        for(int j =0;j<DSPhong.get(i).getDSMAYTINH().size();j++)
                        {
                            if(DSPhong.get(i).getMaPhong().equals(maph)&&DSPhong.get(i).getDSMAYTINH().get(j).getMaMay().equals(mamay)&&ngay.equals(thoigian))
                            {
                                giamay = giamay+DSPhong.get(i).getDSMAYTINH().get(j).getGiaGio();
                                break;
                            }
                        }
                    }
                }
               
            }
            FileReader fr1 = new FileReader("dkgame.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            String line1 = "";
            while (true) { 
                line1 = br1.readLine();
                if(line1==null)
                    break;
                String dsgame[] = line1.split(";");
                String manv1 = dsgame[0];
                String magame = dsgame[1];
                String ngay1 = dsgame[2];
                if(manv1.equals(dsKhachHang.get(b).maKH))
                {
                    for (int i = 0; i < GAME.size(); i++) {
                        if(magame.equals(GAME.get(i).getMaGame())&&ngay1.equals(thoigian))
                        {
                            giagame = giagame+ GAME.get(i).getGia();
                        }
                    }
                }
            }

        } catch (Exception e) {
        }
         tongtien = giagame+(giamay*dsKhachHang.get(b).getSoGioChoi())+giaph;
    }
    public boolean  ktrasodu()
    {
        tinhtien();
        if(tongtien<=dsKhachHang.get(b).soTien)
            return true;
        else
            return false;
    }
    public void capNhatTrangThaiMayT()
    {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String thoigian = time.format(formatter);
        try {
            FileReader fr = new FileReader("datphong.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) { 
                line = br.readLine();
                if(line == null)
                    break;
                String txt[] = line.split(";");
                String stk = txt[0];
                String maph = txt[1];
                String mamay = txt[2];
                String ngay = txt[3];
                if(stk.equals(dsKhachHang.get(b).maKH)&&ngay.equals(thoigian))
                {
                    for (int i = 0; i < DSPhong.size(); i++) {
                        if(maph.equals(DSPhong.get(i).getMaPhong()))
                            for(int j = 0; j<DSPhong.get(i).getDSMAYTINH().size();j++)
                                if(mamay.equals(DSPhong.get(i).getDSMAYTINH().get(j).getMaMay()))
                                {
                                    DSPhong.get(i).getDSMAYTINH().get(j).setTrangThai("Chua dat");
                                    DSPhong.get(i).capNhatTrangThaiMay(DSPhong.get(i).getDSMAYTINH().get(j)); 
                                    capNhatfile();
                                    break;

                                }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm phòng: " + e.getMessage());
        }
    }
}

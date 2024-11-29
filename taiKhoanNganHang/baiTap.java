package taiKhoanNganHang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class baiTap{

    public static void main(String[] args) {
        int s = 0;
        ArrayList<taiKhoan> TAIKHOAN = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int lc,a;
        do { 
            System.out.println("--------------menu------------");
            System.out.println("| 1. Admin                   |");
            System.out.println("| 2. Khach hang              |");
            System.out.println("| 0. Thoat                   |");
            System.out.println("--------------menu------------");
            System.out.print("Nhap vao lua chon: ");
            a=sc.nextInt();
            sc.nextLine();
            switch(a)
            {
                case 1:
                    int b;
                    do { 
                        System.out.println("--------------menu------------");
                        System.out.println("| 1. Them tai khoan          |");
                        System.out.println("| 2. Xoa tai khoan           |");
                        System.out.println("| 0. Thoat                   |");
                        System.out.println("--------------menu------------");
                        System.out.print("Nhap vao lua chon: ");
                        b=sc.nextInt();
                        sc.nextLine();
                        switch (b) {
                            case 1:
                                int loai;

                                do {
                                    System.out.println("---------------menu-------------");
                                    System.out.println("| 1. Them tai khoan thanh toan |");
                                    System.out.println("| 2. Them tai khoan tiet kiem  |");
                                    System.out.println("| 0. Thoat                     |");
                                    System.out.println("---------------menu-------------");
                                    System.out.print("nhap vao lua chon: ");
                                    loai = sc.nextInt();
                                    sc.nextLine();
                                    switch (loai) {
                                        case 1:
                                            taiKhoanThanhToan tkttNew = new taiKhoanThanhToan();
                                            tkttNew.nhap_tt();
                                            for (int i = 0; i < TAIKHOAN.size(); i++) {
                                                if(tkttNew.STK.equals(TAIKHOAN.get(i).STK))
                                                {
                                                    System.out.println("So tai khoan da ton tai !");
                                                    break;
                                                }
                                            }
                                            TAIKHOAN.add(tkttNew);
                                            try {
                                                FileWriter fw = new FileWriter("taikhoan.txt",true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.write(tkttNew.toString());
                                                bw.newLine();
                                                bw.close();
                                                fw.close();
                                            } catch (Exception e) {
                                            }
                                            break;
                                        case 2:
                                            taiKhoanTietKiem tktk = new taiKhoanTietKiem();
                                            tktk.nhap();
                                            for (int i = 0; i < TAIKHOAN.size(); i++) {
                                                if(tktk.STK.equals(TAIKHOAN.get(i).STK))
                                                {
                                                    System.out.println("So tai khoan da ton tai !");
                                                    break;
                                                }
                                            }
                                            
                                            try {
                                                FileWriter fw = new FileWriter("taikhoan.txt",true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.write(tktk.toString());
                                                bw.newLine();
                                                bw.close();
                                                fw.close();
                                            } catch (Exception e) {
                                                System.out.println("lox");
                                            }
                                            TAIKHOAN.add(tktk);
                                            break;
                                        case 0:
                                            System.out.println("thoat chuong trinh !");
                                            break;
                                        default:
                                            System.out.println("lua chon khong hop le moi nhap lai !");
                                            break;
                                    }
                                } while (loai != 0);
                                break;
                            case 2:
                                String stt;
                                System.out.println("Nhap so tai khoan muon xoa: ");
                                stt=sc.nextLine();        
                                try {
                                    List<String> lines4 = readAllLines(Paths.get("taikhoan.txt"));
                                    for(int i = 0; i<lines4.size(); i++)
                                    {
                                        if(lines4.get(i).startsWith(TAIKHOAN.get(s).STK))
                                        {
                                        lines4.remove(i);
                                        break;
                                        }
                                        
                                    }
                                    Files.write(Paths.get("taikhoan.txt"), lines4);
                                } catch (IOException e) {
                                    System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                }
                                TAIKHOAN.removeIf(taiKhoan -> taiKhoan.STK.equals(stt));
                                System.out.println("Tai khoan da bi xoa !");
                                break;
                            case 0:
                                System.out.println("Thoat !");
                                break;
                            default:
                                System.out.println("Lua chon khong hop le, vui long nhap lai !");
                        }
                    } while (b!=0);
                    break;
                case 2 :
                    do {
                        System.out.println("--------------menu------------");
                        System.out.println("| 1. Dang nhap               |");
                        System.out.println("| 0. Thoat                   |");
                        System.out.println("--------------menu------------");
                        System.out.print("moi lua chon chuc nang: ");
                        lc = sc.nextInt();
                        sc.nextLine();
                        switch (lc) {
                            case 1:
                                int c,dem = 0;
                                String STK, 
                                passWord;
                                int otp = 0;
                                try {
                                    FileReader fr = new FileReader("taikhoan.txt");
                                    BufferedReader br = new BufferedReader(fr);
                                    String line = "";
                                    while (true) { 
                                        line = br.readLine();
                                        if(line == null)
                                            break;
                                        String docTK[] = line.split(";");
                                        String sotaikhoan = docTK[0];
                                        String Ten = docTK[1];
                                        double sdu = Double.parseDouble(docTK[2]);
                                        String mk = docTK[3];
                                        String mapin = docTK[4];
                                        String sdt = docTK[5];
                                        String l = docTK[6];
                                        // dem_d ++;
                                        if(l.equals("TT"))
                                        {
                                            taiKhoanThanhToan tt = new taiKhoanThanhToan(sotaikhoan, Ten, sdu, mk,mapin, otp, sdt);
                                            TAIKHOAN.add(tt);
                                        }
                                        if(l.equals("TK"))
                                        {
                                            taiKhoanTietKiem tk = new taiKhoanTietKiem(sotaikhoan, Ten, sdu, mk,mapin, otp, sdt);
                                            TAIKHOAN.add(tk);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                if(TAIKHOAN.size()>0)
                                {
                                    System.out.print("vui long nhap vao so tai khoan: ");
                                    STK = sc.nextLine();
                                    System.out.print("vui long nhap vao mat khau: ");
                                    passWord = sc.nextLine();
                                    // for (int i = 0; i < TAIKHOAN.size(); i++) {
                                    //     if (TAIKHOAN.get(i).STK.equals(STK) && TAIKHOAN.get(i).getpassWord().equals(passWord)) {
                                    //         System.out.println("Dang nhap thanh cong !");
                                    //         s = i;
                                    //         dem ++;
                                    //     }
                                    for (taiKhoan tk : TAIKHOAN) { 
                                        if (tk.STK.equals(STK) && tk.getpassWord().equals(passWord)) {
                                            System.out.println("Dang nhap thanh cong !");
                                            s = TAIKHOAN.indexOf(tk);
                                            dem++;
                                            break; 
                                        }
                                        
                                    } 
                                   
                                    
                                    if(dem==0)
                                    {
                                        do { 
                                            dem++;
                                            
                                            System.out.println("so tai khoan hoac mat khau khong dung !");
                                            System.out.println("vui long nhap lai !");
                                            System.out.print("vui long nhap vao so tai khoan: ");
                                            STK = sc.nextLine();
                                            System.out.print("vui long nhap vao mat khau: ");
                                            passWord = sc.nextLine();
                                            for (taiKhoan tk : TAIKHOAN) { 
                                                if (tk.STK.equals(STK) && tk.getpassWord().equals(passWord)) {
                                                    System.out.println("Dang nhap thanh cong !");
                                                    s = TAIKHOAN.indexOf(tk); // Lưu chỉ số tài khoản
                                                    break; 
                                                }
                                                
                                            } 
                                            if(s!=0)
                                                break;
                                            if(dem ==2)
                                                break;
                                        } while (true);
                                    
                                        if (dem >= 2) {
                                            int Ch;
                                            do
                                            {
                                                System.out.println("--------------menu------------");
                                                System.out.println("| 1. Quen mat khau           |");
                                                System.out.println("| 0. Thoat                   |");
                                                System.out.println("--------------menu------------");
                                                System.out.println("nhap vao lua chon: ");
                                                Ch = sc.nextInt();
                                                switch (Ch) {
                                                    case 1:
                                                        String stknh;
                                                        int t=0,dems =0;
                                                        do
                                                        {
                                                            dems++;
                                                            System.out.println("Nhap vao so tai khoan: ");
                                                            stknh = sc.nextLine();
                                                            for (int i = 0; i < TAIKHOAN.size(); i++) {
                                                                if(stknh.equals(TAIKHOAN.get(i).STK))
                                                                {
                                                                    t=i;
                                                                    break;
                                                                }
                                                            }
                                                            if(dems==3)
                                                                break;
                                                            if(t==0)
                                                                System.out.println("So tai khoan khong dung !");
                                                        }while(t==0);
                                                        if(dems>=3)
                                                            throw new IllegalArgumentException("Thao tac sai qua so lan cho phep !");
                                                        else
                                                            TAIKHOAN.get(t).quenMK();
                                                        try {
                                                            List<String> lines = readAllLines(Paths.get("taikhoan.txt"));
                                                            String line = null;
                                                            for(int i = 0; i<lines.size(); i++)
                                                            {
                                                                if(lines.get(i).startsWith(TAIKHOAN.get(t).STK))
                                                                {
                                                                    if(TAIKHOAN.get(t) instanceof taiKhoanThanhToan)
                                                                        line =  TAIKHOAN.get(t).STK + ";" + TAIKHOAN.get(t).tenTK + ";" + TAIKHOAN.get(t).soDu + ";" +
                                                                        TAIKHOAN.get(t).getpassWord() + ";" + TAIKHOAN.get(t).maPin + ";" + 
                                                                        TAIKHOAN.get(t).SDT + ";" + "TT";
                                                                    else
                                                                    line = TAIKHOAN.get(t).STK + ";" + TAIKHOAN.get(t).tenTK + ";" + TAIKHOAN.get(t).soDu + ";" +
                                                                    TAIKHOAN.get(t).getpassWord() + ";" + TAIKHOAN.get(t).maPin + ";" + 
                                                                    TAIKHOAN.get(t).SDT + ";" + "Tk";
                                                                }
                                                                lines.set(i, line);
                                                                break;
                                                            }
                                                            Files.write(Paths.get("taikhoan.txt"), lines);
                                                        } catch (IOException e) {
                                                            System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                                        }
                                                        break;
                                                    case 0:
                                                        System.out.println("thoat !");
                                                        break;
                                                    default:
                                                        System.out.println("lua chon khong hop le, vui long chon lai !");
                                                        break;
                                                }
                                                break;
                                            }while(Ch !=0);
                                            
                                        }
                                        
                                    }
                                }
                                else
                                {
                                    System.out.println("chua co tai khoan !");
                                    System.out.print("Enter de them tai khoan thanh toan");
                                    String input = sc.nextLine();
                                    if (input.isEmpty()) {
                                        taiKhoanThanhToan tkttNew = new taiKhoanThanhToan();
                                        tkttNew.nhap_tt();
                                        TAIKHOAN.add(tkttNew);
                                        try {
                                            FileWriter fw = new FileWriter("taikhoan.txt",true);
                                            BufferedWriter bw = new BufferedWriter(fw);
                                            bw.write(tkttNew.toString());
                                            bw.newLine();
                                            bw.close();
                                            fw.close();
                                        } catch (Exception e) {
                                        }
                                    }
                                    break;
                                }
                                do {
                                    System.out.println("--------------menu------------");
                                    System.out.println("| 1. Xem thong tin tai khoan |");
                                    System.out.println("| 2. doi mat khau            |");
                                    if(TAIKHOAN.get(s) instanceof taiKhoanThanhToan)
                                        System.out.println("| 3. Gui tien                |");
                                    else
                                        System.out.println("| 3. Gui tiet kiem           |");
                                    System.out.println("| 4. Rut tien                |");
                                    System.out.println("| 5. Chuyen tien             |");
                                    System.out.println("| 6. lich su giao dich       |");
                                    System.out.println("| 7. Dong bang tai khoan     |");
                                    System.out.println("| 8. Mo dong bang tai khoan  |");
                                    System.out.println("| 0. Dang xuat               |");
                                    System.out.println("--------------menu------------");
                                    System.out.print("moi lua chon chuc nang: ");
                                    c = sc.nextInt();
                                    sc.nextLine();
                                    switch (c) {
                                        case 1:
                                            System.out.println("thong tin cua tai khoan la: ");
                                            TAIKHOAN.get(s).xuat();
                                            break;
                                        case 2:
                                            TAIKHOAN.get(s).nhapPassDoi();
                                            try {
                                                List<String> lines = readAllLines(Paths.get("taikhoan.txt"));
                                                String line = null;
                                                for(int i = 0; i<lines.size(); i++)
                                                {
                                                    if(lines.get(i).startsWith(TAIKHOAN.get(s).STK))
                                                    {
                                                        if(TAIKHOAN.get(s) instanceof taiKhoanThanhToan)
                                                            line =  TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                            TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                            TAIKHOAN.get(s).SDT + ";" + "TT";
                                                        else
                                                        line = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                        TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                        TAIKHOAN.get(s).SDT + ";" + "Tk";
                                                    }
                                                    lines.set(i, line);
                                                    break;
                                                }
                                                Files.write(Paths.get("taikhoan.txt"), lines);
                                            } catch (IOException e) {
                                                System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                            }
                                            break;
                                        case 3:
                                            int demt = 0;
                                            try {
                                                List<String> tkhoandb = readAllLines(Paths.get("taikhoandongbang.txt"));
                                                for (int i = 0; i < tkhoandb.size() ; i++) {
                                                    if(tkhoandb.get(i).equals(TAIKHOAN.get(s).STK))
                                                    {
                                                        System.out.println("Tai khoan cua ban da bi dong bang !");
                                                        demt = 1;   
                                                    }
                                                    break;   
                                                } 
            
                                            } catch (Exception e) {
                                            }
                                            if(demt==1)
                                                break;
                                            System.out.print("nhap so tien can gui: ");
                                            double tienGui = sc.nextDouble();
                                            LocalDateTime now2 = LocalDateTime.now();
                                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm dd-MM-YYYY");
                                            String time2 =now2.format(formatter2);
                                            try {
                                                FileWriter fw = new FileWriter("data.txt",true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.write(time2+";"+TAIKHOAN.get(s).STK+";"+TAIKHOAN.get(s).soDu + "+" +tienGui+";"+(TAIKHOAN.get(s).soDu+tienGui)+";"+"null");
                                                bw.newLine();
                                                bw.close();
                                                fw.close();
            
                                            } catch (Exception e) {
                                           
                                            }
                                             TAIKHOAN.get(s).guiTien(tienGui);
                                            try {
                                                List<String> lines2 = Files.readAllLines(Paths.get("taikhoan.txt"));
                                                String line2;
                                                for (int j = 0; j < lines2.size(); j++) { 
                                                    if (lines2.get(j).startsWith(TAIKHOAN.get(s).STK + ";")) {
                                                        if (TAIKHOAN.get(s) instanceof taiKhoanThanhToan) {
                                                            line2 = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                TAIKHOAN.get(s).SDT + ";" + "TT";
                                                        } else {
                                                            line2 = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                TAIKHOAN.get(s).SDT + ";" + "TK";
                                                        }
                                                        lines2.set(j, line2); 
                                                        break; 
                                                    }
            
                                                }
                                                Files.write(Paths.get("taikhoan.txt"), lines2);
                                            } catch (IOException e) {
                                                System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                            }
                                            System.out.println("Gui tien thanh cong !");
                                            break;
                                        case 4:
                                            demt = 0;
                                            try {
                                                List<String> tkhoandb = readAllLines(Paths.get("taikhoandongbang.txt"));
                                                for (int i = 0; i < tkhoandb.size() ; i++) {
                                                    if(tkhoandb.get(i).equals(TAIKHOAN.get(s).STK))
                                                    {
                                                        System.out.println("Tai khoan cua ban da bi dong bang !");
                                                        demt = 1;   
                                                    }
                                                    break;   
                                                } 
            
                                            } catch (Exception e) {
                                            }
                                            if(demt==1)
                                                break;
                                            System.out.print("Nhap vao so tien can rut: ");
                                            double soTien = sc.nextDouble();
                                            
                                            LocalDateTime now1 = LocalDateTime.now();
                                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm dd-MM-YYYY");
                                            String time1 =now1.format(formatter1);
                                            try {
                                                FileWriter fw = new FileWriter("data.txt",true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.write(time1+";"+TAIKHOAN.get(s).STK+";"+TAIKHOAN.get(s).soDu + "-" +soTien+";"+(TAIKHOAN.get(s).soDu-soTien)+";"+"null");
                                                bw.newLine();
                                                bw.close();
                                                fw.close();
            
                                            } catch (Exception e) {
                                            }
                                            TAIKHOAN.get(s).rutTien(soTien);
                                            try {
                                                List<String> lines2 = Files.readAllLines(Paths.get("taikhoan.txt"));
                                                String line2;
                                                for (int j = 0; j < lines2.size(); j++) { 
                                                    if (lines2.get(j).startsWith(TAIKHOAN.get(s).STK + ";")) {
                                                        if (TAIKHOAN.get(s) instanceof taiKhoanThanhToan) {
                                                            line2 = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                TAIKHOAN.get(s).SDT + ";" + "TT";
                                                        } else {
                                                            line2 = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                TAIKHOAN.get(s).SDT + ";" + "TK";
                                                        }
                                                        lines2.set(j, line2); 
                                                        break; 
                                                    }
            
                                                }
                                                Files.write(Paths.get("taikhoan.txt"), lines2);
                                            } catch (IOException e) {
                                                System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                            }
                                            System.out.println("Rut tien thanh cong !");
                                            break;
                                        case 5:
                                            demt = 0;
                                            try {
                                                List<String> tkhoandb = readAllLines(Paths.get("taikhoandongbang.txt"));
                                                for (int i = 0; i < tkhoandb.size() ; i++) {
                                                    if(tkhoandb.get(i).equals(TAIKHOAN.get(s).STK))
                                                    {
                                                        System.out.println("Tai khoan cua ban da bi dong bang !");
                                                        demt = 1;   
                                                    }
                                                    break;   
                                                } 
            
                                            } catch (Exception e) {
                                            }
                                            if(demt==1)
                                                break;
                                            int dem2=0;
                                            System.out.print("nhap vao so tai khoan mmuon chuyen: ");
                                            String stk = sc.nextLine();
                                            System.out.print("nhap vao so tien chuyen: ");
                                            double tienChuyen = sc.nextDouble();
                                            demt = 0;
                                            try {
                                                List<String> tkhoandb = readAllLines(Paths.get("taikhoandongbang.txt"));
                                                for (int i = 0; i < tkhoandb.size() ; i++) {
                                                    if(tkhoandb.get(i).equals(TAIKHOAN.get(s).STK))
                                                    {
                                                        System.out.println("Tai khoan cua ban da bi dong bang !");
                                                        demt = 1;   
                                                    }
                                                    break;   
                                                } 
            
                                            } catch (Exception e) {
                                            }
                                            if(demt==1)
                                                break;
                                            do {
                                                if(tienChuyen <= 0 || tienChuyen > TAIKHOAN.get(s).soDu)
                                                {
                                                    System.out.println("tien chuyen khong hop le hoac so du khong du !");
                                                    System.out.print("nhap vao so tien chuyen: ");
                                                    tienChuyen = sc.nextDouble();
                                                }
                                                
                                            } while (tienChuyen <= 0 || tienChuyen > TAIKHOAN.get(s).soDu);
                                            for (int i = 0; i < TAIKHOAN.size(); i++) {
                                                if (TAIKHOAN.get(i).STK.equals(stk)) {
                                                    LocalDateTime now = LocalDateTime.now();
                                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-YYYY");
                                                    String time =now.format(formatter);
                                                    dem2 ++;
                                                    try {
                                                        FileWriter fw = new FileWriter("data.txt",true);
                                                        BufferedWriter bw = new BufferedWriter(fw);
                                                        bw.write(time+";"+TAIKHOAN.get(s).STK+";"+TAIKHOAN.get(s).soDu + "-" + tienChuyen+";"+(TAIKHOAN.get(s).soDu-tienChuyen)+";"+TAIKHOAN.get(i).STK);
                                                        bw.newLine();
                                                        bw.write(time+";"+TAIKHOAN.get(i).STK+";"+TAIKHOAN.get(i).soDu + "+" +tienChuyen+";"+(TAIKHOAN.get(i).soDu+tienChuyen) +";"+TAIKHOAN.get(s).STK);
                                                        bw.newLine();
                                                        bw.close();
                                                        fw.close();
            
                                                    } catch (Exception e) {
                                                    }
                                                    
                                                    TAIKHOAN.get(i).chuyentien(tienChuyen, 1);
                                                    TAIKHOAN.get(s).chuyentien(tienChuyen, 2);
                                                    try {
                                                        List<String> lines = Files.readAllLines(Paths.get("taikhoan.txt"));
                                                        String line;
                                                        
                                                        for (int j = 0; j < lines.size(); j++) { 
                                                            if (lines.get(j).startsWith(TAIKHOAN.get(s).STK + ";")) {
                                                                if (TAIKHOAN.get(s) instanceof taiKhoanThanhToan) {
                                                                    line = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                        TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                        TAIKHOAN.get(s).SDT + ";" + "TT";
                                                                } else {
                                                                    line = TAIKHOAN.get(s).STK + ";" + TAIKHOAN.get(s).tenTK + ";" + TAIKHOAN.get(s).soDu + ";" +
                                                                        TAIKHOAN.get(s).getpassWord() + ";" + TAIKHOAN.get(s).maPin + ";" + 
                                                                        TAIKHOAN.get(s).SDT + ";" + "TK";
                                                                }
                                                                lines.set(j, line); 
                                                                break; 
                                                            }
            
                                                        }
                                                        Files.write(Paths.get("taikhoan.txt"), lines);
                                                    } catch (IOException e) {
                                                        System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                                    }
                                                    try {
                                                        List<String> lines2 = Files.readAllLines(Paths.get("taikhoan.txt"));
                                                        String line2;
                                                        for (int j = 0; j < lines2.size(); j++) { 
                                                            if (lines2.get(j).startsWith(TAIKHOAN.get(i).STK + ";")) {
                                                                if (TAIKHOAN.get(i) instanceof taiKhoanThanhToan) {
                                                                    line2 = TAIKHOAN.get(i).STK + ";" + TAIKHOAN.get(i).tenTK + ";" + TAIKHOAN.get(i).soDu + ";" +
                                                                        TAIKHOAN.get(i).getpassWord() + ";" + TAIKHOAN.get(i).maPin + ";" + 
                                                                        TAIKHOAN.get(i).SDT + ";" + "TT";
                                                                } else {
                                                                    line2 = TAIKHOAN.get(i).STK + ";" + TAIKHOAN.get(i).tenTK + ";" + TAIKHOAN.get(i).soDu + ";" +
                                                                        TAIKHOAN.get(i).getpassWord() + ";" + TAIKHOAN.get(i).maPin + ";" + 
                                                                        TAIKHOAN.get(i).SDT + ";" + "TK";
                                                                }
                                                                lines2.set(j, line2); 
                                                                break; 
                                                            }
            
                                                        }
                                                       
                                                        Files.write(Paths.get("taikhoan.txt"), lines2);
                                                    } catch (IOException e) {
                                                        System.err.println("Lỗi khi cập nhật tệp: " + e.getMessage());
                                                    }
                                                    System.out.println("Chuyen tien thanh cong !");
                                                    break;
                                                }
                                            }
                                            if(dem2==0)
                                                System.out.println("so tai khoan khong ton tai !");
                                            break;
                                        case 6:
                                            try {
                                                int demso = 0;
                                                FileReader fr = new FileReader("data.txt");
                                                BufferedReader br = new BufferedReader(fr);
                                                String line = "";
                                                while (true) { 
                                                    line = br.readLine();
                                                    if(line == null)
                                                    {   
                                                        if(demso==0)
                                                            System.out.println("Tai khoan nay chua thuc hien giao dich nao !");
                                                        break;
                                                    }
                                                    String txt[] = line.split(";");
                                                    String time = txt[0];
                                                    String soTaiKhoan1 = txt[1];
                                                    String bienDong = txt[2];
                                                    String sodusau= txt[3];
                                                    String soTaiKhoan2 = txt[4];
                                                    if(soTaiKhoan1.equals(TAIKHOAN.get(s).STK))
                                                    {
                                                        demso++;
                                                        System.out.println("------------------------------------------");
                                                        System.out.println("| Thoi gian thuc hien giao dich: "+time);
                                                        System.out.println("| Bien dong so du: "+bienDong);
                                                        System.out.println("| So du: "+sodusau);
                                                        System.out.println("| So tai khoan nhan|chuyen : "+soTaiKhoan2);
                                                        System.out.println("-------------------------------------------");
                                                    }
                                                       
                                                }
                                            } catch (Exception e) {
                                            }
                                            break;
                                        case 7:
                                            try {
                                                FileWriter fw = new FileWriter("taikhoandongbang.txt");
                                                BufferedWriter bw = new BufferedWriter(fw); 
                                                bw.write(TAIKHOAN.get(s).STK);
                                                bw.newLine();
                                                bw.close();
                                                fw.close();
                                            } catch (Exception e) {
                                            }
                                            System.out.println("Dong bang tai khoan thanh cong !");
                                            break;
                                        case 8:
                                            try {
                                                List<String> dstkdb = readAllLines(Paths.get("taikhoandongbang.txt"));
                                                for (int i = 0; i < dstkdb.size(); i++) {
                                                    if(dstkdb.get(i).equals(TAIKHOAN.get(s).STK))
                                                        dstkdb.remove(dstkdb.get(i));
                                                    break;
                                                }
                                                Files.write(Paths.get("taikhoandongbang.txt"),dstkdb);  
                                            } catch (Exception e) {
                                            }
                                            System.out.println("Mo dong bang tai khoan thanh cong !");
                                            break;
                                        case 0:
                                            System.out.println("Dang xuat !");
                                            break;
                                        default:
                                            System.out.println("lua chon khong hop le moi nhap lai !");
                                            break;
                                    }
                                } while (c != 0);
                                break;
                            case 0:
                                System.out.println("thoat chuong trinh !");
                                break;
                            default:
                                System.out.println("lua chon khong hop le moi nhap lai !");
                                break;
                                
                        }
                    } while (lc != 0);
                case 0:
                    System.out.println("Thoat chuong trinh !");
                    break;
                default:
                    System.out.println("Lua chon khong ton tai, vui long chon lai !");
            }
        } while (a!=0);
        
        

    }
}

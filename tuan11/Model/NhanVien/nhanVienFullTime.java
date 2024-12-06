package NhanVien;


import static java.nio.file.Files.readAllLines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class nhanVienFullTime extends  nhanVien{
    protected double phuCap;
    protected Integer cong=0;
    public nhanVienFullTime(){}

    public nhanVienFullTime(double phuCap, LocalDate NgayBD, String SDT, double luongCB, String maNV, String passWord, String tenNV,int cong) {
        super(NgayBD, SDT, luongCB, maNV, passWord, tenNV);
        this.phuCap = phuCap;
        this.cong = cong;
    }
    
    public double getPhuCap() {
        return phuCap;
    }
    public void setPhuCap() {

        if (NgayBD == null) {
            throw new IllegalStateException("Ngày bắt đầu làm việc chưa được khởi tạo!");
        }
        
        int ngayht = LocalDate.now().getYear();
        int ngbd = NgayBD.getYear();
        if(ngayht-ngbd<3)
            this.phuCap =  1000000;
        else
            this.phuCap = 2000000;
    }
    public void nhapFT()
    {
        super.nhap();
        setPhuCap();
    }
    @Override
    public double tinhLuong() {
        return luongCB*cong+phuCap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenNV).append(";");
        sb.append(getPassword()).append(";");
        sb.append(NgayBD).append(";");
        sb.append(SDT).append(";");
        sb.append(luongCB).append(";");
        sb.append(phuCap).append(";");
        sb.append(cong).append(";");
        sb.append("0");
        return sb.toString();
    }

    @Override
    public void chamCong() {
        int dem =0;
        cong =1;
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        int thang = date.getMonthValue();
        String th = String.valueOf(thang);
        try {

            List<String> list = readAllLines(Paths.get("chamcong.txt"));
            String lis="";
            if(list.isEmpty())
            {
                FileWriter fw = new FileWriter("chamcong.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                String gh = thang+";"+cong+";"+STK;
                bw.write(gh);
                bw.newLine();
                bw.close();
                fw.close();
            }
            else{
                FileReader fr = new FileReader("chamcong.txt");
                BufferedReader br = new BufferedReader(fr);
                String li="";
                while(true)
                {
                    li=br.readLine();
                    if(li==null)
                        break;
                    String chamcong[] = li.split(";");
                    int month = Integer.parseInt(chamcong[0]);
                    int congtichluy = Integer.parseInt(chamcong[1]);
                    String sotaikoan = chamcong[2];
                    if(month == thang&&sotaikoan.equals(STK))
                    {
                         cong=cong+congtichluy;
                         break;
                    }
                       
                }
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).startsWith(th+";")&& list.get(i).endsWith(";"+STK))
                    {
                        dem++;
                        lis = thang+";"+cong+";"+STK;
                        list.set(i, lis);
                        break;
                        
                    }             
                }Files.write(Paths.get("chamcong.txt"),list);
                if(dem==0)
                    {
                        FileWriter fw = new FileWriter("chamcong.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String gh = thang+";"+cong+";"+STK;
                        bw.write(gh);
                        bw.newLine();
                        bw.close();
                        fw.close();
                    }
                

            }
   
            
        } catch (Exception e) {
            System.out.println("xay ra loi: " + e.getMessage());
        }
        System.out.println("Cham cong thanh cong !");
    }
    
}

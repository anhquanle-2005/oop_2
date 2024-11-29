package NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class nhaVienPartTime extends nhanVien{
    protected int caLam;
    protected int gio=0;
    public nhaVienPartTime(){}
    public nhaVienPartTime(int gio, LocalDate NgayBD, String SDT, double luongCB, String maNV, String passWord, String tenNV) {
        super(NgayBD, SDT, luongCB, maNV, passWord, tenNV);
        this.gio = gio;
    }
    public int getCaLam() {
        return caLam;
    }
    public int getGio() {
        return gio;
    }
    public int giolam(int lc){
        if(lc ==5)
            gio = gio + 4;
        else
            gio = gio + 5;
        return gio;
    }
    @Override
    public void chamCong()
    {
        int dem =0;
        gio=0;
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        int thang = date.getMonthValue();
        String th = String.valueOf(thang);
        do { 
            System.out.println("Danh sach ca lam : ");
            System.out.println("1. Ca 1 (6:30-11:30)");
            System.out.println("2. Ca 2 (11:30-16:30)");
            System.out.println("3. Ca 3 (16:30 -21:30)");
            System.out.println("4. Ca 4 (21:30-2:30)");
            System.out.println("5. Ca 5 (2:30-6:30)");
            System.out.println("0. Thoat");
            System.out.println("xin moi lua chon: ");
            this.caLam = sc.nextInt();
            sc.nextLine();
            if(caLam==0)
                break;
            giolam(caLam);
        } while (true);
        
        try {

            List<String> list = readAllLines(Paths.get("chamcong.txt"));
            String lis="";
            if(list.isEmpty())
            {
                FileWriter fw = new FileWriter("chamcong.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                String gh = thang+";"+gio+";"+STK;
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
                    int giodalam = Integer.parseInt(chamcong[1]);
                    String sotaikoan = chamcong[2];
                    if(month == thang&&sotaikoan.equals(STK))
                    {
                         gio=gio+giodalam;
                         break;
                    }
                       
                }
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).startsWith(th+";")&& list.get(i).endsWith(";"+STK))
                    {
                        dem++;
                        lis = thang+";"+gio+";"+STK;
                        list.set(i, lis);
                        break;
                        
                    }             
                }Files.write(Paths.get("chamcong.txt"),list);
                if(dem==0)
                    {
                        FileWriter fw = new FileWriter("chamcong.txt",true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String gh = thang+";"+gio+";"+STK;
                        bw.write(gh);
                        bw.newLine();
                        bw.close();
                        fw.close();
                    }
                

            }
   
            // List<String> lines = readAllLines(Paths.get("nhanvien.txt"));
            // String line=null;
            // for(int i =0;i<lines.size();i++)
            // {
            //     if(lines.get(i).startsWith(this.STK))
            //         line = this.STK+";"+this.tenNV+";"+this.getPassWord()+";"+this.NgayBD+";"+this.SDT+";"+this.luongCB+";"+"0"+";"+"0;"+this.gio;
            //     lines.set(i, line);
            //     break;
            // }
            // Files.write(Paths.get("nhanvien.txt"),lines);
        } catch (Exception e) {
            System.out.println("xay ra loi: " + e.getMessage());
        }
    }
    @Override
    public double tinhLuong() {
        return luongCB*gio;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STK).append(";");
        sb.append(tenNV).append(";");
        sb.append(getPassWord()).append(";");
        sb.append(NgayBD).append(";");
        sb.append(SDT).append(";");
        sb.append(luongCB).append(";");
        sb.append("0").append(";");
        sb.append("0").append(";");
        sb.append(gio);
        return sb.toString();
    }

}

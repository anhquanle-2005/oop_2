package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class game {
    protected String maGame;
    protected String tenGame;
    protected double gia;
    protected int so=0;
    public game(){}
    
    public game(String maGame, String tenGame, double gia, int so) {
        this.maGame = maGame;
        this.tenGame = tenGame;
        this.gia = gia;
        this.so = so;
    }

    public String getMaGame() {
        return maGame;
    }
    public String getTenGame() {
        return tenGame;
    }
    public double getGia() {
        return gia;
    }
    public void setMaGame(String maGame) {
        try {
            FileReader fr = new FileReader("game.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while (true) { 
                line = br.readLine();
                if(line ==null)
                    break;
                String txt[] = line.split(";");
                int soo = Integer.parseInt(txt[3]);
                this.so = soo;
            
                   
            }
        } catch (Exception e) {
        }
        maGame = "G0";
        this.so++;
        this.maGame = maGame+String.valueOf(so);
    }
    public void setTenGame(String tenGame) {
        this.tenGame = tenGame;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        setMaGame(maGame);
        System.out.print("nhap vao ten game: ");
        tenGame = sc.nextLine();
        System.out.print("Nhap vao gia cho thue: ");
        gia = sc.nextDouble();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(maGame).append(";");
        sb.append(tenGame).append(";");
        sb.append(gia).append(";");
        sb.append(so).append(";");
        return sb.toString();
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }
    
}

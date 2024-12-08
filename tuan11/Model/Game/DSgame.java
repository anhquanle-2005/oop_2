package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DSgame {
    protected ArrayList<game> GAME;
    public DSgame(){
        GAME = new ArrayList<>();
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
            System.out.println("+maGame: "+g.maGame+"    +tenGame: "+g.tenGame+"    +gia: "+g.gia);
            System.out.println("--------------------------------------------------------");  
        }
    }
    public int timkiem(String maGame)
    {
        for (int i = 0; i <GAME.size(); i++) {
            if(maGame.equals(GAME.get(i).maGame))
                return i;
        }
        return -1;
    }
    // public void dsGameDaThue(){}
    public void chonGame(String maGame)
    {
        int s;
        s=timkiem(maGame);

    }
    public void xoaGame(String maGame)
    {
        GAME.removeIf(game -> game.maGame.equals(maGame));
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
    }
    public static void main(String[] args) {
        DSgame ds = new DSgame();
        ds.dsgame();
    }
}

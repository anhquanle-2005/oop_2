package tuan10.giaoDien;
import javax.swing.JFrame;
public class Window extends JFrame{
    public Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public void showIt() {
		this.setVisible(true);
	}
	
	public void showIt(String title) {
		this.setTitle(title);
		this.setVisible(true);
	}
	
	public void showIt(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Window m1 = new Window();
		m1.showIt();
		
		Window m2 = new Window();
		m2.showIt("Window 2");
		
		Window m3 = new Window();
		m3.showIt("Window 3", 600, 400);
	}
}

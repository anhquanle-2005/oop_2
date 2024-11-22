package tk;

public class nhap {

}
try {
    List<String> lines = Files.readAllLines(Paths.get("taikhoan.txt"));
    List<String> lineUpdate = new ArrayList<>();
    for (String line : lines) {
        if(line.startsWith(TAIKHOAN.get(s).STK + ";"))
        {
            if(TAIKHOAN.get(s) instanceof taiKhoanThanhToan)
                line = TAIKHOAN.get(s).STK  + ";" + TAIKHOAN.get(s).tenTK + ";"+TAIKHOAN.get(s).soDu+";"+TAIKHOAN.get(s).getpassWord()+";"+TAIKHOAN.get(s).maPin+";"+TAIKHOAN.get(s).SDT+";"+"TT";
            else
                line = TAIKHOAN.get(s).STK  + ";" + TAIKHOAN.get(s).tenTK + ";"+TAIKHOAN.get(s).soDu+";"+TAIKHOAN.get(s).getpassWord()+";"+TAIKHOAN.get(s).maPin+";"+TAIKHOAN.get(s).SDT+";"+"TK";
            lineUpdate.add(line);
        }
        if(line.startsWith(TAIKHOAN.get(i).STK + ";"))
        {
            if(TAIKHOAN.get(s) instanceof taiKhoanThanhToan)
                line = TAIKHOAN.get(i).STK  + ";" + TAIKHOAN.get(i).tenTK + ";"+TAIKHOAN.get(i).soDu+";"+TAIKHOAN.get(i).getpassWord()+";"+TAIKHOAN.get(i).maPin+";"+TAIKHOAN.get(i).SDT+";"+"TT";
            else
                line = TAIKHOAN.get(i).STK  + ";" + TAIKHOAN.get(i).tenTK + ";"+TAIKHOAN.get(i).soDu+";"+TAIKHOAN.get(i).getpassWord()+";"+TAIKHOAN.get(i).maPin+";"+TAIKHOAN.get(i).SDT+";"+"TK";
            lineUpdate.add(line);
        }
            
    }
    Files.write(Paths.get("taikhoan.txt"), lineUpdate);

    System.out.println("Cap nhat thanh cong !");
} catch (Exception e) {
}
package tuan7.Anh_Quan.baiTap2;

public class Ngay {
    private int day, month, year;

    public Ngay(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public int getDay()
    {
        return this.day;
    }
    public void setDay(int day)
    {
        this.day=day;
    }
    public int getMonth()
    {
        return this.month;
    }
    public void setMonth(int month)
    {
        this.month=month;
    }
    public int getYear()
    {
        return this.year;
    }
    public void setYear(int year)
    {
        this.year=year;
    }

    @Override
    public String toString() {
        return "Ngay [day=" + day + ", month=" + month + ", year=" + year + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ngay other = (Ngay) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    
}

package Model;

public class KhuPho {
    String maKhuPho;
    String tenKhuPho;

    public void setMaKhuPho(String maKhuPho) {
        this.maKhuPho = maKhuPho;
    }

    public void setTenKhuPho(String tenKhuPho) {
        this.tenKhuPho = tenKhuPho;
    }

    public String getMaKhuPho() {
        return maKhuPho;
    }

    public String getTenKhuPho() {
        return tenKhuPho;
    }

    public KhuPho(String maKhuPho, String tenKhuPho) {
        this.maKhuPho = maKhuPho;
        this.tenKhuPho = tenKhuPho;
    }

}

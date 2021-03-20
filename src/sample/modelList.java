package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class modelList {
    private String sira;

    private String uadi;

    private String ilkfiyat;

    private String sonfiyat;

    private String url;

    public modelList(String sira, String uadi, String ilkfiyat, String sonfiyat, String url) {
        this.sira = sira;
        this.uadi = uadi;
        this.ilkfiyat = ilkfiyat;
        this.sonfiyat = sonfiyat;
        this.url = url;
    }

    public String getSira() {
        return sira;
    }

    public void setSira(String sira) {
        this.sira = sira;
    }

    public String getUadi() {
        return uadi;
    }

    public void setUadi(String uadi) {
        this.uadi = uadi;
    }

    public String getIlkfiyat() {
        return ilkfiyat;
    }

    public void setIlkfiyat(String ilkfiyat) {
        this.ilkfiyat = ilkfiyat;
    }

    public String getSonfiyat() {
        return sonfiyat;
    }

    public void setSonfiyat(String sonfiyat) {
        this.sonfiyat = sonfiyat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class modelList {
    private String sira;

    private String uadi;

    private Double ilkfiyat;

    private Double sonfiyat;

    private String url;

    private Double indirim;

    public modelList(String sira, String uadi, Double ilkfiyat, Double sonfiyat, String url,Double indirim) {
        this.sira = sira;
        this.uadi = uadi;
        this.ilkfiyat = ilkfiyat;
        this.sonfiyat = sonfiyat;
        this.url = url;
        this.indirim=indirim;
    }

    public Double getIndirim() {
        return indirim;
    }

    public void setIndirim(Double indirim) {
        this.indirim = indirim;
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

    public Double getIlkfiyat() {
        return ilkfiyat;
    }

    public void setIlkfiyat(Double ilkfiyat) {
        this.ilkfiyat = ilkfiyat;
    }

    public Double getSonfiyat() {
        return sonfiyat;
    }

    public void setSonfiyat(Double sonfiyat) {
        this.sonfiyat = sonfiyat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

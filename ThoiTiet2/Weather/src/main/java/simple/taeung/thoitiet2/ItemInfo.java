package simple.taeung.thoitiet2;


public class ItemInfo {
    int id,anh;
    String ngay,may,docao,dothap;

    public ItemInfo(int id,int anh, String ngay, String may, String docao, String dothap) {
        this.id = id;
        this.anh = anh;
        this.ngay = ngay;
        this.may = may;
        this.docao = docao;
        this.dothap = dothap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getDothap() {
        return dothap;
    }

    public void setDothap(String dothap) {
        this.dothap = dothap;
    }

    public String getDocao() {
        return docao;
    }

    public void setDocao(String docao) {
        this.docao = docao;
    }

    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}

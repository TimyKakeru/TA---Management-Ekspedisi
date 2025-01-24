package Ekspedisi.Model;

public class Barang {
    private String idBarang;
    private String alamatTujuan;
    private String nomorResi;


    public Barang(String idBarang, String alamatTujuan, String nomorResi) {
        this.idBarang = idBarang;
        this.alamatTujuan = alamatTujuan;
        this.nomorResi = nomorResi;
    }

    public String detailBarang() {
        return "ID Barang: " + idBarang + ", Alamat: " + alamatTujuan + ", Nomor Resi: " + nomorResi ;
    }
}
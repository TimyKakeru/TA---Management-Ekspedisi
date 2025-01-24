package Ekspedisi.Model;

import Ekspedisi.Model.KategoriPengiriman.Pengiriman;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String username;
    private String password;
    private List<Pengiriman> riwayatPengiriman; // Menyimpan riwayat pengiriman

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.riwayatPengiriman = new ArrayList<>(); // Inisialisasi riwayat pengiriman
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void tambahPengiriman(Pengiriman pengiriman) {
        riwayatPengiriman.add(pengiriman); // Menambahkan pengiriman ke riwayat
    }

    public List<Pengiriman> lihatRiwayatPengiriman() {
        return riwayatPengiriman; // Mengembalikan riwayat pengiriman
    }
}
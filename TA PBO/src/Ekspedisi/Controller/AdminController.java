package Ekspedisi.Controller;


import Ekspedisi.Model.*;
import Ekspedisi.View.*;
import Ekspedisi.Model.KategoriPengiriman.*;
import java.util.List;

public class AdminController {
    private Admin admin;
    private View view;

    public AdminController(Admin admin, View view) {
        this.admin = admin;
        this.view = view;
    }

    public void login() {
        view.showLogin();
        String username = view.getInput();
        view.showPassword();
        String password = view.getInput();

        if (admin.login(username, password)) {
            view.showMessage("Login berhasil!");
            showMenu();
        } else {
            view.showMessage("Login gagal. Username atau password salah.");
        }
    }

    private void showMenu() {
        while (true) {
            view.showMenu();
            int pilihan = view.getIntInput();
            view.getInput(); // Clear buffer

            switch (pilihan) {
                case 1:
                    tambahPengiriman();
                    break;
                case 2:
                    lihatRiwayatPengiriman();
                    break;
                case 3:
                    ubahStatusPengiriman();
                    break;
                case 4:
                    view.showMessage("Keluar dari aplikasi.");
                    view.close();
                    return;
                default:
                    view.showMessage("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tambahPengiriman() {
        view.showMessage("Pilih jenis pengiriman:");
        view.showMessage("1. Pengiriman Biasa");
        view.showMessage("2. Pengiriman Ekspres");
        int jenisPengiriman = view.getIntInput();
        view.getInput(); // Clear buffer

        if (jenisPengiriman == 1) {
            // Input pengiriman biasa
            view.showMessage("Masukkan ID Pengiriman: ");
            String idPengirimanBiasa = view.getInput();
            Pengiriman pengirimanBiasa = new Pengiriman(idPengirimanBiasa);

            // Input barang
            while (true) {
                view.showMessage("Masukkan ID Barang (atau ketik 'selesai' untuk mengakhiri): ");
                String idBarang = view.getInput();
                if (idBarang.equalsIgnoreCase("selesai")) {
                    break;
                }
                view.showMessage("Masukkan Alamat Tujuan: ");
                String alamatTujuan = view.getInput();
                view.showMessage("Masukkan Nomor Resi: ");
                String nomorResi = view.getInput();

                Barang barang = new Barang(idBarang, alamatTujuan, nomorResi);
                pengirimanBiasa.tambahBarang(barang);
            }

            // Menambahkan pengiriman ke riwayat
            admin.tambahPengiriman(pengirimanBiasa);
            view.showMessage("Pengiriman Biasa berhasil ditambahkan!");

        } else if (jenisPengiriman == 2) {
            // Input pengiriman ekspres
            view.showMessage("Masukkan ID Pengiriman: ");
            String idPengirimanEkspres = view.getInput();
            view.showMessage("Masukkan biaya ekstra: ");
            double biayaEkstra = view.getIntInput();
            view.getInput(); // Clear buffer
            PengirimanEkspres pengirimanEkspres = new PengirimanEkspres(idPengirimanEkspres, biayaEkstra);

            // Input barang
            while (true) {
                view.showMessage("Masukkan ID Barang (atau ketik 'selesai' untuk mengakhiri): ");
                String idBarang = view.getInput();
                if (idBarang.equalsIgnoreCase("selesai")) {
                    break;
                }
                view.showMessage("Masukkan Alamat Tujuan: ");
                String alamatTujuan = view.getInput();
                view.showMessage("Masukkan Nomor Resi: ");
                String nomorResi = view.getInput();

                Barang barang = new Barang(idBarang, alamatTujuan, nomorResi);
                pengirimanEkspres.tambahBarang(barang);
            }

            // Menambahkan pengiriman ke riwayat
            admin.tambahPengiriman(pengirimanEkspres);
            view.showMessage("Pengiriman Ekspres berhasil ditambahkan!");

        } else {
            view.showMessage("Pilihan tidak valid. Kembali ke menu.");
        }
    }

    private void lihatRiwayatPengiriman() {
        List<Pengiriman> riwayat = admin.lihatRiwayatPengiriman();
        view.showDetailPengiriman(riwayat);
    }

    private void ubahStatusPengiriman() {
        view.showMessage("Masukkan ID Pengiriman yang ingin diubah statusnya: ");
        String idPengirimanUbah = view.getInput();
        Pengiriman pengirimanDitemukan = null;

        for (Pengiriman p : admin.lihatRiwayatPengiriman()) {
            if (p.getIdPengiriman().equals(idPengirimanUbah)) {
                pengirimanDitemukan = p;
                break;
            }
        }

        if (pengirimanDitemukan != null) {
            view.showMessage("Status saat ini: " + pengirimanDitemukan.getStatus());
            view.showMessage("Pilih status baru:");
            view.showMessage("1. Sedang Diproses");
            view.showMessage("2. Sedang Dalam Perjalanan");
            view.showMessage("3. Sampai Tujuan");
            int statusBaru = view.getIntInput();
            view.getInput(); // Clear buffer

            switch (statusBaru) {
                case 1:
                    pengirimanDitemukan.ubahStatus(Status.SEDANG_DIPROSES);
                    break;
                case 2:
                    pengirimanDitemukan.ubahStatus(Status.SEDANG_DALAM_PERJALANAN);
                    break;
                case 3:
                    pengirimanDitemukan.ubahStatus(Status.SAMPAI_TUJUAN);
                    break;
                default:
                    view.showMessage("Pilihan tidak valid.");
            }
            view.showMessage("Status pengiriman berhasil diubah!");
        } else {
            view.showMessage("Pengiriman tidak ditemukan.");
        }
    }
}
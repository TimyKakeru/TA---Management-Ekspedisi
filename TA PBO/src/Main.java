import Ekspedisi.Controller.AdminController;
import Ekspedisi.Model.Admin;
import Ekspedisi.View.View;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi model
        Admin admin = new Admin("admin", "123");

        // Inisialisasi view
        View view = new View();

        // Inisialisasi controller
        AdminController controller = new AdminController(admin, view);

        // Memulai proses login
        controller.login();
    }
}
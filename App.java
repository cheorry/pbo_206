import java.util.Scanner;

public class App {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tampilkan Daftar dan Total");
            System.out.println("4. Pembayaran");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next();
                    System.out.print("Masukkan harga barang: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Masukkan jumlah barang: ");
                    int addQuantity = scanner.nextInt();
                    cashier.addItem(addPrice, addCode, addName, addQuantity);
                    break;

                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String removeCode = scanner.next();
                    cashier.removeItem(removeCode);
                    break;

                case 3:
                    cashier.displayItems();
                    break;

                case 4:
                    double total = cashier.displayTotal();
                    System.out.print("Masukkan jumlah pembayaran: ");
                    double payment = scanner.nextDouble();
                    cashier.processPayment(total, payment);
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}

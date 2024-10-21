import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        System.out.println("Daftar belanja:");
        for (Item item : items) {
            System.out.println("Kode: " + item.getCode() + ", Nama: " + item.getName() +
                    ", Harga: " + item.getPrice() + ", Jumlah: " + item.getQuantity() +
                    ", SubTotal: " + item.getSubTotal());
        }
    }

    public double displayTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getSubTotal();
        }
        System.out.println("Total belanja: " + total);
        return total;
    }

    public double processPayment(double total, double payment) {
        if (payment >= total) {
            double change = payment - total;
            System.out.println("Pembayaran berhasil. Kembalian: " + change);
            return change;
        } else {
            System.out.println("Pembayaran gagal. Uang tidak mencukupi.");
            return -1;
        }
    }
}

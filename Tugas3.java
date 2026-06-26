// Class Hewan (superclass/class induk)
class Hewan {
    // Atribut (Protected agar atribut dapat diakses oleh class itu sendiri dan subclass)
    protected String nama;

    // Constructor tanpa parameter (method khusus yang otomatis dijalankan ketika objek dibuat)
    public Hewan() {
        this.nama = "Hewan";
    }

    // Constructor Overloading
    public Hewan(String nama) {
        this.nama = nama;
    }

    // Method yang akan dioverride
    public void bersuara() {
        System.out.println(nama + " : bersuara!");
    }

    // Getter
    public String getNama() {
        return nama;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }
}


// Class Kucing
class Kucing extends Hewan {

    // Constructor
    public Kucing() {
        super("Kucing");
    }

    // Override Method
    @Override
    public void bersuara() {
        System.out.println(nama + " : Meong!");
    }
}


// Class Anjing
class Anjing extends Hewan {

    // Constructor
    public Anjing() {
        super("Anjing");
    }

    // Override Method
    @Override
    public void bersuara() {
        System.out.println(nama + " : Guk!");
    }
}


// Class Thread
class ThreadHewan extends Thread {

    private Hewan hewan;

    // Constructor
    public ThreadHewan(Hewan hewan) {
        this.hewan = hewan;
    }

    // Method run()
    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            hewan.bersuara();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}


// Main Program
public class Tugas3 {

    public static void main(String[] args) {

        // POLIMORFISME
        System.out.println("=== POLIMORFISME ===");

        Hewan[] daftarHewan = {
                new Kucing(),
                new Anjing()
        };

        for (Hewan h : daftarHewan) {
            h.bersuara();
        }

        // MULTITHREADING
        System.out.println("\n=== MULTITHREADING ===");

        ThreadHewan thread1 = new ThreadHewan(new Kucing());
        ThreadHewan thread2 = new ThreadHewan(new Anjing());

        // Menjalankan kedua thread secara bersamaan
        thread1.start();
        thread2.start();

    }
}

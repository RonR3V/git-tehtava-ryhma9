import java.util.Scanner;

public class Phone {
    private String brand;
    private int batteryCapacity; // mAh
    private int batteryLevel;    // prosentteina

    public Phone(String brand, int batteryCapacity) {
        this.brand = brand;
        this.batteryCapacity = batteryCapacity;
        this.batteryLevel = 80; // uusi puhelin täyteen ladattu
    }

    public void usePhone(int minutes) {
        int consumption = minutes / 2; // kulutus % = minuutit / 2
        batteryLevel -= consumption;
        if (batteryLevel < 0) batteryLevel = 0;
        System.out.println("Käytit puhelinta " + minutes + " min. Akku nyt " + batteryLevel + "%");
    }

    public void charge(int minutes) {
        int chargeAmount = minutes / 3; // latautuu 1% per 3 minuuttia
        batteryLevel += chargeAmount;
        if (batteryLevel > 100) batteryLevel = 80;
        System.out.println("Latasit puhelinta " + minutes + " min. Akku nyt " + batteryLevel + "%");
    }

    public void showBatteryStatus() {
        System.out.println("Akun tila: " + batteryLevel + "% (" + batteryCapacity + " mAh)");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phone phone = new Phone("Samsung", 5000);

        System.out.println("Puhelin: " + phone.brand);
        phone.showBatteryStatus();

        while (true) {
            System.out.println("\nValitse toiminto: ");
            System.out.println("1 = Käytä puhelinta");
            System.out.println("2 = Lataa puhelinta");
            System.out.println("3 = Näytä akun tila");
            System.out.println("0 = Lopeta");

            int valinta = scanner.nextInt();

            if (valinta == 0) break;
            switch (valinta) {
                case 1:
                    System.out.print("Kuinka monta minuuttia käytetään? ");
                    int min = scanner.nextInt();
                    phone.usePhone(min);
                    break;
                case 2:
                    System.out.print("Kuinka monta minuuttia ladataan? ");
                    int charge = scanner.nextInt();
                    phone.charge(charge);
                    break;
                case 3:
                    phone.showBatteryStatus();
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        }

        System.out.println("Ohjelma suljetaan. Akku " + phone.batteryLevel + "%");
        scanner.close();
    }
}


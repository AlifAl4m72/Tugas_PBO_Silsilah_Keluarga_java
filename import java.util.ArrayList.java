import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    String name;
    int age;
    String job;
    double salary;
    double height;
    double weight;
    Person father;
    Person mother;
    List<Person> children;

    public Person(String name, int age, String job, double salary, double height, double weight) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
        this.height = height;
        this.weight = weight;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", Umur: " + age + ", Pekerjaan: " + job + ", Gaji: " + salary + ", Tinggi: " + height + " cm, Berat: " + weight + " kg";
    }

    public void printFamily() {
        System.out.println(this);
        if (father != null) {
            System.out.println("Ayah: " + father);
        }
        if (mother != null) {
            System.out.println("Ibu: " + mother);
        }
        if (!children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                System.out.println("Anak " + (i + 1) + ": " + children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data ayah
        System.out.print("Masukkan nama ayah: ");
        String namaAyah = scanner.nextLine();
        int umurAyah = getIntInput(scanner, "Masukkan umur ayah: ");
        System.out.print("Masukkan pekerjaan ayah: ");
        String pekerjaanAyah = scanner.nextLine();
        double gajiAyah = getDoubleInput(scanner, "Masukkan gaji ayah: ");
        double tinggiAyah = getDoubleInput(scanner, "Masukkan tinggi ayah (cm): ");
        double beratAyah = getDoubleInput(scanner, "Masukkan berat badan ayah (kg): ");

        // Input data ibu
        System.out.print("Masukkan nama ibu: ");
        String namaIbu = scanner.nextLine();
        int umurIbu = getIntInput(scanner, "Masukkan umur ibu: ");
        System.out.print("Masukkan pekerjaan ibu: ");
        String pekerjaanIbu = scanner.nextLine();
        double gajiIbu = getDoubleInput(scanner, "Masukkan gaji ibu: ");
        double tinggiIbu = getDoubleInput(scanner, "Masukkan tinggi ibu (cm): ");
        double beratIbu = getDoubleInput(scanner, "Masukkan berat badan ibu (kg): ");

        // Membuat objek Person untuk ayah dan ibu
        Person ayah = new Person(namaAyah, umurAyah, pekerjaanAyah, gajiAyah, tinggiAyah, beratAyah);
        Person ibu = new Person(namaIbu, umurIbu, pekerjaanIbu, gajiIbu, tinggiIbu, beratIbu);

        // Input data anak-anak
        List<Person> anakAnak = new ArrayList<>();
        while (true) {
            System.out.print("Masukkan nama anak (atau ketik 'selesai' untuk berhenti): ");
            String namaAnak = scanner.nextLine();
            if (namaAnak.equalsIgnoreCase("selesai")) {
                break;
            }
            int umurAnak = getIntInput(scanner, "Masukkan umur anak: ");
            System.out.print("Masukkan pekerjaan anak: ");
            String pekerjaanAnak = scanner.nextLine();
            double gajiAnak = getDoubleInput(scanner, "Masukkan gaji anak: ");
            double tinggiAnak = getDoubleInput(scanner, "Masukkan tinggi anak (cm): ");
            double beratAnak = getDoubleInput(scanner, "Masukkan berat badan anak (kg): ");

            Person anak = new Person(namaAnak, umurAnak, pekerjaanAnak, gajiAnak, tinggiAnak, beratAnak);
            anak.setFather(ayah);
            anak.setMother(ibu);
            anakAnak.add(anak);
            ayah.addChild(anak);
            ibu.addChild(anak);
        }

        // Menampilkan silsilah keluarga
        System.out.println("\nSilsilah Keluarga Ayah:");
        ayah.printFamily();
        System.out.println("\nSilsilah Keluarga Ibu:");
        ibu.printFamily();
        for (Person anak : anakAnak) {
            System.out.println("\nSilsilah Keluarga " + anak.name + ":");
            anak.printFamily();
        }

        scanner.close();
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Input tidak valid. Masukkan nilai integer.");
                scanner.next(); // consume invalid input
            }
        }
        return value;
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Input tidak valid. Masukkan nilai double.");
                scanner.next(); // consume invalid input
            }
        }
        return value;
    }
}

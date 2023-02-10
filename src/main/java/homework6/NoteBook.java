package homework6;

public class NoteBook {
    String model;
    String brand;
    String color;
    String cpuModel;
    int price;
    double diagonal;
    int ramCapacity;
    double weight;
    int hddCapacity;
    long uniqueNumber;

    public NoteBook(String model, String brand, String color, String cpuModel, double diagonal, int ramCapacity, double weight, int hddCapacity, int price, long uniqueNumber) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.cpuModel = cpuModel;
        this.diagonal = diagonal;
        this.ramCapacity = ramCapacity;
        this.weight = weight;
        this.hddCapacity = hddCapacity;
        this.price = price;
        this.uniqueNumber = uniqueNumber;
    }

    public NoteBook(String model, String brand, String color) {
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void printAllSpecsForUser() {
        System.out.printf
                (
                        """
                                ----------------------------------------------------------------------------------------
                                Модель - [%s], бренд - [%s], цвет - [%s], модель процессора - [%s], диагональ - [%.1f.] дюйма
                                Размер ОЗУ - [%dГБ], вес - [%.1f.кг], объем хранилища - [%dмб], цена - [%dруб]
                                """,
                        model, brand, color, cpuModel, diagonal,
                        ramCapacity, weight, hddCapacity, price
                );
    }

    public void printAllSpecsForAdmin() {
        System.out.printf
                (
                        """
                                ----------------------------------------------------------------------------------------
                                Модель - [%s], бренд - [%s], цвет - [%s], модель процессора - [%s], диагональ - [%.1f.] дюйма
                                Размер ОЗУ - [%dГБ], вес - [%.1f.кг], объем хранилища - [%dмб], цена - [%dруб], уникальный индефикатор - [%d]
                                """,
                        model, brand, color, cpuModel, diagonal,
                        ramCapacity, weight, hddCapacity, price, uniqueNumber
                );
    }
}

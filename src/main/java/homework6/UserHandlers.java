package homework6;

// Класс для обработки команд юзера
public class UserHandlers {
    private final DataBase base;
    private boolean isNotInStock = true; //флаг наличия

    public UserHandlers(DataBase base) {
        this.base = base;
    }

    public void showAllGoods() {
        base.showBaseForUser();
    }

    public void searchByColor(String line) {
        for (NoteBook item : base.noteBooks) {
            if (item.getColor().equalsIgnoreCase(line)) {
                item.printAllSpecsForUser();
                isNotInStock = false;
            }
        }
        if (isNotInStock) {
            System.out.println("Ноутбуков такого цвета нет в наличии");
        }
    }

    public void searchByCPU(String line) {
        for (NoteBook item : base.noteBooks) {
            if (item.getCpuModel().equalsIgnoreCase(line)) {
                item.printAllSpecsForUser();
                isNotInStock = false;
            }
        }
        if (isNotInStock) {
            System.out.println("Ноутбуков с таким процессором нет в наличии");
        }
    }

    public void searchByRamCapacity(String line) {
        String[] range = line.split("-");
        if (range.length == 2) {
            searchRamByRange(range);
        } else {
            searchRamByValue(line);
        }
    }

    private void searchRamByValue(String line) {
        try {
            int value = Integer.parseInt(line);
            for (NoteBook item : base.noteBooks) {
                if (item.getRamCapacity() == value) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с таким объемом ОЗУ нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    private void searchRamByRange(String[] range) {
        try {
            int max = Math.max(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            int min = Math.min(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            for (NoteBook item : base.noteBooks) {
                if (item.getRamCapacity() >= min && item.getRamCapacity() <= max) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такими параметрами ОЗУ нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    public void searchByHddCapacity(String line) {
        String[] range = line.split("-");
        if (range.length == 2) {
            searchHddByRange(range);
        } else {
            searchHddByValue(line);
        }
    }

    private void searchHddByValue(String line) {
        try {
            int value = Integer.parseInt(line);
            for (NoteBook item : base.noteBooks) {
                if (item.getHddCapacity() == value) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с таким объемом встроенной памяти нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    private void searchHddByRange(String[] range) {
        try {
            int max = Math.max(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            int min = Math.min(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            for (NoteBook item : base.noteBooks) {
                if (item.getHddCapacity() >= min && item.getHddCapacity() <= max) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такими параметрами встроенной памяти нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    public void searchByDiagonal(String line) {
        String[] range = line.split("-");
        if (range.length == 2) {
            searchDiagonalByRange(range);
        } else {
            searchDiagonalByValue(line);
        }
    }

    private void searchDiagonalByValue(String line) {
        try {
            int value = Integer.parseInt(line);
            for (NoteBook item : base.noteBooks) {
                if (item.getDiagonal() == value) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такой диагональю нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    private void searchDiagonalByRange(String[] range) {
        try {
            double max = Math.max(Double.parseDouble(range[0]), Double.parseDouble(range[1]));
            double min = Math.min(Double.parseDouble(range[0]), Double.parseDouble(range[1]));
            for (NoteBook item : base.noteBooks) {
                if (item.getDiagonal() >= min && item.getDiagonal() <= max) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такими параметрами диагонали нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    public void searchByPrice(String line) {
        String[] range = line.split("-");
        if (range.length == 2) {
            searchPriceByRange(range);
        } else {
            searchPriceByValue(line);
        }
    }

    private void searchPriceByValue(String line) {
        try {
            int value = Integer.parseInt(line);
            for (NoteBook item : base.noteBooks) {
                if (item.getPrice() == value) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такой ценой нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    private void searchPriceByRange(String[] range) {
        try {
            int max = Math.max(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            int min = Math.min(Integer.parseInt(range[0]), Integer.parseInt(range[1]));
            for (NoteBook item : base.noteBooks) {
                if (item.getPrice() >= min && item.getPrice() <= max) {
                    item.printAllSpecsForUser();
                    isNotInStock = false;
                }
            }
            if (isNotInStock) {
                System.out.println("Ноутбуков с такими параметрами стоимости нет в наличии");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, введите число");
            e.printStackTrace();
        }
    }

    public void searchByModel(String line) {
        for (NoteBook item : base.noteBooks) {
            if (item.getModel().equalsIgnoreCase(line)) {
                item.printAllSpecsForUser();
                isNotInStock = false;
            }
        }
        if (isNotInStock) {
            System.out.println("Ноутбуков такой модели нет в наличии");
        }
    }

    public void searchByBrand(String line) {
        for (NoteBook item : base.noteBooks) {
            if (item.getBrand().equalsIgnoreCase(line)) {
                item.printAllSpecsForUser();
                isNotInStock = false;
            }
        }
        if (isNotInStock) {
            System.out.println("Ноутбуков такого производителя нет в наличии");
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
    private final int FREQ_OF_PRODUCTION = 3000;
    private final int SALES_PLAN = 10;
    private final List<Car> stock = new ArrayList<>();

    public synchronized void put(Car car) {
        try {
            System.out.println("Идет производство машины");
            Thread.sleep(FREQ_OF_PRODUCTION);
            System.out.println("Получена новая машина " + car.carBrand);
            stock.add(car);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void buy(String name) {
        while (stock.size() == 0) {
            try {
                System.out.println("Машин нет");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s уехал на новеньком авто %s\n", name, stock.get(0).carBrand);
        stock.remove(0);
    }

    public int getSALES_PLAN() {
        return SALES_PLAN;
    }
}

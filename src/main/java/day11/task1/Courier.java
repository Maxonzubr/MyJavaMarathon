package day11.task1;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    public boolean getIsPayed() {
        return isPayed;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }


    @Override
    public String toString() {
        return "Courier{" +
                "salary=" + salary +
                ", isPayed='" + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        warehouse.setCountDeliveredOrders(warehouse.getCountDeliveredOrders() + 1);
        salary += 100;
    }

    @Override
    public void bonus() {
        if (warehouse.getCountDeliveredOrders() < 10000) System.out.println("Bonus is not available yet");
        else if (warehouse.getCountDeliveredOrders() >= 10000 & isPayed == false) {
            salary += 50000;
            isPayed = true;
        } else System.out.println("Bonus has been already payed");
    }
}

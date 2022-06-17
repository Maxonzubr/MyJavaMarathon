package day11.task1;

public class Picker implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
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
        return "Picker{" +
                "salary=" + salary +
                ", isPayed='" + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        salary += 80;
        warehouse.setCountPickedOrders(warehouse.getCountPickedOrders() + 1);
    }

    @Override
    public void bonus() {
        if (warehouse.getCountPickedOrders() < 10000) System.out.println("Bonus is not available yet");
        else if (warehouse.getCountPickedOrders() >= 10000 & isPayed == false) {
            salary += 70000;
            isPayed = true;
        } else System.out.println("Bonus has been already payed");
    }
}

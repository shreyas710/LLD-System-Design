import Adaptee.WeightMachineForBaby;
import Adapter.WeightMachineAdapter;
import Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBaby());
        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}
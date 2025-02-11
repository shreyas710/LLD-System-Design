package Product.WarehouseSelectionStrategy;

import Product.Warehouse;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouses) {
        return warehouses.get(0);
    }
}

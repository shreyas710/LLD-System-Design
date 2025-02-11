package Product;

import Product.WarehouseSelectionStrategy.WarehouseSelectionStrategy;

import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouses;
    WarehouseSelectionStrategy warehouseSelectionStrategy = null;

    public WarehouseController(List<Warehouse> warehouses, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouses = warehouses;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void addNewWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouses);
    }
}

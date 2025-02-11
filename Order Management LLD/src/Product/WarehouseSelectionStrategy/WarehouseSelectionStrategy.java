package Product.WarehouseSelectionStrategy;

import Product.Warehouse;

import java.util.List;

public abstract class WarehouseSelectionStrategy {
    public abstract Warehouse selectWarehouse(List<Warehouse> warehouses);
}

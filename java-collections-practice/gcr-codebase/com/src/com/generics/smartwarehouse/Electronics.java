package com.generics.smartwarehouse;

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    public String getCategory() {
        return "Furniture";
    }
}

package main.java;

public class Item {
    private boolean frozen = false;
    private String description;
    private String condition;
    private int quantity;

    public Item(String description, String condition, int quantity) {
        this.description = description;
        this.condition = condition;
        this.quantity = quantity;
    }

    public boolean canModify() { return ! frozen; }
    public void freeze() { frozen = true; }

    public String getDescription() { return description; }
    public void setDescription(String new_description) throws FrozenException {
        if (frozen) throw new FrozenException();
        description = new_description;
    }

    public String getCondition() { return condition; }
    public void setCondition(String new_condition) throws FrozenException {
        if (frozen) throw new FrozenException();
        condition = new_condition;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int new_quantity) throws FrozenException {
        if (frozen) throw new FrozenException();
        quantity = new_quantity;
    }
}

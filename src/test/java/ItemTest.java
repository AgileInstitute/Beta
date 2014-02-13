package test.java;

import main.java.*;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
    @Test
    public void canCreateItem() {
        Item item = new Item("Action Figure", "Awesome!", 1);
    }

    @Test
    public void itemHasDescription() {
        String description = "Action Figure";
        String condition = "Awesome!";
        int quantity = 1;
        Item item = new Item(description, condition, quantity);

        Assert.assertEquals(description, item.getDescription());
    }

    @Test
    public void itemHasCondition() {
        String description = "Action Figure";
        String condition = "Awesome!";
        int quantity = 1;
        Item item = new Item(description, condition, quantity);

        Assert.assertEquals(condition, item.getCondition());
    }

    @Test
    public void itemHasQuantity() {
        String description = "Action Figure";
        String condition = "Awesome!";
        int quantity = 1;
        Item item = new Item(description, condition, quantity);

        Assert.assertEquals(quantity, item.getQuantity());
    }

    @Test
    public void canModifyItem() {
        Item item = new Item("Action Figure", "Awesome!", 1);
        Assert.assertTrue(item.canModify());
    }

    @Test
    public void canFreezeItem() {
        Item item = new Item("Action Figure", "Awesome!", 1);
        item.freeze();
    }

    @Test
    public void cannotModifyFrozenItem() {
        Item item = new Item("Action Figure", "Awesome!", 1);
        item.freeze();
        Assert.assertFalse(item.canModify());
    }

    @Test
    public void descriptionSettable() throws FrozenException {
        Item item = new Item("Action Figure", "Awesome!", 1);
        String descr = "Superman";
        item.setDescription(descr);

        Assert.assertEquals(descr, item.getDescription());
    }

    @Test(expected=FrozenException.class)
    public void descriptionNotSetWhenFrozen() throws FrozenException {
        Item item = new Item("Action Figure", "Awesome!", 1);
        String descr = "Superman";
        item.freeze();
        item.setDescription(descr);
    }

    @Test
    public void conditionSettable() throws FrozenException {
        Item item = new Item("Action Figure", "Awesome!", 1);
        String cond = "As-Is";
        item.setCondition(cond);

        Assert.assertEquals(cond, item.getCondition());
    }

    @Test(expected=FrozenException.class)
    public void conditionNotSetWhenFrozen() throws FrozenException {
        Item item = new Item("Action Figure", "Awesome!", 1);
        String cond = "As-Is";
        item.freeze();
        item.setCondition(cond);
    }


}

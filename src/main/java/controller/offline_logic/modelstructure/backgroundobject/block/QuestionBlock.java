package controller.offline_logic.modelstructure.backgroundobject.block;

import controller.offline_logic.modelstructure.entity.item.Item;

public class QuestionBlock extends Block{
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "item")
//    @JsonSubTypes({
//            @JsonSubTypes.Type(value = Coin.class, name = "STAR"),
//            // other subtypes
//    })
    private Item item;

    public QuestionBlock() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

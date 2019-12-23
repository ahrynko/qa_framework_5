package common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor  //create constr with values String,integer
@Getter
public class HotlineItem implements Comparable<HotlineItem> { //interface Comparable(сортировка)

    private String title;
    private Integer price;

    @Override
    public int compareTo(HotlineItem anotherItem) {  //method сравнивания по полю price
        return this.price - anotherItem.price ;
    }
}

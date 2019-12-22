package common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor  //create constr with values String,integer
@Getter
public class HotlineItem {

    private String title;
    private Integer price;
}

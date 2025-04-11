package get_order_list;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestGetOrderList {

    private int courierId;
    private String nearestStation;
    private int limit;
    private int page;
}

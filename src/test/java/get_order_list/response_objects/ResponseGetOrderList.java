package get_order_list.response_objects;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseGetOrderList {

    private List<Orders> orders;
    private PageInfo pageInfo;
    private List<AvailableStations> availableStations;

}

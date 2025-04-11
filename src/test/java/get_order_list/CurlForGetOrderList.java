package get_order_list;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurlForGetOrderList {

    private String URL = "https://qa-scooter.praktikum-services.ru/v1/orders?courierId=1";
}

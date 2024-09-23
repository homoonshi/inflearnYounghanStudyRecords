package hello.core.order;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

  Order createOrder(Long memberId, String itemName, int itemPrice);

}

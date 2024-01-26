package org.erp_case_1.service.order_item;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.dto.order_item.OrderItemCreateRequest;

public interface OrderItemCreateService {
    OrderItem createOrderItem(
            final Order order,
            final OrderItemCreateRequest orderItemCreateRequest
    );
}

package org.erp_case_1.service.order;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.dto.order_item.OrderItemCreateRequest;

import java.util.List;

public interface OrderCreateService {
    Order createOrder(
            final Long orderNumber,
            final List<OrderItemCreateRequest> orderItemCreateRequests
    );
}

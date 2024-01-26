package org.erp_case_1.service.order;

import org.erp_case_1.model.Order;

public interface OrderService {
    Order getOrderByNumber(
            final Long orderNumber
    );
}

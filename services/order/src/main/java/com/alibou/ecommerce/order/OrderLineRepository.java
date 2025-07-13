package com.alibou.ecommerce.order;

import com.alibou.ecommerce.orderline.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

}

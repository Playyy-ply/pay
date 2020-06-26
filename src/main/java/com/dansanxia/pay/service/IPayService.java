package com.dansanxia.pay.service;

import java.math.BigDecimal;

public interface IPayService {
    // 发起支付
    void create(String orderId, BigDecimal amount);
}

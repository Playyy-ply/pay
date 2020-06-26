package com.dansanxia.pay.service.impl;

import com.dansanxia.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {
    @Autowired
    private PayService payService;
    @Test
    public void create() {
        payService.create("1234567891234567232311", BigDecimal.valueOf(0.01));
    }
}
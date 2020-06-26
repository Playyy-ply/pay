package com.dansanxia.pay.service.impl;

import com.dansanxia.pay.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Slf4j
@Service
public class PayService implements IPayService {

    //发起支付
    @Override
    public void create(String orderId, BigDecimal amount) {
        //微信支付配置
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId("wxd898fcb01713c658");          //公众号Id
        wxPayConfig.setMchId("1483469312");
        wxPayConfig.setMchKey("098F6BCD4621D373CADE4E832627B4F6");
        wxPayConfig.setNotifyUrl("http://127.0.0.1");
        //支付类, 所有方法都在这个类里
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        //发起支付
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("4559066-最好的支付sdk");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);
        bestPayService.pay(payRequest);
    }
}

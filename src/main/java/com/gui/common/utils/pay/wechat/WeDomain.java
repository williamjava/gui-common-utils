package com.gui.common.utils.pay.wechat;

public class WeDomain implements IWXPayDomain {
    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new DomainInfo(WXPayConstants.DOMAIN_API,true);
    }
}

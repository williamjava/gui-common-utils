package com.gui.common.utils.pay.sdk.we;

import static com.gui.common.utils.pay.sdk.we.WXPayConstants.DOMAIN_API;

/**
 * @author ZHANGQIAN logeed@aliyun.com
 * @date 2019/10/17 14:21
 */

public class WeDomain implements IWXPayDomain {
    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new DomainInfo(DOMAIN_API,true);
    }
}

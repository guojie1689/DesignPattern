package com.gj.dp.chain;

import javax.xml.ws.Response;

public interface Process {
    //处理请求
    public Result process(Chain chain);

    interface Chain {
        Request request();

        Result next(Request request);
    }
}

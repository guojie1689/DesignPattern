package com.gj.dp.chain;

public class GeneralMananger implements Process{
    @Override
    public Result process(Chain chain) {

        Request request = chain.request();

        if(request.getDays()>10){
            return new Result(false,"总经理：请假时间太长");
        }
        else{
            return new Result(true,"总经理：批准");
        }
    }
}

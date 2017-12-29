package com.gj.dp.chain;

public class DepartManager implements Process {
    @Override
    public Result process(Chain chain) {
        Request request = chain.request();

        if (request.getDays() < 3) {
            System.out.println("3天以内由我审核，批准请假");
            return new Result(true, "批准请假");
        }

        request.setDepartMInfo("该员工有事请假，我这边已批准");
        System.out.println("部门经理批示：该员工有事请假，我这边已批准\"");

        return chain.next(request);
    }
}

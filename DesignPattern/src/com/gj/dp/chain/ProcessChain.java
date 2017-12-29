package com.gj.dp.chain;

import java.util.List;

public class ProcessChain implements Process.Chain {

    private Request request;
    private int index;
    private List<Process> processList = null;


    public ProcessChain(List<Process> processList, Request request, int index) {
        this.processList = processList;
        this.request = request;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Result next(Request request) {
        if (index >= processList.size()) {
            throw new AssertionError();
        }

        Process.Chain chain = new ProcessChain(processList, request, index + 1);

        return processList.get(index).process(chain);
    }
}

package com.gj.dp.chain;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibilityClient {
    private List<Process> processList;

    public ChainOfResponsibilityClient() {
        this.processList = new ArrayList<>();
    }

    public void addProcess(Process process) {
        this.processList.add(process);
    }

    public Result execute(Request request) {
        ArrayList<Process> arrayList = new ArrayList<Process>();

        arrayList.addAll(processList);
        arrayList.add(new DepartManager());
        arrayList.add(new GeneralMananger());

        ProcessChain processChain = new ProcessChain(arrayList, request, 0);

        return processChain.next(request);
    }

}

package com.gj.dp.chain;

public class ChainMain {
    public static void main(String[] args) {
        Request request = new Request.Builder()
                .setDays(2)
                .setDepartment("研发二部")
                .setName("jay")
                .setReason("出去玩")
                .build();

        ChainOfResponsibilityClient chainOfResponsibilityClient = new ChainOfResponsibilityClient();

        Result result = chainOfResponsibilityClient.execute(request);

        System.out.println(result.getMsg());
    }
}

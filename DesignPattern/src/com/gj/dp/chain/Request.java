package com.gj.dp.chain;

public class Request {

    private String name;
    private String reason;
    private String department;
    private int days;
    private String departMInfo;

    public String getDepartMInfo() {
        return departMInfo;
    }

    public void setDepartMInfo(String departMInfo) {
        this.departMInfo = departMInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Request(Builder builder) {
        this.name = builder.name;
        this.reason = builder.reason;
        this.department = builder.department;
        this.days = builder.days;
        this.departMInfo = builder.departmentInfo;
    }

    public static class Builder {
        protected String name;
        protected String reason;
        protected String department;
        protected int days;
        protected String departmentInfo;

        public Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setDays(int days) {
            this.days = days;
            return this;
        }

        public Builder setDepartmentInfo(String departmentInfo) {
            this.departmentInfo = departmentInfo;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}

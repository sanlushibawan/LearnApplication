package com.drizzle.learnapplication.bean;

/**
 * Project Name：pushTest
 * Package Name: com.gepin.pushtest.bean
 * Created by Drizzle on 2019/7/29
 * Instructions：javaBean
 */
public class MyJavabean {
    private String name;
    private String email;
    private Phone phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public class Phone{
        private String home;
        private String mobile;

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

    }
}

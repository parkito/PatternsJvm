package com.siksmfp.creational.proxy.dynamic;

public class WorldMarket {
    public static void main(String... args) {
        Company company = new Company(
                "Company",
                1_000_000,
                Proxies.virtual(MoralFibre.class, RealMoralFibre::new)
        );

        company.makeMoney();
        company.makeMoney();
        company.makeMoney();
        System.out.println(company);
        company.damageEnvironment();
        System.out.println(company);
        company.becomeFocusOfMediaAttention();
        System.out.println(company);
    }
}
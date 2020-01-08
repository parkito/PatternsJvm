package ru.siksmfp.java.patterns.structural.proxy.dynamic;

public class WorldMarket {
    public static void main(String... args) {
        Company cretesoft = new Company("Cretesoft", 1_000_000, Proxies.virtual(
                MoralFibre.class, RealMoralFibre::new));

        cretesoft.makeMoney();
        cretesoft.makeMoney();
        cretesoft.makeMoney();
        System.out.println(cretesoft);
        cretesoft.damageEnvironment();
        System.out.println(cretesoft);
        cretesoft.becomeFocusOfMediaAttention();
        System.out.println(cretesoft);
    }
}
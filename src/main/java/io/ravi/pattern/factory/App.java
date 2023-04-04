package io.ravi.pattern.factory;

public class App implements Runnable{

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    @Override
    public void run() {
        AbstractKingdomFactory factory = new AbstractKingdomFactory();
        System.out.println("elf kingdom");
        Kingdom elfKingdom = factory.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        System.out.println(elfKingdom.getArmy().getDescription());
        System.out.println(elfKingdom.getCastle().getDescription());
        System.out.println(elfKingdom.getKing().getDescription());

        System.out.println("orc kingdom");
        Kingdom orcKingdom = factory.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        System.out.println(orcKingdom.getArmy().getDescription());
        System.out.println(orcKingdom.getCastle().getDescription());
        System.out.println(orcKingdom.getKing().getDescription());
    }

}

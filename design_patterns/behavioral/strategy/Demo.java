package design_patterns.behavioral.strategy;

public class Demo {
    public static void main(String[] args) {
        StrategyA strategyA = new StrategyA();
        StrategyB strategyB = new StrategyB();

        Context context = new Context();

        context.setStrategy(strategyA);
        context.doSomething();

        context.setStrategy(strategyB);
        context.doSomething();
    }
}


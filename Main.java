public class Main {
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

class Context {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        strategy.execute();
    }
}

interface Strategy {
    public void execute();
}

class StrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " has been executed");
    }
}

class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " has been executed");
    }
}
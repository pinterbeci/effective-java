package hu.pinterbeci.effective.java.chapter6.item38;

public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(final double a, final double b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public double apply(final double a, final double b) {
            return a + b;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(final double a, final double b) {
            return a / b;
        }
    },
    TIMES("*") {
        @Override
        public double apply(final double a, final double b) {
            return a * b;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

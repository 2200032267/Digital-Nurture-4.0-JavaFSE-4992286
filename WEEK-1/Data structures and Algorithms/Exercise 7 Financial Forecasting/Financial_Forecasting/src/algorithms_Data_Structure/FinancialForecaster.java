package algorithms_Data_Structure;

public class FinancialForecaster {

    public static double calculateFutureValue(double principal, double annualGrowthRate, int years) {
        if (years == 0) {
            return principal;
        }
        
        double previousValue = calculateFutureValue(principal, annualGrowthRate, years - 1);
        
        return previousValue * (1 + annualGrowthRate);
    }

    public static void main(String[] args) {
    
        double initialPrincipal = 1000.00; 
        double growthRate = 0.08; 
        int forecastYears = 10;

        System.out.println("--- Financial Forecast using Recursion ---");
        System.out.println("Initial Principal: $" + String.format("%.2f", initialPrincipal));
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + forecastYears + " years");

        double futureValue = calculateFutureValue(initialPrincipal, growthRate, forecastYears);

        System.out.println("\nPredicted Future Value after " + forecastYears + " years: $" + String.format("%.2f", futureValue));
        
        double checkValue = initialPrincipal * Math.pow(1 + growthRate, forecastYears);
        System.out.println("Verification using Math.pow(): $" + String.format("%.2f", checkValue));
    }
}

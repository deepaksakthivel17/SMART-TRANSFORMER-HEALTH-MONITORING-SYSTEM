import java.util.*;

public class SmartTransformerMonitor {

    // Inner data model
    static class TransformerData {
        double temperature;
        double oilLevel;
        double loadCurrent;
        double vibration;

        TransformerData(double temp, double oil, double load, double vib) {
            this.temperature = temp;
            this.oilLevel = oil;
            this.loadCurrent = load;
            this.vibration = vib;
        }

        @Override
        public String toString() {
            return "Temp: " + temperature + "°C, Oil: " + oilLevel + "% , Load: " + loadCurrent + "A, Vib: " + vibration + " mm/s";
        }
    }

    // Generate random data
    static TransformerData generateData(Random rand) {
        double temp = 60 + rand.nextDouble() * 50;      // 60 - 110 °C
        double oil = 20 + rand.nextDouble() * 80;       // 20 - 100 %
        double load = 100 + rand.nextDouble() * 150;    // 100 - 250 A
        double vib = rand.nextDouble() * 10;            // 0 - 10 mm/s
        return new TransformerData(temp, oil, load, vib);
    }

    // Check alerts
    static void checkForAlerts(TransformerData data) {
        if (data.temperature > 90) {
            System.out.println("[ALERT] High Temperature!");
        }
        if (data.oilLevel < 30) {
            System.out.println("[ALERT] Low Oil Level!");
        }
        if (data.loadCurrent > 200) {
            System.out.println("[ALERT] Overload Condition!");
        }
        if (data.vibration > 5) {
            System.out.println("[ALERT] Excessive Vibration!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        System.out.println("=== Smart Transformer Health Monitoring System ===");

        for (int i = 0; i < 10; i++) { // simulate 10 readings
            TransformerData data = generateData(rand);
            System.out.println("Reading " + (i+1) + ": " + data);
            checkForAlerts(data);
            System.out.println("-----------------------------------");
            Thread.sleep(2000); // wait 2 sec between readings
        }
    }
}

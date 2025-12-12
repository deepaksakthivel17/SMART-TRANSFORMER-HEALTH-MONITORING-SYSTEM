import java.util.Random;

public class TransformerData {
    private double temperature;
    private double oilLevel;
    private double loadCurrent;
    private double vibration;
    private final Random random;

    // Threshold values
    public static final double MAX_TEMPERATURE = 90.0;
    public static final double MIN_OIL_LEVEL = 30.0;
    public static final double MAX_LOAD_CURRENT = 200.0;
    public static final double MAX_VIBRATION = 5.0;

    public TransformerData() {
        this.random = new Random();
        updateReadings();
    }

    public void updateReadings() {
        // Simulate sensor readings
        this.temperature = 60 + random.nextDouble() * 50;    // 60-110°C
        this.oilLevel = 20 + random.nextDouble() * 80;      // 20-100%
        this.loadCurrent = 100 + random.nextDouble() * 150; // 100-250A
        this.vibration = random.nextDouble() * 10;          // 0-10 mm/s
    }

    // Getters
    public double getTemperature() {
        return temperature;
    }

    public double getOilLevel() {
        return oilLevel;
    }

    public double getLoadCurrent() {
        return loadCurrent;
    }

    public double getVibration() {
        return vibration;
    }

    @Override
    public String toString() {
        return String.format(
            "Temperature: %.1f°C\nOil Level: %.1f%%\nLoad Current: %.1fA\nVibration: %.1f mm/s",
            temperature, oilLevel, loadCurrent, vibration
        );
    }
}
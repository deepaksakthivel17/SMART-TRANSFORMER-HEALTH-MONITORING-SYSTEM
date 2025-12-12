import java.util.List;

public class TransformerStatus {
    private TransformerData lastReadings;
    private List<String> activeAlerts;
    private String overallStatus;

    public void updateStatus(TransformerData data, List<String> alerts) {
        this.lastReadings = data;
        this.activeAlerts = alerts;
        this.overallStatus = determineOverallStatus(alerts);
    }

    private String determineOverallStatus(List<String> alerts) {
        if (alerts.isEmpty()) {
            return "NORMAL - All parameters within acceptable ranges";
        } else if (alerts.stream().anyMatch(alert -> alert.contains("[CRITICAL]"))) {
            return "CRITICAL - Immediate attention required";
        } else {
            return "WARNING - System requires attention";
        }
    }

    public String getStatusReport() {
        StringBuilder report = new StringBuilder();
        
        // Add readings
        report.append(lastReadings.toString()).append("\n\n");
        
        // Add overall status
        report.append("Overall Status: ").append(overallStatus).append("\n\n");
        
        // Add active alerts
        if (!activeAlerts.isEmpty()) {
            report.append("Active Alerts:\n");
            for (String alert : activeAlerts) {
                report.append("- ").append(alert).append("\n");
            }
        }
        
        return report.toString();
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public List<String> getActiveAlerts() {
        return activeAlerts;
    }
}
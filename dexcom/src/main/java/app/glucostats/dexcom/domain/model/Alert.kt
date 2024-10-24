package app.glucostats.dexcom.domain.model

/**
 * Represents an alert event.
 * @property systemTime The system timestamp for the alert.
 * @property displayTime The display timestamp for the alert.
 * @property alertName The name of the alert.
 * @property alertType The type of the alert.
 */
data class Alert(
    val systemTime: String,
    val displayTime: String,
    val alertName: String,
    val alertType: String
)
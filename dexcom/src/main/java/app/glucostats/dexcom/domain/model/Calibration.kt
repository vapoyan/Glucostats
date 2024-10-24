package app.glucostats.dexcom.domain.model

/**
 * Represents a calibration event.
 * @property systemTime The system timestamp for the calibration.
 * @property displayTime The display timestamp for the calibration.
 * @property value The value used for calibration.
 */
data class Calibration(
    val systemTime: String,
    val displayTime: String,
    val value: Double
)
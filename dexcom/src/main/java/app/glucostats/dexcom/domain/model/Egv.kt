package app.glucostats.dexcom.domain.model

/**
 * Represents an estimated glucose value (EGV).
 * @property value The glucose value.
 * @property systemTime The system timestamp for the EGV.
 * @property displayTime The display timestamp for the EGV.
 */
data class Egv(
    val value: Double,
    val systemTime: String,
    val displayTime: String
)
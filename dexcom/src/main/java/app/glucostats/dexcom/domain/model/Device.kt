package app.glucostats.dexcom.domain.model

/**
 * Represents a device used by the user.
 * @property id The unique identifier of the device.
 * @property displayTime The display timestamp for the device.
 * @property status The status of the device.
 * @property lastUploadDate The date when the device last uploaded data.
 */
data class Device(
    val id: String,
    val displayTime: String,
    val status: String,
    val lastUploadDate: String
)
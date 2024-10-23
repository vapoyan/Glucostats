package app.glucostats.dexcom.domain.model

/**
 * Represents an event.
 * @property systemTime The system timestamp for the event.
 * @property displayTime The display timestamp for the event.
 * @property eventType The type of the event.
 * @property value The value associated with the event, if applicable.
 */
data class Event(
    val systemTime: String,
    val displayTime: String,
    val eventType: String,
    val value: String?
)
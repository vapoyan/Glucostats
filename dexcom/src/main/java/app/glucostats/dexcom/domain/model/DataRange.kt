package app.glucostats.dexcom.domain.model

/**
 * Represents the available data range for the user.
 * @property start The start date of the data range.
 * @property end The end date of the data range.
 */
data class DataRange(
    val start: String,
    val end: String
)
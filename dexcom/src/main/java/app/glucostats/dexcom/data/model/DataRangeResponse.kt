package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.DataRange

/**
 * Represents the response containing the available data range.
 * @property dataRange The data range information.
 */
data class DataRangeResponse(
    val dataRange: DataRange
)
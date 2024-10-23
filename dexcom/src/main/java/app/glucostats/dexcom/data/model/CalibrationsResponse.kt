package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.Calibration

/**
 * Represents the response containing a list of calibrations.
 * @property calibrations The list of calibrations.
 */
data class CalibrationsResponse(
    val calibrations: List<Calibration>
)
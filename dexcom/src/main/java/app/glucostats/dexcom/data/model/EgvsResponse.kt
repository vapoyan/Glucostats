package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.Egv

/**
 * Represents the response containing a list of estimated glucose values (EGVs).
 * @property egvs The list of EGVs.
 */
data class EgvsResponse(
    val egvs: List<Egv>
)
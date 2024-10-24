package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.Alert

/**
 * Represents the response containing a list of alerts.
 * @property alerts The list of alerts.
 */
data class AlertsResponse(
    val alerts: List<Alert>
)
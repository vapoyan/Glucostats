package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.Device

/**
 * Represents the response containing a list of devices.
 * @property devices The list of devices.
 */
data class DevicesResponse(
    val devices: List<Device>
)
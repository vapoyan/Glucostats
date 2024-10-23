package app.glucostats.dexcom.data.model

import app.glucostats.dexcom.domain.model.Event

/**
 * Represents the response containing a list of events.
 * @property events The list of events.
 */
data class EventsResponse(
    val events: List<Event>
)
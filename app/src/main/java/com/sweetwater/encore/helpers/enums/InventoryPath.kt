package com.sweetwater.encore.helpers.enums

enum class InventoryPath(val path: String) {
    GetCurrentQuarterDetail("/counts/quarters/current/detail?employeeId=:employeeId"),
    AssignCountRequests("/counts/quarters/current/count-requests?employeeId=:employeeId&zoneId=:zoneId"),
    UploadCount("/counts/quarters/current/count-requests/:countRequestId/product-counts?force=:force"),
    GetRecountSummary("/recounts/zones/summary"),
    GetDailyRecountStatistics("/recounts/employee/:employeeId/daily-statistics"),
    UploadRecount("/recounts/:recountRequestId/locations/:recountLocationId?force=:force"),
    GetRecountRequestsForZone("/recounts/requests?zoneId=:zoneId"),
    GetRecountLocationsForRequest("/recounts/requests/:recountRequestId/locations"),
    GetLocationByName("/locations/name/:name"),
    AddLocationToRecount("/recounts/:recountRequestId/locations")
}
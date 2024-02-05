package com.sweetwater.encore.helpers.functions

import com.sweetwater.encore.helpers.enums.CampusId

class HelperFunctions {
    companion object {
        fun getUrlForCampus(fwaUrl: String, phxUrl: String, endpointUrl: String, campusId: String): String {
            return when (campusId) {
                CampusId.FWA.campusId -> {
                    return "${fwaUrl}${endpointUrl}"
                }

                CampusId.PHX.campusId -> {
                    return "${phxUrl}${endpointUrl}"
                }

                else -> {
                    return ""
                }
            }
        }
    }
}
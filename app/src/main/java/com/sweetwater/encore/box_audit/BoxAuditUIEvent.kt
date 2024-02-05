package com.sweetwater.encore.box_audit

sealed class BoxAuditUIEvent {
    data class OnPackAreaSelected(val packArea: String) : BoxAuditUIEvent()
    object ClearError : BoxAuditUIEvent()
}

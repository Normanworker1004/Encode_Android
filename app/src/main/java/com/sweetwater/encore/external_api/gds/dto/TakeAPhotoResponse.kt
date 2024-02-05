package com.sweetwater.encore.external_api.gds.dto

import com.google.gson.annotations.SerializedName

data class TakeAPhotoResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("path")
    val path: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("preview_url")
    val previewURL: String,

    @SerializedName("size_kb")
    val sizeKB: Int,

    @SerializedName("hash")
    val hash: String,

    @SerializedName("creator_app")
    val creatorApp: String,

    @SerializedName("creator_username")
    val creatorUsername: String,

    @SerializedName("creator_id")
    val creatorID: String,

    @SerializedName("extension")
    val extension: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("publicurl")
    val publicURL: String,

    @SerializedName("public_preview_url")
    val publicPreviewURL: String
)
package com.sweetwater.encore.recounts.data.mappers

import com.sweetwater.encore.Location
import com.sweetwater.encore.ProductBox
import com.sweetwater.encore.RecountLocation
import com.sweetwater.encore.RecountProduct
import com.sweetwater.encore.RecountRequest
import com.sweetwater.encore.external_api.products.dto.ProductBoxDto
import com.sweetwater.encore.recounts.data.dto.LocationDto
import com.sweetwater.encore.recounts.data.dto.RecountLocationDto
import com.sweetwater.encore.recounts.data.dto.RecountProductDto
import com.sweetwater.encore.recounts.data.dto.RecountRequestDto

fun RecountRequest.toRecountRequestDto(): RecountRequestDto {
    return RecountRequestDto(
        recountRequestId = recountRequestId,
        priority = priority,
        requestedByEmployee = requestedByEmployee,
        requestedDate = requestedDate,
        requestedStatus = requestedStatus,
        completedAt = completedAt,
        product = RecountProductDto(
            id = product.id,
            serialNumber = product.serialNumber,
            name = product.name,
            description = product.description,
            manufacturer = product.manufacturer,
            imageURL = product.imageURL,
            productIdentifiers = product.productIdentifiersList,
            productBoxes = product.productBoxesList.map {
                ProductBoxDto(
                    cubicInches = it.cubicInches,
                    dimensionalWeight = it.dimensionalWeight,
                    height = it.height,
                    id = it.id,
                    length = it.length,
                    normallyShipAlone = it.normallyShipAlone,
                    note = it.note,
                    weight = it.weight,
                    width = it.width
                )
            },
        ),
    )
}

fun RecountRequestDto.toRecountRequest(): RecountRequest {
    val recountProduct = RecountProduct.getDefaultInstance().toBuilder().setId(product.id)
        .setName(product.name)
        .setDescription(product.description).setManufacturer(product.manufacturer)
        .setImageURL(product.imageURL)
        .addAllProductIdentifiers(product.productIdentifiers + product.name)
        .addAllProductBoxes(product.productBoxes.map { productBox ->
            ProductBox.getDefaultInstance().toBuilder()
                .setCubicInches(productBox.cubicInches)
                .setDimensionalWeight(productBox.dimensionalWeight)
                .setHeight(productBox.height).setId(productBox.id)
                .setLength(productBox.length)
                .setNormallyShipAlone(productBox.normallyShipAlone)
                .setNote(productBox.note)
                .setWeight(productBox.weight).setWidth(productBox.width).build()
        })
    if (product.serialNumber != null) {
        recountProduct.serialNumber = product.serialNumber
    }

    val recountRequest =
        RecountRequest.getDefaultInstance().toBuilder().setRecountRequestId(recountRequestId)
            .setPriority(priority).setRequestedByEmployee(requestedByEmployee)
            .setRequestedDate(requestedDate).setRequestedStatus(requestedStatus)
            .setProduct(recountProduct)
    if (completedAt != null) {
        recountRequest.completedAt = completedAt
    }

    return recountRequest.build()
}

fun RecountLocation.toRecountLocationDto(): RecountLocationDto {
    return RecountLocationDto(
        recountLocationId = recountLocationId,
        priority = priority,
        location = LocationDto(
            id = location.id,
            name = location.name
        ),
        note = note,
        countedByEmployee = countedByEmployee,
        expectedQuantity = expectedQuantity,
        countedQuantity = countedQuantity,
        countStartAt = countStartAt,
        countCompletedAt = countCompletedAt
    )
}

fun RecountLocationDto.toRecountLocation(): RecountLocation {
    val location =
        Location.getDefaultInstance().toBuilder().setId(location.id).setName(location.name)

    val recountLocation =
        RecountLocation.getDefaultInstance().toBuilder().setRecountLocationId(recountLocationId)
            .setPriority(priority)
            .setLocation(location)
    if (countedByEmployee != null) {
        recountLocation.countedByEmployee = countedByEmployee
    }
    if (expectedQuantity != null) {
        recountLocation.expectedQuantity = expectedQuantity
    }
    if (countedQuantity != null) {
        recountLocation.countedQuantity = countedQuantity
    }
    if (note != null) {
        recountLocation.note = note
    }
    if (countStartAt != null) {
        recountLocation.countStartAt = countStartAt
    }
    if (countCompletedAt != null) {
        recountLocation.countCompletedAt = countCompletedAt
    }

    return recountLocation.build()
}

fun List<RecountLocation>.toRecountLocationsDtoList(): List<RecountLocationDto> {
    return this.map { recountLocation ->
        recountLocation.toRecountLocationDto()
    }
}

fun List<RecountLocationDto>.toRecountLocationsList(): List<RecountLocation> {
    return this.map { recountLocationDto ->
        recountLocationDto.toRecountLocation()
    }
}

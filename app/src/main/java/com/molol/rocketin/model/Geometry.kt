package com.molol.rocketin.model

data class Geometry( val location : BarLocation?) {
    data class BarLocation(val lat : Float, val lng: Float)
}
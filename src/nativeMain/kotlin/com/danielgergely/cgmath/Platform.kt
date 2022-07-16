package com.danielgergely.cgmath

internal actual fun floatArrayCopy(source: FloatArray, destination: FloatArray, destPos: Int): Unit {
    source.copyInto(destination, destinationOffset = destPos)
}

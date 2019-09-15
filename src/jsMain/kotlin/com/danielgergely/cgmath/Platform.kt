package com.danielgergely.cgmath

internal actual fun floatArrayCopy(source: FloatArray, destination: dynamic, destPos: Int) {
    destination.set(source, destPos)
}
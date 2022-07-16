package com.danielgergely.cgmath

internal actual fun floatArrayCopy(source: FloatArray, destination: FloatArray, destPos: Int) =
    System.arraycopy(source, 0, destination, destPos, source.size)
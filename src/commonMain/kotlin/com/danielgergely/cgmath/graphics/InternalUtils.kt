package com.danielgergely.cgmath.graphics

import kotlin.math.sqrt

internal fun length(x: Float, y: Float, z: Float): Float {
    return sqrt(x * x + y * y + z * z)
}

internal fun translateM(
    m: FloatArray, mOffset: Int,
    x: Float, y: Float, z: Float
) {
    for (i in 0..3) {
        val mi = mOffset + i
        m[12 + mi] += m[mi] * x + m[4 + mi] * y + m[8 + mi] * z
    }
}

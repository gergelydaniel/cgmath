package com.danielgergely.cgmath.mat3

import com.danielgergely.cgmath.floatArrayCopy

public fun Mat3.assign(other: Mat3) {
    floatArrayCopy(other.array, array, 0)
}

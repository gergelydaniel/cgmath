package com.danielgergely.cgmath.mat4

import com.danielgergely.cgmath.floatArrayCopy

public fun Mat4.assign(other: Mat4) {
    floatArrayCopy(other.array, array, 0)
}

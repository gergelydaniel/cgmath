package com.danielgergely.cgmath.mat4

import com.danielgergely.cgmath.floatArrayCopy

fun Mat4.assign(other: Mat4) {
    floatArrayCopy(other.array, array, 0)
}
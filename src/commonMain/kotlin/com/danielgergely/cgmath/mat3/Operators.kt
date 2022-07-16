package com.danielgergely.cgmath.mat3

import com.danielgergely.cgmath.vec2.Vec2
import com.danielgergely.cgmath.vec3.Vec3

public operator fun Mat3.times(rhs : Mat3) : Mat3 {
    val result = Mat3.zero()
    for (i in 0..2) {
        for (j in 0..2) {
            result.array[i*3 + j] = 0f
            for (k in 0..2) result.array[i*3 + j] += array[i*3 + k] * rhs.array[k*3 + j]
        }
    }
    return result
}

public operator fun Mat3.timesAssign(other : Mat3) {
    val a = array
    val b = other.array

    val f0 = a[0] * b[0] + a[1] * b[3] + a[2] * b[6]
    val f1 = a[0] * b[1] + a[1] * b[4] + a[2] * b[7]
    val f2 = a[0] * b[2] + a[1] * b[5] + a[2] * b[8]

    val f3 = a[3] * b[0] + a[4] * b[3] + a[5] * b[6]
    val f4 = a[3] * b[1] + a[4] * b[4] + a[5] * b[7]
    val f5 = a[3] * b[2] + a[4] * b[5] + a[5] * b[8]

    val f6 = a[6] * b[0] + a[7] * b[3] + a[8] * b[6]
    val f7 = a[6] * b[1] + a[7] * b[4] + a[8] * b[7]
    val f8 = a[6] * b[2] + a[7] * b[5] + a[8] * b[8]

    array[0] = f0
    array[1] = f1
    array[2] = f2
    array[3] = f3
    array[4] = f4
    array[5] = f5
    array[6] = f6
    array[7] = f7
    array[8] = f8
}

public operator fun Mat3.times(v: Vec3): Vec3 = Vec3(
    array[0] * v.x + array[3] * v.y + array[6] * v.z,
    array[1] * v.x + array[4] * v.y + array[7] * v.z,
    array[2] * v.x + array[5] * v.y + array[8] * v.z
)

public operator fun Mat3.times(v: Vec2): Vec2 = Vec2(
    array[0] * v.x + array[3] * v.y + array[6] * 1f,
    array[1] * v.x + array[4] * v.y + array[7] * 1f
)

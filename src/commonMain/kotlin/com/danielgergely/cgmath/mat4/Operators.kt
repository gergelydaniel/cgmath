package com.danielgergely.cgmath.mat4

import com.danielgergely.cgmath.vec3.Vec3
import com.danielgergely.cgmath.vec4.Vec4


operator fun Mat4.times(rhs: Mat4): Mat4 {
    val result = Mat4.zero()
    for (i in 0..3) {
        for (j in 0..3) {
            result.array[i * 4 + j] = 0f
            for (k in 0..3) result.array[i * 4 + j] += array[i * 4 + k] * rhs.array[k * 4 + j]
        }
    }
    return result
}

// Implementing timesAssign without object allocation
operator fun Mat4.timesAssign(other: Mat4) {
    val a = array
    val b = other.array

    val f0 = a[0] * b[0] + a[1] * b[4] + a[2] * b[8] + a[3] * b[12]
    val f1 = a[0] * b[1] + a[1] * b[5] + a[2] * b[9] + a[3] * b[13]
    val f2 = a[0] * b[2] + a[1] * b[6] + a[2] * b[10] + a[3] * b[14]
    val f3 = a[0] * b[3] + a[1] * b[7] + a[2] * b[11] + a[3] * b[15]

    val f4 = a[4] * b[0] + a[5] * b[4] + a[6] * b[8] + a[7] * b[12]
    val f5 = a[4] * b[1] + a[5] * b[5] + a[6] * b[9] + a[7] * b[13]
    val f6 = a[4] * b[2] + a[5] * b[6] + a[6] * b[10] + a[7] * b[14]
    val f7 = a[4] * b[3] + a[5] * b[7] + a[6] * b[11] + a[7] * b[15]

    val f8 = a[8] * b[0] + a[9] * b[4] + a[10] * b[8] + a[11] * b[12]
    val f9 = a[8] * b[1] + a[9] * b[5] + a[10] * b[9] + a[11] * b[13]
    val f10 = a[8] * b[2] + a[9] * b[6] + a[10] * b[10] + a[11] * b[14]
    val f11 = a[8] * b[3] + a[9] * b[7] + a[10] * b[11] + a[11] * b[15]

    val f12 = a[12] * b[0] + a[13] * b[4] + a[14] * b[8] + a[15] * b[12]
    val f13 = a[12] * b[1] + a[13] * b[5] + a[14] * b[9] + a[15] * b[13]
    val f14 = a[12] * b[2] + a[13] * b[6] + a[14] * b[10] + a[15] * b[14]
    val f15 = a[12] * b[3] + a[13] * b[7] + a[14] * b[11] + a[15] * b[15]

    array[0] = f0
    array[1] = f1
    array[2] = f2
    array[3] = f3
    array[4] = f4
    array[5] = f5
    array[6] = f6
    array[7] = f7
    array[8] = f8
    array[9] = f9
    array[10] = f10
    array[11] = f11
    array[12] = f12
    array[13] = f13
    array[14] = f14
    array[15] = f15
}

operator fun Mat4.plus(rhs: Mat4): Mat4 {
    val result = Mat4.zero()
    for (i in 0..15) {
        result.array[i] = array[i] + rhs.array[i]
    }
    return result
}


operator fun Mat4.times(v: Vec3): Vec3 {
    return Vec3(
        v.x * array[0 * 4 + 0] + v.y * array[1 * 4 + 0] + v.z * array[2 * 4 + 0] + array[3 * 4 + 0],
        v.x * array[0 * 4 + 1] + v.y * array[1 * 4 + 1] + v.z * array[2 * 4 + 1] + array[3 * 4 + 1],
        v.x * array[0 * 4 + 2] + v.y * array[1 * 4 + 2] + v.z * array[2 * 4 + 2] + array[3 * 4 + 2]
    )
}

operator fun Mat4.times(v: Vec4): Vec4 {
    return Vec4(
        v.x * array[0 * 4 + 0] + v.y * array[1 * 4 + 0] + v.z * array[2 * 4 + 0] + v.w * array[3 * 4 + 0],
        v.x * array[0 * 4 + 1] + v.y * array[1 * 4 + 1] + v.z * array[2 * 4 + 1] + v.w * array[3 * 4 + 1],
        v.x * array[0 * 4 + 2] + v.y * array[1 * 4 + 2] + v.z * array[2 * 4 + 2] + v.w * array[3 * 4 + 2],
        v.x * array[0 * 4 + 3] + v.y * array[1 * 4 + 3] + v.z * array[2 * 4 + 3] + v.w * array[3 * 4 + 3]
    )
}
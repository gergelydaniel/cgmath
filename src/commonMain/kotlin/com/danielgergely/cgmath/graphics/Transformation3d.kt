package com.danielgergely.cgmath.graphics

import com.danielgergely.cgmath.mat4.Mat4
import com.danielgergely.cgmath.vec3.Vec3
import kotlin.math.cos
import kotlin.math.sin

private inline fun withMat4(operation: (Mat4) -> Unit): Mat4 {
    val result = Mat4.zero()
    operation(result)
    return result
}

public fun rotateMatrix(angle: Float, axis: Vec3): Mat4 = withMat4 {
    rotateMatrix(angle, axis.x, axis.y, axis.z, it)
}

// Rodrigues matrix
public fun rotateMatrix(angle: Float, axisX: Float, axisY: Float, axisZ: Float, result: Mat4) {
    val c = cos(angle)
    val s = sin(angle)

    val axisLen = length(axisX, axisY, axisZ)
    val wx = axisX / axisLen
    val wy = axisY / axisLen
    val wz = axisZ / axisLen

    result.array[0] = c * (1f - wx * wx) + wx * wx
    result.array[1] = wx * wy * (1f - c) + wz * s
    result.array[2] = wx * wz * (1f - c) - wy * s
    result.array[3] = 0f
    result.array[4] = wx * wy * (1f - c) - wz * s
    result.array[5] = c * (1f - wy * wy) + wy * wy
    result.array[6] = wy * wz * (1 - c) + wx * s
    result.array[7] = 0f
    result.array[8] = wx * wz * (1f - c) + wy * s
    result.array[9] = wy * wz * (1f - c) - wx * s
    result.array[10] = c * (1f - wz * wz) + wz * wz
    result.array[11] = 0f
    result.array[12] = 0f
    result.array[13] = 0f
    result.array[14] = 0f
    result.array[15] = 1f
}

public fun scaleMatrix(x: Float, y: Float, z: Float): Mat4 = withMat4 {
    scaleMatrix(x, y, z, it)
}

public fun scaleMatrix(scale: Vec3): Mat4 = withMat4 {
    scaleMatrix(scale.x, scale.y, scale.z, it)
}

public fun scaleMatrix(sx: Float, sy: Float, sz: Float, result: Mat4) {
    result.array[0] = sx
    result.array[1] = 0f
    result.array[2] = 0f
    result.array[3] = 0f
    result.array[4] = 0f
    result.array[5] = sy
    result.array[6] = 0f
    result.array[7] = 0f
    result.array[8] = 0f
    result.array[9] = 0f
    result.array[10] = sz
    result.array[11] = 0f
    result.array[12] = 0f
    result.array[13] = 0f
    result.array[14] = 0f
    result.array[15] = 1f
}

public fun translateMatrix(t: Vec3): Mat4 = withMat4 {
    translateMatrix(t.x, t.y, t.z, it)
}

public fun translateMatrix(tx: Float, ty: Float, tz: Float, result: Mat4) {
    result.array[0] = 1f
    result.array[1] = 0f
    result.array[2] = 0f
    result.array[3] = 0f
    result.array[4] = 0f
    result.array[5] = 1f
    result.array[6] = 0f
    result.array[7] = 0f
    result.array[8] = 0f
    result.array[9] = 0f
    result.array[10] = 1f
    result.array[11] = 0f
    result.array[12] = tx
    result.array[13] = ty
    result.array[14] = tz
    result.array[15] = 1f
}

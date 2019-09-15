package com.danielgergely.cgmath.graphics

import com.danielgergely.cgmath.mat4.Mat4
import com.danielgergely.cgmath.vec3.Vec3

private inline fun withMat4(operation: (Mat4) -> Unit): Mat4 {
    val result = Mat4.zero()
    operation(result)
    return result
}

/**
 * Creates a viewing matrix derived from an eye point, a reference point indicating the center of the scene, and an UP
 * vector - and returns a new [Mat4] instance containing the result.
 *
 * Based on gluLookAt
 */
fun lookAt(eye: Vec3, center: Vec3, up: Vec3) = withMat4 {
    lookAt(eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z, it)
}

/**
 * Creates a viewing matrix derived from an eye point, a reference point indicating the center of the scene, and an UP
 * vector - and writes the result into an existing object.
 *
 * Based on gluLookAt
 *
 * @param result The [Mat4] object to write the result to.
 */
inline fun lookAt(eye: Vec3, center: Vec3, up: Vec3, result: Mat4) {
    lookAt(eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z, result)
}

/**
 * Creates a viewing matrix derived from an eye point, a reference point indicating the center of the scene, and an UP
 * vector - and writes the result into an existing object.
 *
 * Based on gluLookAt
 *
 * @param result The [Mat4] object to write the result to.
 */
fun lookAt(
    eyeX: Float, eyeY: Float, eyeZ: Float,
    centerX: Float, centerY: Float, centerZ: Float,
    upX: Float, upY: Float, upZ: Float,
    result: Mat4
) {

    // See the OpenGL GLUT documentation for gluLookAt for a description
    // of the algorithm. We implement it in a straightforward way:

    var fx = centerX - eyeX
    var fy = centerY - eyeY
    var fz = centerZ - eyeZ

    // Normalize f
    val rlf = 1.0f / length(fx, fy, fz)
    fx *= rlf
    fy *= rlf
    fz *= rlf

    // compute s = f x up (x means "cross product")
    var sx = fy * upZ - fz * upY
    var sy = fz * upX - fx * upZ
    var sz = fx * upY - fy * upX

    // and normalize s
    val rls = 1.0f / length(sx, sy, sz)
    sx *= rls
    sy *= rls
    sz *= rls

    // compute u = s x f
    val ux = sy * fz - sz * fy
    val uy = sz * fx - sx * fz
    val uz = sx * fy - sy * fx

    result.array[0] = sx
    result.array[1] = ux
    result.array[2] = -fx
    result.array[3] = 0.0f

    result.array[4] = sy
    result.array[5] = uy
    result.array[6] = -fy
    result.array[7] = 0.0f

    result.array[8] = sz
    result.array[9] = uz
    result.array[10] = -fz
    result.array[11] = 0.0f

    result.array[12] = 0.0f
    result.array[13] = 0.0f
    result.array[14] = 0.0f
    result.array[15] = 1.0f

    translateM(result.array, 0, -eyeX, -eyeY, -eyeZ)
}
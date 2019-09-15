package com.danielgergely.cgmath

import com.danielgergely.cgmath.mat3.Mat3
import com.danielgergely.cgmath.mat4.Mat4
import com.danielgergely.cgmath.vec2.Vec2
import com.danielgergely.cgmath.vec3.Vec3
import com.danielgergely.cgmath.vec4.Vec4
import kotlin.math.abs

const val FLOAT_COMPARE_THRESHOLD = 0.001f

private fun allClose(array1: FloatArray, array2: FloatArray) = array1.zip(array2)
    .all { (v1, v2) -> abs(v1 - v2) < FLOAT_COMPARE_THRESHOLD }

infix fun Vec2.closeTo(rhs: Vec2) = allClose(this.array, rhs.array)
infix fun Vec3.closeTo(rhs: Vec3) = allClose(this.array, rhs.array)
infix fun Vec4.closeTo(rhs: Vec4) = allClose(this.array, rhs.array)
infix fun Mat3.closeTo(rhs: Mat3) = allClose(this.array, rhs.array)
infix fun Mat4.closeTo(rhs: Mat4) = allClose(this.array, rhs.array)



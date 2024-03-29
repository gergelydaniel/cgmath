package com.danielgergely.cgmath.vec4

import kotlin.math.sqrt


public operator fun Vec4.plus(other: Vec4): Vec4 = Vec4(x + other.x, y + other.y, z + other.z, w + other.w)

public operator fun Vec4.minus(other: Vec4): Vec4 = Vec4(x - other.x, y - other.y, z - other.z, w - other.w)

public operator fun Vec4.unaryMinus(): Vec4 = Vec4(-x, -y, -z, -w)

public operator fun Float.times(vec: Vec4): Vec4 = Vec4(this * vec.x, this * vec.y, this * vec.z, this * vec.w)

public operator fun Vec4.times(f: Float): Vec4 = Vec4(f * x, f * y, f * z, f * w)

public operator fun Vec4.div(f: Float): Vec4 = Vec4(x / f, y / f, z / f, w / f)

public operator fun Float.plus(v: Vec4): Vec4 = Vec4(this + v.x, this + v.y, this + v.z, this + v.w)

public operator fun Vec4.timesAssign(f: Float) {
    x *= f
    y *= f
    z *= f
    w *= f
}

public operator fun Vec4.plusAssign(other: Vec4) {
    x += other.x
    y += other.y
    z += other.z
    w += other.w
}

public operator fun Vec4.minusAssign(other: Vec4) {
    x -= other.x
    y -= other.y
    z -= other.z
    w -= other.w
}

public val Vec4.length: Float
    get() = sqrt(x * x + y * y + z * z + w * w)

public fun Vec4.normalize(): Vec4 = this / this.length

public infix fun Vec4.dot(rhs: Vec4): Float = x * rhs.x + y * rhs.y + z * rhs.z + rhs.w * w

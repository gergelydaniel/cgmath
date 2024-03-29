package com.danielgergely.cgmath.vec3

import kotlin.math.sqrt

public operator fun Vec3.plus(other: Vec3): Vec3 = Vec3(x + other.x, y + other.y, z + other.z)

public operator fun Vec3.minus(other: Vec3): Vec3 = Vec3(x - other.x, y - other.y, z - other.z)

public operator fun Vec3.unaryMinus(): Vec3 = Vec3(-x, -y, -z)

public operator fun Float.times(vec: Vec3): Vec3 = Vec3(this * vec.x, this * vec.y, this * vec.z)

public operator fun Vec3.times(f: Float): Vec3 = Vec3(f * x, f * y, f * z)

public operator fun Vec3.div(f: Float): Vec3 = Vec3(x / f, y / f, z / f)

public operator fun Float.plus(v: Vec3): Vec3 = Vec3(this + v.x, this + v.y, this + v.z)

public operator fun Vec3.timesAssign(f: Float) {
    x *= f
    y *= f
    z *= f
}

public operator fun Vec3.plusAssign(other: Vec3) {
    x += other.x
    y += other.y
    z += other.z
}

public operator fun Vec3.minusAssign(other: Vec3) {
    x -= other.x
    y -= other.y
    z -= other.z
}

public infix fun Vec3.dot(rhs: Vec3): Float = x * rhs.x + y * rhs.y + z * rhs.z

public infix fun Vec3.cross(rhs: Vec3): Vec3 = Vec3(
    y * rhs.z - z * rhs.y,
    z * rhs.x - x * rhs.z,
    x * rhs.y - y * rhs.x,
)

public val Vec3.length: Float
    get() = sqrt(x * x + y * y + z * z)

public fun Vec3.normalize(): Vec3 = this / this.length

public fun mix(a: Vec3, b: Vec3, n: Float): Vec3 {
    val aMul = 1f - n
    val bMul = n

    return Vec3(
        aMul * a.x + bMul * b.x,
        aMul * a.y + bMul * b.y,
        aMul * a.z + bMul * b.z,
    )
}

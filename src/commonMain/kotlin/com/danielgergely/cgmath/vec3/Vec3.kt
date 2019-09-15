package com.danielgergely.cgmath.vec3

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Vec3 internal constructor(val array: FloatArray) {
    inline var x: Float
        get() = array[0]
        set(value) { array[0] = value }

    inline var y: Float
        get() = array[1]
        set(value) { array[1] = value }

    inline var z: Float
        get() = array[2]
        set(value) { array[2] = value }

    operator fun component1() = array[0]
    operator fun component2() = array[1]
    operator fun component3() = array[2]
}

fun Vec3(x: Float, y: Float, z: Float): Vec3 = Vec3(floatArrayOf(x, y, z))

fun Vec3(other: Vec3): Vec3 = Vec3(other.array.copyOf())
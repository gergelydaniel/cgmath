package com.danielgergely.cgmath.vec3

import kotlin.jvm.JvmInline

@JvmInline
public value class Vec3 internal constructor(public val array: FloatArray) {

    public inline var x: Float
        get() = array[0]
        set(value) {
            array[0] = value
        }

    public inline var y: Float
        get() = array[1]
        set(value) {
            array[1] = value
        }

    public inline var z: Float
        get() = array[2]
        set(value) {
            array[2] = value
        }

    public operator fun component1(): Float = array[0]
    public operator fun component2(): Float = array[1]
    public operator fun component3(): Float = array[2]
}

public fun Vec3(x: Float, y: Float, z: Float): Vec3 = Vec3(floatArrayOf(x, y, z))

public fun Vec3(other: Vec3): Vec3 = Vec3(other.array.copyOf())

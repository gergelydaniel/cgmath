package com.danielgergely.cgmath.vec3

import com.danielgergely.cgmath.vec2.Vec2

public inline var Vec3.xy: Vec2
    get() = Vec2(x, y)
    set(value) {
        x = value.x
        y = value.y
    }

public inline var Vec3.xz: Vec2
    get() = Vec2(x, z)
    set(value) {
        x = value.x
        z = value.y
    }

public inline var Vec3.yz: Vec2
    get() = Vec2(y, z)
    set(value) {
        y = value.x
        z = value.y
    }

public inline var Vec3.yx: Vec2
    get() = Vec2(y, x)
    set(value) {
        y = value.x
        x = value.y
    }

public inline var Vec3.zx: Vec2
    get() = Vec2(z, x)
    set(value) {
        z = value.x
        x = value.y
    }

public inline var Vec3.zy: Vec2
    get() = Vec2(z, y)
    set(value) {
        z = value.x
        y = value.y
    }

public fun Vec3(xy: Vec2, z: Float): Vec3 = Vec3(xy.x, xy.y, z)

package com.danielgergely.cgmath.vec4

import com.danielgergely.cgmath.vec2.Vec2
import com.danielgergely.cgmath.vec3.Vec3


inline var Vec4.xy: Vec2
    get() = Vec2(x, y)
    set(value) {
        x = value.x
        y = value.y
    }

inline var Vec4.xz: Vec2
    get() = Vec2(x, z)
    set(value) {
        x = value.x
        z = value.y
    }

inline var Vec4.yz: Vec2
    get() = Vec2(y, z)
    set(value) {
        y = value.x
        z = value.y
    }

inline var Vec4.yx: Vec2
    get() = Vec2(y, x)
    set(value) {
        y = value.x
        x = value.y
    }

inline var Vec4.zx: Vec2
    get() = Vec2(z, x)
    set(value) {
        z = value.x
        x = value.y
    }

inline var Vec4.zy: Vec2
    get() = Vec2(z, y)
    set(value) {
        z = value.x
        y = value.y
    }

inline var Vec4.xw: Vec2
    get() = Vec2(x, w)
    set(value) {
        x = value.x
        w = value.y
    }

inline var Vec4.zw: Vec2
    get() = Vec2(z, w)
    set(value) {
        z = value.x
        w = value.y
    }

inline var Vec4.yw: Vec2
    get() = Vec2(y, w)
    set(value) {
        y = value.x
        w = value.y
    }

inline var Vec4.wx: Vec2
    get() = Vec2(w, x)
    set(value) {
        w = value.x
        x = value.y
    }

inline var Vec4.wz: Vec2
    get() = Vec2(w, z)
    set(value) {
        w = value.x
        z = value.y
    }

inline var Vec4.wy: Vec2
    get() = Vec2(w, y)
    set(value) {
        w = value.x
        y = value.y
    }

inline var Vec4.xyz: Vec3
    get() = Vec3(x, y, z)
    set(value) {
        x = value.x
        y = value.y
        z = value.z
    }

fun Vec4(xyz: Vec3, w: Float): Vec4 = Vec4(xyz.x, xyz.y, xyz.z, w)
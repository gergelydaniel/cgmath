## CGMath

Graphics math library for Kotlin, supports JVM, JS and multiplatform projects, developed with focus on readability,
performance, and convenient usage with OpenGL based APIs.

This library is used in the multiplatform game project [Skyway](https://skyway.danielgergely.com)

### Installation

At this moment the library is only available from my repository:

```groovy
repositories {
    maven { url 'https://maven.danielgergely.com/releases' }
}
dependencies {
    implementation 'com.danielgergely.cgmath:cgmath:2.0.0'
}
```

Or you can build it manually:
```bash
./gradlew build
```

### Types

* `Vec2`: a two dimensional vector of 32-bit floats
* `Vec3`: a two dimensional vector of 32-bit floats
* `Vec4`: a two dimensional vector of 32-bit floats
* `Mat3`: a 3x3 column-major matrix of 32-bit floats
* `Mat4`: a 4x4 column-major matrix of 32-bit floats

### Features

#### Vector and matrix operators

```kotlin
val v1 = Vec3(1f, 2f, 3f)
val v2 = Vec3(4f, 5f, 6f)

val sum = v1 + v2
val crossProduct = v1 cross v2

val matrix: Mat4
val vector: Vec4
val transformed = matrix * vector
```

#### Swizzling, destructuring

```kotlin
val space = Vec3(…)
val (x, y, z) = space
val plain: Vec2 = space.xy
```

### Performance considerations

* All types are based on float arrays. - This is useful when using OpenGL's `uniform*v` methods, and also provides a 
type hint for Javascript runtimes, so that 32 bit operations can be used instead of the default 64 bit.
* All types are inline classes. - This decreases a payload of the garbage collector which can be important for a realtime
renderer.
* `*assign` operators don't use allocations
* for build in graphics methods like `perspectiveM` and `lookatM`, both assigning and returning versions are provided.
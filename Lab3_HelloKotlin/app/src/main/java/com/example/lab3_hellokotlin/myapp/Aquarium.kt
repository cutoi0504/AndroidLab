package com.example.lab3_hellokotlin.myapp

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
    fun printSize() {
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
    }

    class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
        // Dimensions in cm
        var length: Int = length
        var width: Int = width
        var height: Int = height

        class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
            init {
                println("aquarium initializing")
            }

            init {
                // 1 liter = 1000 cm^3
                println("Volume: ${width * length * height / 1000} liters")
            }
        }

    }
}


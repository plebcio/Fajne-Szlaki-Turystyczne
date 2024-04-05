package com.szlaki.turystyczne.data

import com.szlaki.turystyczne.Trail

class TrailRepository {

    private var trails = mutableListOf<Trail>()
    fun create(){
        // add the trails to the list
        trails = listOf(
            Trail(
                name = "Trail 1",
                description = "Trail 1 description",
                length = 10,
                difficulty = 1,
                durationMin = 60,
                distanceMeter = 1000,
                elevation = 100,
                imagePath = "xd",
                location = "Kraków"
            ),
            Trail(
                name = "Trail 2",
                description = "Trail 2 description",
                length = 20,
                difficulty = 2,
                durationMin = 120,
                distanceMeter = 2000,
                elevation = 200,
                imagePath = "xd",
                location = "Warszawa"
            ),
            Trail(
                name = "Trail 3",
                description = "Trail 3 description",
                length = 30,
                difficulty = 3,
                durationMin = 180,
                distanceMeter = 3000,
                elevation = 300,
                imagePath = "xd",
                location = "Wrocław"
            ),
            Trail(
                name = "Trail 4",
                description = "Trail 4 description",
                length = 40,
                difficulty = 4,
                durationMin = 240,
                distanceMeter = 4000,
                elevation = 400,
                imagePath = "xd",
                location = "Gdańsk"
            ),
            Trail(
                name = "Trail 5",
                description = "Trail 5 description",
                length = 50,
                difficulty = 5,
                durationMin = 300,
                distanceMeter = 5000,
                elevation = 500,
                imagePath = "xd",
                location = "Poznań"
            ),
            Trail(
                name = "Trail 6",
                description = "Trail 6 description",
                length = 60,
                difficulty = 6,
                durationMin = 360,
                distanceMeter = 6000,
                elevation = 600,
                imagePath = "xd",
                location = "Szczecin"
            ),
            Trail(
                name = "Trail 7",
                description = "Trail 7 description",
                length = 70,
                difficulty = 7,
                durationMin = 420,
                distanceMeter = 7000,
                elevation = 700,
                imagePath = "xd",
                location = "Lublin"
            ),
        ).toMutableList()
    }

    fun getTrailbyId(id: Int): Trail {
        // check for out of range access
        if (id < 0 || id >= trails.size) {
            return Trail()
        }
        return trails[id]
    }

    fun getTrailNames(): List<String> {
        return trails.map { it.name }
    }
}
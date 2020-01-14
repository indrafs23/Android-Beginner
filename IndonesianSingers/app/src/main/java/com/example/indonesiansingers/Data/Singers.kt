package com.example.indonesiansingers.Data

import java.io.Serializable

data class Singers(
    var name: String = "",
    var from: String = "",
    var photo: String = ""
) : Serializable
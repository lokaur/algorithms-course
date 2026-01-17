rootProject.name = "algorithms-course"

include("1.graphs", "2.complexity", "3.collection", "4.recursion", "7.hashing", "8.streams", "9.patterns", "12.consoleapp")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        mavenCentral()
    }
}

gradle.projectsLoaded {
    rootProject.allprojects.forEach {
        it.group = "me.lokaur.algorithms"
    }
}

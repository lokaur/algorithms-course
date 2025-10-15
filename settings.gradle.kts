rootProject.name = "algorithms-course"

include("1.graphs", "2.complexity", "3.collection")

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

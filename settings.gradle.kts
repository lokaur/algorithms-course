rootProject.name = "algorithms-course"

include("1.graphs")

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
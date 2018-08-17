package swarmer.plugin

import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec

abstract class SwarmTask : JavaExec() {

  companion object {
    const val MAIN_CLASS = "com.gojuno.swarmer.MainKt"
    const val SWARMER = "swarmer"
    private const val ARTIFACT_DEP = "com.gojuno.swarmer:swarmer:0.2.4"

    fun createSwarmerConfiguration(project: Project) {
      if (project.configurations.findByName(SWARMER) == null) {
        project.configurations.create(SWARMER)
        project.dependencies.add(SWARMER, ARTIFACT_DEP)
      }
    }
  }

  init {
    createSwarmerConfiguration(project)
  }

}
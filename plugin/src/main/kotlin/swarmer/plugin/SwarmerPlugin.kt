package swarmer.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SwarmerPlugin : Plugin<Project> {

  override fun apply(project: Project) {
    val extension = project.extensions.create("swarmer", SwarmerPluginExtension::class.java,
        project)

    project.tasks.create("startSwarm", StartSwarmTask::class.java) {
      it.doFirst {
        (it as StartSwarmTask).virtualDevices(extension.virtualDevices.toMutableList())
      }
    }

    project.tasks.create("stopSwarm", StopSwarmTask::class.java) {
      it.doFirst {
        (it as StopSwarmTask).timeout(extension.timeout)
      }
    }
  }

}
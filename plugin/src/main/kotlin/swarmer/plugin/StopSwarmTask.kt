package swarmer.plugin

import org.gradle.api.tasks.Input

open class StopSwarmTask : SwarmTask(), StopSwarmConfigurator {

  @Input
  override var timeout: Int = 15

  override fun timeout(value: Int) {
    timeout = value
  }

  override fun exec() {
    args = listOf("stop")
    main = MAIN_CLASS
    classpath = project.configurations.getByName(SWARMER)
    super.exec()
  }

}
package swarmer.plugin

import org.gradle.api.tasks.Input

open class StartSwarmTask : SwarmTask(), StartSwarmConfigurator {

  @Input
  override var virtualDevices: MutableList<VirtualDevice> = mutableListOf()

  override fun virtualDevices(value: MutableList<VirtualDevice>) {
    virtualDevices = value
  }

  override fun exec() {
    args = listOf("start") + virtualDevices.flatMap(VirtualDevice::toClientArgs)
    main = MAIN_CLASS
    classpath = project.configurations.getByName(SWARMER)
    super.exec()
  }
}
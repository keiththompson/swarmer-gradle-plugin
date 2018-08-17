package swarmer.plugin

import groovy.lang.Closure
import org.gradle.api.Project

open class SwarmerPluginExtension(project: Project) {

  val virtualDevices = project.container(VirtualDevice::class.java)
  var timeout: Int = 15

  fun virtualDevices(closure: Closure<VirtualDevice>) {
    virtualDevices.configure(closure)
  }

  fun timeout(value: Int) {
    timeout = value
  }

}

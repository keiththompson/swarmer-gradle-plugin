package swarmer.plugin

interface StartSwarmConfigurator {
  var virtualDevices: MutableList<VirtualDevice>
  fun virtualDevices(value: MutableList<VirtualDevice>)
}

interface StopSwarmConfigurator {
  var timeout: Int
  fun timeout(value: Int)
}
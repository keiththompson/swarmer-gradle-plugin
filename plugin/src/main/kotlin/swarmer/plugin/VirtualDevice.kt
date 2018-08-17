package swarmer.plugin

class VirtualDevice(private val name: String) {

  private var packages: String = ""
  private var androidAbi: String = ""
  private var pathToConfigIni: String = ""
  private var emulatorStartOptions: String? = null
  private var emulatorStartTimeoutSeconds: Int? = null
  private var redirectLogcatTo: String? = null
  private var keepExistingAvds: Boolean? = null

  fun toClientArgs(): List<String> {
    return listOf(
        "--emulator-name", name,
        "--package", packages,
        "--android-abi", androidAbi,
        "--path-to-config-ini", pathToConfigIni)
        .let { params ->
          emulatorStartOptions?.let {
            params + arrayOf("--emulator-start-options", it)
          } ?: params
        }.let { params ->
          emulatorStartTimeoutSeconds?.let {
            params + arrayOf("--emulator-start-timeout-seconds", it.toString())
          } ?: params
        }.let { params ->
          redirectLogcatTo?.let {
            params + arrayOf("--redirect-logcat-to", it)
          } ?: params
        }.let { params ->
          keepExistingAvds?.let {
            params + arrayOf("--keep-existing-avds", it.toString())
          } ?: params
        }
  }

}
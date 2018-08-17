# swarmer-gradle-plugin [![](https://img.shields.io/maven-metadata/v/http/plugins.gradle.org/m2/gradle/plugin/keith/thompson/plugin/maven-metadata.xml.svg)](https://plugins.gradle.org/plugin/keith.thompson.swarmer)

Gradle plugin for running [gojuno/swarmer](https://github.com/gojuno/swarmer) from gradle.
This allows for avd configuration via gradle DSL.

## Install

Build script snippet for plugins DSL for Gradle 2.1 and later:
```groovy
plugins {
  id "keith.thompson.swarmer" version "0.1"
}
```

Build script snippet for use in older Gradle versions or where dynamic configuration is required:
```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.keith.thompson:plugin:0.1"
  }
}

apply plugin: "keith.thompson.swarmer"
```

## Usage

This plugin maps the client arguments detailed [here](https://github.com/gojuno/swarmer#options) to gradle DSL. 

| Arg                              | DSL                         |
| -------------------------------- |:---------------------------:| 
| --package                        | packages                    |  
| --android-abi                    | androidAbi                  | 
| --path-to-config-ini             | pathToConfigIni             |
| --emulator-start-options         | emulatorStartOptions        |
| --emulator-start-timeout-seconds | emulatorStartTimeoutSeconds |
| --redirect-logcat-to             | redirectLogcatTo            |
| --keep-existing-avds             | keepExistingAvds            |
| --timeout                        | timeout                     |



```groovy
swarmer {

  virtualDevices {

    Pixel_2 {
      packages = "system-images;android-27;google_apis;x86"
      androidAbi = "google_apis/x86"
      pathToConfigIni = "Pixel_2_API_27/config.ini"
      emulatorStartOptions = "-prop persist.sys.language=en -prop persist.sys.country=US"
    }

    Nexus_6P {
      packages = "system-images;android-26;google_apis;x86"
      androidAbi = "google_apis/x86"
      pathToConfigIni = "Nexus_6P_API_26/config.ini"
      emulatorStartOptions = "-prop persist.sys.language=en -prop persist.sys.country=US"
    }

    Pixel {
      packages = "system-images;android-25;google_apis;x86"
      androidAbi = "google_apis/x86"
      pathToConfigIni = "Pixel_API_25/config.ini"
      emulatorStartOptions = "-prop persist.sys.language=en -prop persist.sys.country=US"
    }

    Nexus_5X {
      packages = "system-images;android-24;google_apis_playstore;x86"
      androidAbi = "google_apis_playstore/x86"
      pathToConfigIni = "Nexus_5X_API_24/config.ini"
      emulatorStartOptions = "-prop persist.sys.language=en -prop persist.sys.country=US"
    }
  }
  timeout = 20
}
```


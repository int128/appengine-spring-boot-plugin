# App Engine Spring Boot Plugin [![Build Status](https://travis-ci.org/int128/appengine-spring-boot-plugin.svg?branch=master)](https://travis-ci.org/int128/appengine-spring-boot-plugin) [![Gradle Status](https://gradleupdate.appspot.com/int128/appengine-spring-boot-plugin/status.svg)](https://gradleupdate.appspot.com/int128/appengine-spring-boot-plugin/status)

This is a Gradle plugin for App Engine Standard and Spring Boot.


## Getting Started

```groovy
plugins {
  id 'java'
  id 'org.springframework.boot' version '1.5.6.RELEASE'
  id 'org.hidetake.appengine.spring.boot' version '0.9.0'
}

sourceCompatibility = JavaVersion.VERSION_1_8
targetCompatibility = JavaVersion.VERSION_1_8

repositories {
  jcenter()
}

dependencies {
  compile 'org.springframework.boot:spring-boot-starter-web'
  compile 'com.google.appengine:appengine-api-1.0-sdk:+'
  providedCompile 'javax.servlet:javax.servlet-api:3.1.0'
}

configurations.all {
  exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
  exclude group: 'org.slf4j', module: 'jul-to-slf4j'
}
```


## Features

The plugin does following things.

- Apply `war` plugin.
- Apply `com.google.cloud.tools.appengine-standard` plugin.
- Disable `bootRepackage` and `findMainClass` task.
- Improve log format of App Engine Dev Server by providing [the custom `logging.properties`](/src/main/groovy/org/hidetake/gradle/appengine/spring/boot/DevLoggingPropertiesTask.groovy).
- Add the task for watch and sync contents.
- Export Spring Boot configuration for debug.
- Export environment dependent properties.


### Watch and sync contents

The plugin continuously watch and sync following contents while App Engine Dev Server is running.

Content | Source | Destination
--------|--------|------------
e.g. Thymeleaf templates    | `src/main/resources` | `build/exploded-*/WEB-INF/classes`
e.g. static files           | `src/main/webapps`   | `build/exploded-*`


### Spring Boot configuration for debug

The plugin exports [system properties for debug](/src/main/groovy/org/hidetake/gradle/appengine/spring/boot/AppEngineSpringBootExtension.groovy)
(e.g. disable cache) as spring-boot-devtools provides.


### Environment dependent properties

Create a `.property` file in the project.

```properties
# .properties
foo.api.client-id=12345678
```

```
# .gitignore
/.properties
```

In App Engine Dev Server, the plugin exports them as system properties.

For production, the plugin stages it as `config/application.properties` in the deployment.


## Contributions

This is an open source software licensed under the Apache License Version 2.0.
Feel free to open issues or pull requests.


### Build

```
./gradlew build
```


### Deployment

Travis CI builds the plugin continuously.
It also publishes the plugin if a tag is pushed and following variables are set.

Environment Variable        | Value
----------------------------|------
`$GRADLE_PUBLISH_KEY`       | `gradle.publish.key` of the API key
`$GRADLE_PUBLISH_SECRET`    | `gradle.publish.secret` of the API key

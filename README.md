# App Engine Spring Boot Plugin [![Build Status](https://travis-ci.org/int128/appengine-spring-boot-plugin.svg?branch=master)](https://travis-ci.org/int128/appengine-spring-boot-plugin)

This is a Gradle plugin for App Engine Standard and Spring Boot.


## Getting Started

```groovy
plugins {
  id 'org.hidetake.appengine.spring.boot' version '0.9.0'
}
```


## Working with Travis CI

Travis CI builds the plugin continuously.
It also publishes the plugin if a tag is pushed and following variables are set.

Environment Variable        | Value
----------------------------|------
`$GRADLE_PUBLISH_KEY`       | `gradle.publish.key` of the API key
`$GRADLE_PUBLISH_SECRET`    | `gradle.publish.secret` of the API key


## Contributions

This is an open source software licensed under the Apache License Version 2.0.
Feel free to open issues or pull requests.

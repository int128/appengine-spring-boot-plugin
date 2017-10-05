package org.hidetake.gradle.appengine.spring.boot

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class PluginSpec extends Specification {

    def "apply() should load the plugin"() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.with {
            apply plugin: 'org.hidetake.appengine.spring.boot'
        }

        then:
        project.plugins.hasPlugin(AppEngineSpringBootPlugin)
    }

}

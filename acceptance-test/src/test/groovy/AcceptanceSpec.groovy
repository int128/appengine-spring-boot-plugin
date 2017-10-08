import org.gradle.testkit.runner.GradleRunner
import spock.lang.Specification
import spock.lang.Unroll

class AcceptanceSpec extends Specification {

    @Unroll
    def 'tasks should be shown'() {
        given:
        def runner = GradleRunner.create()
            .withProjectDir(new File('fixture'))
            .withArguments('-s', 'tasks')
            .withPluginClasspath()
            .forwardOutput()

        when:
        runner.build()

        then:
        noExceptionThrown()
    }

    @Unroll
    def 'project should be built'() {
        given:
        def runner = GradleRunner.create()
                .withProjectDir(new File('fixture'))
                .withArguments('-s', 'build')
                .withPluginClasspath()
                .forwardOutput()

        when:
        runner.build()

        then:
        noExceptionThrown()
    }

}

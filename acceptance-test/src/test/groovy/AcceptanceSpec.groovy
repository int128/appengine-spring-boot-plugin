import org.gradle.testkit.runner.GradleRunner
import spock.lang.Specification
import spock.lang.Unroll

class AcceptanceSpec extends Specification {

    @Unroll
    def 'tasks should be shown'() {
        given:
        def runner = GradleRunner.create()
            .withProjectDir(new File('fixture'))
            .withArguments('tasks')
            .withPluginClasspath()

        when:
        runner.build()

        then:
        noExceptionThrown()
    }

}

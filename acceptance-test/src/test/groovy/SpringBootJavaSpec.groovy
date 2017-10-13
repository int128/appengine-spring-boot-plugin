import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.Unroll

class SpringBootJavaSpec extends Specification {

    static final PROJECT_NAME = 'appengine-spring-boot-java'

    @Unroll
    def 'tasks should be shown'() {
        given:
        Helper.cleanup(PROJECT_NAME)
        def runner = Helper.createGradleRunner(PROJECT_NAME, 'tasks')

        when:
        def result = runner.build()

        then:
        result.output =~ /appengineRun/
    }

    @Unroll
    def 'project should be built'() {
        given:
        Helper.cleanup(PROJECT_NAME)
        def runner = Helper.createGradleRunner(PROJECT_NAME, 'build')

        when:
        def result = runner.build()

        then:
        result.task(':build')?.outcome == TaskOutcome.SUCCESS
    }

    @Unroll
    def 'project should be run'() {
        given:
        Helper.cleanup(PROJECT_NAME)
        def runner = Helper.createGradleRunner(PROJECT_NAME, 'appengineStart')

        when:
        def result = runner.build()

        then:
        result.task(':appengineStart')?.outcome == TaskOutcome.SUCCESS

        when:
        def staticContent = new URL('http://localhost:8080/').text
        def apiContent = new URL('http://localhost:8080/hello').text

        then:
        staticContent == '<html><body>fixture</body></html>'
        apiContent == 'hello'

        cleanup:
        Helper.createGradleRunner(PROJECT_NAME, 'appengineStop').build()
    }

}

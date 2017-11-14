import org.gradle.testkit.runner.GradleRunner

class Helper {
    static void cleanup(String projectName) {
        final projectDir = new File(projectName)
        assert projectDir.exists()
        final buildDir = new File(projectDir, 'build')
        buildDir.deleteDir()
    }

    static GradleRunner createGradleRunner(String projectName, String... commandLine) {
        GradleRunner.create()
            .withProjectDir(new File(projectName))
            .withArguments('-s', *commandLine)
            .withPluginClasspath()
            .forwardOutput()
    }
}

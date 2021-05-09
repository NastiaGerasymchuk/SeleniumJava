package testReportingTesults;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import cucumberFeature.RunCucumberTest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

public class TestLauncher {
    public void LaunchTests () {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(RunCucumberTest.class)
                )
                .filters(
                )
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        // Register a listener of your choice
        TestExecutionListener listener = new TesultsListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
}

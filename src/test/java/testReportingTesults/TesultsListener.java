package testReportingTesults;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import com.tesults.tesults.*;
import java.util.*;

public class TesultsListener implements TestExecutionListener {
    // A list to hold your test cases.
    List<Map<String, Object>> testCases = new ArrayList<Map<String, Object>>();

    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult
            testExecutionResult) {
        if (testIdentifier.isTest()) {
            System.out.println("Execution finished: " + testIdentifier.getDisplayName() + " " +
                    testExecutionResult.toString());
            String result = testExecutionResult.getStatus().toString();
            // Tesults requires result to be one of: [pass, fail, unknown]
            if (result == "SUCCESSFUL") {
                result = "pass";
            } else if (result == "FAILED") {
                result = "fail";
            } else {
                result = "unknown";
            }
            String reason = "";
            if (testExecutionResult.getThrowable().isPresent()) {
                reason = testExecutionResult.getThrowable().get().getMessage();
            }
            String suite = "";
            String separator = "class:";
            if (testIdentifier.getParentId().isPresent()) {
                suite = testIdentifier.getParentId().get();
                suite = suite.substring(suite.indexOf(separator) + separator.length(), suite.lastIndexOf("]"));
            }
            Map<String, Object> testCase = new HashMap<String, Object>();
            String name = testIdentifier.getDisplayName();
            if (name.indexOf("(") != -1) {
                name = name.substring(0, name.lastIndexOf("("));
            }
            testCase.put("name", name);
            testCase.put("result", result);
            testCase.put("suite", suite);
            testCase.put("desc", testIdentifier.getDisplayName());
            testCase.put("reason", reason);
            // (Optional) For uploading files:
            //List<String> files = new ArrayList<String>();
            //files.add("https://548225-1759080-raikfcquaxqncofqfm.stackpathdns.com/path-to-files/test-name/img1.png");
            //files.add("https://548225-1759080-raikfcquaxqncofqfm.stackpathdns.com/path-to-files/test-name/img2.png");
            //testCase.put("files", files);
            testCases.add(testCase);
        }
    }

    public void testPlanExecutionFinished(TestPlan testPlan) {
        // Map<String, Object> to hold your test results data.
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImU5ZTFmMmNjLWVjMWItNDgwYS04MDg4LTQzYjhlM2I3YTY1OS0xNjIwNDE3NzI4ODU4IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiN2IxNDJlODEtYmQ2Yi00MTAxLWI3NzctZjYyNDZlZGJiZmU2IiwidHlwZSI6InQifQ.yZHJfF8TL98RQ_q64DJDit23ycIt7ZN-6kYN7IyUhHQ";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("target", token);
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("cases", testCases);
        data.put("results", results);
        // Upload
        System.out.println("Uploading results data to Tesults...");
        Map<String, Object> response = Results.upload(data);
        System.out.println("success: " + response.get("success"));
        System.out.println("message: " + response.get("message"));
        System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
        System.out.println("errors: " + ((List<String>) response.get("errors")).size());
    }
}

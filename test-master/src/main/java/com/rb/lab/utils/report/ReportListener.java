package com.rb.lab.utils.report;

import org.apache.log4j.Logger;
import org.testng.*;

public class ReportListener implements ITestListener {
    private final static Logger LOG = Logger.getLogger(ReportListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info(String.format("%s starting", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info(String.format("%S success", iTestResult.getName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.error(String.format("%s fail", iTestResult.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.error(String.format("%s skipped", iTestResult.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOG.error(String.format("%s failed with success percentage", iTestResult.getName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOG.info("Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOG.info("Finish");
    }
}

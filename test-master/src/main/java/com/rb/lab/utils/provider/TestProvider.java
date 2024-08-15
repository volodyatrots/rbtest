package com.rb.lab.utils.provider;

import com.rb.lab.utils.DataReader;
import org.testng.annotations.DataProvider;

public class TestProvider {
    @DataProvider(parallel = true)
    public Object[][] getUsersData() {
        return new DataReader().getXLSAndCSVData();
    }
}

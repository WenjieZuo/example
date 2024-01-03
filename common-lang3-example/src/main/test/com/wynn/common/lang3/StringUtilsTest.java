package com.wynn.common.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void replaceTest() {
        Assert.assertNull(StringUtils.replace(null, "123", "321"));//null
        Assert.assertEquals("32123", StringUtils.replace("123", "1", "321"));//32123
    }
}

package com.wynn.common.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void replaceTest() {
        System.out.println(StringUtils.replace(null, "123", "321")); //null
        System.out.println(StringUtils.replace("123", "1", "321"));  //32123
    }
}

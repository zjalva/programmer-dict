package com.ben.util;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 
 * @Title: TimeSerializer.java Copyright: Copyright (c) 2012 Company:安融科技有限公司
 * 
 * @author michael 2012-11-14 下午7:48:13
 * @version V1.0
 */
public class TimeSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jGen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String value = "";
        if (date != null) {
            value = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
        }
        jGen.writeString(value);
    }
}

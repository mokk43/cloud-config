package org.squirrelframework.cloud.resource.security;

/**
 * Created by kailianghe on 16/1/6.
 */
public abstract class AbstractEncoder implements Encoder {

    @Override
    public String encode(String value) throws Exception {
        return encode(value, "UTF-8");
    }
}

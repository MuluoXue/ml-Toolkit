package com.ml.toolkit.util.http;

import org.apache.http.HttpResponse;

/**
 * @author ml
 * @date 2023年02月10日 22:41
 */
public interface HttpFun<V> {

    V handlerHttpResponseCallback(HttpResponse response);
}

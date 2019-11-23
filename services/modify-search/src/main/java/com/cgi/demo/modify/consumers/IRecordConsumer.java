package com.cgi.demo.modify.consumers;

public interface IRecordConsumer<T> {

    boolean listen(T message);
}

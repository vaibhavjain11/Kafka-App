package com.cgi.demo.modify.publisher;

public interface IRecordPublisher<T> {

    void publish(T message);
}

package com.cgi.demo.search.publisher;

public interface IRecordPublisher<T> {

    void publish(T message);
}

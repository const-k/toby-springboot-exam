package com.example.exam_springboot;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        final Hello hello = findHello(name);

        return hello == null ? 0 : hello.getCount();
    }
}

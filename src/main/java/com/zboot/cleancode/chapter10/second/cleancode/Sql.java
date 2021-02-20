package com.zboot.cleancode.chapter10.second.cleancode;

import com.zboot.cleancode.chapter10.second.Column;

public abstract class Sql {
    public Sql(String table, Column[] columns) {
        System.out.println("abstract Sql created");
    }

    abstract public String generate();
}

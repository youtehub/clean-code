package com.zboot.cleancode.chapter10.second.cleancode;

import com.zboot.cleancode.chapter10.second.Column;

public class InsertSql extends Sql {

    public InsertSql(String table, Column[] columns) {
        super(table, columns);
        System.out.println("InsertSql class created");
    }

    @Override
    public String generate() {
        return "insert sql";
    }

}

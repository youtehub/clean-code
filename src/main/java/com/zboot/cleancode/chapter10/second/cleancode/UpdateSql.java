package com.zboot.cleancode.chapter10.second.cleancode;

import com.zboot.cleancode.chapter10.second.Column;

public class UpdateSql extends Sql {

    public UpdateSql(String table, Column[] columns) {
        super(table, columns);
        System.out.println("InsertSql class created");
    }

    @Override
    public String generate() {
        return "update sql";
    }

}

package com.company.real.m.seatingManager;

public class Table implements Comparable<Object> {

    public final int size; //number of chairs around this table

    public Table(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {
        Table t = (Table) o;
        return this.size - t.size;
    }
}
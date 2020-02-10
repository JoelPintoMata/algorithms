package com.company.real.m.seatingManager;

public class Table {

    public final int size; //number of chairs around this table
    private int occupied; //number of chairs around this table

    public Table(int size) {
        this.size = size;
        this.occupied = 0;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
}
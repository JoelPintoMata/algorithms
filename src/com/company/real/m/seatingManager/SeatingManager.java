package com.company.real.m.seatingManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Our restaurant has round tables. Tables come in different sizes that can
 * accommodate 2, 3, 4, 5 or 6 people. People arrive at our restaurant in
 * groups of 6 or less. People in the same group want to be seated at the same
 * table. You can seat a group at any table that has enough empty seats for
 * them. If it's not possible to accommodate them, they're willing to wait.
 * <p>
 * Once they're seated, they can stay as long as they want and you cannot ask
 * them to move to another table (i.e. you cannot move them to make space for
 * another group). In terms of fairness of seating order: seat groups in the
 * order they arrive, but seat opportunistically. For example: a group of 6 is
 * waiting for a table and there are 4 empty seats at a table for 6; if a group
 * of 2 arrives you may put them at the table for 6 but only if you have
 * nowhere else to put them. This may mean that the group of 6 waits a long
 * time, possibly until they become frustrated and leave.
 */
public class SeatingManager {

    public static final int TABLE_SIZE_2 = 2;
    public static final int TABLE_SIZE_3 = 3;
    public static final int TABLE_SIZE_4 = 4;
    public static final int TABLE_SIZE_5 = 5;
    public static final int TABLE_SIZE_6 = 6;

    //    Array mapping a list of tables having a number of free seats
//    this is therefore a 2 indexed array
    List<Table>[] freeTableSeatsArray = new ArrayList[6];  // 1 to 6 possible partially occupied places at a table

    //    List of customer groups waiting to be seated
    List<CustomerGroup> waitingCustomerGroupForTable = new ArrayList<>();

    //    Maps a customer group to their table
    Map<CustomerGroup, Table> seatedCustomerGroupMap;

    //    Maps a table to the number of free seats
//    why? a table for six can have 2 groups of 2; when one is removed how many free
//    spaces we have left? previous 2 plus the emptied 2, we need a wait to quick keep
//    track of these numbers
    Map<Table, Integer> freeSeatsMap;

    /* Constructor */
    public SeatingManager(List<Table> tables) {
        seatedCustomerGroupMap = new HashMap<>();

        freeTableSeatsArray[0] = new ArrayList<>(0);
        freeTableSeatsArray[1] = new ArrayList<>(0);
        freeTableSeatsArray[2] = new ArrayList<>(0);
        freeTableSeatsArray[3] = new ArrayList<>(0);
        freeTableSeatsArray[4] = new ArrayList<>(0);
        freeTableSeatsArray[5] = new ArrayList<>(0);

        freeSeatsMap = new HashMap<>();

        tables = new ArrayList<>(tables);
        for (Table table : tables) {
            freeSeatsMap.put(table, table.size);
            if (table.size == TABLE_SIZE_2) {
                freeTableSeatsArray[1].add(table);
            }
            if (table.size == TABLE_SIZE_3) {
                freeTableSeatsArray[2].add(table);
            }
            if (table.size == TABLE_SIZE_4) {
                freeTableSeatsArray[3].add(table);
            }
            if (table.size == TABLE_SIZE_5) {
                freeTableSeatsArray[4].add(table);
            }
            if (table.size == TABLE_SIZE_6) {
                freeTableSeatsArray[5].add(table);
            }
        }
    }

    private void addFreeSeatsTable(int size, Table table) {
        freeTableSeatsArray[size - 1].add(table);
    }

    private void removeFreeTableSeats(int seats, Table table) {
        freeTableSeatsArray[seats - 1].remove(table);
    }

    /**
     * Group arrives and wants to be seated
     *
     * @param customerGroup a customer group
     */
    public void arrives(CustomerGroup customerGroup) {
        if (!seatCustomerGroup(customerGroup)) {
//            if we were not able to seat this group they will need to wait
            addWaitingCustomerGroup(customerGroup);
        }
    }

    public static void main(String[] a) {
        givenTwoLargeGroups_whenThirdArrives_ThenWaits();
        givenCustomerGroup_whenSeats_thenWeSitOportunistically();
        givenFullCapacity_thenFullCapacity();
        givenTooManyCustomerGroups_whenCustomerGroupLeave_thenWaitingCustomerGroup_is_seated();
    }

    private static void givenTwoLargeGroups_whenThirdArrives_ThenWaits() {
        List<Table> tables = new ArrayList<>();
        Table table = new Table(TABLE_SIZE_2);
        tables.add(table);
        table = new Table(TABLE_SIZE_3);
        tables.add(table);
        table = new Table(TABLE_SIZE_4);
        tables.add(table);
        table = new Table(TABLE_SIZE_5);
        tables.add(table);
        table = new Table(TABLE_SIZE_6);
        tables.add(table);

        CustomerGroup customerGroup;
        SeatingManager seatingManager = new SeatingManager(tables);
        customerGroup = new CustomerGroup(6);
        seatingManager.arrives(customerGroup);
        Assertions.assertNotNull(seatingManager.locate(customerGroup));
        customerGroup = new CustomerGroup(6);
        seatingManager.arrives(customerGroup);

//        we could not seat this customer group
        Assertions.assertNull(seatingManager.locate(customerGroup));

//        we could not seat this customer group
        Assertions.assertEquals(1, seatingManager.waitingCustomerGroupForTableSize());
    }

    /**
     * Seats waiting customer groups
     */
    private void seatWaitingCustomerGroups() {
        for (CustomerGroup customerGroup : waitingCustomerGroupForTable) {
            seatCustomerGroup(customerGroup);
        }
    }

    /**
     * Adds a customer group to the waiting list
     * @param customerGroup a customer group
     */
    private void addWaitingCustomerGroup(CustomerGroup customerGroup) {
        waitingCustomerGroupForTable.add(customerGroup);
    }

    /**
     * Removes a customer group from the waiting list
     * @param customerGroup a customer group
     */
    private void removeWaitingCustomerGroup(CustomerGroup customerGroup) {
        waitingCustomerGroupForTable.remove(customerGroup);
    }

    private static void givenCustomerGroup_whenSeats_thenWeSitOportunistically() {
        List<Table> tables = new ArrayList<>();
        Table table = new Table(TABLE_SIZE_2);
        tables.add(table);
        table = new Table(TABLE_SIZE_3);
        tables.add(table);
        table = new Table(TABLE_SIZE_4);
        tables.add(table);
        table = new Table(TABLE_SIZE_5);
        tables.add(table);
        table = new Table(TABLE_SIZE_6);
        tables.add(table);

        CustomerGroup customerGroup;
        SeatingManager seatingManager = new SeatingManager(tables);
        customerGroup = new CustomerGroup(6);
        seatingManager.arrives(customerGroup);
        Assertions.assertNotNull(seatingManager.locate(customerGroup));
        customerGroup = new CustomerGroup(6);
        seatingManager.arrives(customerGroup);
        customerGroup = new CustomerGroup(3);
        seatingManager.arrives(customerGroup);
        customerGroup = new CustomerGroup(3);
        seatingManager.arrives(customerGroup);

//        we seated a customer group of size 3 in the smallest table available of size 4
        Assertions.assertEquals(4, seatingManager.locate(customerGroup).size);
    }

    /**
     * Locates the table holding a customer group
     *
     * @param customerGroup a customer group
     * @return Return the table at which the group is seated, or null if they are not seated (whether they're waiting or already left).
     */
    public Table locate(CustomerGroup customerGroup) {
        return seatedCustomerGroupMap.get(customerGroup);
    }

    @Test
    private static void givenFullCapacity_thenFullCapacity() {
        List<Table> tables = new ArrayList<>();
        Table table = new Table(TABLE_SIZE_2);
        tables.add(table);
        table = new Table(TABLE_SIZE_3);
        tables.add(table);
        table = new Table(TABLE_SIZE_4);
        tables.add(table);
        table = new Table(TABLE_SIZE_5);
        tables.add(table);
        table = new Table(TABLE_SIZE_6);
        tables.add(table);

        SeatingManager seatingManager = new SeatingManager(tables);

        CustomerGroup customerGroup1 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup1);
        Assertions.assertNotNull(seatingManager.locate(customerGroup1));
        CustomerGroup customerGroup2 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup2);
        Assertions.assertNotNull(seatingManager.locate(customerGroup2));
        CustomerGroup customerGroup3 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup3);
        Assertions.assertNotNull(seatingManager.locate(customerGroup3));
        CustomerGroup customerGroup4 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup4);
        Assertions.assertNotNull(seatingManager.locate(customerGroup4));
        CustomerGroup customerGroup5 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup5);
        Assertions.assertNotNull(seatingManager.locate(customerGroup5));
        CustomerGroup customerGroup6 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup6);
        Assertions.assertNotNull(seatingManager.locate(customerGroup6));
        CustomerGroup customerGroup7 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup7);
        Assertions.assertNotNull(seatingManager.locate(customerGroup7));
        CustomerGroup customerGroup8 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup8);
        Assertions.assertNotNull(seatingManager.locate(customerGroup8));
        CustomerGroup customerGroup9 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup9);
        Assertions.assertNotNull(seatingManager.locate(customerGroup9));
        CustomerGroup customerGroup10 = new CustomerGroup(2);
        seatingManager.arrives(customerGroup10);
//        we cannot seat anyone else, not even the smallest customer group
        Assertions.assertNull(seatingManager.locate(customerGroup10));
        seatingManager.leaves(customerGroup1);
//        once a customer group leaves we empty the queue
        Assertions.assertNotNull(seatingManager.locate(customerGroup10));
    }

    @Test
    private static void givenTooManyCustomerGroups_whenCustomerGroupLeave_thenWaitingCustomerGroup_is_seated() {
        List<Table> tables = new ArrayList<>();
        Table table = new Table(TABLE_SIZE_2);
        tables.add(table);
        table = new Table(TABLE_SIZE_3);
        tables.add(table);
        table = new Table(TABLE_SIZE_4);
        tables.add(table);
        table = new Table(TABLE_SIZE_5);
        tables.add(table);
        table = new Table(TABLE_SIZE_6);
        tables.add(table);

        SeatingManager seatingManager = new SeatingManager(tables);
        CustomerGroup CustomerGroup1 = new CustomerGroup(6);
        seatingManager.arrives(CustomerGroup1);
        Assertions.assertNotNull(seatingManager.locate(CustomerGroup1));
        CustomerGroup customerGroup2 = new CustomerGroup(6);
        seatingManager.arrives(customerGroup2);
        Assertions.assertNull(seatingManager.locate(customerGroup2));
        seatingManager.leaves(CustomerGroup1);
        Assertions.assertNotNull(seatingManager.locate(customerGroup2));
    }

    /**
     * Resets/recalculate a table free seats
     *
     * @param table a table
     * @return this table number of free seats
     */
    private int resetFreeTableSeats(Table table) {
        int total = freeSeatsMap.get(table);
        if (total > 0) {
            freeTableSeatsArray[total - 1].remove(table);
        }
        return total;
    }

    /**
     * Manages the event where a customer group leaves
     * Note: Whether seated or not, the group leaves the restaurant.
     *
     * @param customerGroup a customer group
     */
    public void leaves(CustomerGroup customerGroup) {
//        where is the group?
        Table table = locate(customerGroup);
//        if the customer group is already seated
        if (table != null) {
//            remove this table from the occupied state
//            removeOccupiedTableSeats(customerGroup.size, table);
//            recalculate the number of free seats at this table
            int total = resetFreeTableSeats(table);
            addFreeSeatsTable(customerGroup.size + total, table);
        } else {
//            remove the customer group from the waiting list
            removeWaitingCustomerGroup(customerGroup);
        }

//        now that a group as left, it there anybody waiting to be seated?
        seatWaitingCustomerGroups();
    }

    /**
     * Retrieves the number of customer groups waiting for a table
     *
     * @Return waiting list size
     */
    private int waitingCustomerGroupForTableSize() {
        return waitingCustomerGroupForTable.size();
    }

    private boolean seatCustomerGroup(CustomerGroup customerGroup) {
        for (int customerGroupSize = customerGroup.size; customerGroupSize <= freeTableSeatsArray.length; customerGroupSize++) {
            Table table;
            if (freeTableSeatsArray[customerGroupSize - 1].size() > 0
                    && (table = freeTableSeatsArray[customerGroupSize - 1].get(0)) != null) {
                removeFreeTableSeats(customerGroupSize, table);

                if (customerGroupSize - customerGroup.size > 0) {
                    addFreeSeatsTable(customerGroupSize - customerGroup.size, table);
                }
                freeSeatsMap.put(table, customerGroupSize - customerGroup.size);

//                addOccupiedTableSeats(customerGroup.size, table);

//                seat the given customer group in a free table
                seatedCustomerGroupMap.put(customerGroup, table);
                return true;
            }
        }
        return false;
    }
}

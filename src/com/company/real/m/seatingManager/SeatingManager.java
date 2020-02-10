package com.company.real.m.seatingManager;

import org.junit.jupiter.api.Assertions;

import java.util.*;

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
    int[] tableSizeArray = new int[]{TABLE_SIZE_2, TABLE_SIZE_3, TABLE_SIZE_4, TABLE_SIZE_5, TABLE_SIZE_6};

    Set<Table>[] freeTableArray = new HashSet[5];               // one array position per possible table size
    Set<Table>[] occupiedTableArray = new HashSet[5];           // one array position per possible table size
    List<CustomerGroup> waitingCustomerGroupForTable = new ArrayList<>();

    /* set of tables of size 2 */
    Set<Table> freeTableSize2;
    /* set of tables of size 3 */
    Set<Table> freeTableSize3;
    /* set of tables of size 4 */
    Set<Table> freeTableSize4;
    /* set of tables of size 5 */
    Set<Table> freeTableSize5;
    /* set of tables of size 6 */
    Set<Table> freeTableSize6;

    /* Map to quickly determine where a customer group is seated */
    Map<CustomerGroup, Table> seatedCustomerGroupMap;

    /* Constructor */
    public SeatingManager(List<Table> tables) {
        freeTableSize2 = new HashSet<>();
        freeTableSize3 = new HashSet<>();
        freeTableSize4 = new HashSet<>();
        freeTableSize5 = new HashSet<>();
        freeTableSize6 = new HashSet<>();
        freeTableArray[0] = freeTableSize2;
        freeTableArray[1] = freeTableSize3;
        freeTableArray[2] = freeTableSize4;
        freeTableArray[3] = freeTableSize5;
        freeTableArray[4] = freeTableSize6;

        seatedCustomerGroupMap = new HashMap<>();

        tables = new ArrayList<>(tables);
        for (Table table : tables) {
            if (table.size == TABLE_SIZE_2) {
                freeTableSize2.add(table);
            }
            if (table.size == TABLE_SIZE_3) {
                freeTableSize3.add(table);
            }
            if (table.size == TABLE_SIZE_4) {
                freeTableSize4.add(table);
            }
            if (table.size == TABLE_SIZE_5) {
                freeTableSize5.add(table);
            }
            if (table.size == TABLE_SIZE_6) {
                freeTableSize6.add(table);
            }
        }

        occupiedTableArray[0] = new HashSet<>(0);
        occupiedTableArray[1] = new HashSet<>(0);
        occupiedTableArray[2] = new HashSet<>(0);
        occupiedTableArray[3] = new HashSet<>(0);
        occupiedTableArray[4] = new HashSet<>(0);
    }

    public static void main(String[] a) {
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

//          we are able to seat two customer groups of size 3
        customerGroup = new CustomerGroup(3);
        seatingManager.arrives(customerGroup);
        Assertions.assertNotNull(seatingManager.locate(customerGroup));
        Assertions.assertEquals(3, seatingManager.locate(customerGroup).size);
        customerGroup = new CustomerGroup(3);
        seatingManager.arrives(customerGroup);
        Assertions.assertNotNull(seatingManager.locate(customerGroup));

//        we seated a customer group of size 3 in the smallest table available of size 4
        Assertions.assertEquals(4, seatingManager.locate(customerGroup).size);
    }

    /**
     * Group arrives and wants to be seated
     *
     * @param customerGroup
     */
    public void arrives(CustomerGroup customerGroup) {
        if (!seatCustomerGroup(customerGroup)) {
            addWaitingCustomerGroup(customerGroup);
        }
    }

    private boolean seatCustomerGroup(CustomerGroup customerGroup) {
        Optional<Table> table = getFreeTableOfSize(customerGroup.size);
        if (table.isPresent()) {
            addOccupiedTable(table.get());

            removeFreeTable(table.get());

//             seat the given customer group in a free table
            seatedCustomerGroupMap.put(customerGroup, table.get());
            return true;
        }

        for (int i = (customerGroup.size + 1 - 2); i < tableSizeArray.length; i++) {
            table = freeTableArray[customerGroup.size + 1 - 2].stream().findFirst();
            if (table.isPresent()) {
                addOccupiedTable(table.get());

                removeFreeTable(table.get());

//             seat the given customer group in a free table
                seatedCustomerGroupMap.put(customerGroup, table.get());
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a table of, at least, a given size
     *
     * @param tableSize the table size
     * @return a free table of, at least, a given table size
     */
    private Optional<Table> getFreeTableOfLeastSize(int tableSize) {
        Optional<Table> table;
        return Optional.empty();
    }

    /**
     * Retrieves a table of a given table size
     *
     * @param tableSize the table size
     * @return a free table of a given table size
     */
    private Optional<Table> getFreeTableOfSize(int tableSize) {
        return freeTableArray[tableSize - 2].stream().findFirst();
    }

    /* Whether seated or not, the group leaves the restaurant. */
    public void leaves(CustomerGroup group) {
//        where is the group?
        Table table = seatedCustomerGroupMap.get(group);
//        if the customer group is already seated
        if (table != null) {
//            remove this table from the occupied state
            removeFreeTable(table);

//            add this table to free state
            addFreeTable(table);
        } else {
//            remove the customer group from the waiting list
            removeWaitingCustomerGroup(group);
        }

//        now that a group as left, it there anybody waiting to be seated?
        seatWaitingCustomerGroups();
    }

    /**
     *
     */
    private void seatWaitingCustomerGroups() {
        for (CustomerGroup customerGroup : waitingCustomerGroupForTable) {
            seatCustomerGroup(customerGroup);
        }
    }

    /**
     * @param customerGroup a customer group
     */
    private void addWaitingCustomerGroup(CustomerGroup customerGroup) {
        waitingCustomerGroupForTable.add(customerGroup);
    }

    /**
     * @param customerGroup a customer group
     */
    private void removeWaitingCustomerGroup(CustomerGroup customerGroup) {
        waitingCustomerGroupForTable.remove(customerGroup);
    }

    /**
     * @param table a table
     */
    private void addOccupiedTable(Table table) {
        occupiedTableArray[table.size - 2].add(table);
    }

    /**
     * @param table a table
     */
    private void removeFreeTable(Table table) {
        freeTableArray[table.size - 2].remove(table);
    }

    /**
     * @param table a table
     */
    private void addFreeTable(Table table) {
        freeTableArray[table.size - 2].add(table);
    }

    /**
     * Locates a customer group
     *
     * @param customerGroup a customer group
     * @return Return the table at which the group is seated, or null if they are not seated (whether they're waiting or already left).
     */
    public Table locate(CustomerGroup customerGroup) {
        return seatedCustomerGroupMap.get(customerGroup);
    }
}

package com.javarush.task.task19.task1901;

/* 
TableAdapter
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{ //  класс TableAdapter реализуем интерфейсом BTable
        private ATable aTable;                          // создаем приватное поле aTable типа ATable

        public TableAdapter(ATable aTable){             //реализуем конструктор
            this.aTable = aTable;
        } // создаем конструктор с параметром ATable

        @Override
        public String getHeaderText() {        // добавляем метод интерфейса getHeaderText
            // переопределяем метод getHeaderText
            return "[" + aTable.getCurrentUserName() + "]" + " : " + aTable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}
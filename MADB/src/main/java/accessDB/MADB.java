package accessDB;

import java.sql.*;
import java.util.ArrayList;

public class MADB {

        private String filepath;
        private java.sql.Connection conn;
        private Statement statement;

        public MADB(String filepath) throws SQLException {
                String url = "jdbc:ucanaccess://" + filepath;
                this.filepath = filepath;
                conn = DriverManager.getConnection(url);
                statement = conn.createStatement();
        }

        public String getPath() {
                return filepath;
        }

        public Statement getStatement() {
                return statement;
        }

        public void INSERT(String Table, String Column, String Value) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + " (" + Column + ") VALUES (\'" + Value + "\')");
        }

        public void INSERT(String Table, String Column, int Value) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Column + ") VALUES(" + Value + ")");
        }

        public void INSERT(String Table, String Column, float Value) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Column + ") VALUES(" + Value + ")");
        }

        public void INSERT(String Table, String Column, double Value) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Column + ") VALUES(" + Value + ")");
        }

        public void INSERT(String Table, String Column, boolean Value) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Column + ") VALUES(" + Value + ")");
        }

        public void INSERT(String Table, String[] Columns, String[] Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.stringToList(Values) + ")");
        }

        public void INSERT(String Table, String[] Columns, int[] Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.arrayToList(Values) + ")");
        }

        public void INSERT(String Table, String[] Columns, float[] Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.arrayToList(Values) + ")");
        }

        public void INSERT(String Table, String[] Columns, double[] Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.arrayToList(Values) + ")");
        }

        public void INSERT(String Table, String[] Columns, boolean[] Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.arrayToList(Values) + ")");
        }

        public void INSERT(String Table, String[] Columns, ArrayList<String> Values) throws SQLException { //Inserts value to specific table and field
                this.getStatement().executeUpdate("INSERT INTO " + Table + "(" + Utils.arrayToList(Columns) + ") VALUES(" + Utils.stringToList(Values) + ")");
        }

        /*===========================================================*/
        public void UPDATE(String Table, String Column, String Value, String Id, String IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = \'" + IdValue + "\'");
        }

        public void UPDATE(String Table, String Column, String Value, String Id, int IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = " + IdValue);
        }

        public void UPDATE(String Table, String Column, int Value, String Id, String IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = \'" + IdValue + "\'");
        }

        public void UPDATE(String Table, String Column, int Value, String Id, int IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = " + IdValue);
        }

        public void UPDATE(String Table, String Column, double Value, String Id, String IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = \'" + IdValue + "\'");
        }

        public void UPDATE(String Table, String Column, double Value, String Id, int IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = " + IdValue);
        }

        public void UPDATE(String Table, String Column, boolean Value, String Id, String IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = \'" + IdValue + "\'");
        }

        public void UPDATE(String Table, String Column, boolean Value, String Id, int IdValue) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\' WHERE " + Id + " = " + IdValue);
        }

        public void UPDATE(String Table, String Column, String Value) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = \'" + Value + "\'");
        }

        public void UPDATE(String Table, String Column, int Value) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = " + Value);
        }

        public void UPDATE(String Table, String Column, double Value) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = " + Value);
        }

        public void UPDATE(String Table, String Column, boolean Value) throws SQLException {
                this.getStatement().executeUpdate("UPDATE " + Table + " SET " + Column + " = " + Value);
        }

        /*===========================================================*/
        public void DELETE(String Table, String Column, String Value) throws SQLException { //Deletes record
                if (!valueExists(Table, Column, Value)) {
                        System.out.println("Record doesn't exist");
                        return;
                }

                String query = "DELETE FROM " + Table + " WHERE " + Column + " = \'" + Value + "\'";

                this.getStatement().executeUpdate(query);
                System.out.println("Record deleted");
        }

        public void DELETE(String Table) throws SQLException { //Clears Table
                String query = "DELETE FROM " + Table;
                this.getStatement().executeUpdate(query);

                System.out.println("Table Cleared");
        }

        /*===========================================================*/
        public ArrayList<String> SELECT(String Table, String Column, String Value) throws SQLException {
                ArrayList<String> list = new ArrayList<>();

                String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= \'" + Value + "\'";
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getString(1));

                }

                return list;
        }

        public ArrayList<Integer> SELECT(String Table, String Column, int Value) throws SQLException {
                ArrayList<Integer> list = new ArrayList<>();

                String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= '" + Value;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getInt(1));

                }

                return list;
        }

        public ArrayList<Double> SELECT(String Table, String Column, double Value) throws SQLException {
                ArrayList<Double> list = new ArrayList<>();

                String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= '" + Value;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getDouble(1));

                }

                return list;
        }

        public ArrayList<Boolean> SELECT(String Table, String Column, boolean Value) throws SQLException {
                ArrayList<Boolean> list = new ArrayList<>();

                String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= '" + Value;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getBoolean(1));

                }

                return list;
        }

        public ArrayList<Float> SELECT(String Table, String Column, float Value) throws SQLException {
                ArrayList<Float> list = new ArrayList<>();

                String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= '" + Value;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getFloat(1));

                }

                return list;
        }

        public ArrayList<String> SELECT(String Table, String Column) throws SQLException {
                ArrayList<String> list = new ArrayList<>();

                String query = "SELECT " + Column + " FROM " + Table;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {

                        list.add(rs.getString(1));

                }

                return list;
        }

        public ArrayList<String[]> SELECT(String Table, String[] Columns) throws SQLException {
                ArrayList<String[]> list = new ArrayList<>();

                String query = "SELECT " + Utils.arrayToList(Columns) + " FROM " + Table;
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {
                        String[] str = new String[Columns.length];

                        for (int i = 0; i < Columns.length; i++) {
                                str[i] = rs.getString(i + 1);
                        }

                        list.add(str);
                }

                return list;
        }

        public ArrayList<String[]> SELECT(String Table, String[] Columns, String Column, String Value) throws SQLException {
                ArrayList<String[]> list = new ArrayList<>();

                String query = "SELECT " + Utils.arrayToList(Columns) + " FROM " + Table + " WHERE " + Column + " = \'" + Value + "\'";
                ResultSet rs = this.getStatement().executeQuery(query);

                while (rs.next()) {
                        String[] str = new String[Columns.length];

                        for (int i = 0; i < Columns.length; i++) {
                                str[i] = rs.getString(i + 1);
                        }

                        list.add(str);
                }

                return list;
        }

        /*===========================================================*/
        public boolean valueExists(String Table, String Column, String Value) throws SQLException {
                String query = "SELECT " + Column + " FROM " + Table + " WHERE " + Column + "=\'" + Value + "\'";

                ResultSet rs = this.getStatement().executeQuery(query);
                if (rs.next()) {
                        return true;
                }

                return (false);
        }

        public boolean valueExists(String Table, String Column, int Value) throws SQLException {
                String query = "SELECT " + Column + " FROM " + Table + " WHERE " + Column + "=" + Value;

                ResultSet rs = this.getStatement().executeQuery(query);
                if (rs.next()) {
                        return true;
                }

                return (false);
        }

        public boolean valueExists(String Table, String Column, float Value) throws SQLException {
                String query = "SELECT " + Column + " FROM " + Table + " WHERE " + Column + "=" + Value;

                ResultSet rs = this.getStatement().executeQuery(query);
                if (rs.next()) {
                        return true;
                }

                return (false);
        }

        public boolean valueExists(String Table, String Column, boolean Value) throws SQLException {
                String query = "SELECT " + Column + " FROM " + Table + " WHERE " + Column + "=" + Value;

                ResultSet rs = this.getStatement().executeQuery(query);
                if (rs.next()) {
                        return true;
                }

                return (false);
        }

        /*===========================================================*/
        public int numOfRecords(String Table) throws SQLException {
                ResultSet rs = this.getStatement().executeQuery("SELECT COUNT(*)  FROM " + Table);

                rs.next();
                return rs.getInt(1);
        }

        public int numOfRecords(String Table, String Column) throws SQLException {
                ResultSet rs = this.getStatement().executeQuery("SELECT COUNT( " + Column + ")  FROM " + Table);

                rs.next();
                return rs.getInt(1);
        }

        /*===========================================================*/
        //Need of terminal
        public void CREATE(String name) throws SQLException { //Create table
                ArrayList<String> colNames = new ArrayList<>();
                ArrayList<String> dataTypes = new ArrayList<>();

                String again;
                int i = 1;
                do {
                        System.out.print("Column" + i + " name: ");
                        colNames.add(UserInput.getString());
                        String type;
                        do {
                                System.out.print("DataType" + i + ": ");
                                type = UserInput.getString();
                        } while (!Utils.correctType(type));
                        dataTypes.add(type);
                        i++;

                        System.out.print("Add another (y/n): ");
                        again = UserInput.getString();
                } while (again.equals("y"));

                String query = "CREATE TABLE " + name + " (" + Utils.tableColsFormat(colNames, dataTypes) + ")";
                this.getStatement().executeUpdate(query);
                System.out.println("Table " + name + " created");
        }

        public void CREATE(String Table, String Column, String type) throws SQLException { //Create column in table
                if (!Utils.correctType(type)) {
                        System.out.println("Incorrect data type");
                        return;
                }

                String query = "ALTER TABLE " + Table + " ADD " + Column + " " + type;
                System.out.println(query);
                this.getStatement().executeUpdate(query);
                System.out.println("Column Added");
        }

        
        /*===========DataBase Utils===========*/
        class Utils {
                private static String arrayToList(int[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat("" + arr[i]);
                                } else {
                                        s = s.concat(arr[i] + ", ");
                                }
                        }

                        return s;
                }

                private static String arrayToList(float[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat("" + arr[i]);
                                } else {
                                        s = s.concat(arr[i] + ", ");
                                }
                        }

                        return s;
                }

                private static String arrayToList(double[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat("" + arr[i]);
                                } else {
                                        s = s.concat(arr[i] + ", ");
                                }
                        }

                        return s;
                }

                private static String arrayToList(boolean[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat("" + arr[i]);
                                } else {
                                        s = s.concat(arr[i] + ", ");
                                }
                        }

                        return s;
                }

                private static String arrayToList(String[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat(arr[i]);
                                } else {
                                        s = s.concat(arr[i] + ", ");
                                }
                        }

                        return s;
                }

                private static String stringToList(String[] arr) {
                        String s = "";

                        for (int i = 0; i < arr.length; i++) {
                                if (i == arr.length - 1) {
                                        s = s.concat("\'" + arr[i] + "\'");
                                } else {
                                        s = s.concat("\'" + arr[i] + "\', ");
                                }
                        }

                        return s;
                }

                private static String stringToList(ArrayList<String> arr) {
                        String s = "";

                        for (int i = 0; i < arr.size(); i++) {
                                if (i == arr.size() - 1) {
                                        s = s.concat("\'" + arr.get(i) + "\'");
                                } else {
                                        s = s.concat("\'" + arr.get(i) + "\', ");
                                }
                        }

                        return s;
                }

                private static boolean correctType(String type) {
                        String[] types = {
                                "bigint",
                                "bit",
                                "decimal",
                                "int",
                                "money",
                                "numeric",
                                "smallint",
                                "smallmoney",
                                "tinyint",
                                "float",
                                "real",
                                "date",
                                "datetime2",
                                "datetimeoffset",
                                "smalldatetime",
                                "datetime",
                                "time",
                                "char",
                                "varchar",
                                "text",
                                "nchar",
                                "nvarchar",
                                "ntext",
                                "binary",
                                "varbinary",
                                "image",
                                "cursor",
                                "rowversion",
                                "hierarchyid",
                                "uniqueidentifier",
                                "sql_variant",
                                "xml",
                                "Spatial Geometry Types",
                                "Spatial Geography Types",
                                "table"
                        };

                        for (String type1 : types) {
                                if (type.equals(type1)) {
                                        return true;
                                }
                        }
                        return false;
                }

                private static String tableColsFormat(ArrayList<String> cols, ArrayList<String> types) {
                        String s = "";
                        for (int i = 0; i < cols.size(); i++) {
                                if (i == cols.size() - 1) {
                                        s = s.concat(cols.get(i) + " " + types.get(i));
                                } else {
                                        s = s.concat(cols.get(i) + " " + types.get(i) + ", ");
                                }

                        }
                        return s;
                }
        }
}
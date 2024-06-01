package MetodoBashForth;
public class crearTabla {

    public static String table(String[] column, String[] datos, int maxLen){
        int columnsNumber = column.length ;
        StringBuilder table = new StringBuilder();
        // Print column names
        for (String s : column) {
            table.append(String.format("| %-12s ", s.toUpperCase()));
        }
        table.append("|\n");

        // Print data rows
        for(String d: datos){
            String[] dataColumns = d.split(", ");
            for (int i = 0; i < columnsNumber; i++) {
                table.append(String.format("| %-12s ", divideString(dataColumns[i], maxLen)));
            }
            table.append("|\n");
        }
        return table.toString();
    }

    public static String divideString(String str, int len) {
        int n = str.length();
        return str.substring(0, Math.min(n, len)) + (n == len ? ".." : "");
    }
}
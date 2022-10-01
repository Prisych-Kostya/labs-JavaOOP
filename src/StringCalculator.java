import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final List<Integer> negativeNums = new ArrayList<>();
    private final ArrayList<String> delimiters = new ArrayList<>();
    private String userStr;
    private String [] splittedNums;


    public int getSum(String userStr) throws Exception {

        delimiters.add(",");
        delimiters.add("\\\\n");

        int sum = 0;
        if ((userStr.isEmpty()) || (userStr.equals(" "))) {
            return sum;
        }

        splittedNums = userStr.split(",|\\\\n");


        if (isCorrectStart(userStr)) {
            checkStrEnding(userStr);
            String beginning = userStr.split("\\\\n")[0];
            checkDelimiters(beginning);
            this.userStr = userStr.substring(beginning.length() + 2) + ",0";

        }
        else {
            this.userStr = userStr + ",0";
        }

        sort();

        splitNumbers();

        for (String s : splittedNums) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                negativeNums.add(num);
                continue;
            }
            if (num > 1000) {
                continue;
            }
            sum += num;
        }

        if (negativeNums.size() != 0) {
            System.out.println("Ви увели недозволені (від'ємні) значення, а саме: " + negativeNums.toString());
        }

        return sum;
    }
    private void checkStrEnding(String userStr) throws Exception {
        if (isCorrectStart(userStr)) {
            if (!userStr.contains("\\n")) {
                throw new Exception("Не вистачає завершення рядка!");
            }
        }
    }
    private boolean isCorrectStart(String numbers) {
        return numbers.length() > 2 && numbers.startsWith("//");
    }


    private void checkDelimiters(String starts) {
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(starts);

        while (m.find()) {
            String delim = m.group(1);

            delim = delim.replace("*", "\\*");
            delim = delim.replace("+", "\\+");
            delim = delim.replace("^", "\\^");
            delim = delim.replace(".", "\\.");
            delim = delim.replace("(", "\\(");
            delim = delim.replace(")", "\\)");
            delim = delim.replace("$", "\\$");
            delim = delim.replace("{", "\\{");
            delim = delim.replace("}", "\\}");
            delim = delim.replace("§", "\\§");

            delimiters.add(delim);
        }
    }


    private void sort()
    // function sorts delimiters by length, we need this to correctly split string with our own delimiters
    {
        for (int i = 0; i < delimiters.size(); i++) {
            for (int j = i + 1; j < delimiters.size(); j++) {
                if (delimiters.get(j).length() > delimiters.get(i).length()) {
                    String temp = delimiters.get(i);
                    delimiters.set(i, delimiters.get(j));
                    delimiters.set(j, temp);
                }
            }
        }
    }
    private String getRegex() {
        StringBuilder regex = new StringBuilder();
        for (String delimiter : delimiters) {
            regex.append(delimiter);
            regex.append("|");
        }
        regex.deleteCharAt(regex.length() - 1);
        return regex.toString();
    }

    private void splitNumbers() {
        String regex = getRegex();
        splittedNums = userStr.split(regex);
    }
}

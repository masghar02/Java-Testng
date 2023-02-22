import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import org.openqa.selenium.WebElement;
import java.util.List;


public class randomUserdata {

    public String RandGeneratedStr(int l) {

        // a list of characters to choose from in form of a string
        String alphabet = "Asghar";
        // creating a StringBuffer size of AlphaNumericStr
        StringBuilder s = new StringBuilder(l);
        int i;
        for (i = 0; i < l; i++) {
            //generating a random number using math.random()
            Random random = new Random();
            int index = random.nextInt(alphabet.length());
            //adding Random character one by one at the end of s
            char randomChar = alphabet.charAt(index);
            s.append(randomChar);
        }
        return s.toString();

    }

    public static String getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
        return todayStr;
    }

    public static String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }

    public static void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);
        /**Non-functional JAVA version of this method.*/
        //for (
        //    WebElement cell : elementList) {
        //    String cellText = cell.getText();
        //    if (cellText.contains(day)) {
        //        cell.click();
        //        break;
        //    }
        //}

    }
    public String Randomemail(){
        String alphabet = "nxtlabs";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 9;
        for(int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString().toLowerCase();
        return "asghar"+randomString+"@bystored.com";
//        System.out.println("Random String is: " + randomString);
    }
    public String Randonumber(){
        String alphabet = "7410852123";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 9;
        for(int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
//        System.out.println("Random String is: " + randomString);
    }
}


package UTILS;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.Date;

/**
 *
 * Hoàng Ngọc Long 64121
 */
public class ObjectUtils {

    /**
     * Cast String to integer with try parse
     *
     * @param sIntegerValue
     * @return null if failed
     */
    public static Integer tryParseInt(String sIntegerValue) {
        int number;
        try {
            number = Integer.parseInt(sIntegerValue);
        } catch (Exception e) {
            return null;
        }
        return number;
    }

    /**
     * Truyền chuỗi để nổi với thử phân tích cú pháp
     *
     * @param sFloatValue
     * @trả về null nếu không thành công

     */
    public static Float tryParseFloat(String sFloatValue) {
        float number;
        try {
            number = Float.parseFloat(sFloatValue);
        } catch (Exception e) {
            return null;
        }
        return number;
    }

    /**
     * Truyền chuỗi thành nhân đôi với thử phân tích cú pháp
     *
     * @param sDoubleString
     * @return null nếu không thành công
     */
    public static Double tryParseDouble(String sDoubleString) {
        double number;
        try {
            number = Double.parseDouble(sDoubleString);
        } catch (Exception e) {
            return null;
        }
        return number;
    }

    /**
     * Truyền chuỗi đến ngày với thử phân tích cú pháp
     *
     * @param dateString
     * @param format format date string
     * @return null nếu không thành công
     */
    public static Date tryParseDate(String dateString, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String formatNumber(Object obj) {
        return NumberFormat.getNumberInstance().format(obj);
    }

    public static boolean checkValidateEmail(String email) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(EMAIL_REGEX);
    }

    public static String Null2Str(Object o) {
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    public static String MD5Encoding(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Bây giờ chúng ta cần phải xóa nó nếu bạn thực sự muốn có đầy đủ 32 ký tự.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    /*
     * @Author: https://tranhanhuy.wordpress.com/
     */
    public static String backlashReplace(String myStr) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(myStr);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {

            if (character == '\\') {
                result.append("//");
            } else {
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }
}

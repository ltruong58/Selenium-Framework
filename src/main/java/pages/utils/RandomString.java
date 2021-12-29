package pages.utils;

import java.security.SecureRandom;

public class RandomString {
    public static final String ALPHANUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghiklmnopqrstuvwxyz";
    private static final int LOCAL_PART_LENGTH = 17;
    private static final int PASSWORD_LENGTH = 8;
    private static SecureRandom random = new SecureRandom();

    public String makeRandomName(int length){
        StringBuilder builder = new StringBuilder(length);
        for(int i = 0; i < length; i++){
            if(i == 0)
                builder.append(UPPER.charAt(random.nextInt(UPPER.length())));
            else
                builder.append(LOWER.charAt(random.nextInt(LOWER.length())));
        }
        return builder.toString();
    }

    public String makeRandomEmail(){
        StringBuilder builder = new StringBuilder(LOCAL_PART_LENGTH);
        for(int i = 0; i < LOCAL_PART_LENGTH; i++){
            builder.append(ALPHANUM.charAt(random.nextInt(ALPHANUM.length())));
        }
        builder.append("@a.com");
        return builder.toString();
    }

    public String makeRandomPassword(){
        StringBuilder builder = new StringBuilder(PASSWORD_LENGTH);
        for(int i = 0; i < PASSWORD_LENGTH; i++){
            builder.append(ALPHANUM.charAt(random.nextInt(ALPHANUM.length())));
        }
        return builder.toString();
    }
}

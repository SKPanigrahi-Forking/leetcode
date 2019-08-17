package string;

import java.util.*;

/**
 * 
 */
class _929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            String[] local = arr[0].replace(".","").split("\\+");
            set.add(local[0] + "@" + arr[1]);
        }
        return set.size();
    }
}
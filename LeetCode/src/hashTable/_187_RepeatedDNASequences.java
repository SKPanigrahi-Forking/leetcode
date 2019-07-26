package hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
 * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Set<String> setExist = new HashSet<>();
        Set<String> setStored = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String subs = s.substring(i - 10, i);
            if (setExist.contains(subs) && !setStored.contains(subs)) {
                setStored.add(subs);
                res.add(subs);
            } else {
                setExist.add(subs);
            }
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/1/17.
 */
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length()).append("/").append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> li = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, slash));
            li.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + size + 1;
        }
        return li;
    }

}

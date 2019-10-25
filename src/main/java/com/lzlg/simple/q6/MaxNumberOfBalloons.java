package com.lzlg.simple.q6;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        // 统计每个字母出现的次数
//        int[] counts = new int[5];
//        for (int i = 0; i < text.length(); i++) {
//            switch (text.charAt(i)) {
//                case 'b':
//                    counts[0]++;
//                    break;
//                case 'a':
//                    counts[1]++;
//                    break;
//                case 'l':
//                    counts[2]++;
//                    break;
//                case 'o':
//                    counts[3]++;
//                    break;
//                case 'n':
//                    counts[4]++;
//                    break;
//            }
//        }
//        // l， o，重复两次
//        counts[2] /= 2;
//        counts[3] /= 2;
//        Arrays.sort(counts);
//        return counts[0];

        int[] letters = new int[26];
        for (char ch : text.toCharArray()) {
            letters[ch - 97]++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 97] < min) {
                min = letters[ch - 97];
            }
        }
        return min;
    }

    @Test
    public void test() {
        String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(text));
    }
}

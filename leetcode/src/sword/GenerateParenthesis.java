package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 剑指 Offer II 085. 生成匹配的括号
 * </p>
 *
 * @author mohe
 * @date 2022-02-10 18:34:54
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0)
            return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        //递归跳出条件：右括号多于左括号；左括号数量多于n；
        if (open > n || close > open)
            return;

        if (path.length() == 2 * n)
            res.add(path);
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }
}

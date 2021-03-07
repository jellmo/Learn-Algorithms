package connection;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * <p></p>
 *
 * @author galaxy
 * @date 2021-03-07 23:42:29
 */
public class quickFind extends UF {

    /**
     * 初始化连通分量id数组, 准备好了分量，后续才能在分量中填充触点
     *
     * @param n 分量个数
     */
    public quickFind(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        //TODO
        return 0;
    }

    @Override
    public void union(int p, int q) {
        //TODO
    }

    public static void main(String[] args) {
        //读取触点数量
        int n = StdIn.readInt();
        //设置分量个数并初始化分量列表
        UF uf = new quickFind(n);
        while (!StdIn.isEmpty()) {
            //读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            //如果已连接则忽略
            if (uf.connected(p, q)) {
                continue;
            }
            //未连接则归并分量并打印连接
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
    }
}

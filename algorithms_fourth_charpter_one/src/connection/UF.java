package connection;

import edu.princeton.cs.algs4.*;

/**
 * UF算法基本API封装
 */
public class UF {

    /**
     * 表示所有分量组成的列表(分量id，以触点作为索引)
     */
    private int[] id;

    /**
     * 分量的数量
     */
    private int count;

    /**
     * 初始化连通分量id数组, 准备好了分量，后续才能在分量中填充触点
     *
     * @param n 分量个数
     */
    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 当前分量数量
     *
     * @return 分量数量
     */
    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {

        return 0;
    }

    public void union(int p, int q) {

    }

    public static void main(String[] args) {
        //读取触点数量
        int n = StdIn.readInt();
        //设置分量个数并初始化分量列表
        UF uf = new UF(n);
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

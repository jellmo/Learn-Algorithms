package connection;

/**
 * UF算法基本API封装
 */
public abstract class UF {

    /**
     * 表示所有分量组成的列表(分量id，以触点作为索引)
     * 代表所有分量
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

    /**
     * p触点所在分量的标识符
     *
     * @param p 触点索引(范围为0~n-1)
     * @return 所在分量的标识符
     */
    public abstract int find(int p);

    /**
     * 连通p触点与q触点
     *
     * @param p p触点
     * @param q q触点
     */
    public abstract void union(int p, int q);
}

package com.mycompany.unionfind;

/**
 *
 * @author Dennis
 */
public interface iUF {
    public int count();
    public boolean connected(int p, int q);
    public int find(int p);
    public void union(int p, int q);
}

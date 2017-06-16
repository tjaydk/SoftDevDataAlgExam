package com.mycompany.unionfind;

/**
 *
 * @author Dennis
 */
public class UF implements iUF {

    private int[] id;
    private int[] sz; // this is only used in the weigthed quick union algorithm
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /*
    THIS IS THE QUICK FIND SOLUTION WHICH IS NOT GOOD FOR LARGE AMOUNTS OF DATA AS IT DO AT LEAST N-1 CALLS TO UNION
    AND THEREFORE AT LEAST n^2 ARRAY ACCESSES
     */
//    @Override
//    public int find(int p) {
//        return id[p];
//    }
//
//    @Override
//    public void union(int p, int q) {
//        //put p and q into the same component
//        int pID = find(p);
//        int qID = find(q);
//        
//        // nothing to do if they are already in the same component
//        if(pID == qID) return;
//        
//        for (int i = 0; i < id.length; i++) {
//            if(id[i] == pID) id[i] = qID;
//            count--;
//        }
//    }
    /*
    THIS IS THE QUICK UNION SOLUTION WHICH I BEST CASE CAN GIVE LINEAR TIME BUT STILL HAVE A WORST CASE OF N^2
     */
//    @Override
//    public int find(int p) {
//        // find component name
//        while(p != id[p]) id[p] = p;
//        return p;
//    }
//
//    @Override
//    public void union(int p, int q) {
//        // give p and q the same root
//        int pROOT = find(p);
//        int qROOT = find(q);
//        if(pROOT == qROOT) return;
//        
//        id[pROOT] = qROOT;
//        
//        count--;
//    }
    /*
    THIS IS THE WEIGHTED QUICK UNION SOLUTION WHICH CAN ENSURE LOG N AS IT WILL ALWAYS ATTACH THE SMALLER TREE TO THE LARGER IN UNION
     */
    @Override
    public int find(int p) {
        // find component name
        while (p != id[p]) {
            id[p] = p;
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        // give p and q the same root
        int pROOT = find(p);
        int qROOT = find(q);
        if (pROOT == qROOT) {
            return;
        }

        if (sz[pROOT] < sz[qROOT]) {
            id[pROOT] = qROOT;
            sz[qROOT] += sz[pROOT];
        } else {
            id[qROOT] = pROOT;
            sz[pROOT] += sz[qROOT];
        }

        count--;
    }
}

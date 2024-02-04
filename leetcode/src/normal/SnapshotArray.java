package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray {
    Integer snapId;
    Integer length;
    HashMap<Integer, List<Integer>> snapData = new HashMap<>();

    public SnapshotArray(int length) {
        snapId = 0;
        ArrayList<Integer> data = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            data.add(0);
        }
        snapData.put(snapId, data);
        this.length = length;
    }

    public void set(int index, int val) {
        snapData.get(snapId).set(index, val);
    }

    public int snap() {
        snapId++;
        List<Integer> oldData = snapData.get(snapId - 1);
        ArrayList<Integer> data = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            data.add(i, oldData.get(i));
        }
        snapData.put(snapId, data);
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        return snapData.get(snap_id).get(index);
    }

    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(3);
        obj.set(0, 5);
        System.out.println(obj.snap());
        obj.set(0, 6);
        System.out.println(obj.get(0, 0));
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0, 4);
        snapshotArray.set(0, 16);
        snapshotArray.set(0, 13);
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.get(0, 0));
        System.out.println(snapshotArray.snap());
        //0 5 0 13 1
        System.out.println("//////////");
//        SnapshotArray sa = new SnapshotArray(4);
//        System.out.println(sa.snap());
//        System.out.println(sa.snap());
//        System.out.println(sa.get(3, 1));
//        sa.set(2,4);
//        System.out.println(sa.snap());
//        sa.set(1,4);
        SnapshotArray ssa = new SnapshotArray(1);
        ssa.set(0, 15);
        System.out.println(ssa.snap());
        System.out.println(ssa.snap());
        System.out.println(ssa.snap());
        System.out.println(ssa.get(0, 2));
        System.out.println(ssa.snap());
        System.out.println(ssa.snap());
        System.out.println(ssa.get(0, 0));
    }
}

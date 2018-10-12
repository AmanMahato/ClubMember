package ClubMember;

import java.util.HashMap;

public class HashIndex extends HashMap{

    public HashIndex() {
        super();
    }

    public void addMember(String ID, Integer index) {
        this.put(ID, index);
    }

    public int findMember(String ID) {
        Integer index = (Integer)this.get(ID);
        if (index == null) return -1;
        else return index;
    }

}

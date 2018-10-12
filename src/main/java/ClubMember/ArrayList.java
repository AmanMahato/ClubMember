package ClubMember;

import java.util.LinkedList;
import java.util.List;

public class ArrayList {

    List<Member> memberList = new LinkedList<>();

    ArrayList storage = null;

    private ArrayList(){

    }

    public ArrayList getStorage() {
        if (storage == null) {
            return new ArrayList();
        } else {
            return storage;
        }
    }

    private void add(Member member){
        memberList.add(member);
    }

    public void delete(Member member){
        memberList.remove(member);
    }

    public void modifyFirstName(Member member, String newFirstName){
        memberList.remove(member);
        add(new Member());
    }

}

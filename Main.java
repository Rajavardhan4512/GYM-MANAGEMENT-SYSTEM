import java.util.ArrayList;
import java.util.List;

class Member {
    private int memberId;
    private String name;
    private int age;
    private String email;
    private String phoneNumber;

    public Member(int memberId, String name, int age, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + memberId + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Phone: " + phoneNumber;
    }
}

class Gym {
    private List<Member> members;

    public Gym() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public List<Member> getMembersByAge(int age) {
        List<Member> membersByAge = new ArrayList<>();
        for (Member member : members) {
            if (member.getAge() == age) {
                membersByAge.add(member);
            }
        }
        return membersByAge;
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
}

 class Main {
    public static void main(String[] args) {
        Gym gym = new Gym();

        Member member1 = new Member(1, "Lokesh.G", 21, "lokesh_ganipisety@srmap.edu.in", "1234567890");
        Member member2 = new Member(2, "Bhargav.N", 22, "bhargav_n@srmap.edu.in", "9876543210");
        Member member3 = new Member(3, "Rajavardhan.V", 45, "Rajavardhan_v@srmap.edu.in", "4567890123");

        gym.addMember(member1);
        gym.addMember(member2);
        gym.addMember(member3);

        System.out.println("All Members:");
        List<Member> allMembers = gym.getAllMembers();
        for (Member member : allMembers) {
            System.out.println(member);
        }

        System.out.println("\nMembers aged 30:");
        List<Member> membersByAge = gym.getMembersByAge(30);
        for (Member member : membersByAge) {
            System.out.println(member);
        }

        int memberIdToFind = 2;
        Member foundMember = gym.findMemberById(memberIdToFind);
        if (foundMember != null) {
            System.out.println("\nFound Member with ID " + memberIdToFind + ":");
            System.out.println(foundMember);
        } else {
            System.out.println("\nMember with ID " + memberIdToFind + " not found.");
        }

        gym.removeMember(member1);

        System.out.println("\nUpdated Members:");
        allMembers = gym.getAllMembers();
        for (Member member : allMembers) {
            System.out.println(member);
        }
    }
}

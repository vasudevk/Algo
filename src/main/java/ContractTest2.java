import java.util.HashSet;
import java.util.Set;

public class ContractTest2 {

    public static void main(String[] args) {

        EmployeeKey2 ek1 = new EmployeeKey2("100", "05151991");
        EmployeeKey2 ek2 = new EmployeeKey2("100", "05151991");
        EmployeeKey2 ek3 = new EmployeeKey2("101", "07151993");
        EmployeeKey2 ek4 = new EmployeeKey2("101", "07151993");
        EmployeeKey2 ek5 = new EmployeeKey2("102", "09151993");

        Set<EmployeeKey2> set = new HashSet<>();
        set.add(ek1);
        set.add(ek2);
        set.add(ek3);
        set.add(ek4);
        set.add(ek5);

        // Comment out hashCode & equals contract and check the result
        System.out.println(set);
    }
}

class EmployeeKey2 {

    private String empId;
    private String dob;

    EmployeeKey2(String empId, String dob) {
        this.empId = empId;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeKey2 that = (EmployeeKey2) o;

        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        return dob != null ? dob.equals(that.dob) : that.dob == null;
    }

    @Override
    public int hashCode() {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeKey2{" +
                "empId='" + empId + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
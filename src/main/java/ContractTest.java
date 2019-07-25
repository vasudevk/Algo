import java.util.HashMap;
import java.util.Map;

public class ContractTest {

    public static void main(String[] args) {

        Map<EmployeeKey, String> cache = loadEmpCache();

        EmployeeKey lookUpKey = new EmployeeKey("101", "06151992");
        String empName = cache.get(lookUpKey);
        System.out.println("The employee name is " + empName);

    }

    private static Map<EmployeeKey, String> loadEmpCache() {

        EmployeeKey ek1 = new EmployeeKey("100", "05151991");
        EmployeeKey ek2 = new EmployeeKey("101", "06151992");
        EmployeeKey ek3 = new EmployeeKey("102", "07151993");
        EmployeeKey ek4 = new EmployeeKey("103", "07151993");

        Map<EmployeeKey, String> cache = new HashMap<>();
        cache.put(ek1, "Vasu");
        cache.put(ek2, "Dattu");
        cache.put(ek3, "Amit");
        cache.put(ek4, "Siva");

        return cache;
    }
}

class EmployeeKey {

    private String empId;
    private String dob;

    EmployeeKey(String empId, String dob) {
        this.empId = empId;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeKey that = (EmployeeKey) o;

        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;
        return dob != null ? dob.equals(that.dob) : that.dob == null;
    }

    @Override
    public int hashCode() {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }
}
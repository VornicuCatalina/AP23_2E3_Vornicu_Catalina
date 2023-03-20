import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void getName() {
        Company company = new Company("Amazon");
        assertEquals("Amazon", company.getName());
    }

    @Test
    void getNoRelationship() {
        Company company = new Company("Amazon");
        Node helper = new Company("Centric");
        company.addRelationship(helper, "business partners");
        assertEquals(1, company.getNoRelationship());
    }

    @Test
    void getNoWorkers() {
        Company company = new Company("Amazon");
        company.setNoWorkers(120);
        assertEquals(120, company.getNoWorkers());
    }
}
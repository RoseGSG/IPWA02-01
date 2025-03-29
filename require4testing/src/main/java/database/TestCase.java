package database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne  // Verknüpft die TestCase-Entität mit Requirement
    private Requirement requirement;

    @ManyToOne  // Verknüpft die TestCase-Entität mit TestRun
    private TestRun testRun;

    @ManyToOne  // Verknüpft die TestCase-Entität mit Tester
    private Tester tester;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    // Standardkonstruktor
    public TestCase() {}

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestCase{id=" + id + ", requirement=" + requirement + ", testRun=" + testRun + ", tester=" + tester + ", description='" + description + "', status='" + status + "'}";
    }
}

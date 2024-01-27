import java.io.Serializable;
import java.time.Year;
import java.util.Date;

public class Students extends Persons implements Serializable {
    private String studentId;
    private String currentUniversity;
    private String startYear;
    private double cumulativeGpa;

    private AcademicPerformance academicPerformance;
    public Students() {
    }

    public Students(long id, String name, String address, Date birthDate, double height, double weight,
                    String studentId, String currentUniversity, String startYear, double cumulativeGpa) {
        super(id, name, address, birthDate, height, weight);
        this.studentId = studentId;
        this.currentUniversity = currentUniversity;
        this.startYear = startYear;
        this.cumulativeGpa = cumulativeGpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCurrentUniversity() {
        return currentUniversity;
    }

    public void setCurrentUniversity(String currentUniversity) {
        this.currentUniversity = currentUniversity;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public double getCumulativeGpa() {
        return cumulativeGpa;
    }

    public void setCumulativeGpa(double cumulativeGpa) {
        this.cumulativeGpa = cumulativeGpa;
    }

    public AcademicPerformance getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(AcademicPerformance academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    @Override
    public String toString() {
        return "Students{" +
                super.toString()+
                "studentId='" + studentId + '\'' +
                ", currentUniversity='" + currentUniversity + '\'' +
                ", startYear=" + startYear +
                ", cumulativeGpa=" + cumulativeGpa +
                ", academicPerformance=" + academicPerformance +
                '}';
    }
}
